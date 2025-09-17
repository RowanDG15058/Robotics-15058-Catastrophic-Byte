// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class main extends LinearOpMode {
    @Override
    public void runOpMode() {
        encoders encoders = new encoders(hardwareMap);
        encoders.resetEncoders();
        // Motors
        DcMotor motor0 = hardwareMap.get(DcMotor.class, "motor0");
        DcMotor motor1 = hardwareMap.get(DcMotor.class, "motor1");
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "motor2");
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "motor3");
        // Servo(s)
        Servo servo0 = hardwareMap.get(Servo.class, "servo0");
        // This waits for start
        waitForStart();
        while (opModeIsActive()){
            // Variables for everything! Turning, and the encoders positions.
            double turn = gamepad1.right_stick_x;
            double y_move = gamepad1.left_stick_y;
            double y1dist = encoders.y1distance();
            double y2dist = encoders.y2distance();
            double x1dist = encoders.x1distance();
            // If the turn and y_move are both at full power (1+1) it will move the servo
            if (turn + y_move == 2) {
                servo0.setPosition(1);
            } else {
                servo0.setPosition(0);
            }
            // This sets the motors power based on the turn and y movement
            motor0.setPower(y_move + turn);
            motor1.setPower(y_move + turn);
            motor3.setPower(y_move - turn);
            motor2.setPower(y_move - turn);
            telemetry.addData("Y1 Distance", y1dist);
            telemetry.addData("Y2 Distance", y2dist);
            telemetry.addData("X1 Distance", x1dist);
            telemetry.update();
        }
    }
}
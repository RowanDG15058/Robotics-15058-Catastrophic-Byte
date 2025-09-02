package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class teleop extends LinearOpMode {
    DcMotor motor0, motor1, motor2, motor3;
    Servo servo0;
    @Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        waitForStart();
        while (opModeIsActive()){
            double turn = gamepad1.right_stick_x;
            double y_move = gamepad1.left_stick_y;
            motor0.setPower(y_move + turn);
            motor1.setPower(y_move + turn);
            motor3.setPower(y_move - turn);
            motor2.setPower(y_move - turn);
        }

    }
}

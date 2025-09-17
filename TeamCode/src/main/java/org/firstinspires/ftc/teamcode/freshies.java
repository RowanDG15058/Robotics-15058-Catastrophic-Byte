package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class freshies extends LinearOpMode {

    DcMotor motor;
    Servo servo;
    @Override
    public void runOpMode() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        servo = hardwareMap.get(Servo.class, "servo");
        waitForStart();
        while (opModeIsActive()) {
            motor.setPower(gamepad1.left_stick_y);

            if (gamepad2.a){
                servo.setPosition(0.5);
            } else {
                servo.setPosition(1);
            }
            
        }
    }
}

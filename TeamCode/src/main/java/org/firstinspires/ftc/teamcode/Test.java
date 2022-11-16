package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="TestBalls", group="TeleOp")
public class Test extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motorFrontLeft  = hardwareMap.dcMotor.get("LeftBall");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("RightBall");
        DcMotor motorBackLeft   = hardwareMap.dcMotor.get("BackLeftBall");
        DcMotor motorBackRight  = hardwareMap. dcMotor. get("BackRightBall");

        waitForStart();

        while (opModeIsActive()) {
            double ly = -gamepad1.left_stick_y; 
            double lx = gamepad1.left_stick_x; 
            double rx = gamepad1.right_stick_x;
            double denominator = Math.max(Math.abs(ly) + Math.abs(lx) + Math.abs(lx), 1);

            motorFrontLeft.setPower((ly + lx + rx) / denominator); 
            motorFrontRight.setPower((ly - lx - rx) / denominator);
            motorBackLeft.setPower((ly - lx + rx) / denominator);
            motorBackRight.setPower((ly + lx - rx) / denominator);

            idle();
        }

    }
}
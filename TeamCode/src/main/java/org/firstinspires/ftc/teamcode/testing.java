package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class testing extends LinearOpMode {
    private FireHardwareMap hwMap = null;
    private ElapsedTime runtime = new ElapsedTime();
    //final double mecanumWheelCircumference = Math.PI*3.5; // note that this is slightly lower, adjusting for rolling w/ slipping

    DcMotor frontRightMotor = null;
    DcMotor frontLeftMotor = null;
    DcMotor backRightMotor = null;
    DcMotor backLeftMotor = null;



    @Override
    public void runOpMode() {
        hwMap = new FireHardwareMap(this.hardwareMap);
        frontRightMotor = hwMap.frontRightMotor;
        frontLeftMotor = hwMap.frontLeftMotor;
        backRightMotor = hwMap.backRightMotor;
        backLeftMotor = hwMap.backLeftMotor;

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        telemetry.addData("Robot Status: ", "ready");
        telemetry.addData("Version: ", "Auton 1.3.2");
        telemetry.update();

        waitForStart();
        runtime.reset();

        telemetry.addData("Robot Status: ", "started");
        telemetry.update();

        while (opModeIsActive()) {
            telemetry.addData("Version: ", "Auton 1.3.2");
            telemetry.addData("Current frontLeftMotor Encoder Position: ", frontLeftMotor.getCurrentPosition());
            telemetry.addData("frontLeftMotor Operational: ", frontLeftMotor.isBusy());
            telemetry.addData("Current frontRightMotor Encoder Position: ", frontRightMotor.getCurrentPosition());
            telemetry.addData("frontRightMotor Operational: ", frontRightMotor.isBusy());
            telemetry.addData("Current backLeftMotor Encoder Position: ", backLeftMotor.getCurrentPosition());
            telemetry.addData("backLeftMotor Operational: ", backLeftMotor.isBusy());
            telemetry.addData("Current backRightMotor Encoder Position: ", backRightMotor.getCurrentPosition());
            telemetry.addData("backRightMotor Operational: ", backRightMotor.isBusy());
            telemetry.update();
            idle();
        }



//        drive(0.9, 2000);

    }

//    public void drive(double power, int ms) {
//        hwMap.backLeftMotor.setPower(power);
//        hwMap.backRightMotor.setPower(power);
//        hwMap.frontLeftMotor.setPower(power);
//        hwMap.frontRightMotor.setPower(power);
//        sleep((long) ms);
//    }
//
//    public void drive(double dist) {
//
//    }
}
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BasicAuton extends LinearOpMode {
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

        frontRightMotor.setTargetPosition(2000);
        frontLeftMotor.setTargetPosition(2000);
        backRightMotor.setTargetPosition(2000);
        backLeftMotor.setTargetPosition(2000);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Robot Status: ", "ready");
        telemetry.update();

        waitForStart();
        runtime.reset();

        frontRightMotor.setPower(0.5);
        frontLeftMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);

        telemetry.addData("Robot Status: ", "started");
        telemetry.update();

        while (opModeIsActive() && frontRightMotor.isBusy()) {
            telemetry.addData("Current Encoder Position: ", frontLeftMotor.getCurrentPosition());
            telemetry.update();
            idle();
        }

        frontRightMotor.setPower(0.0);
        frontLeftMotor.setPower(0.0);
        backRightMotor.setPower(0.0);
        backLeftMotor.setPower(0.0);

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

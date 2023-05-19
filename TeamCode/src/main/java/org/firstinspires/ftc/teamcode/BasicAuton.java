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
    DcMotor mechanismMotor = null;

    private final int motorTicksPerTile = 1000;

    @Override
    public void runOpMode() {
        hwMap = new FireHardwareMap(this.hardwareMap);
        frontRightMotor = hwMap.frontRightMotor;
        frontLeftMotor = hwMap.frontLeftMotor;
        backRightMotor = hwMap.backRightMotor;
        backLeftMotor = hwMap.backLeftMotor;
        mechanismMotor = hwMap.mechanismMotor;

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        mechanismMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        mechanismMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // move from start position to far tile, also intake the cone by spinning mechanismMotor CCW
        frontRightMotor.setTargetPosition((int) (4.2*motorTicksPerTile));
        frontLeftMotor.setTargetPosition((int) (4.2*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (4.2*motorTicksPerTile));
        backLeftMotor.setTargetPosition((int) (4.2*motorTicksPerTile));

//        mechanismMotor.setTargetPosition((int) (-10000));

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//        mechanismMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Robot Status: ", "ready");
        telemetry.addData("Version: ", "Auton 1.3.3");
        telemetry.update();

        waitForStart();
        runtime.reset();

        frontRightMotor.setPower(0.5);
        frontLeftMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);


        telemetry.addData("Robot Status: ", "started");
        telemetry.update();

        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.3.3");
            telemetry.addData("Current frontLeftMotor Encoder Position: ", frontLeftMotor.getCurrentPosition());
            telemetry.addData("frontLeftMotor Operational: ", frontLeftMotor.isBusy());
            telemetry.addData("Current frontRightMotor Encoder Position: ", frontRightMotor.getCurrentPosition());
            telemetry.addData("frontRightMotor Operational: ", frontRightMotor.isBusy());
            telemetry.addData("Current backLeftMotor Encoder Position: ", backLeftMotor.getCurrentPosition());
            telemetry.addData("backLeftMotor Operational: ", backLeftMotor.isBusy());
            telemetry.addData("Current backRightMotor Encoder Position: ", backRightMotor.getCurrentPosition());
            telemetry.addData("backRightMotor Operational: ", backRightMotor.isBusy());
            telemetry.update();
            mechanismMotor.setPower(0.8);
            idle();
        }

        frontRightMotor.setPower(0.0);
        frontLeftMotor.setPower(0.0);
        backRightMotor.setPower(0.0);
        backLeftMotor.setPower(0.0);

        mechanismMotor.setPower(0.0);

        // make the turn
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setTargetPosition((int) (-2.5*motorTicksPerTile));
        frontLeftMotor.setTargetPosition((int) (2.5*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (2.5*motorTicksPerTile));
        backLeftMotor.setTargetPosition((int) (-2.4*motorTicksPerTile));

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setPower(0.5);
        frontLeftMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);

        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.3.3");
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

        // move back and outtake cone
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setTargetPosition((int) (-1*motorTicksPerTile));
        frontLeftMotor.setTargetPosition((int) (-1*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (-1*motorTicksPerTile));
        backLeftMotor.setTargetPosition((int) (-1*motorTicksPerTile));

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setPower(0.5);
        frontLeftMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);

        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.3.3");
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

        frontRightMotor.setPower(0.0);
        frontLeftMotor.setPower(0.0);
        backRightMotor.setPower(0.0);
        backLeftMotor.setPower(0.0);

        mechanismMotor.setPower(0.0);


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
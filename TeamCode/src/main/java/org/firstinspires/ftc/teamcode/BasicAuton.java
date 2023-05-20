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

        mechanismMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mechanismMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // starting sequence
        telemetry.addData("Robot Status: ", "ready");
        telemetry.addData("Version: ", "Auton 1.3.3");
        telemetry.update();

        waitForStart();
        runtime.reset();

        telemetry.addData("Robot Status: ", "started");
        telemetry.update();

        // drive forward 4.2 tiles
        drive(4.2);

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

        // strafe right (will make method later)


        // debug
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
        drive(-1.0);

        // debug
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

    public void drive(double numOfTiles) {
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));
        frontLeftMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));
        backLeftMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setPower(0.5);
        frontLeftMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);
    }

    public void strafe(double numOfTiles, boolean right) {
        int dir = (right) ? -1 : 1;
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setTargetPosition((int) (dir*numOfTiles*motorTicksPerTile));
        frontLeftMotor.setTargetPosition((int) (-1*dir*numOfTiles*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (-1*dir*numOfTiles*motorTicksPerTile));
        backLeftMotor.setTargetPosition((int) (dir*numOfTiles*motorTicksPerTile));

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setPower(0.5);
        frontLeftMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);
    }

    public void rotate(double degrees, boolean ccw) {
        int dir = (ccw) ? -1 : 1;
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setTargetPosition((int) (-1*dir*degrees*motorTicksPerTile));
        frontLeftMotor.setTargetPosition((int) (dir*degrees*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (-1*dir*degrees*motorTicksPerTile));
        backLeftMotor.setTargetPosition((int) (dir*degrees*motorTicksPerTile));

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setPower(0.5);
        frontLeftMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);
    }
}
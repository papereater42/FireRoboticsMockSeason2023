package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BasicAuton extends LinearOpMode {
    private FireHardwareMap hwMap = null;
    private ElapsedTime runtime = new ElapsedTime();
    private ActiveLocation activeLocation = null;
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
        activeLocation = new ActiveLocation(hwMap);
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
        telemetry.addData("Version: ", "Auton 1.4");
        telemetry.update();

        waitForStart();
        runtime.reset();

        telemetry.addData("Robot Status: ", "started");
        telemetry.update();

        // drive forward 4.2 tiles

        rotate(5, true);



        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.4");
            telemetry.addData("IMU: ", activeLocation.getTrimmedAngleInDegrees());
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

        mechanismMotor.setPower(0);

     drive(4.3, 1000,true);



        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.4");
            telemetry.addData("IMU: ", activeLocation.getTrimmedAngleInDegrees());
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

        mechanismMotor.setPower(0);

        // strafe right (will make method later)
        rotate(85-activeLocation.getTrimmedAngleInDegrees(), true);
       //drive(2);
        //strafe(4.5, true);

        // debug
        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.4");
            telemetry.addData("IMU: ", activeLocation.getTrimmedAngleInDegrees());
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

        mechanismMotor.setPower(0);


        // move forward
       drive(2.75,0,true);

        // debug
        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.4");
            telemetry.addData("IMU: ", activeLocation.getTrimmedAngleInDegrees());
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

        drive(0, -1000,false);



        while (opModeIsActive() && mechanismMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.4");
            telemetry.addData("IMU: ", activeLocation.getTrimmedAngleInDegrees());
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

        mechanismMotor.setPower(0);

        strafe(1.5, true);



        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.4");
            telemetry.addData("IMU: ", activeLocation.getTrimmedAngleInDegrees());
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

        mechanismMotor.setPower(0);

        drive(0.2, 0,false);



        while (opModeIsActive() && frontLeftMotor.isBusy()) {
            telemetry.addData("Version: ", "Auton 1.4");
            telemetry.addData("IMU: ", activeLocation.getTrimmedAngleInDegrees());
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

        mechanismMotor.setPower(0);


    }

    public void drive(double numOfTiles, int mechMotor, boolean cone) {
        double x = 0.5;
        if(cone){
            x = 0.99;
        }


        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        mechanismMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mechanismMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));
        frontLeftMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));
        backLeftMotor.setTargetPosition((int) (numOfTiles*motorTicksPerTile));
        mechanismMotor.setTargetPosition(mechMotor);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        mechanismMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRightMotor.setPower(x);
        frontLeftMotor.setPower(x);
        backRightMotor.setPower(x);
        backLeftMotor.setPower(x);
        mechanismMotor.setPower(0.8);
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
        frontLeftMotor.setTargetPosition((int) (-0.9*dir*numOfTiles*motorTicksPerTile));
        backRightMotor.setTargetPosition((int) (-0.9*dir*numOfTiles*motorTicksPerTile));
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

    public void rotate(double degrees, boolean cw) {
        int dir = (cw) ? 1 : -1;
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setTargetPosition((int) (-1*dir*degrees*800.0/90));
        frontLeftMotor.setTargetPosition((int) (dir*degrees*800.0/90));
        backRightMotor.setTargetPosition((int) (-1*dir*degrees*800.0/90));
        backLeftMotor.setTargetPosition((int) (dir*degrees*800.0/90));

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
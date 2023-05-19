package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
Lemme preface this by saying that this is a worst-case scenario if the encoders absolutely refuse to work
Time based auton go brrr ig
 */

@Autonomous
public class TimeBasedAuton extends LinearOpMode {
    private FireHardwareMap hwMap = null;
    private ElapsedTime runtime = new ElapsedTime();
    private final double mecanumWheelRadius = 1.7;
    private final double revolutionsPerMinute = 1620;

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



        driveDistance(60);

    }

    public void driveDistance(double distance) {
        double timeNeeded = distance*1000/(revolutionsPerMinute/(60*2*Math.PI)*mecanumWheelRadius);
        driveTime(timeNeeded);
    }

    public void driveTime(double ms) {
        double power = 0.5;
        hwMap.backLeftMotor.setPower(power);
        hwMap.backRightMotor.setPower(power);
        hwMap.frontLeftMotor.setPower(power);
        hwMap.frontRightMotor.setPower(power);
        sleep((long) ms);
        hwMap.backLeftMotor.setPower(0);
        hwMap.backRightMotor.setPower(0);
        hwMap.frontLeftMotor.setPower(0);
        hwMap.frontRightMotor.setPower(0);
    }
}

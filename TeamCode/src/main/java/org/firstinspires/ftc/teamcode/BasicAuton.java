package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BasicAuton extends LinearOpMode {
    private FireHardwareMap hwMap = null;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        hwMap = new FireHardwareMap(this.hardwareMap);

        waitForStart();
        runtime.reset();


    }

    public void drive(double power, int ms) {
        hwMap.backLeftMotor.setPower(power);
        hwMap.backRightMotor.setPower(power);
        hwMap.frontLeftMotor.setPower(power);
        hwMap.frontRightMotor.setPower(power);
        sleep((long) ms);
    }
}

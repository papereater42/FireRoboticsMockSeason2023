package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsTouchSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
public class FireHardwareMap {
    //create motors
    public DcMotor frontRightMotor = null;
    public DcMotor frontLeftMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotor backLeftMotor = null;

    //create servos
    public DcMotor mechanismMotor = null;

    public BNO055IMU imu = null;

    //public TouchSensor touch = null;
    public RevBlinkinLedDriver led = null;
    public RevTouchSensor touch = null;

    //Hardware Map object
    com.qualcomm.robotcore.hardware.HardwareMap HardwareMap = null;

    public ElapsedTime runtime = new ElapsedTime();



    public FireHardwareMap(com.qualcomm.robotcore.hardware.HardwareMap hwmap) {

        initialize(hwmap);
    }

    private void initialize(com.qualcomm.robotcore.hardware.HardwareMap hwmap) {
        HardwareMap = hwmap;
        //the name of device should change based on name
        frontRightMotor = HardwareMap.get(DcMotor.class, "frontRightMotor");
        frontLeftMotor = HardwareMap.get(DcMotor.class, "frontLeftMotor");
        backRightMotor = HardwareMap.get(DcMotor.class, "backRightMotor");
        backLeftMotor = HardwareMap.get(DcMotor.class, "backLeftMotor");

        mechanismMotor = HardwareMap.get(DcMotor.class, "mechanismMotor");

       touch = HardwareMap.get(RevTouchSensor.class, "touch");
       led = HardwareMap.get(RevBlinkinLedDriver.class, "led");
        //Making servo
        //leftServo = HardwareMap.get(Servo.class, "leftServo");

        //Set up motor direction

        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        //Set motor mode
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        mechanismMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Set zero power behavior

        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //Set 0 power
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);


        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        //return value of radians
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        //gets imu from rev hardware map and connects it to code
        imu = HardwareMap.get(BNO055IMU.class, "imu");        //sets the settings we declared above.
        imu.initialize(parameters);
        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);
    }
}






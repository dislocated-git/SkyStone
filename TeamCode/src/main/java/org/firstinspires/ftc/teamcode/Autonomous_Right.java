package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Autonomous Right", group = "Autonomous Path")
public class Autonomous_Right extends LinearOpMode {


    private AutonomousFunctions AutoFunc = null;
    //  Declare hardware variables
    //Declare motors
    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotor rightBackMotor;

    private DcMotorSimple intakeLeftMotor;
    private DcMotorSimple intakeRightMotor;
    private BNO055IMU imu;

    private CRServo clampServo = null;

    // Detector object
   // private GoldAlignDetector detector = null;

    private void Initialise() {
        telemetry.addData("Status", "Starting up..");
        telemetry.update();
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);



        clampServo = hardwareMap.get(CRServo.class, "clampServo");

        intakeLeftMotor = hardwareMap.get(DcMotorSimple.class,"intakeLeftMotor");
        intakeRightMotor = hardwareMap.get(DcMotorSimple.class, "intakeRightMotor");
        intakeLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = false;
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        //Initialise AutonomousFunctions instance with hardware variables; set time interval
        AutoFunc = new AutonomousFunctions(leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor);

        waitForStart();
    }

    @Override
    public void runOpMode() {

        Initialise();
        AutoFunc.MoveInX(-1, 1, 0.6);
        sleep(4000);

    }




}

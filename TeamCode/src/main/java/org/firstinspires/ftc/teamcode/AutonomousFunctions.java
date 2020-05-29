package org.firstinspires.ftc.teamcode;


//import com.disnodeteam.dogecv.CameraViewDisplay;
//import com.disnodeteam.dogecv.DogeCV;
//import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class AutonomousFunctions extends LinearOpMode {

    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotor rightBackMotor;

    private static final double revsPerBlock = 2000;
    private static final double revsPerFullRotation = 6000;

    AutonomousFunctions(DcMotor leftFrontMotor, DcMotor rightFrontMotor, DcMotor leftBackMotor, DcMotor rightBackMotor) {
        this.leftFrontMotor = leftFrontMotor;
        this.rightFrontMotor = rightFrontMotor;
        this.leftBackMotor = leftBackMotor;
        this.rightBackMotor = rightBackMotor;
    }

    public void MoveInY(float y, double distance, double speed) {
        ResetEncoders();

        leftBackMotor.setTargetPosition((int)(Math.round(distance * revsPerBlock * y)));
        rightBackMotor.setTargetPosition((int)(Math.round(distance * revsPerBlock * y)));
        leftFrontMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * y)));
        rightFrontMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * y)));


        leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftBackMotor.setPower(speed);
        rightBackMotor.setPower(speed);
        leftFrontMotor.setPower(speed);
        rightFrontMotor.setPower(speed);

        while (opModeIsActive() && (leftBackMotor.getCurrentPosition() > 0  || rightBackMotor.getCurrentPosition() > 0 || rightBackMotor.getCurrentPosition() > 0 ||rightFrontMotor.getCurrentPosition() > 0))
        {

            telemetry.update();
            idle();
        }

        leftBackMotor.setPower(0);
        rightBackMotor.setPower(0);
        leftFrontMotor.setPower(0);
        rightFrontMotor.setPower(0);
    }

    public void MoveInX(float x, double distance, double speed) {
        ResetEncoders();

        leftBackMotor.setTargetPosition((int)(Math.round(distance * revsPerBlock * x)));
        rightBackMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * x)));
        leftFrontMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * x)));
        rightFrontMotor.setTargetPosition((int)(Math.round(distance * revsPerBlock * x)));


        leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftBackMotor.setPower(speed);
        rightBackMotor.setPower(speed);
        leftFrontMotor.setPower(speed);
        rightFrontMotor.setPower(speed);

        while (opModeIsActive() && (leftBackMotor.isBusy() && rightBackMotor.isBusy() && rightBackMotor.isBusy() && rightFrontMotor.isBusy()))
        {

            telemetry.update();
            idle();
        }

        leftBackMotor.setPower(0);
        rightBackMotor.setPower(0);
        leftFrontMotor.setPower(0);
        rightFrontMotor.setPower(0);
    }

    public void ResetEncoders(){
        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void runOpMode() {
    }
}

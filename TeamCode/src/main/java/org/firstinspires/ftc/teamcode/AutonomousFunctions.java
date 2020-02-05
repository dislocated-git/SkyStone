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

    private static final double revsPerBlock = 1000;
    private static final double revsPerFullRotation = 400;

    AutonomousFunctions(DcMotor leftFrontMotor, DcMotor rightFrontMotor, DcMotor leftBackMotor, DcMotor rightBackMotor) {
        this.leftFrontMotor = leftFrontMotor;
        this.rightFrontMotor = rightFrontMotor;
        this.leftBackMotor = leftBackMotor;
        this.rightBackMotor = rightBackMotor;
    }

    public void MoveInY(float y, double distance, double speed) {
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftBackMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * y)));
        leftBackMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * y)));
        leftBackMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * y)));
        leftBackMotor.setTargetPosition((int)(-Math.round(distance * revsPerBlock * y)));
    }

    @Override
    public void runOpMode() {
    }
}

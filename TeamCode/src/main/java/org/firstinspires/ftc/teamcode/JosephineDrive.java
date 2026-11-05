package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.ArrayList;

enum ShooterState{
    STOP,
    SHOOT,
    REVERSE
}

@TeleOp
public class JosephineDrive extends LinearOpMode {
    //TODO: define motors, sensors, processors here
    //private DcMotor nectarShooter;

    //private DcMotor pollenShooter;

    //private DcMotor intake;

    private Drive drive;

    private ArrayList<ShooterState> shooterStateList = new ArrayList<>();

    @Override
    public void runOpMode() throws InterruptedException {
        // TODO: add initialise code here
        this.drive = new Drive(null, null, null, null);

        waitForStart();
        resetRuntime();

        if (opModeIsActive()) {
            while(opModeIsActive()) {
                //TODO: add loop code here
                telemetry.addData("Runtime: ", getRuntime());
                telemetry.update();
                this.drive.drive(gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
                telemetry.addLine(shooterStateList.toString());
                handleShooter();
                handleIntake();

            }
        }
    }

    private void handleShooter() {
        // check controller and set shooter to what its meant to be doing
//        if (gamepad1.right_bumper) {
//            telemetry.addLine("nectarShooter: 1");
//            telemetry.addLine("pollenShooter: 1");
//            // nectarShooter.setPower(0.5);
//            // pollenShooter.setPower(0.5);
//        } else {
//            if (gamepad1.right_trigger_pressed) {
//                telemetry.addLine("nectarShooter: -1");
//                telemetry.addLine("pollenShooter: -1");
//            } else {
//                telemetry.addLine("nectarShooter: 0");
//                telemetry.addLine("pollenShooter: 0");
//            }
//        }

        //if right bumper: add ShooterStates.SHOOT to shooter state list
        if (gamepad1.right_bumper){
            if (!shooterStateList.contains(ShooterState.SHOOT)) {
                shooterStateList.remove(ShooterState.REVERSE);
                shooterStateList.remove(ShooterState.REVERSE);
                shooterStateList.add(ShooterState.SHOOT);
            }
        }

        //if right trigger: add ShooterStates.REVERSE to shooter state list
        if (gamepad1.right_trigger_pressed){
            if(!shooterStateList.contains(ShooterState.REVERSE)){
                shooterStateList.add(ShooterState.REVERSE);
            }
        }

//        if (gamepad1.right_bumper && gamepad1.right_trigger)

    }


    private void handleIntake() {
        // check controller and set intake to what its meant to be doing
        if (gamepad1.left_bumper) {
            telemetry.addLine("Intake: 1");
            // intake.setPower(1);
        } else {
            telemetry.addLine("Intake: 0");
            // intake.setPower(0);
        }
    }

    private void driveInit() {
        //frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        //frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        //backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        //backRight = hardwareMap.get(DcMotor.class, "backRight");

        //frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        //backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        //backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private void intakeInit() {
        //intake = hardwareMap.get(DcMotor.class, "intake");

        //intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private void shooterInit() {
        //nectarShooter = hardwareMap.get(DcMotor.class, "nectarShooter");
        //pollenShooter = hardwareMap.get(DcMotor.class, "pollenShooter");

        //nectarShooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //pollenShooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


}

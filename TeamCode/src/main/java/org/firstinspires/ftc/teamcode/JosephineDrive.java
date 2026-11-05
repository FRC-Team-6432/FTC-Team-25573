package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class JosephineDrive extends LinearOpMode {
    //TODO: define motors, sensors, processors here
    //private DcMotor nectarShooter;

    //private DcMotor pollenShooter;

    private DriveSubsystem driveSubsystem;
    private IntakeSubsystem intakeSubsystem;


    @Override
    public void runOpMode() throws InterruptedException {
        this.driveSubsystem = new DriveSubsystem(
                hardwareMap.get(DcMotor.class, "front left"),
                hardwareMap.get(DcMotor.class, "front right"),
                hardwareMap.get(DcMotor.class, "back left"),
                hardwareMap.get(DcMotor.class, "back right"),
                telemetry
        );

        this.intakeSubsystem = new IntakeSubsystem(hardwareMap.get(DcMotor.class, "intake"), telemetry);

        telemetry.update();
        waitForStart();
        resetRuntime();

        if (opModeIsActive()) {
            while(opModeIsActive()) {
                telemetry.addData("Runtime: ", getRuntime());

                this.driveSubsystem.drive(gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
                this.intakeSubsystem.handle(gamepad1.right_bumper, gamepad1.right_trigger_pressed);

                this.driveSubsystem.telemetry();
                this.intakeSubsystem.telemetry();
                telemetry.update();
            }
        }
    }


    private void shooterInit() {
        //nectarShooter = hardwareMap.get(DcMotor.class, "nectarShooter");
        //pollenShooter = hardwareMap.get(DcMotor.class, "pollenShooter");

        //nectarShooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //pollenShooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}

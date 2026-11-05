package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeSubsystem {
    private DcMotor intakeMotor;
    private Telemetry telemetry;

    public IntakeSubsystem(DcMotor intakeMotor, Telemetry telemetry) {
        this.intakeMotor = intakeMotor;
        this.telemetry = telemetry;
    }

    public void handle(boolean shouldIntake, boolean shouldOuttake) {
        if (shouldIntake) {
            intakeMotor.setPower(1);
        } else if (shouldOuttake) {
            intakeMotor.setPower(-1);
        } else {
            intakeMotor.setPower(0);
        }
    }

    public void telemetry() {
        telemetry.addData("Intake", intakeMotor.getPower());
    }
}

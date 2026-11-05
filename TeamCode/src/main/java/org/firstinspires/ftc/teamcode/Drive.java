package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive {
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
    }

    public void drive(double forward, double strafe, double rotation) {
        frontLeft.setPower((forward + rotation) - strafe);
        frontRight.setPower((forward - rotation) + strafe);
        backRight.setPower((forward - rotation) - strafe);
        backLeft.setPower((forward + rotation) + strafe);
    }
}

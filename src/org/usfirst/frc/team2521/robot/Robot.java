
package org.usfirst.frc.team2521.robot;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	ADXL362 adxl;
	ADXRS450_Gyro adxrs;
	
	private Joystick stick;
	
	private JoystickButton resetButton;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		adxl = new ADXL362(Accelerometer.Range.k2G);
		adxrs = new ADXRS450_Gyro();
		
		stick = new Joystick(0);
		resetButton = new JoystickButton(stick, 1);
		
		adxrs.calibrate();
	}
	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro You
	 * can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		if (resetButton.get()) {
			adxrs.reset();
		}
		
		SmartDashboard.putNumber("ADXL getX()", adxl.getX());
		SmartDashboard.putNumber("ADXL getY()", adxl.getY());
		SmartDashboard.putNumber("ADXL getZ()", adxl.getZ());
		SmartDashboard.putNumber("ADXRS getAngle()", adxrs.getAngle());
		SmartDashboard.putNumber("ADXRS getRate()", adxrs.getRate());
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	}
	
}

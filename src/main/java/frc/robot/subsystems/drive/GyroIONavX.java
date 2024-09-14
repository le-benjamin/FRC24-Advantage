package frc.robot.subsystems.drive;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.SPI;

/** IO implementation for navX */
public class GyroIONavX implements GyroIO {
  private final AHRS navx = new AHRS(SPI.Port.kMXP, (byte)100);

  public GyroIONavX() {
    navx.reset();
  }

  @Override
  public void updateInputs(GyroIOInputs inputs) {
    inputs.connected = navx.isConnected();
    inputs.yawPosition = Rotation2d.fromDegrees(navx.getAngle());
    inputs.yawVelocityRadPerSec = Units.degreesToRadians(navx.getRate());
  }
}

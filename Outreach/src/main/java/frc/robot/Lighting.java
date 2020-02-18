package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase; //highlight stages instead

import frc.robot.subsystems.Drive;

public class Lighting extends SubsystemBase {
  private int rainbowHue = 0;
  private Drive m_drive;

  private AddressableLED LED = new AddressableLED(1);
  private AddressableLEDBuffer LEDBuffer = new AddressableLEDBuffer(100);

  private int length = LEDBuffer.getLength();
  private int pulseIndex = 0;

  public Lighting(Drive drive) {
    LED.setLength(length);

    rainbow();

    LED.setData(LEDBuffer);
    LED.start();
  }

  public void teleopPeriodic() {
    int cap = (int) (m_drive.getLeftOutput.get() * length);
    if (cap > 0) {
      for (var i = 0; i < cap; i++) { // red with left output %
        LEDBuffer.setRGB(i, 0, 255, 0);
      }
      for (var i = cap; i < length; i++) {
        LEDBuffer.setRGB(i, 255, 255, 0);
      }
    } else {
      for (var i = 0; i < Math.abs(cap); i++) {
        LEDBuffer.setRGB(i, 255, 0, 0);
      }
      for (var i = Math.abs(cap); i < length; i++) {
        LEDBuffer.setRGB(i, 255, 255, 0);
      }
    }
    LED.setData(LEDBuffer);
  }

  public void autonomousInit() {
    rainbow();
    LED.setData(LEDBuffer);
  }

  public void disabledPeriodic() {
    for (int i = 0; i < length; i++) {
      LEDBuffer.setRGB(i, (int) (Math.sin(i + pulseIndex) * 14 + 14), (int) (Math.sin(i + pulseIndex) * 35 + 35),
          (int) (Math.sin(i + pulseIndex) * 71 + 71));
    }
    LED.setData(LEDBuffer);
    pulseIndex++;
  }

  private void rainbow() {
    for (var i = 0; i < LEDBuffer.getLength(); i++) {
      final var hue = (rainbowHue + (i * 180 / LEDBuffer.getLength())) % 180;
      LEDBuffer.setHSV(i, hue, 255, 128);
    }
    rainbowHue += 3;
    rainbowHue %= 180;
  }
}
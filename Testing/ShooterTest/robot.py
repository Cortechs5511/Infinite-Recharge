import wpilib
from wpilib import SmartDashboard

class MyRobot(wpilib.TimedRobot):
    def robotInit(self):
        self.frontRight = wpilib.Talon(0)
        self.rearRight = wpilib.Talon(1)
        self.frontRight.setInverted(True)
        self.rearRight.setInverted(True)
        self.right = wpilib.SpeedControllerGroup(self.frontRight, self.rearRight)

        self.frontLeft = wpilib.Talon(2)
        self.rearLeft = wpilib.Talon(3)
        self.left = wpilib.SpeedControllerGroup(self.frontLeft, self.rearLeft)

        self.leftStick = wpilib.Joystick(0)
        self.rightStick = wpilib.Joystick(1)

        SmartDashboard.putNumber("Target Speed", 0)

    def teleopInit(self):
        SmartDashboard.putNumber("Target Speed", 0)

    def teleopPeriodic(self):
        speed = SmartDashboard.getNumber("Target Speed", 0)
        self.left.set(speed)
        self.right.set(speed)

if __name__ == "__main__":
    wpilib.run(MyRobot)

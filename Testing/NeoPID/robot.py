#note: this code is written with for the 2019 release of robotpy
import wpilib
from wpilib import SmartDashboard as sd
from wpilib import Spark
import rev
from rev import CANSparkMax

class MyRobot(wpilib.TimedRobot):
    def robotInit(self):
        self.neo0: CANSparkMax = CANSparkMax(50, rev.MotorType.kBrushless)
        self.neo1: CANSparkMax = CANSparkMax(51, rev.MotorType.kBrushless)

        neos = wpilib.SpeedControllerGroup(self.neo0, self.neo1)
        self.neo1.setInverted(True)

        self.neo0.clearFaults()
        self.neo1.clearFaults()

        self.neo0.setClosedLoopRampRate(3)
        self.neo0.enableVoltageCompensation(10)
        self.neo1.setClosedLoopRampRate(3)
        self.neo1.enableVoltageCompensation(10)
        self.revPID = rev._impl.CANPIDController(self.neo0)
        self.revVelPID = rev._impl.CANEncoder(self.neo0)
        self.revPID.setOutputRange(-0.9, 0.9, 0) #lower bound was -0.1 if it breaks
        sd.putNumber("Target RPM", 0)
        sd.putNumber("P", 0.0002)
        sd.putNumber("I", 0)
        sd.putNumber("D", 0.002)
        sd.putNumber("FF", 0.00022)
        sd.putNumber("Speed", 0)

    def teleopInit(self):
        self.neo0.getEncoder().setPosition(0)
        self.neo1.getEncoder().setPosition(0)

    def teleopPeriodic(self):
        self.val = sd.getNumber("Target RPM", 0)
        sd.putNumber("Current RPM", self.revVelPID.getVelocity())
        sd.putNumber("NEO Power", self.neo0.get())
        self.revPID.setP(sd.getNumber("P", 0.0002), 0)
        self.revPID.setI(sd.getNumber("I", 0), 0)
        self.revPID.setD(sd.getNumber("D", 0.002), 0)
        self.revPID.setFF(sd.getNumber("FF", 0.00022), 0)
        self.revPID.setReference(self.val, rev.ControlType.kVelocity, 0, 0)
        #self.neo0.set(sd.getNumber("Speed", 0))

if __name__ == '__main__':
    wpilib.run(MyRobot)

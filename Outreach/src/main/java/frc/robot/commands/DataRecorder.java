package frc.robot.commands;

import java.io.FileWriter;
import java.io.IOException;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DataRecorder extends CommandBase {
    private static final int MAX_ROWS = 9000;
    private static final int COLUMNS = 8;
    private Drive m_drive;
    public double[][] data = new double[MAX_ROWS][COLUMNS];
    private int row = 0;
    private int col = 0;
    private double time = 0;

    public DataRecorder(Drive drive) {
    }

    @Override
    public void execute() {
        col = 0;
        data[row][col++] = m_drive.getLeftVelocity.get();
        data[row][col++] = m_drive.getRightVelocity.get();
        //data[row][col++] = m_drive.getLeftPosition.get();
        //data[row][col++] = m_drive.getRightPosition.get();
        data[row][col++] = m_drive.getLeftOutput.get();
        data[row][col++] = m_drive.getRightOutput.get();
        data[row][col++] = m_drive.getGyroAngle.get();
        data[row][col++] = time;

        row++;
        time += 0.02;
    }

    @Override
    public boolean isFinished() {
        if (time >= 170) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void end(boolean interrupted) {
        FileWriter out;
        try {
            out = new FileWriter("/home/lvuser/data.csv");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < COLUMNS; c++) {
                    out.append(Double.toString(data[r][c]));
                    out.append(",");
                }
                out.append("\n");
            }
        } catch (IOException err) {
            err.printStackTrace();
        } finally {
            try {
                // out.flush(); //<-- code to test
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
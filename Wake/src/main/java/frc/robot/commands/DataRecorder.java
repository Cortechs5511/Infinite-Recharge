package frc.robot.commands;

import java.io.FileWriter;
import java.io.IOException;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DataRecorder extends CommandBase {
    private static final int MAX_ROWS = 50 * 10;
    private static final int COLUMNS = 5;
    private Drive m_drive;
    public double[][] data = new double[MAX_ROWS][COLUMNS];
    private int row = 0;
    private int col = 0;
    private int iteration = 0;

    public DataRecorder(Drive drive) {
        m_drive = drive;
    }

    @Override
    public void execute() {
        col = 0;
        if ((m_drive.getLeftVelocity.get() == 0) && (m_drive.getRightVelocity.get() == 0)){
        }else{
            data[row][col++] = m_drive.getLeftVelocity.get();
            data[row][col++] = m_drive.getRightVelocity.get();
            data[row][col++] = m_drive.getLeftOutput.get();
            data[row][col++] = m_drive.getRightOutput.get();
            data[row][col++] = iteration;
            // navx
            // data[row][col++] = m_drive.getRightOutput.get();
            row++;
        }
        iteration++;
    }

    @Override
    public boolean isFinished() {
        if ((row == (MAX_ROWS - 2)) || ((data[row][0] == 0) && (data[row][1] == 0))) {
            return row > 0;
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
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
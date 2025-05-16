package scr;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class FileService {

    private String fileName;

    public FileService(String fileName){
        this.fileName = fileName;
    }


    public void save(SensorModel sm, Action a) throws IOException{

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))){

            // Dati dei sensori
            pw.append(String.valueOf(sm.getSpeed()));
            pw.append("|");
            pw.append(String.valueOf(sm.getAngleToTrackAxis()));
            pw.append("|");
            pw.append(Arrays.toString(sm.getTrackEdgeSensors()));
            pw.append("|");
            pw.append(String.valueOf(sm.getFocusSensors()));
            pw.append("|");
            pw.append(String.valueOf(sm.getTrackPosition()));
            pw.append("|");
            pw.append(String.valueOf(sm.getGear()));
            pw.append("|");
            pw.append(String.valueOf(sm.getLateralSpeed()));
            pw.append("|");
            pw.append(String.valueOf(sm.getCurrentLapTime()));
            pw.append("|");
            pw.append(String.valueOf(sm.getDamage()));
            pw.append("|");
            pw.append(String.valueOf(sm.getDistanceFromStartLine()));
            pw.append("|");
            pw.append(String.valueOf(sm.getDistanceRaced()));
            pw.append("|");
            pw.append(String.valueOf(sm.getLastLapTime()));
            pw.append("|");
            pw.append(String.valueOf(sm.getRPM()));
            pw.append("|");
            pw.append(String.valueOf(sm.getWheelSpinVelocity()));
            pw.append("|");

            // Dati degli attuatori
            pw.append(String.valueOf(a.accelerate));
            pw.append("|");
            pw.append(String.valueOf(a.brake));
            pw.append("|");
            pw.append(String.valueOf(a.clutch));
            pw.append("|");
            pw.append(String.valueOf(a.gear));
            pw.append("|");
            pw.append(String.valueOf(a.steering));
            pw.append("\n");


        }
        finally{
            System.out.println("Scrittura completata");
        }

    }


}

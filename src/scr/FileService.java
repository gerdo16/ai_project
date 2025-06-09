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


    public void saveCSV(SensorModel data) throws IOException{

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))){
            
            // Dati dei sensori
            pw.append(String.valueOf(data.getSpeed()));
            pw.append("|");
            pw.append(String.valueOf(data.getAngleToTrackAxis()));
            pw.append("|");
            pw.append(String.valueOf(data.getTrackEdgeSensors()[0]));
            pw.append("|");
            pw.append(String.valueOf(data.getTrackEdgeSensors()[9]));
            pw.append("|");
            pw.append(String.valueOf(data.getTrackEdgeSensors()[18]));
            pw.append("|");
            pw.append(String.valueOf(data.getTrackPosition()));
            pw.append("|");
            pw.append(String.valueOf(data.getLateralSpeed()));
            pw.append("|");
            pw.append(String.valueOf(data.getDamage()));
            pw.append("|");

        }
        finally{
            System.out.println("Scrittura completata");
        }

    }


}

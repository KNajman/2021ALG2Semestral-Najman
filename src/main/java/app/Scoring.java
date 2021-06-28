package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

/**
 *
 * @author najma
 */
public class Scoring {

    private final LocalTime[] timeOn1km;
    private final int[] pullUps;
    private final int[] sitUps;
    private final int[] pushUps;

    public Scoring(LocalTime[] timeOn1km, int[] pullUps, int[] sitUps, int[] pushUps) {
        this.timeOn1km = timeOn1km;
        this.pullUps = pullUps;
        this.sitUps = sitUps;
        this.pushUps = pushUps;
    }

    public void loadFitness(File filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            LocalTime timeOn1[] = new LocalTime[5];
            int pullU[] = new int[5];
            int sitU[]= new int[5];
            int pushU[] = new int[5];
            int i = 0;
            Scoring s;
            br.readLine(); //preskoceni zahlavi
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); //x,0:00:00,1,2,3,4
                timeOn1[i] = LocalTime.parse(parts[1]);
                pullU[i] = Integer.parseInt(parts[2]);
                sitU[i] = Integer.parseInt(parts[3]);
                pushU[i] = Integer.parseInt(parts[4]);
                i++;
            }
            s = new Scoring(timeOn1, pullU, sitU, pushU);
        }
    }

}

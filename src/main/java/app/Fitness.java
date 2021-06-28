package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author najma
 */
public class Fitness {

    private final String[] category;
    private final int[] maxPoints;

    public Fitness(String[] category, int[] maxPoints) {
        this.category = category;
        this.maxPoints = maxPoints;
    }

    public void loadFitness(File filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String str[] = new String[5];
            int num[] = new int[5];
            int i = 0;
            Fitness f;
            br.readLine(); //preskoceni zahlavi
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); //výborna,10
                str[i] = parts[0];
                num[i] = Integer.parseInt(parts[1]);
                i++;
            }
            f = new Fitness(str, num);
        }
    }

}

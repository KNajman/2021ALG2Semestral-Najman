package ui;

import app.Aspirant;
import app.Test;
import app.Fitness;
import app.Scoring;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author najma
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static File dataDirectory;
    public static Test myTest;
    public static Fitness f;
    public static Scoring s;

    public static void main(String[] args) {
        myTest = new Test();
        String userDir = System.getProperty("user.dir");
        dataDirectory = new File(userDir + File.separator + "data");

        while (true) {
            try {
                f.loadFitness(new File(dataDirectory, "zdatnost.csv"));
                s.loadScoring(new File("bodovani.csv"));
                System.out.println("Fyzické hodnocení pro příjetí na Univerzitu Obrany");
                System.out.println("Zadejte soubor nazev souboru z ktereho budou nacitani sportovci");
                String aspirantFile = sc.next();
                myTest.loadAspirants(new File(dataDirectory, aspirantFile));
            } catch (IOException ex) {
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Nacteni dat ze souboru neprobehlo v poradku");
            }
            
            System.out.println("");
            vypocetBodu(Test, )
        }
    }

}

}

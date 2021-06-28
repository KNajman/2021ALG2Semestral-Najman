package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author najma
 */
public class Test {

    public static DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("mm:ss");
    private List<Aspirant> Aspirants;

    public Test() {
        Aspirants = new ArrayList<>();
    }

    /**
     * *
     * load file with aspirants
     *
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadAspirants(File filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int number, age, pullUps, sitUps, pushUps;
            LocalTime timeOn1Km;
            String name, surname;
            Aspirant a;
            br.readLine(); //preskoceni zahlavi
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); //1,Jan Novak,21
                number = Integer.parseInt(parts[0]);
                String[] firstLast = parts[1].split(" ");
                name = firstLast[1];
                surname = firstLast[0];
                age = Integer.parseInt(parts[2]);
                timeOn1Km = LocalTime.parse(parts[2], dtfTime);
                pullUps = Integer.parseInt(parts[3]);
                sitUps = Integer.parseInt(parts[4]);
                pushUps = Integer.parseInt(parts[5]);
                a = new Aspirant(number, name, surname, age, timeOn1Km, pullUps, sitUps, pushUps);
                Aspirants.add(a);
            }
        }
    }

    /**
     * *
     * find aspirants with unique number
     * @param number
     * @return
     */
    private Aspirant findByNumber(int number) {
        for (Aspirant a : Aspirants) {
            if (a.getNumber() == number) {
                return a;
            }
        }
        throw new NoSuchElementException("Runner with number " + number + "does not exist.");
    }
/***
 * 
 * @return data list to string
 * 
 */
    private String getResults() {
        StringBuilder sb = new StringBuilder();
        Aspirants.forEach(a -> {
            sb.append(a).append("\n");
        });
        return sb.toString();
    }
/**
 * 
 * @return sorted list of Aspirants by points
 */
    public String getAspirantsByPoints() {
        Collections.sort(Aspirants, Aspirant.BY_POINTS);
        return getResults();
    }
/**
 * 
 * @return sorted list of Aspirants by name
 */
    public String getAspirantsByName() {
        Collections.sort(Aspirants, Aspirant.BY_NAME);
        return getResults();
    }
/**
 * 
 * @return sorted list of Aspirants by unique number
 */
    public String getAspirantsByNumber() {
        Collections.sort(Aspirants);
        return getResults();
    }
/***
 * 
 * @param resultFile
 * @throws IOException 
 */
    //ulozeni vysledku do textoveho souboru, oddelovaci znak je mezera
    public void saveResultsToText(File resultFile) throws IOException {
        Collections.sort(Aspirants, Aspirant.BY_POINTS);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, false)))) { //true (append) - zapise data na konec souboru
            pw.println(String.format("%s %s %s %s", "Cislo", "Jmeno", "Prijmeni", "body")); //zahlavi
            String s;
            for (Aspirant a : Aspirants) {
                s = String.format("%d %s %s %s", a.getNumber(), a.getName(), a.getSurname(), a.getPoints());
                pw.println(s);
            }
        }
    }
/***
 * 
 */
    public void setPoints() {
        int points = 0;
        for (Aspirant a : Aspirants) {
            Colections.a.setPoints(points);
        }

    }

    /***
     * 
     */
        public void writeDownToJSON {
         ObjectMapper objectMapper = new ObjectMapper();
        // uožení do souboru
        try {
            objectMapper.writeValue(new File("file.json"), Test());
            System.out.println("MyObject uložen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

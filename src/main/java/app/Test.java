
package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
    public static DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("M/d/yyyy");
    public static DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("H:mm:ss.S");
    private List<Aspirant> Aspirants;
    
    public Test(){
        Aspirants = new ArrayList<>();
        
    }
    
    public void loadAspirants(File filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            int number, age;
            String name, surname;
            Aspirant a;
            br.readLine(); //preskoceni zahlavi
            while((line = br.readLine()) != null){
                String[] parts = line.split(","); //1,Jan Novak,21
                number = Integer.parseInt(parts[0]);
                String[] firstLast = parts[1].split(" ");
                name = firstLast[1];
                surname = firstLast[0];
                age=Integer.parseInt(parts[2]);
                a = new Aspirant(number,name, surname, age);
                Aspirants.add(a);
            }
        }
    }
    
     private Aspirant findByNumber(int number){
        for (Aspirant a : Aspirants) {
            if(a.getNumber() == number){
                return a;
            }
        }
        throw new NoSuchElementException("Runner with number " + number + "does not exist.");
    }
    
    private String getResults(){
        StringBuilder sb = new StringBuilder();
        for (Aspirant a : Aspirants) {
            sb.append(a).append("\n");
        }
        return sb.toString();
    }
    
    public String getAspirantsByPoints(){
        Collections.sort(Aspirants, Aspirant.BY_POINTS);
        return getResults();
    }
    
    public String getAspirantsByName(){
        Collections.sort(Aspirants, Aspirant.BY_NAME);
        return getResults();
    }
    
    public String getAspirantsByNumber(){
        Collections.sort(Aspirants);
        return getResults();
    }
    
    
    //ulozeni vysledku do textoveho souboru, oddelovaci znak je mezera
    public void saveResultsToText(File resultFile) throws IOException{
        Collections.sort(Aspirants, Aspirant.BY_POINTS);
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, false)))){ //true (append) - zapise data na konec souboru
            pw.println(String.format("%s %s %s %s","Cislo", "Jmeno", "Prijmeni", "body")); //zahlavi
            String s;
            for (Aspirant a : Aspirants) {
                s = String.format("%d %s %s %s",a.getNumber(), a.getName(), a.getSurname(), a.getPoints());
                pw.println(s);
            }
        }
    }
    
    
    
    
}

package app;

import java.text.Collator;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author najma
 */
public class Aspirant implements Comparable<Aspirant> {
    public static DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("mm:ss");

    private final int number;
    private String name;
    private String surname;
    //private LocalDate born;
    private int age;
    private int points;
    private LocalTime timeOn1Km;
    private int pullUps;
    private int sitUps;
    private int pushUps;

    public Aspirant(int number, String name, String surname, int age, LocalTime timeOn1Km, int pullUps, int sitUps, int pushUps) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.timeOn1Km = timeOn1Km;
        this.pullUps = pullUps;
        this.sitUps = sitUps;
        this.pushUps = pushUps;
    }
    
    public LocalTime getTimeOn1Km() {
        return timeOn1Km;
    }

    public int getPullUps() {
        return pullUps;
    }

    public int getSitUps() {
        return sitUps;
    }

    public int getPushUps() {
        return pushUps;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Uchazeč číslo ").append(number);
        sb.append(", jmeno ").append(name);
        sb.append("").append(surname);
        sb.append(", vek ").append(age);
        sb.append(", body ").append(points);
        return sb.toString();
    }

    public static final Comparator<Aspirant> BY_POINTS
            = (Aspirant a1, Aspirant a2) -> a1.getPoints() - a2.getPoints();

    public static Collator col = Collator.getInstance(new Locale("cs", "CZ"));
    public static final Comparator<Aspirant> BY_NAME = new Comparator<Aspirant>() {
        @Override
        public int compare(Aspirant a1, Aspirant a2) {
            int result = col.compare(a1.surname, a2.surname);
            if (result == 0) { //if same lastName, compare using firstName
                result = col.compare(a1.name, a2.name);
            }
            return result;
        }
    };

    @Override
    public int compareTo(Aspirant o) {
        return this.number - o.number;
    }

}

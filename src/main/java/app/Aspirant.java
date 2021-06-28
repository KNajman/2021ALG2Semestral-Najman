package app;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author najma
 */
public class Aspirant implements Comparable<Aspirant> {

    private final int number;
    private String name;
    private String surname;
    //private LocalDate born;
    private int age;
    private int points;

    public Aspirant(int number, String name, String surname, int age) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.age = age;
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
        sb.append("Uchazec cislo: ").append(number);
        sb.append(",jmeno ").append(name);
        sb.append(" ").append(surname);
        sb.append(", vek ").append(age);
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

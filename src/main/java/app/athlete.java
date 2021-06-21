package app;

/**
 *
 * @author najmas
 */
public class athlete {

    private int athleteNumber;
    private String name;
    private String surname;
    private String team;
    private int age;
//    private double heigth;
//    private double weigth;
//    private double BMI;
    
//    int year = LocalDate.now().getYear(); 
//    int n=1;


    public athlete(int athleteNumber, String name, String surname, String team, int age) {
        this.athleteNumber = athleteNumber;
        this.name = name;
        this.surname = surname;
        this.team = team;
        this.age = age;        
    }

    public int getAthleteNumber() {
        return athleteNumber;
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

    public String getTeam() {
        return team;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(athleteNumber);
        sb.append(", ").append(name);
        sb.append(", ").append(surname);
        sb.append(", ").append(age);
        return sb.toString();
    }

    public static void main(String[] args) {

    }



}

import java.util.Calendar;

public class Person {


    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;


    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getFormalName(){
        return title + ". " + firstName + " " + lastName;
    }

    public int getAge(){
        int age=0;
        age= 2023 - YOB;
        return age;
    }

    public int getAge(int year){
        year = Calendar.getInstance().get(Calendar.YEAR);
        return (year - YOB);
    }

    public String toCSVDataRecord() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

}



package package_student;

public class Student {

    private int matnr;

    private String firstname;

    private String lastname;

    private String email;

    //Constructors

    public Student() {
    }

    public Student(int matnr, String firstname, String lastname, String email) {
        this.matnr = matnr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    //Getter and Setter

    public int getMatnr() {
        return matnr;
    }

    public void setMatnr(int matnr) {
        this.matnr = matnr;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "matnr=" + matnr +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

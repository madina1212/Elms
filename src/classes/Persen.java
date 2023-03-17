package classes;

import enums.Gender;
public class Persen {
    private String name;
    private String sorName;
    private long id;
    private String gmail;
    private String passwprd;
    private Gender gender;

    public Persen(String name, String sorName, long id, String gmail, String passwprd, Gender gender) {
        this.name = name;
        this.sorName = sorName;
        this.id = id;
        this.gmail = gmail;
        this.passwprd = passwprd;
        this.gender = gender;
    }

    public Persen(int i) {
    }

    public String getName(String name2) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSorName() {
        return sorName;
    }

    public void setSorName(String sorName) {
        this.sorName = sorName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPasswprd() {
        return passwprd;
    }

    public void setPasswprd(String passwprd) {
        this.passwprd = passwprd;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Persen{" +
                "name='" + name + '\'' +
                ", sorName='" + sorName + '\'' +
                ", id=" + id +
                ", gmail='" + gmail + '\'' +
                ", passwprd='" + passwprd + '\'' +
                ", gender=" + gender +
                '}';
    }

    public void getStudentList() {
    }

    public void getSorName(String name2) {
    }

    public String getName() {
        return null;
    }
}

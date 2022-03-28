package Classes;

import java.io.Serializable;
//Extends the super class which is the DefaultMember class
//Shows Inheritance here.
public class StudentMember extends DefaultMember implements Serializable {
    //Attributes for the class
    private String SchoolName;
    //Constructor for class
    public StudentMember(int membershipNumber, String name, Date startmeMbershipDate, String schoolName) {
        super(membershipNumber, name, startmeMbershipDate);
        SchoolName = schoolName;
    }
    //Using getters and setters to access the instance variables
    //Shows Encapsulation
    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    @Override
    public String toString() {
        return "StudentMember{" +
                "SchoolName='" + SchoolName + '\'' +
                "} " + super.toString();
    }
}

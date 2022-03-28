package Classes;

import java.io.Serializable;
//Extending the DefaultMember class which is the Super Class
//Shows Inheritance
public class Over60Member extends DefaultMember implements Serializable {

    //Attributes for class Over60Member
    private int Age;

    public Over60Member(int membershipNumber, String name, Date startMembershipDate, int age) {
        super(membershipNumber, name, startMembershipDate);
        Age = age;
    }
    //Using getters and setters
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Over60Member{" +
                "Age=" + Age +
                "} " + super.toString();
    }
}

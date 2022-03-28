package Classes;

import java.io.Serializable;

public abstract class DefaultMember implements Serializable {
    //Instance variables of the DefaultMember class
    private int membershipNumber;
    private String name;
    private Date startMembershipDate;

    //Creating the constructor for the class
    public DefaultMember(int membershipNumber, String name, Date startMembershipDate) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.startMembershipDate = startMembershipDate;
    }
    //Getter methods and Setter methods for the instance variables
    //Shows use of Encapsulation.
    public int getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    @Override
    public String toString() {
        return "DefaultMember{" +
                "membershipNumber=" + membershipNumber +
                ", name='" + name + '\'' +
                ", startMembershipDate=" + startMembershipDate +
                '}';
    }

}

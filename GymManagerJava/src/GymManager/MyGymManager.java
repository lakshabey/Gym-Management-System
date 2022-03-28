package GymManager;

import Classes.Date;
import Classes.DefaultMember;
import Classes.Over60Member;
import Classes.StudentMember;
import javafx.application.Application;
import sample.Main;

import java.io.*;
import java.util.*;

public class MyGymManager implements GymManager, Serializable {
    //Creating ArrayList to store the member's details.
    //with initial capacity of 100 members
    ArrayList<DefaultMember> gymmmbers = new ArrayList<>(100);

    @Override
    public ArrayList<DefaultMember> addMember(DefaultMember member) {


        //Adding member to gymmembers list
        if (gymmmbers.size()<100) {
            gymmmbers.add(member);
        }
        else {
            //validation(if exceeds 100 members)

            System.out.println("PROCESS FAILED. MEMBER LIST EXCEEDED!!!\n");
        }

        return gymmmbers;
    }

    @Override
    public void deleteMember() {
        boolean condition = false;
        Scanner del = new Scanner(System.in);
        System.out.println("Enter membership number of member");
        int membershipNo = del.nextInt();
        for (DefaultMember member: gymmmbers) {
            if (member.getMembershipNumber() == membershipNo) {
                condition = true;
                gymmmbers.remove(member);
                System.out.println("Member successfully removed");
                break;
            }
        }
        if (!condition) {

            System.out.println("Error in removing");
        }


    }

    @Override
    //Printing the List in the console
    public void printMember() {
        //Iterating through the list and printing
        for (int i=0;i<gymmmbers.size();i++){
            DefaultMember printMember = gymmmbers.get(i);
            System.out.println(printMember.toString());
        }

    }

    @Override
    //Sorting the list of members Alphabetically by name
    public void sortMembers() throws ClassCastException {
        Collections.sort(gymmmbers, new Comparator<DefaultMember>() {

            public int compare(DefaultMember s1, DefaultMember s2){
                return Integer.valueOf(s1.getName().compareTo(s2.getName()));
            }
        });
        for (int i=0;i<gymmmbers.size();i++){
            DefaultMember sortMembers = gymmmbers.get(i);
            System.out.println(sortMembers.toString());
        }

    }

    @Override
    //Saving/Writing the members to file
    public void saveMember() throws IOException {
        String newFileName = "GymMembersData.txt";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(newFileName));
        outputStream.writeObject(gymmmbers);
        outputStream.close();
        System.out.println("Successfully Saved to File");



    }
    //the main run method to display to the manager
    @Override
    //The main menu to run for the Gym Manager
    public void openMenu() throws Exception {
        boolean exit = false;
        //Getting the input from the user
        Scanner input = new Scanner(System.in);

        while(!exit) {
            //Displaying the choices from the menu to the user
            System.out.println("Enter 1 to Add a new member");
            System.out.println("Enter 2 to Delete a Memeber");
            System.out.println("Enter 3 to Sort the members list");
            System.out.println("Enter 4 to Save a Member/Members");
            System.out.println("Enter 5 to Print Members list");
            System.out.println("Enter 6 to open GUI");
            System.out.println("Enter 0 to Exit Programme");
            int choice = input.nextInt();
            //If the user selects to add a member
            if (choice == 1) {
                //Display the amount of slots used up and available
                System.out.println("Number of used up slots are " + gymmmbers.size());
                System.out.println("Number of slots available is "+ (100-gymmmbers.size()) );

                //the choice to add a student or an over 60 member
                System.out.println("\nEnter 1 to add a student member");
                System.out.println("Enter number 2 to add a member over 60 years of age");
                int memberChoice = input.nextInt();
                //If user selects to add a student
                if (memberChoice == 1) {
                    //Entering the name of the student which was an instance variable in DefaultMember class.
                    System.out.println("Enter name of the student below");
                    String studentsName = input.next();
                    //Entering the membership number
                    System.out.println("Enter the Membership number of the Student");
                    int stuMembershipNo = input.nextInt();
                    //Getting the start date of membership
                    System.out.println("Enter the starting Day of the membership of the student");
                    int startMemDay = input.nextInt();
                    //Validation for the number of days
                    if (startMemDay>30){
                        System.out.println("Day cannot be more than 30 Days. Please enter a valid date");
                        startMemDay = input.nextInt();
                    }
                    System.out.println("Enter the starting Month of the membership of the student");
                    int startMemMonth = input.nextInt();
                    //Validation for the number of months
                    if (startMemMonth>12){
                        System.out.println("Inavlid Month. Please enter a Valid month");
                        startMemMonth = input.nextInt();
                    }
                    System.out.println("Enter the starting Year of the membership of the student");
                    int startMemYear = input.nextInt();
                    Date date = new Date(startMemDay, startMemMonth, startMemYear);
                    //Getting the school name of the student
                    System.out.println("Enter the School name of the Student");
                    String nameOfSchool = input.next();

                    //Creating student object
                    StudentMember newStudentMember = new StudentMember(stuMembershipNo, studentsName, date, nameOfSchool );
                    //Passing to the setter methods
                    newStudentMember.setSchoolName(nameOfSchool);
                    newStudentMember.setMembershipNumber(stuMembershipNo);
                    newStudentMember.setName(studentsName);
                    newStudentMember.setStartMembershipDate(date);
                    //Calling the addMember method
                    addMember(newStudentMember);
                    System.out.println("Member Added!");


                }
                //If choice is 2, adds over 60 member
                else if (memberChoice == 2) {


                    //Getting the name of the over 60 member
                    System.out.println("Enter name of the over 60 new member");
                    String nameOfMember = input.next();
                    //Getting the membership number
                    System.out.println("Enter membership number of member");
                    int membershipNo = input.nextInt();
                    //Getting the starting membership date
                    System.out.println("Enter Starting Day of membership");
                    int startMemDay = input.nextInt();
                    //Validation for the number of days
                    if (startMemDay>30){
                        System.out.println("Day cannot be more than 30 Days. Please enter a valid date");
                        startMemDay = input.nextInt();
                    }
                    System.out.println("Enter the Starting Month of the membership");
                    int startMemMonth = input.nextInt();
                    //Validation for the number of months
                    if (startMemMonth>12){
                        System.out.println("Inavlid Month. Please enter a Valid month");
                        startMemMonth = input.nextInt();
                    }
                    System.out.println("Enter the Starting Year of the membership");
                    int startMemYear = input.nextInt();
                    Date membershipDate = new Date(startMemDay, startMemMonth, startMemYear);
                    //Getting the age of the member
                    System.out.println("Enter the age of the member");
                    int ageOfMember = input.nextInt();
                    //Creating Over60Member class object and passing the inputs to it.
                    Over60Member newOver60Member = new Over60Member(membershipNo, nameOfMember, membershipDate, ageOfMember);
                    //Using setter methods to set the inputs.
                    newOver60Member.setName(nameOfMember);
                    newOver60Member.setMembershipNumber(membershipNo);
                    newOver60Member.setAge(ageOfMember);
                    newOver60Member.setStartMembershipDate(membershipDate);
                    addMember(newOver60Member);
                    System.out.println("Member Added!");
                }
                //Deleting members
            } else if (choice == 2) {
                deleteMember();
            } else if (choice == 3) {
                //Sorting the members
                sortMembers();
            } else if (choice == 4) {
                //Saving or Writing Members
                saveMember();
            } else if (choice == 5) {
                //Printing Members
                printMember();
            } else if(choice==6){
                Application.launch(Main.class);}
            else {
                //To exit the programme
                System.out.println("\nDo you wish to exit the program (yes/no) ");
                String newChoice = input.next();
                newChoice.toLowerCase();
                if(newChoice.equals("yes")) {
                    exit = true;
                    continue;
                }
                //using validations to exit
                while (!newChoice.equals("no")) {
                    System.out.println("\nplease enter 'yes' to exit and 'no' to continue.)");
                    newChoice = input.next();
                    newChoice.toLowerCase();
                    if (newChoice.equals("y")) {
                        exit = true;
                        break;
                    }
                    else if (newChoice.equals("n")) {
                        continue;
                    }
                }

            }
        }

    }

}

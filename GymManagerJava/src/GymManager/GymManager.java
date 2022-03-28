package GymManager;

import Classes.DefaultMember;

import java.io.IOException;
import java.util.ArrayList;

public interface GymManager {
    public ArrayList<DefaultMember> addMember(DefaultMember member);
    public void deleteMember();
    public void printMember();
    public void sortMembers() throws ClassCastException;
    public void saveMember() throws IOException;
    public void openMenu() throws Exception;
}

package sample;

import Classes.Date;
import Classes.DefaultMember;
import GymManager.MyGymManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Main extends Application {

    ObservableList<DefaultMember> retrieved = FXCollections.observableArrayList();
    String line;
    Stage theNewWindow;
    TableView<DefaultMember> tableOfMembers;

    @Override
    public void start(Stage primaryStage) throws Exception{
        theNewWindow = primaryStage;
        theNewWindow.setTitle("Members List of the Gym");

        TableColumn<DefaultMember,Integer> membershipNoColumn = new TableColumn<>("Membership Number");
        membershipNoColumn.setMinWidth(210);
        membershipNoColumn.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));

        TableColumn<DefaultMember,String> memberNameColumn = new TableColumn<>("Member Name");
        memberNameColumn.setMinWidth(150);
        memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<DefaultMember, Date> memStartDateColumn = new TableColumn<>("Starting Date");
        memStartDateColumn.setMinWidth(150);
        memStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));

        tableOfMembers = new TableView<>();
        //ObservableList<DefaultMember> oListStavaka = FXCollections.observableArrayList(getMembersList());
        //tableOfMembers.setItems();
        tableOfMembers.getColumns().addAll(membershipNoColumn, memberNameColumn, memStartDateColumn);



        VBox newLayout = new VBox(20);
        newLayout.getChildren().addAll(tableOfMembers);

        Scene newsScene = new Scene(newLayout);
        theNewWindow.setScene(newsScene);

        theNewWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<DefaultMember> getMembersList() {
        ObservableList<DefaultMember> gymMemberList = FXCollections.observableArrayList();
        ObjectInputStream inputStream;


            try {
                inputStream = new ObjectInputStream(new FileInputStream("GymMembersData.txt"));
                List<DefaultMember> members = (new List<DefaultMember>() {
                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public boolean contains(Object o) {
                        return false;
                    }

                    @Override
                    public Iterator<DefaultMember> iterator() {
                        return null;
                    }

                    @Override
                    public Object[] toArray() {
                        return new Object[0];
                    }

                    @Override
                    public <T> T[] toArray(T[] a) {
                        return null;
                    }

                    @Override
                    public boolean add(DefaultMember defaultMember) {
                        return false;
                    }

                    @Override
                    public boolean remove(Object o) {
                        return false;
                    }

                    @Override
                    public boolean containsAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean addAll(Collection<? extends DefaultMember> c) {
                        return false;
                    }

                    @Override
                    public boolean addAll(int index, Collection<? extends DefaultMember> c) {
                        return false;
                    }

                    @Override
                    public boolean removeAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean retainAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public DefaultMember get(int index) {
                        return null;
                    }

                    @Override
                    public DefaultMember set(int index, DefaultMember element) {
                        return null;
                    }

                    @Override
                    public void add(int index, DefaultMember element) {

                    }

                    @Override
                    public DefaultMember remove(int index) {
                        return null;
                    }

                    @Override
                    public int indexOf(Object o) {
                        return 0;
                    }

                    @Override
                    public int lastIndexOf(Object o) {
                        return 0;
                    }

                    @Override
                    public ListIterator<DefaultMember> listIterator() {
                        return null;
                    }

                    @Override
                    public ListIterator<DefaultMember> listIterator(int index) {
                        return null;
                    }

                    @Override
                    public List<DefaultMember> subList(int fromIndex, int toIndex) {
                        return null;
                    }
                }) ;inputStream.readObject();
                gymMemberList.addAll(members);
                inputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        return gymMemberList;
    }

}


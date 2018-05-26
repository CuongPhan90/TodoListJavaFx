package com.david.todolist;

import com.david.todolist.datamodel.Todoitem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import javax.swing.text.html.ListView;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Todoitem> todoItems;
    @FXML
    private javafx.scene.control.ListView<Todoitem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    public void initialize(){
        Todoitem item1 = new Todoitem("Mail Birthday Card","Buy a 26th birthday card for Kathy",
                LocalDate.of(2018,Month.DECEMBER,13));
        Todoitem item2 = new Todoitem("Doctor Appointment","See Doctor at Longfield Street",
                LocalDate.of(2018,Month.NOVEMBER,14));
        Todoitem item3 = new Todoitem("Java Course","Study Java language",
                LocalDate.of(2018,Month.JANUARY,1));
        Todoitem item4 = new Todoitem("JavaScript Course","Study JavaScript",
                LocalDate.of(2018,Month.JULY,13));
        Todoitem item5 = new Todoitem("Job Interview","Get an interview on Tuesday",
                LocalDate.of(2018,Month.JUNE,23));

        todoItems = new ArrayList<Todoitem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue != null){
                    Todoitem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    deadlineLabel.setText(item.getDeadline().toString());
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

    }

    @FXML
    public void handelClickListView(){
        Todoitem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());

//        System.out.println("The selected item is : " + item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());

    }
}

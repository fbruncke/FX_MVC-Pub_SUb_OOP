package com.example.fx_simplenavminusdatabinding;

import Model.Student;
import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;


public class DetailviewController implements Subscriber{

    //The model class Student, which the UI binds to
    private Student student = null;

    //The UI instance variables
    @FXML
    private Label welcomeText;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAge;

    //Evenhandlers for the UI
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onMainClick() {
        Main.changeScene(ControllerNames.OverView);
    }


    @FXML
    protected void onChangeStudentClick() {

        student.setName( tfName.getText() );
        MessageBroker.getInstance().publish(MessageBroker.Subjects.info, tfName.getText());
    }

    @FXML
    protected void onLoadDataButtonClick() {
        tfName.setText(student.getName());
        tfAge.setText( Integer.toString(student.getAge() ));
    }


    @FXML
    public void initialize() {
        //creating an instance of the model class student
        student = new Student("Heino Hinkelbein", 67);

    }


    @Override
    public void update(String message) {

    }
}

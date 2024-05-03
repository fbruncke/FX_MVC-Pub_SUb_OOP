package com.example.fx_simplenavminusdatabinding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmptyviewController implements Subscriber{
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome emptyview controller!");
        MessageBroker.getInstance().subscribe(this, MessageBroker.Subjects.info);
    }




    public void changeView(ActionEvent actionEvent)
    {
        //welcomeText.setText("Test");
        //Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Main.changeScene(ControllerNames.DetailsView);

    }

    @Override
    public void update(String message) {
        welcomeText.setText(message);
    }
}

package controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RentingCar {

    @FXML
    private JFXButton RentBtn;
    @FXML
    public void handleCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/customers.fxml"));
        Stage stage=stageService.mainStage;
        stage.setOnCloseRequest(e-> Platform.exit());
        stage.setScene(new Scene(root,671,506));
        stage.show();
    }




}

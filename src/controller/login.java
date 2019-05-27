package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class login implements Initializable {


    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXCheckBox BoxRem;

    @FXML
    private ImageView progress;

    public void loginAction() throws IOException {
        progress.setVisible(true);
        PauseTransition pause = new PauseTransition();
        boolean check = checkLogin(Username.getText(),Password.getText());
        if(check == true)
        {
            pause.setDuration(Duration.seconds(2));
            pause.play();
            pause.setOnFinished((e)->{
                try {
                    login();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }


    }

    public void login() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Car.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnCloseRequest(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }



    public boolean checkLogin(String username, String password)
    {
        if(!username.equals("admin") && !password.equals("admin"))
        {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        progress.setVisible(false);
    }
}

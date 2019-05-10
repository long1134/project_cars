package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import info.Car;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class home implements Initializable {
    private boolean isOpen = false;

    @FXML
    private AnchorPane Menu;

    @FXML
    private ImageView menuIcon;


    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnInFo;


    @FXML
    private JFXButton newCar;

    @FXML
    private JFXButton oldCar;

    @FXML
    private AnchorPane popupLogout;

    @FXML
    private TreeTableView<?> tableInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        popupLogout.setVisible(false);
        Menu.setVisible(false);
        DropShadow drop_shadow = new DropShadow(10, Color.RED);
        Menu.setEffect(drop_shadow);
        newCar.setEffect(drop_shadow);
        oldCar.setEffect(drop_shadow);
    }

    public void initTable()
    {
        TreeItem<String> name = new TreeItem<>("Long vip");
        TreeTableColumn<String,String> columnName = new TreeTableColumn<>("Name");
        columnName.setPrefWidth(100);
        tableInfo.setPrefWidth(150);

    }


    @FXML
    void openMenu(MouseEvent event) {
        if(!isOpen)
        {
            Menu.setVisible(true);
            isOpen = false;
        }
        else
        {
            Menu.setVisible(false);
            isOpen=true;
        }
    }


    @FXML
    void hoverMenu(MouseEvent event) {

    }


    @FXML
    void openPopupLogout(ActionEvent event) {
        popupLogout.setVisible(true);
        Menu.setVisible(false);
    }

    @FXML
    void outPopupLogout(ActionEvent event) {
        popupLogout.setVisible(false);
    }

    @FXML
    void logoutLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root,601,506));
        stage.show();
    }
}

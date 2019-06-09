package controllerAdmin;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreAdminControll implements Initializable {
    @FXML
    private JFXButton gotoCustomers;

    @FXML
    private JFXButton ListOrder;

    @FXML
    private JFXButton Employee;

    @FXML
    private JFXButton Store;

    @FXML
    private ImageView menuIcon;

    @FXML
    private TableView<?> tableInfoOldCar;

    @FXML
    private TableColumn<?, ?> CarName;

    @FXML
    private TableColumn<?, ?> dayCome;

    @FXML
    private TableColumn<?, ?> cost;

    @FXML
    private TableColumn<?, ?> quality;

    @FXML
    private TableColumn<?, ?> statusCar;

    @FXML
    private AnchorPane Menu;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnInFo;

    @FXML
    private JFXTextField txtNameCar;

    @FXML
    private JFXTextField txtPriceCar;

    @FXML
    private JFXTextField txtQuanlityCar;

    @FXML
    private JFXButton btnAddCar;

    @FXML
    private JFXButton btnSaveChange;

    @FXML
    private DatePicker txtDayCar;

    @FXML
    private JFXButton btnOpenPopupDelete;

    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleCustomer(ActionEvent actionEvent) {
    }

    public void gotoListOrder(ActionEvent actionEvent) {
    }

    public void GoToEmployee(ActionEvent actionEvent) {
    }

    public void GoToStore(ActionEvent actionEvent) {
    }

    public void openMenu(MouseEvent mouseEvent) {
    }

    public void openPopupLogout(ActionEvent actionEvent) {
    }

    public void handleSaveCar(ActionEvent actionEvent) {
    }

    public void openPopUp(ActionEvent actionEvent) {
    }
}

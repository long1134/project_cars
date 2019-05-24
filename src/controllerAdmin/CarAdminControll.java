package controllerAdmin;

import com.jfoenix.controls.JFXButton;
import controller.stageService;
import info.Car;
import info.CarAdmin;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarAdminControll implements Initializable {
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
    private AnchorPane Menu;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnInFo;

    @FXML
    private AnchorPane popupLogout;

    @FXML
    private JFXButton closePopup;

    @FXML
    private JFXButton newCar;

    @FXML
    private JFXButton oldCar;

    @FXML
    private TableView<CarAdmin> tableInfo;

    @FXML
    private TableColumn<CarAdmin, String> CarName;

    @FXML
    private TableColumn<CarAdmin, String> CarBrand;

    @FXML
    private TableColumn<CarAdmin, String> Price;

    @FXML
    private TableColumn<CarAdmin, String> guarantee;

    @FXML
    private TableColumn<CarAdmin, String> DayCar;

    @FXML
    private TableColumn<CarAdmin, String> Quantity;

    @FXML
    private TableColumn<CarAdmin, Button> Edit = new TableColumn<CarAdmin,Button>("Update");

    @FXML
    private TableColumn<CarAdmin, Button> Delete;

    @FXML
    private TableView<?> tableInfoOldCar;

    @FXML
    private TableColumn<CarAdmin, String> CarNameOld;

    @FXML
    private TableColumn<CarAdmin, String> CarBrandOld;

    @FXML
    private TableColumn<CarAdmin, String> PriceOld;

    @FXML
    private TableColumn<CarAdmin, String> guaranteeOld;

    @FXML
    private TableColumn<CarAdmin, String> DayCarOld;

    @FXML
    private TableColumn<CarAdmin, String> QuantityOld;

    @FXML
    private TableColumn<CarAdmin, String> KMOld;

    @FXML
    private TableColumn<CarAdmin, Button> EditOld;

    @FXML
    private TableColumn<CarAdmin, Button> DeleteOld;

    @FXML
    void GoToEmployee(ActionEvent event) {

    }

    @FXML
    void GoToStore(ActionEvent event) {

    }

    @FXML
    void gotoListOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/listOrder.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnCloseRequest(a-> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void handleCustomer(ActionEvent event) throws IOException{
        Parent root =FXMLLoader.load(getClass().getResource("/sample/customers.fxml"));     Stage stage=stageService.mainStage;
        stage.setOnCloseRequest(e->Platform.exit());
        stage.setScene(new Scene(root,671,506));
        stage.show();
    }


    @FXML
    void logoutLogin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/login.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root,601,506));
        stage.show();
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
    void showNewCar(ActionEvent event) {
        newCar.setStyle("-fx-background-color: red");
        oldCar.setStyle("-fx-background-color:  #97cc76");
        tableInfoOldCar.setVisible(false);
        tableInfo.setVisible(true);
    }

    @FXML
    void showOldCar(ActionEvent event) {
        newCar.setStyle("-fx-background-color:  #97cc76");
        oldCar.setStyle("-fx-background-color: red");
        tableInfoOldCar.setVisible(true);
        tableInfo.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        popupLogout.setVisible(false);
        popupLogout.toFront();
        Menu.setVisible(false);
        Menu.toFront();
        DropShadow drop_shadow = new DropShadow(10, Color.RED);
        Menu.setEffect(drop_shadow);
        popupLogout.setEffect(drop_shadow);
        newCar.setEffect(drop_shadow);
        oldCar.setEffect(drop_shadow);
        tableInfoOldCar.setVisible(false);
        InitTableNewCar();
    }

    public void InitTableNewCar()
    {
        CarName.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarName));

        CarBrand.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarBrand));
        //Can't how to add double or Int to column so i have to transform to string
        Price.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().Price.toString()));

        DayCar.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().DayCar));

        guarantee.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().guarantee));

        Quantity.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper( param.getValue().Quantity.toString()));

        Edit.setCellValueFactory(new PropertyValueFactory<>("Update"));

        Delete.setCellValueFactory(new PropertyValueFactory<>("Delete"));

        CarAdmin carBoss = new CarAdmin("BMW S10","BMW",1000.99,"21/10/1999","23/10/2018",19);
        CarAdmin carBoss1 = new CarAdmin("BMW S10","BMW",1000.99,"21/10/1999","23/10/2018",19);

        ObservableList<CarAdmin> data = FXCollections.observableArrayList(carBoss,carBoss1);
        //add data to table

        //show it into table
        tableInfo.setItems(data);
    }

    public void openMenu(MouseEvent mouseEvent) {
    }

    public void hoverMenu(MouseEvent mouseEvent) {
    }
}

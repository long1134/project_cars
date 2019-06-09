package controllerAdmin;

import JDBC.JDBCConnect;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.stageService;
import info.Car;
import info.CarAdmin;
import info.CarOld;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.CarNewServices;
import services.CarOldServices;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CarAdminControll implements Initializable {
    private boolean isNewCar = true;
    CarNewServices arrCarNew = new CarNewServices();
    CarOldServices arrCarOld = new CarOldServices();
    private  boolean isUpdate = false;

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
    private TableView<CarOld> tableInfoOldCar;

    @FXML
    private TableColumn<CarOld, String> CarNameOld;

    @FXML
    private TableColumn<CarOld, String> CarBrandOld;

    @FXML
    private TableColumn<CarOld, String> PriceOld;

    @FXML
    private TableColumn<CarOld, String> guaranteeOld;

    @FXML
    private TableColumn<CarOld, String> DayCarOld;

    @FXML
    private TableColumn<CarOld, String> QuantityOld;

    @FXML
    private TableColumn<CarOld, String> KMOld;

    // form data

    @FXML
    private JFXTextField txtNameCar;

    @FXML
    private DatePicker txtDayCar;

    @FXML
    private JFXTextField txtGruantCar;

    @FXML
    private JFXTextField txtPriceCar;

    @FXML
    private JFXTextField txtBrandCar;

    @FXML
    private JFXTextField txtQuanlityCar;

    @FXML
    private JFXTextField txtKMCar;

    @FXML
    private JFXButton btnAddCar;

    @FXML
    private JFXButton btnSaveChange;

    //end form data

    //popup delete

    @FXML
    private JFXButton btnOpenPopupDelete;

    @FXML
    private AnchorPane popupDelete;

    @FXML
    private JFXButton btnPopupDeleteYes;

    @FXML
    private JFXButton btnPopupDeleteNo;

    @FXML
    void HandlebtnDeleteNo(ActionEvent event) {
        popupDelete.setVisible(false);

    }

    @FXML
    void HandlebtnDeleteYes(ActionEvent event) throws SQLException {
        if(isNewCar)
        {
            CarAdmin car = tableInfo.getSelectionModel().getSelectedItem();
            int i = arrCarNew.arrNewCar.indexOf(car);
            arrCarNew.deleteNewCar(car.id);
            arrCarNew.arrNewCar.remove(i);
            InitTableNewCar(FXCollections.observableArrayList(arrCarNew.arrNewCar));
        }
        else
        {
            CarOld car = tableInfoOldCar.getSelectionModel().getSelectedItem();
            arrCarOld.arrOldCar.remove(car);
            InitTableOldCar(FXCollections.observableArrayList(arrCarOld.arrOldCar));
        }

        popupDelete.setVisible(false);
    }

    @FXML
    void openPopUp()
    {
        if (!tableInfo.getSelectionModel().isEmpty() || !tableInfoOldCar.getSelectionModel().isEmpty())
            popupDelete.setVisible(true);
    }
    //end popup delete

    @FXML
    void GoToEmployee(ActionEvent event) {

    }

    @FXML
    void GoToStore(ActionEvent event) {

    }

    @FXML
    void gotoListOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/ListOrder.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnCloseRequest(a-> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void handleCustomer(ActionEvent event) throws IOException{
        Parent root =FXMLLoader.load(getClass().getResource("/sample/customers.fxml"));
        Stage stage=stageService.mainStage;
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
        txtKMCar.setVisible(false);
        isNewCar=!isNewCar;
    }

    @FXML
    void showOldCar(ActionEvent event) {
        newCar.setStyle("-fx-background-color:  #97cc76");
        oldCar.setStyle("-fx-background-color: red");
        tableInfoOldCar.setVisible(true);
        tableInfo.setVisible(false);
        txtKMCar.setVisible(true);
        isNewCar=!isNewCar;
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
        txtKMCar.setVisible(false);

        try {
            InitTableNewCar(FXCollections.observableArrayList(arrCarNew.getArrDefault()));
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            InitTableOldCar(FXCollections.observableArrayList(arrCarOld.getArrDefault()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void InitTableNewCar(ObservableList<CarAdmin> arrCar)
    {
        CarName.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarName));

        CarBrand.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarBrand));
        //Can't how to add double or Int to column so i have to transform to string
        Price.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().Price.toString()));

        DayCar.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().DayCar));

        guarantee.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper(param.getValue().guarantee));

        Quantity.setCellValueFactory((TableColumn.CellDataFeatures<CarAdmin, String> param) -> new ReadOnlyStringWrapper( param.getValue().Quantity.toString()));


        ObservableList<CarAdmin> data = arrCar;
        //add data to table

        //show it into table
        tableInfo.setEditable(true);
        tableInfo.setItems(data);
    }

    public void InitTableOldCar(ObservableList<CarOld> arrCar)
    {
        CarNameOld.setCellValueFactory((TableColumn.CellDataFeatures<CarOld, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarName));

        CarBrandOld.setCellValueFactory((TableColumn.CellDataFeatures<CarOld, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarBrand));
        //Can't how to add double or Int to column so i have to transform to string
        PriceOld.setCellValueFactory((TableColumn.CellDataFeatures<CarOld, String> param) -> new ReadOnlyStringWrapper(param.getValue().Price));

        DayCarOld.setCellValueFactory((TableColumn.CellDataFeatures<CarOld, String> param) -> new ReadOnlyStringWrapper(param.getValue().DayCar));

        guaranteeOld.setCellValueFactory((TableColumn.CellDataFeatures<CarOld, String> param) -> new ReadOnlyStringWrapper(param.getValue().guarantee));

        QuantityOld.setCellValueFactory((TableColumn.CellDataFeatures<CarOld, String> param) -> new ReadOnlyStringWrapper( param.getValue().Quantity));

        KMOld.setCellValueFactory((TableColumn.CellDataFeatures<CarOld, String> param)-> new ReadOnlyStringWrapper(param.getValue().KMOld));


        ObservableList<CarOld> data = arrCar;
        //add data to table

        //show it into table
        tableInfoOldCar.setEditable(true);
        tableInfoOldCar.setItems(data);
    }


    @FXML
    void handleAddCar(ActionEvent event) throws SQLException {
        String name = txtNameCar.getText();
        String brand = txtBrandCar.getText();
        String price = txtPriceCar.getText();
        String gruant = txtGruantCar.getText();
        String quanlity = txtQuanlityCar.getText();
        String Day = txtDayCar.getValue().toString();

        if(!isNewCar)
        {
            String KM = txtNameCar.getText();
            CarOld car = new CarOld(name,brand,price,Day,gruant,quanlity,KM);
            arrCarOld.arrOldCar.add(car);
            arrCarOld.addOldCar(car);

            InitTableOldCar(FXCollections.observableArrayList(arrCarOld.arrOldCar));
            txtNameCar.setText("");
            txtBrandCar.setText("");
            txtPriceCar.setText("");
            txtGruantCar.setText("");
            txtQuanlityCar.setText("");
            txtDayCar.setValue(null);
            txtKMCar.setText("");
        }
        else
        {
            CarAdmin car = new CarAdmin(name,brand,price,Day,gruant,quanlity);
            arrCarNew.arrNewCar.add(car);
            arrCarNew.addNewCar(car);
            InitTableNewCar(FXCollections.observableArrayList(arrCarNew.arrNewCar));
            txtNameCar.setText("");
            txtBrandCar.setText("");
            txtPriceCar.setText("");
            txtGruantCar.setText("");
            txtQuanlityCar.setText("");
            txtDayCar.setValue(null);
        }

    }


    @FXML
    void handleSaveCar(ActionEvent event) throws SQLException {

        CarAdmin car = tableInfo.getSelectionModel().getSelectedItem();
        CarOld carOld = tableInfoOldCar.getSelectionModel().getSelectedItem();
        int i = arrCarNew.arrNewCar.indexOf(car);
        if(!isUpdate)
        {

            if(!isNewCar)
            {
                txtNameCar.setText(carOld.CarName);
                txtBrandCar.setText(carOld.CarBrand);
                txtPriceCar.setText(carOld.Price);
                txtGruantCar.setText(carOld.guarantee);
                txtQuanlityCar.setText(carOld.Quantity);
                txtKMCar.setText(carOld.KMOld);
            }
            else
            {
                txtNameCar.setText(car.CarName);
                txtBrandCar.setText(car.CarBrand);
                txtPriceCar.setText(car.Price);
                txtGruantCar.setText(car.guarantee);
                txtQuanlityCar.setText(car.Quantity);
            }
        }
        else
        {
            String name = txtNameCar.getText();
            String brand = txtBrandCar.getText();
            String price = txtPriceCar.getText();
            String gruant = txtGruantCar.getText();
            String quanlity = txtQuanlityCar.getText();
            String Day = txtDayCar.getValue().toString();
            if(!isNewCar)
            {
                String k = carOld.id;
                String KM = txtKMCar.getText();
                int j = arrCarOld.arrOldCar.indexOf(carOld);
                carOld = new CarOld(name,brand,price,Day,gruant,quanlity,KM);
                arrCarOld.arrOldCar.set(j,carOld);
                InitTableOldCar(FXCollections.observableArrayList(arrCarOld.arrOldCar));
            }
            else
            {
                String k = car.id;
                car = new CarAdmin(name,brand,price,Day,gruant,quanlity);
                arrCarNew.arrNewCar.set(i,car);
                car.id = k;
                arrCarNew.updateNewCar(car);
                InitTableNewCar(FXCollections.observableArrayList(arrCarNew.arrNewCar));
            }

            txtNameCar.setText("");
            txtBrandCar.setText("");
            txtPriceCar.setText("");
            txtGruantCar.setText("");
            txtQuanlityCar.setText("");
            txtKMCar.setText("");
            txtDayCar.setValue(null);
        }

        isUpdate=!isUpdate;
    }

    public void openMenu(MouseEvent mouseEvent) {
    }

    public void hoverMenu(MouseEvent mouseEvent) {
    }
}

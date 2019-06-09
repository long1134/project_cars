package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import info.Car;
import info.CarOld;
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
import javafx.scene.control.*;
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
    private JFXButton ListOrder;

    @FXML
    private JFXButton newCar;

    @FXML
    private JFXButton oldCar;

    @FXML
    private AnchorPane popupLogout;

    @FXML
    private TableView<Car> tableInfo = new TableView<Car>();

    @FXML
    TableColumn<Car,String> CarName = new TableColumn<>("Name");

    @FXML
    TableColumn<Car,String> CarBrand = new TableColumn<>("CarBrand");

    @FXML
    TableColumn<Car,String> Price = new TableColumn<>("Price");

    @FXML
    TableColumn<Car,String> DayCar = new TableColumn<>("DayCar");

    @FXML
    TableColumn<Car,String> guarantee = new TableColumn<>("guarantee");

    @FXML
    TableColumn<Car,String> Quantity = new TableColumn<>("Quantity");


    @FXML
    private TableView<CarOld> tableInfoOldCar;

    @FXML
    private TableColumn<CarOld, String> CarNameOld;

    @FXML
    private TableColumn<CarOld, String> CarBrandOld;

    @FXML
    private TableColumn<CarOld, Double> PriceOld;

    @FXML
    private TableColumn<CarOld, String> DayCarOld;

    @FXML
    private TableColumn<CarOld, String> guaranteeOld;

    @FXML
    private TableColumn<CarOld, Integer> QuantityOld;

    @FXML
    private TableColumn<CarOld, Double> KMOld;

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
        initTable();
    }


    public void initTable()
    {

        // Add info to column
        CarName.setCellValueFactory((TableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarName));

        CarBrand.setCellValueFactory((TableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().CarBrand));
        //Can't how to add double or Int to column so i have to transform to string
        Price.setCellValueFactory((TableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().Price.toString()));

        DayCar.setCellValueFactory((TableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().DayCar));

        guarantee.setCellValueFactory((TableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().guarantee));

        Quantity.setCellValueFactory((TableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper( param.getValue().Quantity.toString()));



        // create data to table
        Car carBoss = new Car("BMW S10","BMW","1000.99","21/10/1999","23/10/2018","19");
        Car carBoss1 = new Car("BMW S10","BMW","1000.99","21/10/1999","23/10/2018","19");

        ObservableList<Car> data = FXCollections.observableArrayList(carBoss,carBoss1);
        //add data to table

        //show it into table
        tableInfo.setItems(data);

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

    public void handleCustomer() throws IOException{
//      FXMLLoader fXMLLoader;
        Parent root =FXMLLoader.load(getClass().getResource("/sample/customers.fxml"));     Stage stage=stageService.mainStage;
        stage.setOnCloseRequest(e->Platform.exit());
        stage.setScene(new Scene(root,671,506));
        stage.show();
    }

    //show list old car
    public void showOldCar()
    {
        newCar.setStyle("-fx-background-color:  #97cc76");
        oldCar.setStyle("-fx-background-color: red");
        tableInfoOldCar.setVisible(true);
        tableInfo.setVisible(false);
    }

    //show list new car
    public void showNewCar()
    {
        newCar.setStyle("-fx-background-color: red");
        oldCar.setStyle("-fx-background-color:  #97cc76");
        tableInfoOldCar.setVisible(false);
        tableInfo.setVisible(true);
    }

    public void gotoListOrder() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/listOrder.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnCloseRequest(a->Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }
}

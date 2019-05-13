package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import info.Car;
import info.CarOld;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private TreeTableView<Car> tableInfo = new TreeTableView<Car>();

    @FXML
    TreeTableColumn<Car,String> CarName = new TreeTableColumn<>("Name");

    @FXML
    TreeTableColumn<Car,String> CarBrand = new TreeTableColumn<>("CarBrand");

    @FXML
    TreeTableColumn<Car,String> Price = new TreeTableColumn<>("Price");

    @FXML
    TreeTableColumn<Car,String> DayCar = new TreeTableColumn<>("DayCar");

    @FXML
    TreeTableColumn<Car,String> guarantee = new TreeTableColumn<>("guarantee");

    @FXML
    TreeTableColumn<Car,String> Quantity = new TreeTableColumn<>("Quantity");

    @FXML
    private TreeTableView<CarOld> tableInfoOldCar;

    @FXML
    private TreeTableColumn<CarOld, String> CarNameOld;

    @FXML
    private TreeTableColumn<CarOld, String> CarBrandOld;

    @FXML
    private TreeTableColumn<CarOld, Double> PriceOld;

    @FXML
    private TreeTableColumn<CarOld, String> DayCarOld;

    @FXML
    private TreeTableColumn<CarOld, String> guaranteeOld;

    @FXML
    private TreeTableColumn<CarOld, Integer> QuantityOld;

    @FXML
    private TreeTableColumn<CarOld, Double> KMOld;

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
        initTable();
    }

    public void initTable()
    {

        // Add info to column
        CarName.setCellValueFactory((TreeTableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().CarName));

        CarBrand.setCellValueFactory((TreeTableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().CarBrand));
        //Can't how to add double or Int to column so i have to transform to string
        Price.setCellValueFactory((TreeTableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().Price.toString()));

        DayCar.setCellValueFactory((TreeTableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().DayCar));

        guarantee.setCellValueFactory((TreeTableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().guarantee));

        Quantity.setCellValueFactory((TreeTableColumn.CellDataFeatures<Car, String> param) -> new ReadOnlyStringWrapper( param.getValue().getValue().Quantity.toString()));


        // create data to table
        Car carBoss = new Car("BMW S10","BMW",1000.99,"21/10/1999","23/10/2018",19);

        //add data to table
        TreeItem<Car> itemRoot = new TreeItem<Car>(carBoss);

        //show it into table
        tableInfo.setRoot(itemRoot);

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
}

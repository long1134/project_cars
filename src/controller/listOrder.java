package controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import info.OrderBuyingCar;
import info.OrderRentingCar;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.OrderBuyingCarServices;
import services.OrderRentingCarServices;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class listOrder implements Initializable {
    private boolean isOpen = false;
    private boolean isBuyingCar = false;
    private boolean isNewCar = true;
    private ArrayList<OrderBuyingCar> buyingCarArrayList = new OrderBuyingCarServices().getArrDefault();
    private OrderBuyingCarServices OrderBuyingSV = new OrderBuyingCarServices();

    private OrderRentingCarServices OrderRentingSV = new OrderRentingCarServices();

    @FXML
    private JFXButton ListCar;

    @FXML
    private JFXButton gotoCustomers;

    @FXML
    private ImageView menuIcon;

    @FXML
    private AnchorPane Menu;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnInFo;


    @FXML
    private JFXButton closePopup;


    @FXML
    private JFXButton btnAddOrder;

    @FXML
    private JFXTextField serachName;

    //show table feature
    @FXML
    private JFXButton btnShowRentingOrder;

    @FXML
    private JFXButton btnShowBuyingOrder;

    @FXML
    void ShowBuyingOrder(ActionEvent event) {
        btnShowBuyingOrder.setStyle("-fx-background-color: red");
        btnShowBuyingOrder.setTextFill(Color.WHITE);
        btnShowRentingOrder.setStyle("-fx-border-color: red");
        btnShowRentingOrder.setStyle("-fx-border-color: red");
        btnShowRentingOrder.setTextFill(Color.RED);
        tableOrderBuy.setVisible(true);
        tableOrderRenting.setVisible(false);
    }

    @FXML
    void ShowRentingOrder(ActionEvent event) {
        btnShowRentingOrder.setStyle("-fx-background-color: red");
        btnShowRentingOrder.setTextFill(Color.WHITE);
        btnShowBuyingOrder.setStyle("-fx-border-color: red");
        btnShowBuyingOrder.setStyle("-fx-border-color: red");
        btnShowBuyingOrder.setTextFill(Color.RED);
        tableOrderBuy.setVisible(false);
        tableOrderRenting.setVisible(true);
    }

    //close show table feature

    //table orderbuying car

    @FXML
    private TableView<OrderBuyingCar> tableOrderBuy;

    @FXML
    private TableColumn<OrderBuyingCar, String> idOrder ;

    @FXML
    private TableColumn<OrderBuyingCar, String> nameCus;

    @FXML
    private TableColumn<OrderBuyingCar, String> idCus;

    @FXML
    private TableColumn<OrderBuyingCar, String> phoneCus;

    @FXML
    private TableColumn<OrderBuyingCar, String> emailCus;

    @FXML
    private TableColumn<OrderBuyingCar, String> addressCus;

    @FXML
    private TableColumn<OrderBuyingCar, String> carName;

    @FXML
    private TableColumn<OrderBuyingCar, String> idCar;

    @FXML
    private TableColumn<OrderBuyingCar, String> dayStart;

    @FXML
    private TableColumn<OrderBuyingCar, String> Price;

    @FXML
    private TableColumn<OrderBuyingCar, String> statusCar;
    //close table orderbuying car

    // table orderRenting car
    @FXML
    private TableView<OrderRentingCar> tableOrderRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> idOrderRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> nameCusRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> idCusRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> phoneCusRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> emailCusRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> addressCusRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> carNameRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> idCarRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> PriceRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> dayCarRenting;

    @FXML
    private TableColumn<OrderRentingCar, String> dayStartRenting;
    //close table orderRenting car

    //begin popup
    @FXML
    private AnchorPane popupLogout;

    @FXML
    private AnchorPane popupForm;

    @FXML
    private JFXButton btnRentCar;

    @FXML
    private JFXButton btnBuyCar;

    @FXML
    private JFXTextField txtIDCar;

    @FXML
    private JFXTextField txtDayRent;

    @FXML
    private DatePicker txtDayStart;

    @FXML
    private DatePicker txtDay;

    @FXML
    private JFXTextField txtNumCus;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtPhone;

    @FXML
    private JFXTextField txtNameCus;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtIDOrder;

    @FXML
    private JFXTextField txtCarName;

    @FXML
    private Text txtLabel;

    @FXML
    private JFXButton btnChoseNew;

    @FXML
    private JFXButton btnChoseOld;

    @FXML
    void btnChoseBuying(ActionEvent event) {
        txtDayRent.setVisible(false);
        txtDayStart.setVisible(false);
        btnRentCar.setStyle("-fx-background-color:  #97cc76");
        btnBuyCar.setStyle("-fx-background-color:  #de6262");
        txtLabel.setVisible(true);
        btnChoseNew.setVisible(true);
        btnChoseOld.setVisible(true);
        txtDay.setVisible(true);
    }

    @FXML
    void btnChoseRenting(ActionEvent event) {
        txtDayRent.setVisible(true);
        txtDayStart.setVisible(true);
        btnBuyCar.setStyle("-fx-background-color:  #97cc76");
        btnRentCar.setStyle("-fx-background-color:  #de6262");
        txtLabel.setVisible(false);
        btnChoseNew.setVisible(false);
        btnChoseOld.setVisible(false);
        txtDay.setVisible(false);
    }

    @FXML
    void ChoseNewCar(ActionEvent event) {
        btnChoseOld.setStyle("-fx-background-color: white");
        btnChoseOld.setStyle("-fx-border-color: red");
        btnChoseOld.setTextFill(Color.RED);
        btnChoseNew.setStyle("-fx-background-color: red");
        btnChoseNew.setTextFill(Color.WHITE);
        isNewCar=!isNewCar;
    }

    @FXML
    void ChoseOldCar(ActionEvent event) {
        btnChoseNew.setStyle("-fx-background-color: white");
        btnChoseNew.setStyle("-fx-border-color: red");
        btnChoseNew.setTextFill(Color.RED);
        btnChoseOld.setStyle("-fx-background-color: red");
        btnChoseOld.setTextFill(Color.WHITE);
        isNewCar=!isNewCar;
    }
    //end popup

    @FXML
    private JFXButton btnShowForm;

    @FXML
    private JFXButton btnCloseForm;

    @FXML
    void gotoListCar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/home.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        popupForm.toFront();
        txtLabel.setVisible(false);
        btnChoseNew.setVisible(false);
        btnChoseOld.setVisible(false);
        txtDay.setVisible(false);
        tableOrderRenting.setVisible(false);
        DrawTable(FXCollections.observableArrayList(OrderBuyingSV.getArrDefault())) ;
        DrawTableRentingCar(FXCollections.observableArrayList(OrderRentingSV.getArrDefault()));
    }

    public void handleCustomer() {
    }

    public void openMenu(javafx.scene.input.MouseEvent mouseEvent) {
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
    void AddOrder(ActionEvent event) {
        String idCus = txtNumCus.getText();
        String nameCus = txtNameCus.getText();
        String phoneCus = txtPhone.getText();
        String addressCus = txtAddress.getText();
        String emailCus = txtEmail.getText();
        String price = txtPrice.getText();
        String idOrder = txtIDOrder.getText();
        String carName = txtCarName.getText();
        String idCar= txtIDCar.getText();
        String statusCar = (isNewCar?"New":"Old");
        if(isBuyingCar)
        {
            String dayCome = txtDay.getValue().toString();
            OrderBuyingCar order = new OrderBuyingCar(idCus,nameCus,phoneCus,addressCus,emailCus,price,dayCome,idCar,carName,statusCar,idOrder);
            OrderBuyingSV.arrOrderBuyingCar.add(order);
            DrawTable(FXCollections.observableArrayList(OrderBuyingSV.arrOrderBuyingCar));
            txtDay.setValue(null);
        }
        else
        {
            String dayStart = txtDayStart.getValue().toString();
            String dayRent = txtDayRent.getText();
            OrderRentingCar order = new OrderRentingCar(idCus,nameCus,phoneCus,addressCus,emailCus,price,dayRent,idCar,carName,dayStart,idOrder);
            OrderRentingSV.arrOrderRentingCar.add(order);
            DrawTableRentingCar(FXCollections.observableArrayList(OrderRentingSV.arrOrderRentingCar));
            txtDayRent.setText("");
            txtDayStart.setValue(null);
        }

        txtNumCus.setText("");
        txtNameCus.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtPrice.setText("");
        txtIDOrder.setText("");
        txtCarName.setText("");
        txtIDCar.setText("");
        popupForm.setVisible(false);
    }

    //draw table buyingCar
    void DrawTable(ObservableList<OrderBuyingCar> infoOrder)
    {
        idCar.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idCar));

        idCus.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idCus));

        nameCus.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().nameCus));

        phoneCus.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().phoneCus));

        emailCus.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().emailCus));

        addressCus.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().addressCus));

        Price.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().Price));

        idCar.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idCar));

        dayStart.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().dayCome));

        carName.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().nameCar));

        statusCar.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().statusCar));

        idOrder.setCellValueFactory((TableColumn.CellDataFeatures<OrderBuyingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idOrder));

        ObservableList<OrderBuyingCar> data = infoOrder;

        System.out.println(data);

        tableOrderBuy.setItems(data);

    }

    //draw table renting car
    void DrawTableRentingCar(ObservableList<OrderRentingCar> infoOrder)
    {
        idCarRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idCar));

        idCusRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idCus));

        nameCusRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().nameCus));

        phoneCusRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().phoneCus));

        emailCusRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().emailCus));

        addressCusRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().addressCus));

        PriceRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().Price));

        idCarRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idCar));

        dayCarRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().DayRent));

        carNameRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().nameCar));

        dayStartRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().DayStart));

        idOrderRenting.setCellValueFactory((TableColumn.CellDataFeatures<OrderRentingCar,String> param)->new ReadOnlyStringWrapper(param.getValue().idOrder));

        ObservableList<OrderRentingCar> data = infoOrder;

        System.out.println(data);

        tableOrderRenting.setItems(data);

    }


    public void openPopupLogout(javafx.event.ActionEvent actionEvent) {
        popupLogout.setVisible(true);
        Menu.setVisible(false);
    }

    public void hoverMenu(javafx.scene.input.MouseEvent mouseEvent) {
    }

    @FXML
    void ShowForm(ActionEvent event) {
        popupForm.setVisible(true);
    }

    @FXML
    void CloseForm(ActionEvent event) {
        popupForm.setVisible(false);
    }
}

package controllerAdmin;

import com.jfoenix.controls.JFXButton;
import controller.stageService;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import info.employee;
import services.EmployeeServices;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeAdminControl implements Initializable {

    EmployeeServices arrEmployee = new EmployeeServices();

    //cac button click chuyên scence
    @FXML
    private JFXButton ListCarAdmin;

    @FXML
    private JFXButton CustomersAdmin;

    @FXML
    private JFXButton btnRentingCar;

    @FXML
    private JFXButton ListOrderAdmin;

    @FXML
    private JFXButton EmployeeAdmin;

    @FXML
    private JFXButton StoreAdmin;

    @FXML
    private JFXButton DashboardAdmin;
//    //cac handleaction button click chuyên scence

    @FXML
    void handleDashboardAdmin(ActionEvent event) throws IOException {
        DashboardAdmin.setStyle("-fx-background-color:#de6262");

        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Dashboard.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }



    @FXML
    void handleListCarAdmin(ActionEvent event) throws IOException {
        ListCarAdmin.setStyle("-fx-background-color:#de6262");

        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Car.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void handleCustomersAdmin(ActionEvent event) throws IOException {
        ListOrderAdmin.setStyle("-fx-background-color:#de6262");

        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/customer.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void handleListOrderAdmin(ActionEvent event) throws IOException {
        ListOrderAdmin.setStyle("-fx-background-color:#de6262");

        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/ListOrder.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void HandleStoreAdmin(ActionEvent event) throws IOException {
        StoreAdmin.setStyle("-fx-background-color:#de6262");
        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Store.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void HandleEmployeeAdmin(ActionEvent event) throws IOException {
        EmployeeAdmin.setStyle("-fx-background-color:#de6262");
        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Employee.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private AnchorPane Menu;
    private boolean isOpen = false;
    @FXML
    private AnchorPane popupLogout;
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
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private JFXButton btnThem=new JFXButton();
    @FXML
    private JFXButton btnXoa=new JFXButton();
    @FXML
    private JFXButton btnSua=new JFXButton();
    @FXML
    private JFXButton btnX=new JFXButton();
    @FXML
    private JFXButton btnSubmit=new JFXButton();
    //Ten anchorpane
    @FXML
    private  AnchorPane popupOption =new AnchorPane();
    @FXML
    private AnchorPane popupEdit =new AnchorPane();
    // table
    @FXML
    private TableView<employee> tableShow=new TableView<employee>();
    //label
    @FXML
    private Label tempLabel=new Label();
    //textfield

    final ObservableList<employee> data = FXCollections.observableArrayList(
            new employee("1752","doan","tu","2511","123456789","25/11/2019","122","Nhan Vien","255","150000","222"),
            new employee("221","doan","tu","2511","123456789","25/11/2019","122","Nhan Vien","255","150000","222"),
            new employee("321","doan","tu","2511","123456789","25/11/2019","122","Nhan Vien","255","150000","222"),
            new employee("233","doan","tu","2511","123456789","25/11/2019","122","Nhan Vien","255","150000","222"),
            new employee("123","doan","tu","2511","123456789","25/11/2019","122","Nhan Vien","255","150000","222")
    );

    final ObservableList<String> dataType = FXCollections.observableArrayList(
            new String( "Quan ly"), new String( "Nhan Vien")
    );


    @FXML
    private TextField id = new TextField();
    @FXML
    private TextField Ho = new TextField();
    @FXML
    private TextField Ten = new TextField();
    @FXML
    private TextField userID = new TextField();

    @FXML
    private TextField pass = new TextField();
    @FXML
    private TextField datework = new TextField();
    @FXML
    private TextField MaQL = new TextField();
    @FXML
    private TextField maPhong = new TextField();

    @FXML
    private TextField luong = new TextField();
    @FXML
    private TextField tienHoaHong = new TextField();
    @FXML
    private ComboBox<String>  chucvu = new ComboBox<String>();

    @FXML
    void handleBtnXoa (ActionEvent e){
        employee em = tableShow.getSelectionModel().getSelectedItem();
        data.remove(data.indexOf(em));
        tableShow.setItems(data);
    }

    @FXML
    void handleBtnThem (ActionEvent e){
        popupEdit.setVisible(true);
        tempLabel.setText("Them thong tin khach hang");
    }
    //sua
    @FXML
    JFXButton btnEdit=new JFXButton();

    @FXML
    void handleBtnEdit(ActionEvent e) throws SQLException, ClassNotFoundException {
        String cv=chucvu.getSelectionModel().getSelectedItem();
        String id= this.id.getText();
        String ho= this.Ho.getText();
        String ten= this.Ten.getText();
        String userid= this.userID.getText();
        String pass= this.pass.getText();
        String date= this.datework.getText();
        String maql= this.MaQL.getText();
        String maphong= this.maPhong.getText();
        String luong= this.luong.getText();
        String hoahong= this.tienHoaHong.getText();

        employee employee = tableShow.getSelectionModel().getSelectedItem();
        employee emp = new employee(employee.ID,ho,ten,userid,pass,date,maql,cv,maphong,luong,hoahong);
        arrEmployee.updateEmployee(emp);
        initTableShow();
        popupEdit.setVisible(false);
    }

    @FXML
    void handleBtnSua (ActionEvent e){
        popupEdit.setVisible(true);
        btnEdit.setVisible(true);
        btnSubmit.setVisible(false);
        employee em = tableShow.getSelectionModel().getSelectedItem();


        this.id.setText(em.ID);
        this.Ho.setText(em.HO);
        this.pass.setText(em.Pass);
        this.Ten.setText(em.Ten);
        this.userID.setText(em.userID);

        this.datework.setText(em.NgayVaoLam);
        this.MaQL.setText(em.MaQL);
        this.maPhong.setText(em.MaPhong);
        this.luong.setText(em.Luong);
        this.tienHoaHong.setText(em.TienHoaHong);
        this.chucvu.setPromptText(em.ChucVu);

        tempLabel.setText("Sua thong tin khach hang");
    }

    @FXML
    void handleBtnX (ActionEvent e){
        popupEdit.setVisible(false);
    }

    @FXML
    void handleBtnSubmit (ActionEvent e) throws SQLException, ClassNotFoundException {
        String cv=chucvu.getSelectionModel().getSelectedItem();
        String id= this.id.getText();
        String ho= this.Ho.getText();
        String ten= this.Ten.getText();
        String userid= this.userID.getText();
        String pass= this.pass.getText();
        String date= this.datework.getText();
        String maql= this.MaQL.getText();
        String maphong= this.maPhong.getText();
        String luong= this.luong.getText();
        String hoahong= this.tienHoaHong.getText();

        this.id.setText("");
        this.Ho.setText("");
        this.pass.setText("");
        this.Ten.setText("");
        this.userID.setText("");

        this.datework.setText("");
        this.MaQL.setText("");
        this.maPhong.setText("");
        this.luong.setText("");
        this.tienHoaHong.setText("");

        employee em = new employee(id,ho,ten,userid,pass,date,maql,cv,maphong,luong,hoahong);
        arrEmployee.addNEmployee(em);
        initTableShow();
    }

    @FXML
    TextField searchField=new TextField();

    @FXML
    int handleSearchField(KeyEvent e)
    {
        ObservableList<employee> tempcus = FXCollections.observableArrayList();
        String key=searchField.getText();
        System.out.println(key);
        tempcus=findKey(key);
        if(!tempcus.isEmpty())
        {

            this.tableShow.setItems(tempcus);
            return 1;
        }
        this.tableShow.setItems(data);
        return -1;
    }

    ObservableList<employee> findKey(String key)
    {    final   ObservableList<employee> a= FXCollections.observableArrayList();
        for(int i =0 ;i<data.size();i++){
            employee temp=data.get(i);

            if(temp.ID.toString().contains(key)){
                System.out.println(key);
                a.add(temp);
            }
        }
        System.out.println(a);
        return a;
    }

    @FXML
    TableColumn<employee,String> idCol = new TableColumn<>("idCol");
    @FXML
    TableColumn<employee,String> nameCol = new TableColumn<>("nameCol");
    @FXML
    TableColumn<employee,String> userIDCol = new TableColumn<>("userIDCol");

    @FXML
    TableColumn<employee,String> passCol = new TableColumn<>("passCol");
    @FXML
    TableColumn<employee,String> dateWorkCol = new TableColumn<>("dateWorkCol");
    @FXML
    TableColumn<employee,String> supervisorIDCol = new TableColumn<>("supervisorIDCol");

    @FXML
    TableColumn<employee,String> positionCol = new TableColumn<>("positionCol");
    @FXML
    TableColumn<employee,String> apartmentCol = new TableColumn<>("apartmentCol");
    @FXML
    TableColumn<employee,String> salaryCol = new TableColumn<>("salaryCol");

    public void initTableShow() throws SQLException, ClassNotFoundException {

        idCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().ID));
        nameCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().Ten));
        userIDCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().userID ));

        passCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().Pass));
        dateWorkCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().NgayVaoLam));
        supervisorIDCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().MaQL));

        positionCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().ChucVu));
        apartmentCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().MaPhong ));
        salaryCol.setCellValueFactory((TableColumn.CellDataFeatures<employee, String> param) -> new ReadOnlyStringWrapper(param.getValue().Luong));

        tableShow.setItems(FXCollections.observableArrayList(arrEmployee.getArrDefault()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chucvu.setItems(dataType);
        tableShow.setVisible(true);
        popupEdit.setVisible(false);
        try {
            initTableShow();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

// end

}

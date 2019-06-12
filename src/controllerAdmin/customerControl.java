package controllerAdmin;

import com.jfoenix.controls.JFXButton;
import controller.stageService;
import info.Customer;
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

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class customerControl implements Initializable {

    //cac button click chuyên scence
    @FXML
    private JFXButton ListCarAdmin;
    @FXML
    private JFXButton CustomersAdmin;
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
        stage.setScene(new Scene(root,601,506));
        stage.show();
    }

    @FXML
    void handleListCarAdmin(ActionEvent event) throws IOException {
        ListCarAdmin.setStyle("-fx-background-color:#de6262");

        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Car.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root,601,506));
        stage.show();
    }
    @FXML
    void handleCustomersAdmin(ActionEvent event) throws IOException {
        ListOrderAdmin.setStyle("-fx-background-color:#de6262");

        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/customer.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root,750,750));
        stage.show();
    }
    @FXML
    void handleListOrderAdmin(ActionEvent event) throws IOException {
        ListOrderAdmin.setStyle("-fx-background-color:#de6262");

        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/ListOrder.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root,601,506));
        stage.show();
    }
    @FXML
    void HandleStoreAdmin(ActionEvent event) throws IOException {
        StoreAdmin.setStyle("-fx-background-color:#de6262");
        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Store.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root,601,506));
        stage.show();
    }
    @FXML
    void HandleEmployeeAdmin(ActionEvent event) throws IOException {
        EmployeeAdmin.setStyle("-fx-background-color:#de6262");
        Parent root = FXMLLoader.load(getClass().getResource("/AdminFXML/Employee.fxml"));
        Stage stage = stageService.mainStage;
        stage.setOnHidden(a -> Platform.exit());
        stage.setScene(new Scene(root,601,506));
        stage.show();
    }

    // thoat ra
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
        stage.setScene(new Scene(root,601,506));
        stage.show();
    }


// end

    // khai bao cac thanh phan trong customer
    // nut
   @FXML
    private JFXButton btnThem=new JFXButton();
    @FXML
    private JFXButton editBtn=new JFXButton();
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
    private  TableView<Customer> tableShow=new TableView<Customer>();
    //label
    @FXML
    private Label tempLabel=new Label();
    //khai bao column tableview

    @FXML
    TableColumn<Customer,String> cusID = new TableColumn<>("cusID");
    @FXML
    TableColumn<Customer,String> cusName = new TableColumn<>("cusName");
    @FXML
    TableColumn<Customer,String> cusAge = new TableColumn<>("cusAge");

    @FXML
    TableColumn<Customer,String> cusType = new TableColumn<>("cusType");
    @FXML
    TableColumn<Customer,String> cusPhone = new TableColumn<>("cusPhone");

    //bien luu du lieu day len table
    final ObservableList<Customer> data = FXCollections.observableArrayList(
            new Customer("223","hoang ","59","Khach vip","244444145"),
            new Customer("113"," anh","59","Khach vip","244444145"),
            new Customer("443","hoang tu","59","Khach vip","244444145"),
            new Customer("221","tu anh","59","Khach vip","244444145"),
            new Customer("152","hoang duc","59","Khach thuong","244444145")

    );
    // bien chua kieu nguoi dung
    final ObservableList<String> dataType = FXCollections.observableArrayList(
            new String( "Khach vip"), new String( "Khach thuong"), new String( "Khach tiem nang")
    );

    //textfield
    @FXML
    private TextField id = new TextField() ;
    @FXML
    private TextField name = new TextField() ;
    @FXML
    private TextField age = new TextField() ;
    @FXML
    private TextField phone = new TextField();

    @FXML
    private TextField searchField = new TextField();

    //combobox
    @FXML
    private ComboBox <String> cbbType = new  ComboBox <String>();

    @FXML
    private ComboBox <String> cbbTypeEdit = new  ComboBox <String>();
    //cac action
    //them
    @FXML
    void handleBtnThem (ActionEvent e){
        popupEdit.setVisible(true);
        tempLabel.setText("Them thong tin khach hang");
        editBtn.setVisible(false);
        btnSubmit.setVisible(true);
//        cbbTypeEdit.setItems(dataType);
        //continute
    }

    //xoa
    @FXML
    void handleBtnXoa (ActionEvent e){
//        Button btnInventory = new Button("Inventory");
//        Button btnCalcTax = new Button("Tax");
//        btnInventory.disableProperty().bind(
//                tableShow.getSelectionModel().selectedItemProperty().isNull()
//        );
        Customer cus = tableShow.getSelectionModel().getSelectedItem();
        data.remove(data.indexOf(cus));
        tableShow.setItems(data);

    }

    //sua
    @FXML
    void handleBtnSua (ActionEvent e){
        Customer cus = tableShow.getSelectionModel().getSelectedItem();
        this.id.setText(cus.id);
        this.name.setText(cus.name);
        this.age.setText(cus.age);
        this.phone.setText(cus.phone);
        cbbTypeEdit.setValue(cus.type);
        System.out.println(cus.type);
        editBtn.setVisible(true);
        btnSubmit.setVisible(false);
        String a = cus.type;
        System.out.println(data.indexOf(cus));
        popupEdit.setVisible(true);
        tempLabel.setText("Sua thong tin khach hang");
    }

    @FXML
    void handleBtnX (ActionEvent e){
        popupEdit.setVisible(false);
    }
    @FXML
    void handleBtnSubmit (ActionEvent e){
        String temp=cbbTypeEdit.getSelectionModel().getSelectedItem();
        String idf= id.getText();
        String agef= age.getText();
        String namef= name.getText();
        String phonef= phone.getText();

        Customer cus =new Customer(idf,namef,agef,temp,phonef);
        System.out.println(cus.name + cus.id + cus.type + cus.phone + cus.age);

        data.add(cus);
        tableShow.setItems(data);

        System.out.println(data);
        this.id.setText("");
        this.age.setText("");
        this.name.setText("");
        this.phone.setText("");
        return;
    }
    @FXML
    void handleSearchField (ActionEvent e){
    }

    @FXML
    void editBtnHandle (ActionEvent e){
        String temp=cbbTypeEdit.getSelectionModel().getSelectedItem();
        String idf= id.getText();
        String agef= age.getText();
        String namef= name.getText();
        String phonef= phone.getText();
        System.out.println(idf + agef + namef +phonef);
        Customer cus =new Customer(idf,namef,agef,temp,phonef);
        System.out.println(cus.name + cus.id + cus.phone + cus.type + cus.age);

//        for (Customer i :data) {
//            System.out.println(i.id);
//            System.out.println(cus.id);
//
//            if( i.getID()==cus.id){
//                i.xuat();
//            }
//
//        }
//        int index;
//        for (int i =0;i < data.size();i++)
//        {
//            if(data.get(i).id==cus.id)
//            {
//                index = i;
//                System.out.println(index);
//                break;
//            }
//        }



//        data.set(data.indexOf(data.filtered(sv ->sv.id==cus.id)),cus);
//        List<Customer> temp=

//        System.out.println( data.indexOf(data.stream().filter(a -> a.getID()==cus.id)));
//        System.out.println(data.indexOf(data.filtered(customer ->{
//
//        })));

        System.out.println(data.filtered(sv ->sv.id==cus.id));
        tableShow.setItems(data);
    }
    @FXML
    int handleSearchField(KeyEvent e)
    {
        ObservableList<Customer> tempcus = FXCollections.observableArrayList();
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
    ObservableList<Customer> findKey(String key)
    {    final   ObservableList<Customer> a= FXCollections.observableArrayList();
        for(int i =0 ;i<data.size();i++){
            Customer temp=data.get(i);

            if(temp.name.toString().contains(key)){
                System.out.println(key);
                a.add(temp);
            }
        }
        System.out.println(a);
        return a;
    }




    public void initTableShow()
    {
        tableShow.getColumns().addAll(cusID,cusName,cusAge,cusType,cusPhone);

        cusID.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().id));
        cusName.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().name));
        cusAge.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().age ));
        cusType.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().type));
        cusPhone.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().phone));

        tableShow.setItems(data);
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            cbbType.setItems(dataType);
            cbbTypeEdit.setItems(dataType);
            tableShow.setVisible(true);

        initTableShow();
            popupEdit.setVisible(false);
    }
}

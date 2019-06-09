package controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import info.Customer;
//import info.CusVip;
public class customers implements Initializable {
    @FXML
    private AnchorPane Menu;
    @FXML
    private AnchorPane popupLogout;
    private boolean isOpen = false;
    @FXML
    private JFXButton vip;

    @FXML
    private JFXButton normal;

    @FXML
    private JFXButton potential;

    @FXML
    private JFXButton addUserbtn;

    @FXML
    private TextField textSearch;

    @FXML
    private JFXButton exit;


    @FXML
    private AnchorPane popupAdd; //popup hien ra khi nhan nut add user

    // add user element
    @FXML
    private TextField idfx;
    @FXML
    private TextField namefx;
    @FXML
    private TextField agefx;

    @FXML
    private TextField phonefx;

    @FXML
    private JFXRadioButton vipRadioCheck;
    @FXML
    private JFXRadioButton normalRadioCheck;
    @FXML
    private JFXRadioButton potentialRadioCheck;

    //end add user element




    @FXML
    private TableView<Customer> tableCus = new TableView<Customer>();



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

    final ObservableList<Customer> data = FXCollections.observableArrayList(
            new Customer("152","hoang ","59","khach vip","244444145"),
            new Customer("152"," anh","59","khach vip","244444145"),
            new Customer("152","hoang tu","59","khach vip","244444145"),
            new Customer("152","tu anh","59","khach vip","244444145"),
            new Customer("152","hoang duc","59","khach vip","244444145")
    );

    ArrayList<Customer> listCus = new ArrayList<>();

    @FXML
    void createUser(ActionEvent event)
    {
        String temp="";
        String id= this.idfx.getText();
        String age= this.agefx.getText();
        String name= this.namefx.getText();
        String phone= this.phonefx.getText();

        this.idfx.setText("");
        this.agefx.setText("");
        this.namefx.setText("");
        this.phonefx.setText("");
        if(this.vipRadioCheck.isSelected())
        {
            temp = "khach vip";
        }
        if(this.normalRadioCheck.isSelected())
        {
            temp = "khach thuong";
        }
        if(this.potentialRadioCheck.isSelected())
        {
            temp = "khach tiem nang";
        }
        Customer cus =new Customer(id,name,age,temp,phone);
        data.add(cus);
        tableCus.setItems(data);
//        System.out.println(listCus.toString());


    }

//    void divideCus(List<info.Customer> arr)
//    {Customer cus;
//        for(int i=0;i<arr.size();i++)
//        {
//            arr.forEach((e) -> e.type == "khach vip" );
//             cus = arr.get(i);
//            if(cus.type == "khach vip") {
//
//
//            }
//
//            else if(cus.type == "khach thuong") {
//
//
//            }
//
//
//        }
//
//    }
//    ObservableList<Customer> sortKey(String key){
//
//    }
//


    @FXML
    int hanhdleSearch(KeyEvent e)
    {
        ObservableList<Customer> tempcus = FXCollections.observableArrayList();
        String key=textSearch.getText();
        System.out.println(key);
        tempcus=findKey(key);
        if(!tempcus.isEmpty())
        {

            this.tableCus.setItems(tempcus);
            return 1;
        }
        this.tableCus.setItems(data);
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




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        popupAdd.setVisible(false);
        tableCus.setVisible(true);
        popupAdd.setVisible(false);
        initTable();
        Menu.setVisible(false);
    }

    public void initTable(){
        tableCus.getColumns().addAll(cusID,cusName,cusAge,cusType,cusPhone);




        cusID.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().id));
        cusName.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().name));
        cusAge.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().age ));
        cusType.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().type));
        cusPhone.setCellValueFactory((TableColumn.CellDataFeatures<Customer, String> param) -> new ReadOnlyStringWrapper(param.getValue().phone));
//        TreeItem<Customer> rootItem= new TreeItem<Customer>(cus);
        tableCus.setItems(data);

    }




    void openPopupLogout(ActionEvent event) {
        popupLogout.setVisible(true);
        Menu.setVisible(false);
    }

    // nhan vao nut add user
    @FXML
    void addUserClick(ActionEvent event)
    {
        System.out.println(event);
        popupAdd.setVisible(true);
        tableCus.setVisible(false);
    }

    @FXML
    void exitClick(ActionEvent event)
    {
        popupAdd.setVisible(false);
        tableCus.setVisible(true);
    }



    @FXML
    void outPopupLogout(ActionEvent event) {
        popupLogout.setVisible(false);
    }

    void hoverMenu(MouseEvent event) {

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




}



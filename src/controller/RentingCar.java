package controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import info.rentingCar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RentingCar implements Initializable  {

    @FXML
    private JFXButton btnAddRent;
    @FXML
    private TableView<rentingCar> tableRent = new TableView<rentingCar>();
    @FXML
    TableColumn<rentingCar,String> rentName = new TableColumn<>("rentName");
    @FXML
    TableColumn<rentingCar,String> rentBrand = new TableColumn<>("rentBrand");
    @FXML
    TableColumn<rentingCar,String> rentPrice = new TableColumn<>("rentPrice");
    @FXML
    TableColumn<rentingCar,String> rentKM = new TableColumn<>("rentKM");

    @FXML
    private TextField textSearch;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private AnchorPane popupAction;
    @FXML
    TableColumn<rentingCar,String> rentDay = new TableColumn<>("rentDay");
    @FXML
    TableColumn<rentingCar,String> unrent = new TableColumn<>("unrent");
    @FXML
    TableColumn<rentingCar,String> condition = new TableColumn<>("condition");

    @FXML
    private AnchorPane popupAdd;
    @FXML
    private JFXButton popupQuitBtn;
    @FXML
    private JFXButton popupSubmit;
    @FXML
    private TextField name;
    @FXML
    private TextField brand;
    @FXML
    private TextField rented;
    @FXML
    private TextField unrented;
    @FXML
    private TextField km;
    @FXML
    private TextField price;
    @FXML
    private CheckBox condi;


    final ObservableList<rentingCar> data = FXCollections.observableArrayList(
            new rentingCar("toyota X", "toyota","52200","52","25/11/2010","25/12/2010","ok"),
            new rentingCar("honda X", "toyota","52200","52","25/11/2010","25/12/2010","ok"),
            new rentingCar("mitxubiki X", "toyota","52200","52","25/11/2010","25/12/2010","ok"),
            new rentingCar("mes", "toyota","52200","52","25/11/2010","25/12/2010","ok"),
            new rentingCar("ford X", "toyota","52200","52","25/11/2010","25/12/2010","ok"),
            new rentingCar("ford ranger", "toyota","52200","52","25/11/2010","25/12/2010","ok")
            );


    @FXML
    public void handleCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/customers.fxml"));
        Stage stage=stageService.mainStage;
        stage.setOnCloseRequest(e-> Platform.exit());
        stage.setScene(new Scene(root,671,506));
        stage.show();
    }
    @FXML
    void handleAddClick(ActionEvent event){

        tableRent.setVisible(false);
        popupAdd.setVisible(true);
        popupAction.setVisible(false);

    }
    @FXML
    void handleQuitClick(ActionEvent event){
        tableRent.setVisible(true);
        popupAdd.setVisible(false);
        popupAction.setVisible(true);
    }

    @FXML
    boolean checkCondition(ActionEvent e)
    {
        if(condi.isSelected())
        {
            return true ;
        }
        return false;
    }
    @FXML
    int hanhdleSearch(KeyEvent e)
    {
         ObservableList<rentingCar> tempcar = FXCollections.observableArrayList();
        String key=textSearch.getText();
        tempcar=findKey(key);
        if(!tempcar.isEmpty())
        {

            this.tableRent.setItems(tempcar);
            return 1;
        }
        this.tableRent.setItems(data);
        return -1;
    }
    ObservableList<rentingCar> findKey(String key)
    {    final   ObservableList<rentingCar> a= FXCollections.observableArrayList();
        for(int i =0 ;i<data.size();i++){
            rentingCar temp=data.get(i);

            if(temp.nameRent.toString().contains(key)){
                    System.out.println(key);
                    a.add(temp);
                }
        }
        return a;
    }








    @FXML
    void submitHandle(ActionEvent e){

        String name = this.name.getText();
        String brand = this.brand.getText();
        String km = this.km.getText();
        String price = this.price.getText();
        String rented = this.rented.getText();
        String unrented = this.unrented.getText();
        String condi="khong co xe";
        if(checkCondition(e))
        {
            condi="co xe";
        }
        rentingCar car = new rentingCar(name,brand,price,km,rented,unrented,condi);
        this.data.add(car);
        this.tableRent.setItems(data);
    }


    public void initTable(){
        tableRent.getColumns().addAll(rentName,rentBrand,rentPrice,rentKM,rentDay,unrent,condition);


        rentName.setCellValueFactory((TableColumn.CellDataFeatures<rentingCar, String> param) -> new ReadOnlyStringWrapper(param.getValue().nameRent));
        rentBrand.setCellValueFactory((TableColumn.CellDataFeatures<rentingCar, String> param) -> new ReadOnlyStringWrapper(param.getValue().brandRent));
        rentPrice.setCellValueFactory((TableColumn.CellDataFeatures<rentingCar, String> param) -> new ReadOnlyStringWrapper(param.getValue().priceRent ));
        rentKM.setCellValueFactory((TableColumn.CellDataFeatures<rentingCar, String> param) -> new ReadOnlyStringWrapper(param.getValue().kmRent ));
        rentDay.setCellValueFactory((TableColumn.CellDataFeatures<rentingCar, String> param) -> new ReadOnlyStringWrapper(param.getValue().dayRent));
        unrent.setCellValueFactory((TableColumn.CellDataFeatures<rentingCar, String> param) -> new ReadOnlyStringWrapper(param.getValue().dayReturnRent));
        condition.setCellValueFactory((TableColumn.CellDataFeatures<rentingCar, String> param) -> new ReadOnlyStringWrapper(param.getValue().conditionRent ));

//        TreeItem<Customer> rootItem= new TreeItem<Customer>(cus);
        tableRent.setItems(data);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        popupAdd.setVisible(false);
        popupAdd.toFront();
        initTable();
        popupAction.setVisible(true);

    }
}

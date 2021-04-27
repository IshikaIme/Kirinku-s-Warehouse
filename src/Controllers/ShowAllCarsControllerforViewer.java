package Controllers;

import Applications.Main;
import Server.Car;
import Server.CarList;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowAllCarsControllerforViewer  {

   private static Main main;


    @FXML
    private TableView<Car> table;

    @FXML
    private TableColumn<Car, String> TableRegNo;

    @FXML
    private TableColumn<Car, Integer> Tableyear;



    @FXML
    private TableColumn<Car, String> tablecolor1;

    @FXML
    private TableColumn<Car, String> Tablecolor2;

    @FXML
    private TableColumn<Car, String> Tablecolor3;

    @FXML
    private TableColumn<Car, String> Tablecarmake;

    @FXML
    private TableColumn<Car, String> Tablecarmodel;


    @FXML
    private TableColumn<Car, Integer> Tableprice;

    @FXML
    private TableColumn<Car, Integer> Tablequantity;

    ObservableList<Car> observableList;

    public void setCars(List<Car>Carlist)
    {
        observableList= FXCollections.observableArrayList(Carlist);
        settablefunction();
    }

    public void initialize()
    {
        //System.out.println(main.getCars());
       observableList = FXCollections.observableArrayList(main.getCars());
       settablefunction();
       // System.out.println(main);

    }


    public void settablefunction() {

        observableList= FXCollections.observableArrayList();
        observableList.addAll(main.getCars());
        TableRegNo.setCellValueFactory(new PropertyValueFactory<>("Reg"));
        Tableyear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        tablecolor1.setCellValueFactory(new PropertyValueFactory<>("color1"));
        Tablecolor2.setCellValueFactory(new PropertyValueFactory<>("color2"));
        Tablecolor3.setCellValueFactory(new PropertyValueFactory<>("color3"));
        Tablecarmake.setCellValueFactory(new PropertyValueFactory<>("carmake"));
        Tablecarmodel.setCellValueFactory(new PropertyValueFactory<>("carmodel"));
        Tableprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Tablequantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        table.setItems(observableList);

    }

    public static void setMain(Main main1) {
        main = main1;
    }




    @FXML
    private Circle button;

    @FXML
    void homepressed(ActionEvent event) throws Exception{
            main.ShowHomePage();
    }


    public void seTCars(List<Car> cars){
        table.getItems().setAll(cars);
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


    @FXML
    private Button buycar;

    @FXML
    private Button refresh;

    @FXML
    public void buycar(javafx.event.ActionEvent event) throws IOException {
        Car buyCar;
        buyCar=table.getSelectionModel().getSelectedItem();
       // int i= buycar.getQuantity();
        main.getNetworkUtil().write("BUY");
        main.getNetworkUtil().write(buyCar);

        Parent root2;
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/BoughtACar.fxml"));

        root2= loader.load();
        BoughtACarController    controller= loader.getController();
        //controller.setMain(main);



        Scene scene = new Scene(root2, 800, 600);

        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("BoughtACar");
        window.show();


        //observableList.setAll();
       // main.getNetworkUtil().write(i);
        //observableList.remove(buycar);
    }


    @FXML
    public void refreshpressed(ActionEvent event) throws IOException {
        //main.getNetworkUtil().write("REFRESH");
        main.getNetworkUtil().write("ViewCarsForViewers");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            table.getItems().clear();
                            table.getItems().setAll(main.getCars());
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void backpressed(ActionEvent event) throws IOException {
        Parent root2;
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/ShowHomePageofCarsforViewer.fxml"));

        root2= loader.load();
        HomepageOfCarControllerforViewer controller= loader.getController();
        controller.setMain(main);



        Scene scene = new Scene(root2, 800, 600);

        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("CarHomePage");
        window.show();
    }
}
/*
   FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/CarDialoguePane.fxml"));
        CarDialoguePaneController.setMain(main);
        Parent root2 =loader.load();
        Scene scene = new Scene(root2, 845, 658);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Add A Car");
        window.show();
        CarDialoguePaneController controller= loader.getController();
 */


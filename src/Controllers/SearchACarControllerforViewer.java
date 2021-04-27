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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchACarControllerforViewer {
  // private static final Main main= Main.mainnn;
   private static Main main;
    public static void setMain(Main main1)
    {
        main= main1;
    }


    @FXML
    private TextField reginput;

    @FXML
    private TextField carmakeinput;

    @FXML
    private TextField carmodelinput;


    @FXML
    private TableView<Car> table2;

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

    @FXML
    private Circle button;

    @FXML
    private Button refresh;

    ObservableList<Car> observableList;


    public void setCars(List<Car> Carlist)
    {
        observableList= FXCollections.observableArrayList(Carlist);
        //settablefunction();
    }

   /*public void initialize()
    {
       //System.out.println(main.getCars());
       observableList = FXCollections.observableArrayList(main.getCars());
       settablefunction();
        // System.out.println(main);

    }*/


    /*public void settablefunction() {

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
        table2.setItems(observableList);

    }*/

   // public static void setMain(Main main1) {
       //main = main1;
   // }





    @FXML
    void resetpressed(ActionEvent event) {
       reginput.setText("");
       carmakeinput.setText("");
       carmodelinput.setText("");

    }

    @FXML
    void carMakeInputpressed(ActionEvent event) {

    }

    @FXML
    void carmodelInputpressed(ActionEvent event) {

    }

    @FXML
    void homepressed2(ActionEvent event) throws IOException {
     /*Parent root2;
     FXMLLoader loader= new FXMLLoader();
     loader.setLocation(getClass().getResource("/FXML/FirstScreen.fxml"));

     root2= loader.load();
     HomepageOfCarControllerforViewer controller= loader.getController();
     //controller.setMain(main);



     Scene scene = new Scene(root2, 800, 740);

     Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
     window.setScene(scene);
     window.setTitle("First Screen");
     window.show();*/

     main.ShowHomePage();

    }

    @FXML
    void backpressed(ActionEvent ev) throws IOException {
     Parent root2;
     FXMLLoader loader= new FXMLLoader();
     loader.setLocation(getClass().getResource("/FXML/ShowHomePageofCarsforViewer.fxml"));

     root2= loader.load();
     HomepageOfCarControllerforViewer controller= loader.getController();
    // controller.setMain(main);



     Scene scene = new Scene(root2, 800, 600);

     Stage window =(Stage) ((Node)ev.getSource()).getScene().getWindow();
     window.setScene(scene);
     window.setTitle("CarHomePage");
    }

   // @FXML
    //void refreshpressed(ActionEvent event) throws IOException {
       /* main.getNetworkUtil().write("ViewCarsForViewers");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            table2.getItems().clear();
                            table2.getItems().setAll(main.getCars());
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

    //}

    @FXML
    void reginputpressed(ActionEvent event) throws IOException {



        //main.getNetworkUtil().write("SEARCHBYREG");
        // main.getNetworkUtil().write(reginput.getText());
        //observableList= FXCollections.observableArrayList();
        //observableList.addAll(main.getCars());

    }

    @FXML
    void searchbycarmakemodel(ActionEvent event) throws IOException {
        String carmake= carmakeinput.getText();
        String carmodel= carmodelinput.getText();
        main.getNetworkUtil().write("SEARCHBYMAKEMODEL");
        main.getNetworkUtil().write(carmake);
        main.getNetworkUtil().write(carmodel);


    }

    @FXML
    void searchbyreg(ActionEvent event) throws IOException, ClassNotFoundException {

        String reg= reginput.getText();
        main.getNetworkUtil().write("SEARCHBYREG");
        main.getNetworkUtil().write(reg);
        //System.out.println("kam kore na!!!!!!!!!!!!!!!!!!!!11");


       // Car car= (Car)main.getNetworkUtil().read();
        //observableList.add(car);
        //table2.setItems(observableList);


       // table2.setItems(observableList);


      /*
        for(int i=0; i<table2.getItems().size(); i++) {
            if(table2.getItems()

        }
        table2.getItems().clear();
        //table2.getItems().setAll();
*/
    }



}

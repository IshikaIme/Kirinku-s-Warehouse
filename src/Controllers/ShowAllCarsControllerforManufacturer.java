package Controllers;

import Applications.Main;
import Server.Car;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ShowAllCarsControllerforManufacturer {

   private static Main main;


    @FXML
    private AnchorPane Mainpane;


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


        table.setEditable(true);

        observableList= FXCollections.observableArrayList();
        observableList.addAll(main.getCars());
        TableRegNo.setCellValueFactory(new PropertyValueFactory<>("Reg"));


        /*TableRegNo.setCellFactory(TextFieldTableCell.forTableColumn());
        TableRegNo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, String> event) {
                Car car=event.getRowValue();
                car.setReg(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/



        Tableyear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        Tableyear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Tableyear.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, Integer> event) {
                Car car=event.getRowValue();
                car.setYear(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        tablecolor1.setCellValueFactory(new PropertyValueFactory<>("color1"));
        tablecolor1.setCellFactory(TextFieldTableCell.forTableColumn());
        tablecolor1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, String> event) {
                Car car=event.getRowValue();
                car.setColor1(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Tablecolor2.setCellValueFactory(new PropertyValueFactory<>("color2"));
        Tablecolor2.setCellFactory(TextFieldTableCell.forTableColumn());
        Tablecolor2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, String> event) {
                Car car=event.getRowValue();
                car.setColor2(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        Tablecolor3.setCellValueFactory(new PropertyValueFactory<>("color3"));
        Tablecolor3.setCellFactory(TextFieldTableCell.forTableColumn());
        Tablecolor3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, String> event) {
                Car car=event.getRowValue();
                car.setColor3(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Tablecarmake.setCellValueFactory(new PropertyValueFactory<>("carmake"));
        Tablecarmake.setCellFactory(TextFieldTableCell.forTableColumn());
        Tablecarmake.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, String> event) {
                Car car=event.getRowValue();
                car.setCarmake(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        Tablecarmodel.setCellValueFactory(new PropertyValueFactory<>("carmodel"));
        Tablecarmodel.setCellFactory(TextFieldTableCell.forTableColumn());
        Tablecarmodel.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, String> event) {
                Car car=event.getRowValue();
                car.setCarmodel(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        Tableprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Tableprice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Tableprice.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, Integer> event) {
                Car car=event.getRowValue();
                car.setPrice(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        Tablequantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Tablequantity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Tablequantity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Car, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Car, Integer> event) {
                Car car=event.getRowValue();
                car.setQuantity(event.getNewValue());
                try {
                    sendEditInfo(car);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        table.setItems(observableList);

    }

    public static void setMain(Main main1) {
        main = main1;
    }

    public void sendEditInfo(Car car) throws IOException {


        main.getNetworkUtil().write("EDIT");
        main.getNetworkUtil().write(car);
       // System.out.println("setEditInfo kam kore" + car);
    }



    @FXML
    private Circle button;

    @FXML
    void homepressed(ActionEvent event) throws Exception{
        main.ShowHomePage();
    }

    @FXML
    private Button addcar;

    @FXML
    private Button deletecar;

    @FXML
    private Button refreshbutton;

    @FXML
    public void addcarpressed(javafx.event.ActionEvent event) throws IOException {

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
       /* main.getNetworkUtil().write("ViewCarsForViewers");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
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
        }).start();*/

       // controller.setAllCarController(this);
       // Car car =controller.Addrequest();




       /* Dialog<ButtonType> dialog=new Dialog<>();
        dialog.initOwner(Mainpane.getScene().getWindow());
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/FXML/DialoguePane.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (Exception e){
            System.out.println("Couldn't load the dialogue");
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK){
            DialogPane dialoguePane=fxmlLoader.getController();
            //dialoguePane.setmain(main);
            Car car= dialoguePane.Addrequest();*/

        /*if(car!=null){
            main.getNetworkUtil().write("ADD");
            main.getNetworkUtil().write(car);
            settablefunction();
        }
        else
            main.showAlertForAdministrator();*/


    }



    @FXML
    void deletecarpressed(javafx.event.ActionEvent event) throws IOException {
       //table.getSelectionModel();
        Car deleteCar;
        deleteCar=table.getSelectionModel().getSelectedItem();

            main.getNetworkUtil().write("DELETE");
            main.getNetworkUtil().write(deleteCar);
            observableList.remove(deleteCar);
        }
       // table.getItems().removeAll(table.getSelectionModel().getSelectedItems());





    @FXML
    void refreshpressed(ActionEvent event) throws IOException {

        //main.getNetworkUtil().write("REFRESH");
        main.getNetworkUtil().write("ViewCarsForViewers");
        //if(table.getItems().get)
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


    public void backpressed2(ActionEvent event) throws IOException {
        Parent root2;
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/ShowHomePageofCarsforManufacturer.fxml"));

        root2= loader.load();
        HomepageOfCarControllerforManufacturer controller= loader.getController();
        controller.setMain(main);



        Scene scene = new Scene(root2, 800, 600);

        Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("CarHomePage");
        window.show();
    }
}



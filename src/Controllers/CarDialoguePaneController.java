package Controllers;

import Applications.Main;
import Server.Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CarDialoguePaneController {
        private static Main main;
        private HomepageOfCarControllerforViewer carcontoller;

        public static void setMain(Main main1) {
            main = main1;
        }

        @FXML
        private AnchorPane dialogue;

        @FXML
        private TextField regno;

        @FXML
        private TextField year;

        @FXML
        private TextField color1;

        @FXML
        private TextField color2;

        @FXML
        private TextField color3;

        @FXML
        private TextField carmake;

        @FXML
        private TextField carmodel;

        @FXML
        private TextField price;

        @FXML
        private TextField quantity;

        @FXML
        private Button ok;

        @FXML
        private Button cancel;

        @FXML
        void cancelpressed(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ShowAllCarsforManufacturer.fxml"));

            ShowAllCarsControllerforManufacturer.setMain(main);
            //controller.setMain(main);
            Parent root2= loader.load();
            Scene scene = new Scene(root2, 800, 600);

            Stage window = (Stage)dialogue.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("CarTable");
            window.show();

        }

        @FXML
        void okpressed(ActionEvent event) {
            try {

                Car car= Addrequest();
                if(car!=null){
                    main.getNetworkUtil().write("ADD");
                    main.getNetworkUtil().write(car);
                   // settablefunction();
                }
                else
                { main.showAlertForAdministrator();
                return;}
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ShowAllCarsforManufacturer.fxml"));

                ShowAllCarsControllerforManufacturer.setMain(main);
                //controller.setMain(main);
                Parent root2= loader.load();
                Scene scene = new Scene(root2, 800, 600);

                Stage window = (Stage)dialogue.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("CarTable");
                window.show();
                //secondstage.setResizable(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

           // carcontoller.Showcarsformanufacturer
          // new HomepageOfCarControllerforManufacturer().Showcarsformanufacturer();

        }

        public Car Addrequest(){
            Car car=null;
            String reg1=regno.getText();
            String year1=year.getText();
            int year2;
            int price1;
            int quantity1;
            try{
                year2=Integer.parseInt(year1);
                price1=Integer.parseInt(price.getText());
                quantity1=Integer.parseInt(quantity.getText());}
            catch (Exception e){
                return null;
            }
            String carmake1=carmake.getText();
            String carmodel1=carmodel.getText();
            String color11=color1.getText();
            String color21=color2.getText();
            String color31=color3.getText();



            if(reg1.equals("")||carmake1.equals("")||carmodel1.equals("")){
                return null;
            }

            car=new Car(reg1,year2,color11,color21,color31,carmake1,carmodel1,price1,quantity1);

            return car;

        }


    public void setAllCarController(HomepageOfCarControllerforViewer hw) {
            this.carcontoller= hw;

    }
}





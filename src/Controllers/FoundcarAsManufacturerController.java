package Controllers;

import Applications.Main;
import Server.Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    public class FoundcarAsManufacturerController {
        private Main main;


        @FXML
        private TextField reg;

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
        void backpressed(ActionEvent event) {

            try{

                FXMLLoader loader= new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/SearchACarforViewer.fxml"));
                Parent root2;
                root2= loader.load();
                SearchACarControllerforViewer controller= loader.getController();
                controller.setMain(main);



                Scene scene = new Scene(root2, 800, 600);

                Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.setTitle("Search A Car for Viewer.");
                window.show();
                //secondstage.setResizable(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



        public void setCarinfo(Car car) {

            reg.setText(car.getReg());
            year.setText(Integer.toString(car.getYear()));
            color1.setText(car.getColor1());
            color2.setText(car.getColor2());
            color3.setText(car.getColor3());

            carmake.setText(car.getCarmake());

            carmodel.setText(car.getCarmodel());

            price.setText(Integer.toString(car.getPrice()));
            quantity.setText(Integer.toString(car.getQuantity()));


            reg.setEditable(false);
            year.setEditable(false);
            color1.setEditable(false);
            color2.setEditable(false);
            color3.setEditable(false);
            carmake.setEditable(false);
            carmodel.setEditable(false);
            price.setEditable(false);
            quantity.setEditable(false);





        }


        public void setMain(Main main) {
            this.main=main;
        }
    }

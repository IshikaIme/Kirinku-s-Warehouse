package Controllers;

import Applications.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondScreenController {
    private static Main main;

    public static void setMain(Main main1)
    {
        main=main1;
    }
    @FXML
    private Button serverclick;

    @FXML
    private Button clientclick;



    @FXML
    private void serverloginclick(ActionEvent event) {
        try {
            //Parent root4;
            //root4 = FXMLLoader.load(getClass().getResource("/FXML/ServerLogin.fxml"));
            Parent root4;
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ServerLogin.fxml"));

            root4= loader.load();
            ServerLoginController controller= loader.getController();
            controller.setMain(main);

            Scene scene = new Scene(root4, 800, 600);

            Stage window3 =(Stage) ((Node)event.getSource()).getScene().getWindow();
            window3.setScene(scene);
            window3.setTitle("Manufacturer login");
            window3.show();
            //secondstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void clientloginclick(ActionEvent ev) {
        try {


            Parent root2;


            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/CLientLogin.fxml"));

            root2= loader.load();
            ClientLoginController controller= loader.getController();
            controller.setMain(main);


            //root2 = FXMLLoader.load(getClass().getResource("/FXML/ShowAllCarsforviewers.fxml"));

            Scene scene = new Scene(root2, 800, 600);


            Stage window2 =(Stage) ((Node)ev.getSource()).getScene().getWindow();
            window2.setScene(scene);
            window2.setTitle("Client login screen");
            window2.show();
            //secondstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

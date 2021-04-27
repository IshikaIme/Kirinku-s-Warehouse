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

import java.io.IOException;


public class FirstScreenController {
    private static Main main;
    private Stage stage;

    public static void setMain(Main main1) {
        main = main1;
    }

    public void secondscreen(ActionEvent event) {
        try {

            Parent root2;
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/SecondScreen.fxml"));

            root2= loader.load();
            SecondScreenController controller= loader.getController();
            controller.setMain(main);



            Scene scene = new Scene(root2, 800, 600);

            Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Choose option");
             window.show();
            //secondstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
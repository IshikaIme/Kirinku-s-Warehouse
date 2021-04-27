package Controllers;


import Applications.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class BoughtACarController {
    private Main main;
    public void setMain(Main main1)
    {
        main=main1;
    }


    public void cheerspressed(ActionEvent event) {
        try {

            Parent root2;
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ShowAllCarsforviewers.fxml"));
           // ShowAllCarsControllerforViewer.setMain(main);
            root2= loader.load();
            ShowAllCarsControllerforViewer controller= loader.getController();



            //root2 = FXMLLoader.load(getClass().getResource("/FXML/ShowAllCarsforviewers.fxml"));

            Scene scene = new Scene(root2, 800, 600);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("CarTable");
            window.show();
            //secondstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

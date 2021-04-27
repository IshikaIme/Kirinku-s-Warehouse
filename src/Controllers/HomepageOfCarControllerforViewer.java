package Controllers;

import Applications.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomepageOfCarControllerforViewer {
    public Event event;
    private static Main main;
    public static void setMain(Main main1) {
        main = main1;
    }

    @FXML
    private Button home;

    @FXML
    private Button showallcars;

    @FXML
    private Button credits;

    @FXML
    private ImageView exit;

    @FXML
    void Credits(ActionEvent event) {

    }

    @FXML
    void Home(ActionEvent event) throws Exception{
        main.ShowHomePage();

    }

    @FXML
    void searchAcar(ActionEvent event) {
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

    @FXML
    void showAllCars(ActionEvent event) throws Exception {
        this.event = event;
      //  System.out.println(main);
        //System.out.println(main.getNetworkUtil());
        main.getNetworkUtil().write("ViewCarsForViewers");
       //main.showCarviewsForViewer();
         Showcarsforviewers();


    }



   void Showcarsforviewers() {
        try {

            Parent root2;
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ShowAllCarsforviewers.fxml"));
            ShowAllCarsControllerforViewer.setMain(main);
            root2= loader.load();
            //ShowAllCarsController controller= loader.getController();



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

    public void backpressed(java.awt.event.ActionEvent ev)
    {

    }

    /*@FXML
    void searchAcar(ActionEvent event) {
        try{
        Parent root2;
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/SearchACarforViewer.fxml"));
       SearchACarControllerforViewer Controller= new SearchACarControllerforViewer();

        root2= loader.load();
        Controller= loader.getController();
            //Controller.setMain(main);

        Scene scene = new Scene(root2, 800, 600);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Search A CarTable");
        window.show();

        //secondstage.setResizable(false);

            /*Parent root2;
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
        }*/


    /*} catch (Exception e) {
        e.printStackTrace();
    }


    }*/

}
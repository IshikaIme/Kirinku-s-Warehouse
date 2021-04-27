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

public class HomepageOfCarControllerforManufacturer {
    public Event event;
    private static Main main;

    public static void setMain(Main main1) {
        main = main1;
    }

    @FXML
    private Button home2;

    @FXML
    private Button showallcars2;

    @FXML
    private Button credits2;

    @FXML
    private ImageView exit;

    @FXML
    void Credits2(ActionEvent event) {

    }

    @FXML
    void Home2(ActionEvent event) throws Exception {
        main.ShowHomePage();

    }

    @FXML
    void searchAcar2(ActionEvent event) {

        try{

            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/SearchACarforManufacturer.fxml"));
            Parent root2;
            root2= loader.load();
            SearchACarControllerforManufacturer controller= loader.getController();
          controller.setMain(main);



            Scene scene = new Scene(root2, 800, 600);

            Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("Search A Car for Manufacturer.");
            window.show();
            //secondstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showAllCars2(ActionEvent event) throws Exception {
        this.event = event;
        //  System.out.println(main);
        //System.out.println(main.getNetworkUtil());
        main.getNetworkUtil().write("ViewCarsForViewers");
        //main.showCarviewsForViewer();
        Showcarsformanufacturer();


    }


    public void Showcarsformanufacturer() {
        try {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ShowAllCarsforManufacturer.fxml"));

            ShowAllCarsControllerforManufacturer.setMain(main);
            //controller.setMain(main);
            Parent root2= loader.load();
            Scene scene = new Scene(root2, 800, 600);

            Stage window = (Stage) home2.getScene().getWindow();
            window.setScene(scene);
            window.setTitle("CarTable");
            window.show();
            //secondstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
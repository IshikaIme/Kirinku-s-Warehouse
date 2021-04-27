package Applications;

import Client.Client;
import Controllers.FirstScreenController;
import Controllers.FoundcarAsViewerController;
import Controllers.SecondScreenController;

import Controllers.ShowAllCarsControllerforManufacturer;
import Server.Car;
import Server.ReadThreadServer;
import Server.Server;
import Util.NetworkUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    private NetworkUtil networkUtil;
    private Stage stage;
    public static Main mainnn;
    public static ShowAllCarsControllerforManufacturer showcars = new ShowAllCarsControllerforManufacturer();
    private static List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public Stage getStage() {
        return stage;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void setCars(List<Car> cars1) {
        cars = cars1;
        //System.out.println("car setted successfully");
        // System.out.println(cars);
    }


    // private Client client;

   /* public void setClient(Client client) {
        this.client = client;
    }*/

    @Override
    public void start(Stage primaryStage) {
        mainnn = this;
        try {
            stage = primaryStage;
            //connectToServer();
            ShowHomePage();
            //  setCars();

          /*  Parent root = FXMLLoader.load(getClass().getResource("/FXML/FirstScreen.fxml"));

            primaryStage.setTitle("Ready2Ride?");
            Scene scene= new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
            */

            /*Parent root;
            root = FXMLLoader.load(getClass().getResource("/FXML/FirstScreen.fxml"));

            /*
            Loading the controller
           FirstScreenController controller = loader.getController();
           controller.init(userName);
           controller.setMain(this);
            //Set the primary stage
           */
            /*
            connectToServer();
            primaryStage.setTitle("Home");
            primaryStage.setScene(new Scene(root, 758, 687));
            primaryStage.show();
            primaryStage.setResizable(false); */


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33334;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void ShowHomePage() throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/FirstScreen.fxml"));
        root = loader.load();
        FirstScreenController firstScreenController = loader.getController();
        FirstScreenController.setMain(this);
        stage.setTitle("First Screen");
        stage.setScene(new Scene(root, 800, 720));
        stage.show();
        stage.setResizable(false);
    }




   /* public void showCarviewsForViewer() throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/FXML/ShowAllCarsforviewers.fxml"));
        Parent root=fxmlLoader.load();
        showcars=fxmlLoader.getController();
        showcars.setMain(this);
        stage.setTitle("Page For User for Car view");
        stage.setScene(new Scene(root,800,600));
        stage.show();
    }*/


    @Override
    public void init() throws Exception {
        connectToServer();
    }

    public void showAlertForAdministrator() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!!!!!Incorrect Credentials.");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("You have to fulfill the requirements. Check and try again");
        alert.showAndWait();
    }

    void showCarFound(Car c) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/FoundcarAsViewer.fxml"));
        root = loader.load();
        FoundcarAsViewerController fv = loader.getController();
        fv.setMain(this);
        fv.setCarinfo(c);
        stage.setTitle("FoundCarAsViewer");
        stage.setScene(new Scene(root, 800, 720));
        stage.show();
        stage.setResizable(false);




    }


}



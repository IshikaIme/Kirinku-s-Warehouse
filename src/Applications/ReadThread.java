package Applications;

import Applications.Main;
import Controllers.FirstScreenController;
import Controllers.FoundcarAsViewerController;
import Controllers.HomepageOfCarControllerforManufacturer;
import Server.Car;
import Util.NetworkUtil;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
//import util.LoginDTO;

import java.io.IOException;
import java.util.List;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final Main main;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String hudai = "ViewCarsForViewers";
                //main.NetworkUtil.write();
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof List) {
                        //System.out.println("ki hoitese bujhtasi na");
                        // System.out.println((List<Car>)o);
                        main.setCars((List<Car>) o);
                    }

                    if (o instanceof String) {
                        if (((String) o).equalsIgnoreCase("CarNotFound")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    //System.out.println("Nullshala tao print hoyna");
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("No Car found!");
                                    alert.setHeaderText("Sorry! We have found no car.");
                                    alert.setContentText("We don't have such car right now, Check back later.");
                                    alert.showAndWait();
                                }


                            });
                        }
                    }
                    if (o instanceof Car) {

                        System.out.println(o);
                        // main.getCars().add((Car)o);


                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    main.showCarFound((Car)o);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                                // if (o != null) {
                                    //alert er kotha barta
                                    /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Search Result");
                                    alert.setHeaderText("Car Information :");
                                    alert.setContentText(o.toString());
                                    alert.showAndWait();*/
                               /* else {
                                    System.out.println("Nullshala tao print hoyna");
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("No Car found!");
                                    alert.setHeaderText("Sorry! We have found no car.");
                                    alert.setContentText("We don't have such car right now, Check back later.");
                                    alert.showAndWait();
                                }*/

                                //error er kotha barta


                            }


                        });

                    }


                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}






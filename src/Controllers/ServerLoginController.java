package Controllers;

import Applications.Main;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ServerLoginController {

    private static Main main;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private CheckBox rememberme;

    @FXML
    private Button login;

    @FXML
    private Text title;

    @FXML
    private ImageView carimg;

    @FXML
    private ImageView progress2;

    @FXML
    private Button reset;

    public ServerLoginController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        progress2.setVisible(false);
        username.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
    }

    @FXML
    public void loginAction(ActionEvent event) {

        String validUserName = "ime";
        String validPassword = "1234";
        String userName2 = username.getText();
        String passWord2 = password.getText();
        progress2.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3.00));
        pt.setOnFinished(aee -> {
            System.out.println("Login connecting: ");
        });
        pt.play();


        if (userName2.equals(validUserName) && passWord2.equals(validPassword)) {
            // successful login


            try {
                System.out.println("Login Successfully! ");

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

                /*Parent root2;
                root2 = FXMLLoader.load(getClass().getResource("/FXML/ShowHomePageofCarsforViewer.fxml"));


                Scene scene = new Scene(root2, 800, 600);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.setTitle("CarHomePage");
                window.show();*/
                //secondstage.setResizable(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // failed login
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();

        }
    }


    @FXML
    public void resetAction(ActionEvent event) {
        username.setText("");
        password.setText("");
    }

    void setMain(Main main) {
        this.main = main;
    }

}

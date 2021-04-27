package Controllers;

import Applications.Main;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientLoginController implements Initializable {

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
    private ImageView progress;


    @FXML
    private Button reset;

    public String Clientname;

    public static void setMain(Main main1)
    {
        main= main1;
    }


    public ClientLoginController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");

    }



    //public void loginAction2(ActionEvent e) {

        // Label userText , passwordText;
        //  String userName = userText.getText();
        // String password = passwordText.getText();
            
            
            /*LoginDTO loginDTO = new LoginDTO();
            loginDTO.setUserName(userName);
            loginDTO.setPassword(password);*/
            /*try {
                main.getNetworkUtil().write(loginDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
   // }

    // void resetAction2(ActionEvent event) {


   // }



    public void loginAction2(javafx.event.ActionEvent actionEvent1) {
        try{
        String userName = username.getText();
        String passWord = password.getText();
        //Client client= new Client("localhost" , 33344);

        progress.setVisible(true);
       /* PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3.00));
        pt.setOnFinished(a -> {
            System.out.println("Login Successfully! ");
        });
        pt.play();*/
        Clientname= userName;

            Parent root2;
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/ShowHomePageofCarsforViewer.fxml"));

            root2= loader.load();
            HomepageOfCarControllerforViewer controller= loader.getController();
            controller.setMain(main);



            Scene scene = new Scene(root2, 800, 600);

            Stage window =(Stage) ((Node)actionEvent1.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.setTitle("CarHomePage");
            window.show();
            //secondstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void resetAction2(javafx.event.ActionEvent actionEvent) {

        username.setText("");
        password.setText("");
    }



}

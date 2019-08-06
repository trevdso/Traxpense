package traxpense.Controllers;

import java.io.File;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import traxpense.objects.User;

public class MainController {
	@FXML private TextField txtFirst;
	@FXML private TextField txtLast;
	@FXML private TextField txtUserName;
	@FXML private TextField txtPassword;
	@FXML private TextField txtPasswordConfirm;
	@FXML private Button btnSignUp;
	@FXML private Button btnLogin;
	@FXML private Button btnLogo;

	@FXML private void initialize() { // lambde expressions for each button sending it to their respective method
            
            btnSignUp.setOnAction(e -> {onSignUpClicked();} );
            btnLogin.setOnAction(e -> {onLoginClicked();} );
            btnLogo.setOnAction(e -> {onLogoClicked();} );
	}

	private void onSignUpClicked() { 
            try{
                User user = new User();
                user.setFName(txtFirst.getText());
                user.setLName(txtLast.getText());
                user.setUsername(txtUserName.getText());
                user.setPassword(txtPassword.getText(),txtPasswordConfirm.getText());
                
           
            }catch(IllegalArgumentException n){
                Alert errorID = new Alert(Alert.AlertType.ERROR, n.getMessage(), ButtonType.OK);
                errorID.showAndWait();
                return;
            }
            Stage stage = (Stage)btnSignUp.getScene().getWindow();
            stage.close();
            try {
                AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/traxpense/resources/Dashboard.fxml"));
                Scene scene = new Scene(root,800,500);
                scene.getStylesheets().add(getClass().getResource("/traxpense/CSS/traxpenseStyle.css").toExternalForm());
                Stage secondStage = new Stage();
                secondStage.setTitle("Dashboard");
                            secondStage.getIcons().add(new Image(("file:TraxpenseLogo.png")));
                secondStage.setScene(scene);
                secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
                secondStage.showAndWait();
            } catch(Exception e) {
                e.printStackTrace();
            }
	}
	private void onLoginClicked() { // if login is pressed
		// Open the second window (stage)
            try{
                String dirPath = System.getProperty("user.dir") + "\\src\\traxpense\\data\\";
                File dir = new File(dirPath);
                File[] directoryListing = dir.listFiles();
                System.out.println(Arrays.toString(directoryListing));
                if (directoryListing.length > 0) {
                    for (File child : directoryListing) {
                        
                    }
                } else {
                    Alert errorID = new Alert(Alert.AlertType.ERROR, "There are no users currently signed up on your system\nSign up!", ButtonType.OK);
                    errorID.showAndWait();
                    return;
                }
            }catch(Exception e){
                return;
            }
            Stage stage = (Stage)btnLogin.getScene().getWindow();
            stage.close();
            try {
                AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/traxpense/resources/Dashboard.fxml"));
                Scene scene = new Scene(root,800,500);
                scene.getStylesheets().add(getClass().getResource("/traxpense/CSS/traxpenseStyle.css").toExternalForm());
                Stage secondStage = new Stage();
                secondStage.setTitle("Dashboard");
                            secondStage.getIcons().add(new Image(("file:TraxpenseLogo.png")));
                secondStage.setScene(scene);
                secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
                secondStage.showAndWait();
            } catch(Exception e) {
                e.printStackTrace();
            }
            
	}
        
	private void onLogoClicked() {

	}
}

package traxpense;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
	@FXML private TextField txtFirst;
	@FXML private TextField txtLast;
	@FXML private TextField txtEmail;
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

	private void onSignUpClicked() { // if sign up is pressed

	}
	private void onLoginClicked() { // if login is pressed
		// Open the second window (stage)
        try {
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root,800,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage secondStage = new Stage();
            secondStage.setTitle("Welcome To Traxpense");
			secondStage.getIcons().add(new Image(("file:traxpenseIcon.png")));
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
            secondStage.showAndWait();
        } catch(Exception e) {
            e.printStackTrace();
        }
        btnLogin.getScene().getWindow().hide(); // FIX THIS, DOES NOT CAUSE ANY COMPILE ERRORS BUT ALSO DOES NOT HIDE ORIGINAL SCENE
	}
	private void onLogoClicked() {

	}
}

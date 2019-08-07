package traxpense.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
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


/**
* Main Class Controller that handles sign up and input
*/
public class MainController {
    
    @FXML private TextField txtFirst;
    @FXML private TextField txtLast;
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    @FXML private TextField txtPasswordConfirm;
    @FXML private TextField txtLogin;
    @FXML private TextField txtLoginPass;

    @FXML private Button btnSignUp;
    @FXML private Button btnLogin;

    /**
    * Initialize and add buttons to actions allowing for clicks
    */
    @FXML private void initialize() { // lambde expressions for each button sending it to their respective method

        btnSignUp.setOnAction(e -> {onSignUpClicked();} );
        btnLogin.setOnAction(e -> {onLoginClicked();} );

    }

    /**
    * On sign up clicked the user's input fields are collected and a new file with the User's info is created
    */
    private void onSignUpClicked() { 
        
        try{
            
            User user = new User();
            user.setFName(txtFirst.getText());
            user.setLName(txtLast.getText());
            user.setUsername(txtUsername.getText());
            user.setPassword(txtPassword.getText(),txtPasswordConfirm.getText());
            updateFile(user);

        }catch(IllegalArgumentException n){
            
            Alert errorID = new Alert(Alert.AlertType.ERROR, n.getMessage(), ButtonType.OK);
            errorID.showAndWait();
            
            return;
            
        }
        //Once done close thi window and go to the dashboard window
        try {
            
            Stage stage = (Stage)btnSignUp.getScene().getWindow();
            stage.close();
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/traxpense/resources/Dashboard.fxml"));
            Scene scene = new Scene(root,800,500);
            scene.getStylesheets().add(getClass().getResource("/traxpense/CSS/traxpenseStyle.css").toExternalForm());
            Stage secondStage = new Stage();
            secondStage.setTitle("Dashboard");
            String filePath = System.getProperty("user.dir") + "\\src\\traxpense\\traxpenseIcon.png";
            secondStage.getIcons().add(new Image(new FileInputStream(filePath)));
            secondStage.setScene(scene);
            secondStage.initModality(Modality.NONE);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
            secondStage.showAndWait();
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }

    /**
    * When Log in is clicked we search for the user's file using their 
    * username and match thir password stored
    * to check for authorization
    */
    private void onLoginClicked() { // if login is pressed
            // Open the second window (stage)
        try{
            String dirPath = System.getProperty("user.dir") + "\\src\\traxpense\\data\\";
            File dir = new File(dirPath);
            File[] directoryListing = dir.listFiles();
            boolean check = false;
            if (directoryListing.length > 0) {
                
                for (File child : directoryListing) {
                    
                    BufferedReader buffer = new BufferedReader(new FileReader(child)); 
                    String st;

                    while ((st = buffer.readLine()) != null){
                        
                        String[] vals = st.split(":");
                        String tempUser = vals[0];
                        
                        if(tempUser.equalsIgnoreCase(txtLogin.getText())){
                            
                            check = true;
                            String temp = txtLoginPass.getText().trim();
                            //encryption was involved at one point but the .equals function wouldnt work with the string
                            //String pass = decrypt(vals[1]).trim();
                            String pass = vals[1].trim();
                            
                            if(temp.equalsIgnoreCase(pass)){
                                

                                try {
                                    
                                    User user = new User(tempUser, pass, vals[2], vals[3]);
                                    Stage stage = (Stage)btnLogin.getScene().getWindow();
                                    stage.close();
                                    AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/traxpense/resources/Dashboard.fxml"));
                                    Scene scene = new Scene(root,800,500);
                                    scene.getStylesheets().add(getClass().getResource("/traxpense/CSS/traxpenseStyle.css").toExternalForm());
                                    Stage secondStage = new Stage();
                                    secondStage.setTitle("Dashboard");
                                    String filePath = System.getProperty("user.dir") + "\\src\\traxpense\\traxpenseIcon.png";
                                    secondStage.getIcons().add(new Image(new FileInputStream(filePath)));
                                    secondStage.setScene(scene);
                                    secondStage.initModality(Modality.NONE);  // Use this to make the 2nd window modal (must close 2nd window to return to main window)
                                    secondStage.showAndWait();
                                    
                                } catch(Exception e) {
                                    
                                    e.printStackTrace();
                                    
                                }
                                
                            }else if(txtLoginPass.getText().isEmpty()){
                                
                                Alert errorID = new Alert(Alert.AlertType.ERROR, "Password field is empty", ButtonType.OK);
                                errorID.showAndWait();
                                
                                return;
                                
                            }else {
                                
                                Alert errorID = new Alert(Alert.AlertType.ERROR, "Invalid Password", ButtonType.OK);
                                errorID.showAndWait();
                                
                                return;
                                
                            }
                            
                            return;
                            
                        }else if(txtLogin.getText().isEmpty()){
                            
                            Alert errorID = new Alert(Alert.AlertType.ERROR, "Username field is empty", ButtonType.OK);
                            errorID.showAndWait();
                            
                            return;
                            
                        }
                        
                    }

                }
                
                if(check == false){
                    
                    Alert errorID = new Alert(Alert.AlertType.ERROR, "No such user on system, sign up!", ButtonType.OK);
                    errorID.showAndWait();
                    
                    return;
                    
                }
                
            } else {
                
                Alert errorID = new Alert(Alert.AlertType.ERROR, "There are no users currently signed up on your system\nSign up!", ButtonType.OK);
                errorID.showAndWait();
                
                return;
                
            }
            
        }catch(Exception e){
            
            return;
            
        }
        
    }

    /**
    * This function writes to file updating User info
    */
    private void updateFile(User user) {
        
        try{    
            
            String absoluteFilePath = System.getProperty("user.dir") + "\\src\\traxpense\\data\\" + user.getFName() + ".txt";
            File file = new File(absoluteFilePath);
            
            if(file.createNewFile()){
                
                FileWriter f = new FileWriter(absoluteFilePath, true);
                String line = String.format("%s:%s:%s:%s\n", user.getUsername(), user.getPassword(), user.getFName(), user.getLName());
                f.append(line);

                f.close();
                
            }else {
                
                FileWriter f = new FileWriter(absoluteFilePath, true);
                String line = String.format("%s:%s:%s:%s\n", user.getUsername(), user.getPassword(), user.getFName(), user.getLName());
                f.append(line);    
                f.close();    
                
            }


        }catch(Exception e){
            
            System.out.println(e.getMessage());
            
        }
        
    }
    
}

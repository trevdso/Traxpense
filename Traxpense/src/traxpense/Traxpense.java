package traxpense;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Traxpense extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,800,500); // x then y
			scene.getStylesheets().add(getClass().getResource("traxpenseStyle.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Welcome To Traxpense");
			primaryStage.getIcons().add(new Image(("file:TraxpeneLogo.png")));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

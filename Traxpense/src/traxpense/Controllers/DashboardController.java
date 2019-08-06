package traxpense.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class DashboardController {
	@FXML private PieChart spendingChart;
	@FXML private Button btnLogo;
	@FXML private Button btnProfile;
	@FXML private Button btnAssets;
	@FXML private Button btnLiable;
	@FXML private Button btnReports;
	@FXML private Button btnLogout;
	//Preparing ObservbleList object
	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
	   new PieChart.Data("Entertainment", 13),
	   new PieChart.Data("Food", 25),
	   new PieChart.Data("Neccesities", 10),
	   new PieChart.Data("Rent/Mortgage", 22));
	PieChart pieChart = new PieChart(pieChartData);

	@FXML private void initialize() { // lambde expressions for each button sending it to their respective method
		btnLogo.setOnAction(e -> {onLogoClicked();} );
		btnProfile.setOnAction(e -> {onProfileClicked();} );
		btnAssets.setOnAction(e -> {onAssetsClicked();} );
		btnLiable.setOnAction(e -> {onLiableClicked();} );
		btnReports.setOnAction(e -> {onReportsClicked();} );
		btnLogout.setOnAction(e -> {onLogoutClicked();} );
	}

	private void onLogoClicked() { // go back to dashboard

	}
	private void onProfileClicked() {
		try {
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Profile.fxml"));
            Scene scene = new Scene(root,800,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage thirdStage = new Stage();
            thirdStage.setTitle("Traxpense Profile");
            thirdStage.getIcons().add(new Image(("file:traxpenseIcon.png")));
            thirdStage.setScene(scene);
            thirdStage.initModality(Modality.APPLICATION_MODAL);
            thirdStage.showAndWait();
        } catch(Exception e) {
            e.printStackTrace();
        }
		// close dashboard stage
	}
	private void onAssetsClicked() {
		try {
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Assets.fxml"));
            Scene scene = new Scene(root,800,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage fourthStage = new Stage();
            fourthStage.setTitle("Your Assets - Traxpense");
            fourthStage.getIcons().add(new Image(("file:traxpenseIcon.png")));
            fourthStage.setScene(scene);
            fourthStage.initModality(Modality.APPLICATION_MODAL);
            fourthStage.showAndWait();
        } catch(Exception e) {
            e.printStackTrace();
        }
		// close dashboard stage
	}
	private void onLiableClicked() {
		try {
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Liabilities.fxml"));
            Scene scene = new Scene(root,800,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage fifthStage = new Stage();
            fifthStage.setTitle("Your Liabilities - Traxpense");
            fifthStage.getIcons().add(new Image(("file:traxpenseIcon.png")));
            fifthStage.setScene(scene);
            fifthStage.initModality(Modality.APPLICATION_MODAL);
            fifthStage.showAndWait();
        } catch(Exception e) {
            e.printStackTrace();
        }
		// close dashboard stage
	}
	private void onReportsClicked() {
		try {
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Reports.fxml"));
            Scene scene = new Scene(root,800,500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage sixthStage = new Stage();
            sixthStage.setTitle("Your Report - Traxpense");
            sixthStage.getIcons().add(new Image(("file:traxpenseIcon.png")));
            sixthStage.setScene(scene);
            sixthStage.initModality(Modality.APPLICATION_MODAL);
            sixthStage.showAndWait();
        } catch(Exception e) {
            e.printStackTrace();
        }
		// close dashboard stage
	}
	private void onLogoutClicked() { // go back to home page

	}

}

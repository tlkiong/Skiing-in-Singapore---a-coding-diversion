package main;

import java.io.IOException;

import main.common.util.Resource;
import main.dashboard.view.DashboardViewController;
import main.root.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private BorderPane rootLayout;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Skiing In Singapore!");

		initRootLayout();
	}
	
	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("root/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			// Give root layout controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//
//	public void showDashboard(){
//		try {
//			// Load person overview
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class
//					.getResource("dashboard/view/DashboardView.fxml"));
//			AnchorPane dashboardView = (AnchorPane) loader.load();
//			primaryStage.setHeight(780);
//			primaryStage.setWidth(1200);
//			primaryStage.setY(0);
//			primaryStage.setX(200);
//			primaryStage.setMaximized(true);
//			// Set person overview onto center of root layout
//			rootLayout.setCenter(dashboardView);
//			
//			// Give the controller access to the main app.
//			DashboardViewController dashboardViewController = loader.getController();
//			dashboardViewController.setMainApp(this);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
}

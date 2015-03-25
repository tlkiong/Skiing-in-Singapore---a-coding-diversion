package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.homepage.view.HomepageController;
import main.root.view.RootLayoutController;

public class MainApp extends Application {
	
	private BorderPane rootLayout;
	private Stage primaryStage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Skiing In Singapore!");

		initRootLayout();
		showHomepageView();
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
			primaryStage.centerOnScreen();
			
			// Give root layout controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private void showHomepageView() {
		try {
			// Load person overview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("homepage/view/HomepageView.fxml"));
			AnchorPane dashboardView = (AnchorPane) loader.load();

			// Set homepage view onto center of root layout
			rootLayout.setCenter(dashboardView);
			
			// Give the controller access to the main app.
			HomepageController homepageController = loader.getController();
			homepageController.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//
//	public void showDashboard(){
//		
//	}
//	
}

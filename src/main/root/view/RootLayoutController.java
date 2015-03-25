package main.root.view;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import main.MainApp;

public class RootLayoutController {
	// Reference to the main application
	private MainApp mainApp;
	private Hyperlink viewCodeLink = new Hyperlink("https://github.com/tlkiong/Skiing-in-Singapore---a-coding-diversion");
	private Hyperlink myLinkedinLink = new Hyperlink("https://sg.linkedin.com/pub/lee-kiong-tan/84/ab6/443");
	
	/*
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/*
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}

	@FXML
	private void openViewCodeLink() {
		mainApp.getHostServices().showDocument(viewCodeLink.getText());
	}

	@FXML
	private void openMyLinkedinLink() {
		mainApp.getHostServices().showDocument(myLinkedinLink.getText());
	}

}

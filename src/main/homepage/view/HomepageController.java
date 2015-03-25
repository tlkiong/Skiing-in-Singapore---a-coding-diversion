package main.homepage.view;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import main.MainApp;
import main.util.TextFileData;

public class HomepageController {
	// Reference to the main application
	private MainApp mainApp;
	private String[][] dataFromTxtFile;

	@FXML
	GridPane gridpane = new GridPane();

	/*
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		TextFileData txtFileData = new TextFileData();
		dataFromTxtFile = txtFileData.getTxtFileData();
		//Gridpane.add(dataon the box, column, row)
		for (int i =0; i<dataFromTxtFile.length;i++){
			for (int j=0; j<dataFromTxtFile[i].length;j++){
				Text data = new Text(dataFromTxtFile[i][j]);
				System.out.println("HERE: "+dataFromTxtFile[i][j]);
				gridpane.add(data,i,j);
			}
		}
		
		System.out.println("dataFromTxtFile length: "+dataFromTxtFile.length);
	}

	/*
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}

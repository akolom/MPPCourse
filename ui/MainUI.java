package ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainUI extends Application{

	public static void main(String[] args) {
		Application.launch(MainUI.class, args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(
				"Login.fxml"));

		primaryStage.setTitle("Library Management System");
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	

}

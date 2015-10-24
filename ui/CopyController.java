package ui;


import business.Book;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class CopyController {
	@FXML
	private TextField isbn;
	
	@FXML
	private Button add;
	
	@FXML
	protected void handleAddCopyAction(ActionEvent event) {
		SystemController sys = new SystemController();
		
		try {
			sys.addBookCopy(isbn.getText());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText("Confirmation");
			alert.setContentText("Copy Added Sucessfully!");

			alert.showAndWait();
			isbn.setText("");
			add.setDisable(true);
			
		} catch (LibrarySystemException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@FXML
	protected void handlKeyAction(final KeyEvent keyevent) {

		SystemController sys = new SystemController();
		
		Book b = sys.searchBook(isbn.getText());
		
		boolean book = sys.isBookExist(isbn.getText());
		add.setDisable(b == null);
		
		isbn.setStyle("-fx-background-color: white");
		if (!book) {

			isbn.setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");

		} else if (b != null)

			isbn.setStyle("-fx-background-color: rgb(119, 192, 75, .9);");

	}

}

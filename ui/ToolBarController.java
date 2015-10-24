package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;


public class ToolBarController {
	@FXML
	private ScrollPane root;
	
	@FXML
	private Pane main;

	@FXML
	protected void handleAddBookButtonAction(ActionEvent event) {

		try {
			
			root.setContent(FXMLLoader.load(getClass().getResource(
					"AddBook.fxml")));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	protected void handleAddMemeberButtonAction(ActionEvent event) {

		try {
			
			root.setContent(FXMLLoader.load(getClass().getResource(
					"AddMember.fxml")));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	protected void handleCheckOutButtonAction(ActionEvent event) {

		try {
			
			root.setContent(FXMLLoader.load(getClass().getResource(
					"checkout.fxml")));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	protected void handleOverdueButtonAction(ActionEvent event) {

		try {
			
			root.setContent(FXMLLoader.load(getClass().getResource(
					"overdue.fxml")));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	@FXML
	protected void handleAddCopyButtonAction(ActionEvent event) {

		try {
			
			root.setContent(FXMLLoader.load(getClass().getResource(
					"AddCopy.fxml")));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	@FXML
	protected void handlePrintRecordButtonAction(ActionEvent event) {

		try {
			
			root.setContent(FXMLLoader.load(getClass().getResource(
					"printRecord.fxml")));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	@FXML
	protected void handleLogoutButtonAction(ActionEvent event) {

		try {
			
			main.getChildren().clear();
			main.getChildren().add(FXMLLoader.load(getClass().getResource(
					"Login.fxml")));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

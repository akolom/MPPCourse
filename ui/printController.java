package ui;

import business.Book;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class printController {
	@FXML
	private TextField member;

	@FXML
	private Button print;

	@FXML
	protected void handlKeyAction(final KeyEvent keyevent) {

		SystemController sys = new SystemController();
	
		
		LibraryMember m = sys.search(member.getText());
		boolean memberFlag = sys.isMemberExist(member.getText());
		print.setDisable(m == null);
		member.setStyle("-fx-background-color: white;");
		if (! memberFlag) {

			member.setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");
		} else if (m != null) {

			member.setStyle("-fx-background-color: rgb(119, 192, 75, .7);");
		}

	}

	@FXML
	protected void handlPrintAction(ActionEvent event) {

		SystemController sys = new SystemController();
		try {
			sys.printCheckoutRecord(member.getText());
		} catch (LibrarySystemException e) {
	
			e.printStackTrace();
		}

	}
}

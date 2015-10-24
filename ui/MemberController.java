package ui;

import business.Address;
import business.LibrarySystemException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MemberController {
	@FXML
	private TextField memberID;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField phoneNum;

	@FXML
	private TextField street;

	@FXML
	private TextField city;

	@FXML
	private TextField state;

	@FXML
	private TextField zip;

	@FXML
	protected void handleAddAction(ActionEvent event) {

		SystemController sys = new SystemController();
		Address addr = new Address(street.getText(), city.getText(),
				state.getText(), zip.getText());
		try {
			if (memberID.getText().equals("") || firstName.getText().equals("")
					|| lastName.getText().equals("")
					|| phoneNum.getText().equals("")
					|| street.getText().equals("") || city.getText().equals("")
					|| state.getText().equals("") || zip.getText().equals("")) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText("Fields can not be Empty!");
				alert.showAndWait();
			} else {

				sys.addNewMember(memberID.getText(), firstName.getText(),
						lastName.getText(), phoneNum.getText(), addr);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Member Added Sucessfully!");
				alert.showAndWait();
				memberID.setText("");
				firstName.setText("");
				lastName.setText("");
				phoneNum.setText("");
				street.setText("");
				city.setText("");
				state.setText("");
				zip.setText("");
			}
		} catch (LibrarySystemException e) {

			e.printStackTrace();
		}
	}

	@FXML
	protected void handleClearAction(ActionEvent event) {
		memberID.setText("");
		firstName.setText("");
		lastName.setText("");
		phoneNum.setText("");
		street.setText("");
		city.setText("");
		state.setText("");
		zip.setText("");

	}

}

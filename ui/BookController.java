package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import business.Address;
import business.Author;
import business.Book;
import business.LibrarySystemException;
import business.SystemController;
import javafx.scene.Node;

public class BookController {
	@FXML
	private VBox authorbox;

	@FXML
	private TextField bookTitle;

	@FXML
	private TextField isbn;

	@FXML
	private TextField maxCheckoutLength;

	@FXML
	private TextField NumCopies;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField credentials;

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
	protected void handleAddAuthorAction(ActionEvent event) {

		try {

			authorbox.getChildren().add(
					FXMLLoader.load(getClass().getResource("Author.fxml")));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	protected void handleAddAction(ActionEvent event) {
		SystemController sys = new SystemController();
		List<Author> authors = new ArrayList<Author>();
		Address address = new Address(street.getText(), city.getText(),
				state.getText(), zip.getText());
		Author author = new Author(firstName.getText(), lastName.getText(),
				phoneNum.getText(), address, credentials.getText());
		authors.add(author);
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		for (Node n : authorbox.getChildren()) {
			AnchorPane aPane = (AnchorPane) n;
			TextField firstNamefield = (TextField) aPane.lookup("#firstName");
			TextField lastNamefield = (TextField) aPane.lookup("#lastName");
			TextField credentialsfield = (TextField) aPane
					.lookup("#credentials");
			TextField phoneNumfield = (TextField) aPane.lookup("#phoneNum");
			TextField streetfield = (TextField) aPane.lookup("#street");
			TextField cityfield = (TextField) aPane.lookup("#city");
			TextField statefield = (TextField) aPane.lookup("#state");
			TextField zipfield = (TextField) aPane.lookup("#zip");
			
			address = new Address(streetfield.getText(), cityfield.getText(),
					statefield.getText(), zipfield.getText());
			author = new Author(firstNamefield.getText(),
					lastNamefield.getText(), phoneNumfield.getText(), address,
					credentialsfield.getText());
			authors.add(author);

		}

		if (bookTitle.getText().equals("") || isbn.getText().equals("")
				|| maxCheckoutLength.getText().equals("")
				|| NumCopies.getText().equals("")
				|| firstName.getText().equals("")
				|| lastName.getText().equals("")
				|| credentials.getText().equals("")
				|| phoneNum.getText().equals("") || street.getText().equals("")
				|| city.getText().equals("") || state.getText().equals("")
				|| zip.getText().equals("") ) {

			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Fields Can not be Empty!");
			alert.showAndWait();
		} else if (!maxCheckoutLength.getText().matches("\\d+")
				|| !NumCopies.getText().matches("\\d+")) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Max Checkout Length and Number of Copies must be digits!");
			alert.showAndWait();
		} else {

			try {
				sys.addBook(isbn.getText(), bookTitle.getText(),
						Integer.parseInt(maxCheckoutLength.getText()), authors,
						Integer.parseInt(NumCopies.getText()));
				alert.setAlertType(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText("Confirmation");
				alert.setContentText("Book Added Sucessfully!");

				alert.showAndWait();
				isbn.setText("");
				bookTitle.setText("");
				maxCheckoutLength.setText("");
				NumCopies.setText("");
				firstName.setText("");
				lastName.setText("");
				phoneNum.setText("");
				credentials.setText("");
				street.setText("");
				city.setText("");
				state.setText("");
				zip.setText("");
				authorbox.getChildren().clear();

			} catch (NumberFormatException | LibrarySystemException e) {

				e.printStackTrace();
			}
		}

	}

	@FXML
	protected void handleClearAction(ActionEvent event) {
		isbn.setText("");
		bookTitle.setText("");
		maxCheckoutLength.setText("");
		NumCopies.setText("");
		firstName.setText("");
		lastName.setText("");
		phoneNum.setText("");
		credentials.setText("");
		street.setText("");
		city.setText("");
		state.setText("");
		zip.setText("");
		authorbox.getChildren().clear();

	}
}

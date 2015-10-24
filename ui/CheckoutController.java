package ui;


import java.util.ArrayList;
import java.util.List;

import business.Book;
import business.CheckoutRecordEntry;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


public class CheckoutController {
	@FXML
	private Pane root;

	@FXML
	private Button checkout;

	@FXML
	private TextField memberID;

	@FXML
	private TextField isbn;

	@FXML
	private TableView<CheckoutTableModel> table;

	@FXML
	private TableColumn<CheckoutTableModel, String> isbnColumn;
	@FXML
	private TableColumn<CheckoutTableModel, String> memberColumn;
	@FXML
	private TableColumn<CheckoutTableModel, String> copyNumColumn;
	@FXML
	private TableColumn<CheckoutTableModel, String> checkoutColumn;
	@FXML
	private TableColumn<CheckoutTableModel, String> dueColumn;

	private boolean member;
	private boolean book;
	private ObservableList<CheckoutTableModel> data;
	
	@FXML
	protected void handleMemberFieldAction(KeyEvent event) {
		SystemController sys = new SystemController();
		Book b = sys.searchBook(isbn.getText());
		LibraryMember m = sys.search(memberID.getText());
		member = sys.isMemberExist(memberID.getText());
		checkout.setDisable(b == null || m == null);
		memberID.setStyle("-fx-background-color: white;");
		if (!member) {

			memberID.setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");
		} else if (m != null) {

			memberID.setStyle("-fx-background-color: rgb(119, 192, 75, .7);");
		}

	}

	@FXML
	protected void handleBookFieldAction(KeyEvent event) {
		SystemController sys = new SystemController();
		Book b = sys.searchBook(isbn.getText());
		LibraryMember m = sys.search(memberID.getText());
		book = sys.isBookExist(isbn.getText());
		checkout.setDisable(m == null || b == null);
		
		isbn.setStyle("-fx-background-color: white");
		if (!book) {

			isbn.setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");

		} else if (b != null)

			isbn.setStyle("-fx-background-color: rgb(119, 192, 75, .9);");

	}

	@FXML
	protected void handleCheckoutAction(ActionEvent event) {
		SystemController sys = new SystemController();

		try {

			sys.checkoutBook(memberID.getText(), isbn.getText());
			List<CheckoutRecordEntry> list = sys.search(memberID.getText())
					.getRecord().getCheckoutRecordEntries();
			List<CheckoutTableModel> records =new ArrayList<>();
			for (CheckoutRecordEntry e : list) {
				CheckoutTableModel model = new CheckoutTableModel(
						memberID.getText(), e.getBook(), Integer.valueOf(
								e.getCopy().getCopyNum()).toString(), e
								.getCheckoutDate().toString(), e.getDueDate()
								.toString());
				records.add(model);
			}
			data = FXCollections.observableArrayList(records);
			table.getItems().setAll(data);
		} catch (LibrarySystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

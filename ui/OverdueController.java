package ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.Book;
import business.LibraryMember;
import business.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class OverdueController implements Initializable{
	@FXML
	private TableView<Overdue> table;

	@FXML
	private TableColumn<Overdue, String> isbnColumn;
	@FXML
	private TableColumn<Overdue, String> titleColumn;
	@FXML
	private TableColumn<Overdue, String> memberColumn;
	@FXML
	private TableColumn<Overdue, String> copyColumn;
	@FXML
	private TableColumn<Overdue, String> dueColumn;

	@FXML
	private TextField bookID;
	
	
	@FXML
	private Button overdue;
	
	private ObservableList<Overdue> data;
	 
	
	@FXML
	protected void handleBookFieldAction(KeyEvent event) {
		SystemController sys = new SystemController();
		Book b = sys.searchBook(bookID.getText());
		boolean book = sys.isBookExist(bookID.getText());
		overdue.setDisable(b == null);
		bookID.setStyle("-fx-background-color: white;");
		if (!book) {

			bookID.setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");
		} else if (b != null) {

			bookID.setStyle("-fx-background-color: rgb(119, 192, 75, .7);");
		}

	}
	
	@FXML
	protected void handleOverdueAction(ActionEvent event) {

		SystemController sys = new SystemController();
		List<Overdue> list = sys.getOverdue(bookID.getText());
		data = FXCollections.observableArrayList(list);
		table.getItems().setAll(data);
;		
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		isbnColumn.setCellValueFactory(new PropertyValueFactory<Overdue,String>("isbnProperty"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Overdue,String>("titleProperty"));
		memberColumn.setCellValueFactory(new PropertyValueFactory<Overdue,String>("memberProperty"));
		copyColumn.setCellValueFactory(new PropertyValueFactory<Overdue,String>("copyNumProperty"));
		dueColumn.setCellValueFactory(new PropertyValueFactory<Overdue,String>("dueDateProperty"));
		data = FXCollections.observableArrayList();
		table.getItems().addAll(data);
		
		
	}

	
}

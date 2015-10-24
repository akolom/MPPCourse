package ui;

import java.io.IOException;

import dataaccess.Auth;
import business.LoginException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class LoginController {
	@FXML
	private Pane root;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	@FXML
	private Text actiontarget;

	@FXML
	protected void handleLoginAction(ActionEvent event) {
         
		SystemController sys = new SystemController();
		try {
			sys.login(username.getText(), password.getText()) ;
			
			root.getChildren().clear();
			switch(SystemController.currentAuth){
			case BOTH:
				root.getChildren()
				.add(root = FXMLLoader.load(getClass().getResource(
						"Main.fxml")));
				break;
			case ADMIN:
				root.getChildren()
				.add(root = FXMLLoader.load(getClass().getResource(
						"MainAdmin.fxml")));
				break;
			case LIBRARIAN:
				root.getChildren()
				.add(root = FXMLLoader.load(getClass().getResource(
						"MainLibrarian.fxml")));
				break;
			}
			
		} catch(LoginException le){
			actiontarget.setText(le.getMessage());
		}
		catch (IOException e) {

			e.printStackTrace();
		}
	}

}

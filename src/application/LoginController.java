package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class LoginController  implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private Data data = new Data();
	private String userID;
	
	@FXML private TextField usernameTextField;
	@FXML private PasswordField passwordPasswordField;
	@FXML private Label warningLabel;
	
	// Function fires when Sign In button is pressed
	public void signInButton(ActionEvent event) throws IOException {
		String username = usernameTextField.getText();
		String password = passwordPasswordField.getText();
		userID = data.verifyUsernameAndPassword(username, password);
		System.out.println(userID);
		
		if( userID == "false") {
			warningLabel.setVisible(true);
		}else {
			Data.user = userID;
			if (userID == "014") load("WarehouseAgentDashboard.fxml", event);
			if (userID == "015") load("WarehouseManagerAllParcels.fxml", event);
			if (userID == "016") load("DeliveryDriverHandover.fxml", event);
			if (userID == "017") load("InternationalDriverCargoDepartingInfo.fxml", event);
			if (userID == "018") load("LogisticsAgentBranchStats.fxml", event);
			if (userID == "019") load("OrderConfirmationSpecialistOrderProcessing.fxml", event);
			
		}
		
	}
	
	public void load(String view, ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(view));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		warningLabel.setVisible(false);

		
	}

}

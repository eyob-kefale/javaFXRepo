import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class logIn {

    @FXML
    private Button logIn_button;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label errorMessage;

    public void userLogIn(ActionEvent event) throws IOException {
        // login();
        validateLogIn();
    }

    public void userSignUp(ActionEvent event) throws IOException {
        // login();
        App a = new App();
        a.changeScene("signUp.fxml");
    }

    // public void login() throws IOException {
    // App m = new App();
    // if (username.getText().toString().equals("eyob") &&
    // password.getText().toString().equals("123")) {
    // errorMessage.setText("Success");
    // m.changeScene("logOut.fxml");
    // } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
    // errorMessage.setText("please enter your data");
    // } else {
    // errorMessage.setText("Wrong user name or password");
    // }
    // }

    public void validateLogIn() {
        App m = new App();
        DataBaseConnection connectionNow = new DataBaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogIn = "select count(1) from users where name='" + username.getText() + "'And password='"
                + password.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogIn);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    m.changeScene("SuccessMessage.fxml");
                    errorMessage.setText("Wellcome");
                } else {

                    errorMessage.setText("Invalid login");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

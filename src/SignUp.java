import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp {

    @FXML
    private PasswordField Password;

    @FXML
    private TextField id;

    @FXML
    private Button signUp;

    @FXML
    private TextField userName;

    public void userSignUp(ActionEvent event) throws IOException {
        // login();
        creatProfile();
    }

    public void creatProfile() {

        DataBaseConnection connectionNow = new DataBaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String insert = ("insert into users values(?,?,?)");
        try {
            PreparedStatement pStatement = connectDB.prepareStatement(insert);
            pStatement.setString(1, id.getText());
            pStatement.setString(2, userName.getText());
            pStatement.setString(3, Password.getText());

            // System.out.printf(id.getText(), userName.getText(), Password.getText());
            pStatement.executeUpdate();
            App a = new App();
            a.changeScene("logIn.fxml");

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

}

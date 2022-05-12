import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class logOut {

    @FXML
    private Button logOut;

    public void logout() throws Exception {
        App a = new App();
        a.changeScene("logIn.fxml");
    }
}

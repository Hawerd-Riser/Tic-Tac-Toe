import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class go {

    @FXML
    private Label winText;

    public void setResultMessage(String message) {
      winText.setText(message);
      //winText.setAlignment(null);
    }

}


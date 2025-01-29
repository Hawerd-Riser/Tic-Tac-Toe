import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;


public class tttContorller implements Initializable{
    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private ImageView playerO;

    @FXML
    private ImageView playerX;

    private boolean turn = true;

    ArrayList<Button> buttons;
    Driver d1 = new Driver();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons = new ArrayList<>(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9));
        buttons.forEach(button ->{
            setmark(button);
            button.setFocusTraversable(false);
        });
    }

    public void setmark(Button button){
        button.setOnMouseClicked(_ ->{
            int cursor = setButton(button);
            d1.setter(turn, cursor);
            button.setDisable(true);
            if(d1.checkWin(turn)|| d1.counter>=9){
                System.out.println("From here ----");
                hasWon(turn);
            }

        });
    }
    public int setButton(Button button){
        String Id= button.getId();
        if (turn){
            button.setText("X");
            turn = false;
            playerX.setOpacity(0);
            playerO.setOpacity(1);

        }else{
            button.setText("O");
            turn = true;
            playerX.setOpacity(1);
            playerO.setOpacity(0);
        }
        return (Integer.parseInt(Id));
    }
    public void hasWon(boolean win) {
        String resultMessage = new String();
        if (d1.checkWin(turn)) {
            resultMessage = turn ? "Player O Won!" : "Player X Won!";
            desabpleAll();
        }else{
            resultMessage = "Draw";
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameOver.fxml"));
            Parent root = loader.load();
    
            // Get controller of GameOver.fxml
            go gameOverController = loader.getController();
                
            // Set the result message dynamically
            gameOverController.setResultMessage(resultMessage);
    
            Stage gameOverStage = new Stage();
            gameOverStage.setTitle("Game Over");
            gameOverStage.setScene(new Scene(root));
            gameOverStage.show();
    
            // Disable further input (optional)
            buttons.forEach(button -> button.setDisable(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


    @FXML
    void Restart(ActionEvent event) {
        buttons.forEach(button ->{
            button.setDisable(false);
            button.setText("");
        });
        d1.resetBoard();
    }
    public void desabpleAll(){
        buttons.forEach(button ->{
            button.setDisable(false);
        });
    }
    
    

}

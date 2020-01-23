package sample;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextArea dialog;
    public TextField msg_text;
    public Button btn;
    public String lastMessage = "";

    public void printOut(String input) {
        if (!input.equals(lastMessage)) {
            dialog.appendText("User: " + input + "\n");
            dialog.setScrollTop(Double.MAX_VALUE);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.setController(this);
        msg_text.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    Main.getController().printOut(msg_text.getText());
                    Main.getClient().printWriter.println(msg_text.getText());
                    lastMessage = msg_text.getText();
                    msg_text.setText("");
                }
            }
        });
    }
}

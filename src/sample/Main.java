package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static Controller controller;

    public static Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        Main.controller = controller;
    }
    public static Client client;

    public static Client getClient() {
        return client;
    }

    public static void setClient(Client client) {
        Main.client = client;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene( new Scene(root, 600, 500));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        client = new Client();
        client.start();
        launch(args);
    }
}

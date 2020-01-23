package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;

public class Client extends Thread {
    public BufferedReader bufferedReader;
    public PrintWriter printWriter;
    @Override
    public void run() {
        final String HOST = "localhost";
        final int PORT = 1234;
        Socket s = null;
        try {
            s = new Socket(HOST, PORT);
            printWriter = new PrintWriter(s.getOutputStream(),true);
            System.out.println("connected");
            bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        while (true) {
            String input = null;
            try {
                input = bufferedReader.readLine();
                if(input != null){
                    Main.getController().printOut(input);
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}

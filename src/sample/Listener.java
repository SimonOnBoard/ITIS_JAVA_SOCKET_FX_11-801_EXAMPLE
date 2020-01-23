package sample;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Listener extends Thread {
    PrintWriter printWriter;
    public Listener(OutputStream outputStream) {
        this.printWriter = new PrintWriter(outputStream,true);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            printWriter.println(input);
        }
    }
}

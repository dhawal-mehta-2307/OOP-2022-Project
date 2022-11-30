package client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    // Used to keep track of all the clients and broadcast messages to all of them...
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader; // To read messages sent by the client
    private BufferedWriter bufferedWriter; // To send messages to client
    private String clientUsername;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            clientHandlers.add(this);
        } catch (IOException e) {
            System.out.println("Error with client handler");
            e.printStackTrace();
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {

    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
    }
    public void closeEverything(Socket socket, BufferedReader br, BufferedWriter bw) {
        removeClientHandler();
        try {
            if (br != null) br.close();
            if (bw != null) bw.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

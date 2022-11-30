package client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Admin {

    private ServerSocket adminSocket;

    public Admin(ServerSocket adminSocket) {
        this.adminSocket = adminSocket;
    }

    public void startServer() {
        try {
            while (!adminSocket.isClosed()) {
                Socket socket = adminSocket.accept();
                System.out.println("A new user has connected");
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {

        }
    }

    public void closeServerSocket() {
        try {
            if (adminSocket != null) adminSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket adminSocket = new ServerSocket(1234);
        Admin admin = new Admin(adminSocket);
        admin.startServer();
    }
    private SortedMap<User, String> userRegister = new TreeMap<>();

    public void registerNewUser(String userName, String password) throws UserNameAlreadyExistsException {
        for(User user: userRegister.keySet()) {
            if(user.getUserName().equals(userName))
                throw new UserNameAlreadyExistsException("Username taken. Please choose another one.");
        }
        userRegister.put(new User(userName), password);
    }

    public void loginUser(String userName, String password) throws IncorrectCredentialsException {
        boolean isValid = false;
        for(User user: userRegister.keySet()) {
            if (user.getUserName().equals(userName) && userRegister.get(user).equals(password)) {
                System.out.println("Login successful");
                isValid = true;
                break;
            }
        }
        if (!isValid) throw new IncorrectCredentialsException("Incorrect username/password!");
    }

    public void logoutUser() {

    }

    public void displayTopTenContributors() {
        int i = 1;
        for (User user: userRegister.keySet()) {
            if (i == 10) break;
            System.out.println(user.getUserName() + ": " + user.getDecksContributed());
            i++;
        }
    }

}

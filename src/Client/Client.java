package Client;

import Server.ReadThreadServer;
import Util.NetworkUtil;

import java.net.Socket;
import java.util.Scanner;


public class Client {

    //Socket socket = null;

    public Client(String serverAddress, int serverPort) {
        try {

            NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);
            //networkUtil.write(clientName);
           // new ReadThreadServer(networkUtil);
          //  new WriteThreadClient(networkUtil, clientName);
        } catch (Exception e) {
            //System.out.println("Client failed to connect");
        }
    }
}



/*public class Client {


    public Client(int port, String ip){
        try {
            this.socket = new Socket(ip, port);
            this.input = new ObjectInputStream(socket.getInputStream());
            this.output = new ObjectOutputStream(socket.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Client Failed to connect");
        }
    }*/



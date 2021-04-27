package Server;

import Util.NetworkUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Server{

    public static CarList carList=new CarList();
    private static final String INPUT_FILE_NAME = "in.txt";
  //private static final String OUTPUT_FILE_NAME = "in.txt";
    public static Map<String,String> userAndPass=new HashMap<>();
   // public static List<Car> carList = File.readFile();

    private ServerSocket serverSocket;
  public HashMap<String, String> userMap;

    Server() {
        /*userMap = new HashMap<>();
        userMap.put("a", "a");
        userMap.put("b", "b");
        userMap.put("c", "c");
        userMap.put("d", "d");
        userMap.put("e", "e");*/
        try {
            serverSocket = new ServerSocket(33334);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);

        loadCars();

        new ReadThreadServer( this,networkUtil);
        //loaddata();
    }


    public static void main(String[] args) {
        Server server= new Server();
    }


    public static void loadCars()
    {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while (true) {
                line = br.readLine();
                System.out.println(line);
                if (line == null) break;
                String [] cartoken= line.split(",");
                Car car= new Car(cartoken[0], Integer.parseInt(cartoken[1]),cartoken[2],cartoken[3],cartoken[4],cartoken[5],cartoken[6],Integer.parseInt(cartoken[7]),Integer.parseInt(cartoken[8]));
                carList.add(car);
                System.out.println(car);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try{
            String line;
            BufferedReader br=new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while(true){
                line=br.readLine();
                if(line!=null){
                    String[] lines=line.split(",");
                    String resigtration_Number=lines[0];
                    String yearMade=lines[1];
                    String color1=lines[2];
                    if(color1==null){
                        color1=",";
                    }
                    String color2=lines[3];
                    if(color2==null){
                        color2=",";
                    }
                    String color3=lines[4];
                    if(color3==null){
                        color3=",";
                    }
                    String carmake=lines[5];
                    String carmodel=lines[6];
                    String price=lines[7];
                    String quantity=lines[8];
                    Car car1=new Car(resigtration_Number,Integer.parseInt(yearMade),
                            color1,color2,color3,carmake,carmodel,Integer.parseInt(price),Integer.parseInt(quantity));
                    //carList.addCar(car1);

                }
                else break;
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
    }
   /* public static void loaddata(){
        try{
            String line;
            BufferedReader br=new BufferedReader(new FileReader("name.txt"));

            while(true){
                line=br.readLine();
                if(line!=null){
                    String[] lines=line.split(" ");
                    userAndPass.put(lines[0],lines[1]);
                }
                else break;
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/
}

/*
   try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while (true) {
                line = br.readLine();
                if (line == null) break;
                String [] cartoken= line.split(",");
                Car car= new Car(cartoken[0], Integer.parseInt(cartoken[1]),cartoken[2],cartoken[3],cartoken[4],cartoken[5],cartoken[6],Integer.parseInt(cartoken[7]));
                carList.add(car);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
package Server;

import Util.NetworkUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private Server server;
    private Thread thr;
    private NetworkUtil networkUtil;
    private static List<Car> cars = Server.carList.getCarList();

    public ReadThreadServer(Server server, NetworkUtil networkUtil) {
        this.server = server;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();

    }

    public void run() {
        try {
            while (true) {

                Object o = networkUtil.read();

                if (o instanceof String) {

                    String info = (String) o;
                    //System.out.println(info);
                    if (info.equalsIgnoreCase("ViewCarsForViewers")) {
                        // System.out.println(cars);
                        networkUtil.write(cars);
                    }

                    if (info.equals("ADD")) {
                        //String[] infoOfCar = info[1].split(",");
                        /*Car c = new Car(infoOfCar[0], Integer.parseInt(infoOfCar[1]), infoOfCar[2], infoOfCar[3],
                                infoOfCar[4], infoOfCar[5], infoOfCar[6], Integer.parseInt(infoOfCar[7]), Integer.parseInt(infoOfCar[8]));*/
                        Car car = (Car) networkUtil.read();

                        if (car != null) {
                            synchronized (server) {
                                addCar(car);
                                writeCars();
                                networkUtil.write("ADDED_SUCCESSFULLY");
                           }
                        } else {
                            networkUtil.write("COULDN'T ADDED");
                        }

                    }

                    if (info.equalsIgnoreCase("EDIT")) {

                        // System.out.println("Edit kortasi");


                        while (true) {

                            Car car = (Car) networkUtil.read();
                            if (car != null) {
                               synchronized (server) {
                                    //  System.out.println(car.getReg());
                                    // System.out.println("Synchronize er vitor car");
                                    editCar(car);
                                    writeCars();
                                    break;
                              }


                            }
                        }

                    }


                    if (info.equalsIgnoreCase("DELETE")) {

                        System.out.println("Delete kortasi");


                        while (true) {
                          /*Car c = new Car(carinfo[1], Integer.parseInt(carinfo[2]), carinfo[3], carinfo[4],
                                  carinfo[5], carinfo[6], carinfo[7], Integer.parseInt(carinfo[8]), Integer.parseInt(carinfo[9]));*/
                            Car car = (Car) networkUtil.read();
                            if (car != null) {
                                synchronized (server) {
                                    // System.out.println(car.getReg());
                                    //System.out.println("Synchronize er vitor car");
                                    deleteCar(car);
                                    writeCars();
                                    break;
                                }


                            }
                        }


                    }
                    if (info.equalsIgnoreCase("BUY")) {
                        while (true) {
                            Car car = (Car) networkUtil.read();
                            if (car != null) {
                                synchronized (server) {

                                   /*if(car.getQuantity()==0) {
                                      deleteCar(car);
                                   }*/
                                    buyCar(car);
                                    writeCars();
                                    break;
                                }


                            }

                        }
                    }


                   /* if (info.equalsIgnoreCase("REFRESH")) {
                        synchronized (server) {
                            networkUtil.write(cars);
                            writeCars();
                            System.out.println("Refresh e tip disi");
                            networkUtil.getOos().reset();

                        }
                    }*/


                    if (info.equalsIgnoreCase("SEARCHBYREG")) {


                            String reg = (String) networkUtil.read();

                            if (reg != null) {
                              synchronized (server) {
                                    //System.out.println(car.getReg());
                                    //System.out.println("Synchronize er vitor car");
                                    //editCar(car);
                                    //searchCarbyreg(reg);
                                    Car carob = searchCarbyreg(reg);

                                    if(carob!=null)
                                    {
                                       // networkUtil.write("CarNotFound");
                                        networkUtil.write(carob);
                                        System.out.println("car null na");
                                    }
                                   /* System.out.println(carob);
                                    networkUtil.getOos().reset();
                                     networkUtil.write(carob);*/
                                    else {
                                        networkUtil.write("CarNotFound");
                                        System.out.println("car null");

                                    }
                                    // else
                                      //  networkUtil.write("There is no such car!");


                               }


                            }
                           // writeCars();



                    }


                    if (info.equalsIgnoreCase("SEARCHBYMAKEMODEL")) {


                        String CarMAKE = (String) networkUtil.read();
                        String CarMODEL= (String) networkUtil.read();

                        if ((CarMAKE != null)&&(CarMODEL !=null)) {
                           synchronized (server) {
                                //System.out.println(car.getReg());
                                //System.out.println("Synchronize er vitor car");
                                //editCar(car);
                                //searchCarbyreg(reg);
                                Car carob = searchbymakemodel(CarMAKE, CarMODEL);

                                if(carob!=null)
                                {
                                    // networkUtil.write("CarNotFound");
                                    networkUtil.write(carob);
                                   // System.out.println("car null na");
                                }
                                   /* System.out.println(carob);
                                    networkUtil.getOos().reset();
                                     networkUtil.write(carob);*/
                                else {
                                    networkUtil.write("CarNotFound");
                                   // System.out.println("car null");

                                }
                                // else
                                //  networkUtil.write("There is no such car!");


                         }


                        }
                        // writeCars();



                    }



                }


            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Car addCar(Car car) {
        for (Car c : cars) {
            if (c.getReg().compareToIgnoreCase(car.getReg()) == 0) {
                System.out.println("Car couldn't added, Cause it's already in the list");
                return null;
            }
        }
        cars.add(car);
        return car;

    }

    public static void deleteCar(Car car) {
        int index = -1;
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            if (c.getReg().compareToIgnoreCase(car.getReg()) == 0) {
                index = cars.indexOf(c);
                System.out.println("Deleted Item is " + c);

            }
        }
        if (index != -1)
            cars.remove(index);
        else
            System.out.println("Check carefully! There is no car.");
        writeCars();
    }

    public static void editCar(Car c) {
        System.out.println("function editCar");
        // System.out.println(c);
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getReg().equals(c.getReg())) {
                System.out.println("In edit Car ");
                cars.set(i, c);
                return;
                //return c;
            }

        }
        // return c;

    }

    public static void buyCar(Car c) {
        System.out.println("function BuyCar");
        // System.out.println(c);
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getReg().equals(c.getReg())) {

                //System.out.println(cars.get(i).getQuantity());

                int q = cars.get(i).getQuantity();
                c.setQuantity(q - 1);
                editCar(c);
                if (q == 1) {
                    //networkUtil.write("ZERO CAR")
                    deleteCar(c);
                }




            }

               /*int pastq;
               int nowq;
                pastq= cars.get(i).getQuantity();
                nowq= pastq-1;
                 cars.get(i).setQuantity(nowq);
                if (cars.get(i).getQuantity() == 0) {
                    deleteCar(cars.get(i));
                }
            }
                cars.set(i,c);
                //return ;

            }
        return c;*/

        }

        return;

    }


    public static void writeCars() {
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("in.txt"));
            for (Car c : cars) {
                bw.write(String.valueOf(c));
                bw.write("\n");

            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Car searchCarbyreg(String reg) {
        int index = -1;
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            if (c.getReg().equalsIgnoreCase(reg)) {
                index = cars.indexOf(c);
                System.out.println(c);
                return c;
                //return c;
                //System.out.println("Deleted
                // Item is " + c);

            }
        }
        //System.out.println("Null  dare pathai");
               Car car = null;
                return car;


    }

    public static Car searchbymakemodel(String carmake, String carmodel) {
        int index = -1;
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            if( (c.getCarmake().equalsIgnoreCase(carmake))&& (c.getCarmodel().equalsIgnoreCase(carmodel))) {
                index = cars.indexOf(c);
                System.out.println(c);
                return c;
                //return c;
                //System.out.println("Deleted
                // Item is " + c);

            }
        }
        //System.out.println("Null  dare pathai");
        Car car = null;
        return car;


    }

}




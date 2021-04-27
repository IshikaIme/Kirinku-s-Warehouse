package Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarList implements Serializable {
    private List<Car> carList;

    public CarList() {
        carList = new ArrayList<Car>();
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public int getSize() {
        return carList.size();
    }

    public Car getCar(int index) {
        return carList.get(index);
    }

    public void add(Car car) {
      for(Car c:carList)
        {
            if(c.getReg().compareToIgnoreCase(car.getReg())==0)
            {
                System.out.println("Sorry, It has already in the list");
                return;
            }
        }


        carList.add(car);
    }

    public void edit(Car car)
    {
        for(Car c:carList)
        {
            if(c.getReg().compareToIgnoreCase(car.getReg())==0)

            {

                c.setCarmodel(car.getCarmodel());
                c.setCarmake(car.getCarmake());
                c.setColor1(car.getColor1());
                c.setColor2(car.getColor2());
                c.setColor3(car.getColor3());
                c.setQuantity(car.getQuantity());
                c.setPrice(car.getPrice());
                c.setYear(car.getYear());

                System.out.println("Sorry, It has already in the list");
                return;
            }
        }

    }
}


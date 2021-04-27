package Server;

import java.io.Serializable;

public class Car implements Serializable {
    private String Reg;
    private int Year;
    private String color1;
    private String color2;
    private String color3;
    private String carmake;
    private String carmodel;
    private int price;
    private int quantity;


    public Car(String Reg, int  Year, String color1, String color2, String color3, String carmake, String carmodel, int price ,int quantity)
    {
        this.Reg= Reg;
        this.Year= Year;
        this.color1= color1;
        this.color2=color2;
        this.color3=color3;
        this.carmake=carmake;
        this.carmodel=carmodel;
        this.price=price;
        this.quantity=quantity;

    }
    public void setReg(String reg)
    {
        Reg=reg;
    }
    public void setYear(int year) {
        Year = year;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public void setCarmake(String carmake) {
        this.carmake = carmake;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReg() {
        return Reg;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return Year;
    }

    public String getCarmake() {
        return carmake;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public String getColor3() {
        return color3;
    }

    public int getQuantity(){return quantity; };

    public Car makecar(String Reg, int Year, String color1, String color2, String color3 , String carmake, String carmodel, int price, int quantity)
    {
            return new Car(Reg,Year,color1,color2,color3,carmake,carmodel,price,quantity);
    }


    public String toString()
    {
        return Reg+","+Year+","+color1+","+color2+","+color3+","+carmake+","+carmodel+","+price + "," + quantity;
    }

    private static final long serialVersionUID= 1L;


}

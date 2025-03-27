package src.si.feri.um.mg.vao;

public class User {

    private String email;
    private String name;
    private double balance;
    private String carType;

    public User(String email, String name, double balance, String carType) {
        this.email = email;
        this.name = name;
        this.balance = balance;
        this.carType = carType;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}
    public String getCarType() {return carType;}
    public void setCarType(String carType) {this.carType = carType;}

    @Override
    public String toString() {
        return "User [email= " + email + ", name= " + name + ", balance= " + balance + ", carType= " + carType + " ]";
    }
}

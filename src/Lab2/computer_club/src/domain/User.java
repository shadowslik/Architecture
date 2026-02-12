package domain;

public class User {

    private Integer id;
    private String name;
    private double balance;

    public User(Integer id, String name, double balance){
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public void deducBalance(double amount){
        if(balance < amount){
            throw new IllegalArgumentException("Недостаточно средст на балансе");
        }

        balance -= amount;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

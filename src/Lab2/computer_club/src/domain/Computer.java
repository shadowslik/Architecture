package domain;

public class Computer {

    private Integer id;
    private String name;
    private double pricePerHour;
    private boolean available;

    public Computer(int id, String name, double pricePerHour,boolean available){
        this.id = id;
        this.name = name;
        this.available = available;
        this.pricePerHour = pricePerHour;
    }


    public void setBusy(){
        if(!available){
            throw new IllegalArgumentException("Компьютер уже занят");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        String status = available ? "Свободен" : "Занят";
        return String.format("Computer(id=%d, name=%s, %s, %.0f₽/час)",
                id, name, status, pricePerHour);
    }
}

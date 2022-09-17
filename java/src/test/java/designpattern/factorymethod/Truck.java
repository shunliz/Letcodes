package designpattern.factorymethod;

public class Truck implements Transport{
    @Override
    public String deliver() {
        return "Deliver by Truck.";
    }
}

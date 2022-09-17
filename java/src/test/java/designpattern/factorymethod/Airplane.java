package designpattern.factorymethod;

public class Airplane implements Transport{
    @Override
    public String deliver() {
        return "Deliver by Airplane.";
    }
}

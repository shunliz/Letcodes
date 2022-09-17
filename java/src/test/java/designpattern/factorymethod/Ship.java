package designpattern.factorymethod;

public class Ship implements Transport{
    @Override
    public String deliver() {
        return "Deliver by Ship";
    }
}

package designpattern.factorymethod;

public class AirLogistic extends Logistic{
    @Override
    public Transport createTransport() {
        return new Airplane();
    }
}

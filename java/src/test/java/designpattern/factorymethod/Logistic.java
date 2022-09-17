package designpattern.factorymethod;

public abstract class Logistic {
    public abstract  Transport createTransport();
    public void planDeliver() {
        Transport transport = createTransport();
        System.out.println(transport.deliver());
    }
}

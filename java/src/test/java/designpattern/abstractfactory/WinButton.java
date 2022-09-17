package designpattern.abstractfactory;

public class WinButton implements Button{
    @Override
    public String draw() {
        System.out.println("Win button");
        return "Win button";
    }
}

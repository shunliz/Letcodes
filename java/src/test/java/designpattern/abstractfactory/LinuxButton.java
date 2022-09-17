package designpattern.abstractfactory;

public class LinuxButton implements Button{
    @Override
    public String draw() {
        System.out.println("Linux Button");
        return "Linux Button";
    }
}

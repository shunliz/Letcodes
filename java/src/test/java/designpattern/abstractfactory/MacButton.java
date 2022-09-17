package designpattern.abstractfactory;

public class MacButton implements Button{
    @Override
    public String draw() {
        System.out.println("Mac Button");
        return "Mac Button";
    }
}

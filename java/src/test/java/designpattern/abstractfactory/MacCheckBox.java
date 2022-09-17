package designpattern.abstractfactory;

public class MacCheckBox implements CheckBox{
    @Override
    public String draw() {
        System.out.println("Mac Checkbox");
        return "Mac CheckBox";
    }
}

package designpattern.abstractfactory;

public class LinuxCheckBox implements CheckBox {
    @Override
    public String draw() {
        System.out.println("Linux Checkbox");
        return "Linux Checkbox";
    }
}

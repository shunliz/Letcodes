package designpattern.abstractfactory;

public class WinCheckBox implements CheckBox{
    @Override
    public String draw() {
        System.out.println("Win Checkbox");
        return "Win Checkbox";
    }
}

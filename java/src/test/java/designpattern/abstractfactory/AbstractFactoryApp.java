package designpattern.abstractfactory;

public class AbstractFactoryApp {
    GUIFactory factory = null;
    public static void main(String[] args) {
        GUIFactory factory = new WinFactory();
        createUI(factory);

        /**
         * Let's say i want to add the Linux UI.
         * I need to add LinuxGUIFactory, LinuxButton,LinuxCheckBox.
         * No breaking existing code, open to change.
         */

        GUIFactory factory2 = new LinuxFactory();
        createUI(factory2);
    }

    private static void createUI(GUIFactory factory) {
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();
        button.draw();
        checkBox.draw();
    }
}

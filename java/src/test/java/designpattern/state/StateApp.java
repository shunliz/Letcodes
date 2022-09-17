package designpattern.state;


public class StateApp {
    public static void main(String[] args) {
        Player player = new Player();
        GUI ui = new GUI(player);
        ui.init();
    }
}

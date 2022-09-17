package designpattern.factorymethod;

public class FactoryMethodApp {
    public static void main(String[] args) {
        Logistic searlogistic = new SeaLogistic();
        searlogistic.planDeliver();

        /**
         * when you want to add air logistic, no need to change the previous code. just add new Transport
         * type Airplane and new logistic type AirLogistic.
         *
         * Follow the Open/Closed Principle, add new code without breaking the existing code
         * Single Responsibility Principle. move creation code to the factory method.
         * */
        Logistic airlogistic = new AirLogistic();
        airlogistic.planDeliver();
    }
}

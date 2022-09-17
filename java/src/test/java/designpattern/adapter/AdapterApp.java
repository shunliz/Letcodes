package designpattern.adapter;

public class AdapterApp {
    public static void main(String[] args) {
        // 已经实现了子类
        Power5VAdapter power5VAdapter = new Power5VAdapter(new AC220());
        power5VAdapter.output5V();

        // 直接实现子类
        PowerAdapter powerAdapter = new PowerAdapter(new AC220()) {
            @Override
            public int output5V() {
                int output = 0;
                if (mAC220 != null) {
                    output = mAC220.output220V() / 44;
                }
                return output;
            }
        };
        powerAdapter.output5V();
    }
}

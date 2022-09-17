package designpattern.adapter;

public abstract class PowerAdapter implements DCOutput{
    protected AC220 mAC220;

    public PowerAdapter(AC220 ac220){
        this.mAC220 = ac220;
    }

    @Override
    public int output5V() {
        return mAC220.output220V();
    }

    @Override
    public int output9V() {
        return mAC220.output220V();
    }

    @Override
    public int output12V() {
        return mAC220.output220V();
    }

    @Override
    public int output24V() {
        return mAC220.output220V();
    }
}


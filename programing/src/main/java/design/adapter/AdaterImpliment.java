package design.adapter;

public class AdaterImpliment implements Adapter {


    @Override
    public Float twiceOf(Float f) {

        return java.lang.Math.doubled(f.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float f) {
        return (float) java.lang.Math.half(f.doubleValue());
    }
}

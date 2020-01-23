package javainterview.chapter7;

import java.util.ArrayList;
import java.util.List;

public interface GenericOperation<A, B> {

    B perfromOperation(A value);
}

class StringLengthOperation implements GenericOperation<String, Integer>{

    @Override
    public Integer perfromOperation(String value) {
        return value.length();
    }

    public static <A, B> List<B> mapList(List<A> values, GenericOperation<A,B> op){
        List<B> ret = new ArrayList<>();

        for (A value : values) {
            ret.add(op.perfromOperation(value));
        }

        return ret;
    }
}

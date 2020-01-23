package javainterview.chapter7;

import java.util.ArrayList;
import java.util.List;

public class ListAdd {

    public static List<Integer> addOne(List<Integer> numbers) {
        List<Integer> ret = new ArrayList<>();

        for (Integer integer : ret) {
            ret.add(integer + 1);
        }

        return ret;
    }

    public interface IntergerOperation {
        Integer perfromOperation(Integer value);
    }

    public static List<Integer> updateList(List<Integer> numbers, IntergerOperation op) {
        List<Integer> ret = new ArrayList<>();

        for (Integer integer : numbers) {
            ret.add(op.perfromOperation(integer));
        }

        return ret;
    }


    static class AddOneOper implements IntergerOperation {

        @Override
        public Integer perfromOperation(Integer value) {
            return value + 1;
        }
    }
}

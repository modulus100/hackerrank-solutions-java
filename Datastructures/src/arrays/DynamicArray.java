package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class DynamicArray {

    public static void main(String[] args) {
        dynamicArray(2, Arrays.asList(
                Arrays.asList(1, 0, 5),
                Arrays.asList(1, 1, 7),
                Arrays.asList(1, 0, 3),
                Arrays.asList(2, 1, 0),
                Arrays.asList(2, 1, 1)));
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        AtomicInteger lastAnswer = new AtomicInteger(0);
        List<Integer> out = new ArrayList<>();
        HashMap<Integer, ArrayList> seqList = new HashMap<>();
        Function<Integer, Integer> getIndex = x -> ((x ^ lastAnswer.get()) % n);

        queries.forEach((query) -> {
            int index = getIndex.apply(query.get(1));

            if (query.get(0) == 1) {
                if (seqList.containsKey(index)) {
                    seqList.get(index).add(query.get(2));
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(query.get(2));
                    seqList.put(index, list);
                }
            } else {
                int sequenceIndex = query.get(2) % seqList.get(index).size();
                lastAnswer.set((int)(seqList.get(index).get(sequenceIndex)));
                out.add(lastAnswer.get());

                System.out.println(lastAnswer.get());
            }
        });

        return out;
    }
}

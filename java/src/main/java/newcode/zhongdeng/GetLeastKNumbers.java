package newcode.zhongdeng;

import java.util.*;

public class GetLeastKNumbers {
    public Integer[] GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue()-o1.intValue();
            }
        });
        for(int i: input){
            q.add(i);
            if(q.size() > k){
                q.poll();
            }

        }
        return q.toArray(new Integer[q.size()]);
    }
}

package letcode.zhongdeng;

import newcode.zhongdeng.TreeTraverse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermuteSolutionTest {

    private static PermuteSolution test;

    @BeforeAll
    public static void init(){
        test = new PermuteSolution();
    }

    @Test
    void permute() {
        int[] arr = {1,2,3};
        List<List<Integer>> res= test.permute(arr);
        List<List<Integer>> exp = new ArrayList<>();
        for(List<Integer> list: res){
            for(Integer i: list){
                System.out.print(i+",");
            }
            System.out.println("");
        }
        assertEquals(6, res.size());
    }

    @Test
    void permute2() {
        int[] arr = {1,2,3};
        List<List<Integer>> res= permute2(arr);
        List<List<Integer>> exp = new ArrayList<>();
        for(List<Integer> list: res){
            for(Integer i: list){
                System.out.print(i+",");
            }
            System.out.println("");
        }
        assertEquals(6, res.size());
    }


    public List<List<Integer>> permute2(int[] arrs){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<>();
        backtrace(res, tempList, arrs);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> tempList, int[] arrs) {
        if(tempList.size() == arrs.length){
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=0;i<arrs.length;i++){
            if(tempList.contains(arrs[i])){
                continue;
            }

            tempList.add(arrs[i]);
            backtrace(res, tempList,arrs);
            tempList.remove(tempList.size()-1);
        }
    }
}
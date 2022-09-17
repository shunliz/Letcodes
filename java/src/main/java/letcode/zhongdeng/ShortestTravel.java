package letcode.zhongdeng;

import java.util.*;

public class ShortestTravel {
    public int solution(int[] a) {
        // Write your answer here
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            Set<Integer> temp = new HashSet<>();
            int len = 0;
            for(int j=i;j<a.length;j++){
                temp.add(a[j]);
                if(temp.equals(set)){
                    len = j-i+1;
                    if(len <min){
                        min = len;
                    }
                }
            }
        }
        return min;
    }

    public int solution2(String[] n, String[] r) {
        // Write your answer here
        HashMap<String,Integer> groups = new HashMap<>();
        for(int j=0;j<n.length;j++){
            String groupname = null;
            int flag = 0;
            for(int i=0;i<n[j].length();i++){
                if(Character.isDigit(n[j].charAt(i))){
                    flag = 1;
                    if(i>=n[j].length()-1){
                        groupname = n[j].substring(0,i+1);
                        if(!groups.containsKey(groupname)){
                            groups.put(groupname,0);
                        }

                    }
                    continue;
                }
                if((Character.isLetter(n[j].charAt(i)) && flag ==1)){
                    groupname = n[j].substring(0,i);
                    if(!groups.containsKey(groupname)){
                        groups.put(groupname,0);
                    }
                }
            }
            if(!r[j].equalsIgnoreCase("passed")){
                groups.put(groupname, 1);
            }
        }

        int failcnt = 0;
        for(String s: groups.keySet()){
            if(groups.get(s)>0){
                failcnt++;
            }
        }

        int total = groups.size();
        return (total-failcnt)*100/total;
    }


    public int solution3(String[] a) {
        LinkedList<String> ls = new LinkedList<>();
        for(String s: a){
            ls.add(s);
        }

        for(int i=0;i<ls.size();i++){
            if(ls.get(i).equalsIgnoreCase("C")){
                ls.set(i-1, "0");
                ls.set(i, "0");
                continue;
            }

            if(ls.get(i).equalsIgnoreCase("D")){
                int j=0;
                while(ls.get(i-j-1).equals("0")){
                    j++;
                }
                Integer val = Integer.parseInt(ls.get(i-j-1));
                val = 2*val;
                ls.set(i, val+"");
                continue;
            }
            if(ls.get(i).equals("+")){
                int j=0;
                while(ls.get(i-j-1).equals("0")){
                    j++;
                }
                Integer val1 = Integer.parseInt(ls.get(i-j-1));
                j++;
                while(ls.get(i-j-1).equals("0")){
                    j++;
                }
                Integer val2 = Integer.parseInt(ls.get(i-j-1));
                ls.set(i,val1+val2+"");
                continue;
            }
        }

        Integer sum = 0;
        for(String s : ls){
            Integer val = Integer.parseInt(s);
            sum += val;
        }
        return sum.intValue();
    }
}


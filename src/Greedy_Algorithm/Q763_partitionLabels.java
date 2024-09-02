package Greedy_Algorithm;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: IIE
 * @name: Q763_partitionLabels
 * @Date: 2024/5/29
 */

public class Q763_partitionLabels {
    public static void main(String[] args) {
        Map map=new HashMap<>();
        map.put(10,0);


    }
    public List<Integer> partitionLabels(String s){
        List<Integer> result=new ArrayList<Integer>();
        Set<Character> list=new HashSet<>();
        int index=0;
        for(int i=0;i<s.length();i++){
            if(list.contains(s.charAt(i))){

            }
        }
        return result;
    }

}

package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q56_merge
 * @Date: 2024/3/31
 */
public class Q56_merge {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        merge(intervals);
    }
    public static int[][] merge(int[][] intervals){
        //对intervals[i][0]进行排序
        if(intervals.length==0){
                return new int[0][2];
        }
        //从小到大进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0]-interval2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] concurrent=new int[2];
        concurrent[0]=intervals[0][0];
        concurrent[1]=intervals[0][1];
        for (int i = 0; i <intervals.length-1; i++) {
            if(intervals[i+1][0]==concurrent[0]){
                concurrent[1]=Math.max(concurrent[1],intervals[i+1][1]);
            }else{
                if(intervals[i+1][0]>concurrent[1]){
                    result.add(new int[]{concurrent[0], concurrent[1]});
                    concurrent[0]=intervals[i+1][0];
                    concurrent[1]=intervals[i+1][1];
                }else{
                    concurrent[1]=Math.max(concurrent[1],intervals[i+1][1]);
                }
            }
        }
        result.add(new int[]{concurrent[0], concurrent[1]});
        return result.toArray(new int[result.size()][]);
    }
}

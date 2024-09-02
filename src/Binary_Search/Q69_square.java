package Binary_Search;

import java.util.stream.IntStream;

//重点
public class Q69_square {

    //计算某一非负整数的平方根，结果只保留整数
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(7));
    }

    public static boolean isPerfectSquare(int num) {
            int left=0;
            int right=num;
            int ans=-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                //ans是满足ans*ans<=num的最大整数,向右不断向做逼近元素
                //重点：①为什么要向右逼近：因为一开始数值很大，一旦开始向左逼近了，可能快找到了
                //     ②为什么是变化之前的左边界-1，记录小的那个数值
                if((long)mid*mid<=num){
                    ans=mid;
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            if((long)ans*ans==num){
                return true;
            }else{
                return false;
            }
        }


    }


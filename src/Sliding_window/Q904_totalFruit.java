package Sliding_window;

public class Q904_totalFruit {
    public static void main(String[] args) {
        int[] fruits={1,1,6,5,6,6,1,1,1,1};
        int a=totalFruit(fruits);
        System.out.println(a);
    }
    private static int totalFruit(int[] fruits){
        int result=1;
        int left=0; //左蓝子
        int fruit1=-1;
        int fruit1Index=0;
        int fruit2=-1;
        int fruit2Index=0;
        for(int right=0;right<fruits.length;right++){
            //先让空篮子装满
            if(fruit1==-1){
                fruit1=fruits[right];
                fruit1Index=right;
            }else if(fruit2==-1&&fruits[right]!=fruit1){
                fruit2=fruits[right];
                fruit2Index=right;
            }
            if(fruits[right]==fruit1){
                fruit1Index=right;
                result=Math.max(result,right-left+1);
            }else if(fruits[right]==fruit2){
                fruit2Index=right;
                result=Math.max(result,right-left+1);
            }else{
                //移动左蓝子
                result=Math.max(result,right-left);
                if(fruits[right-1]==fruit2){
                    left=fruit1Index+1;
                    //System.out.println(left);
                    //该句代码有误
                    fruit1=fruit2;
                    fruit1Index=fruit2Index;
                    fruit2=fruits[right];
                    fruit2Index=right;
                }else{
                    left=fruit2Index+1;
                    fruit2=fruits[right];
                    fruit2Index=right;
                }

            }
        }
        if(fruit2==-1){
            return fruits.length;
        }else{
            return result;
        }
    }}

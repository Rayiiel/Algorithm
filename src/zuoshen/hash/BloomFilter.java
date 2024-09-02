package zuoshen.hash;

/**
 * @Author: IIE
 * @name: BloomFilter
 * @Date: 2024/9/2
 */
public class BloomFilter {

}

class BitMap{
    int[] bitMap=new int[10]; //1 int 32bit  可以表示320个bit位

    public int getBit(int i){
        int numIndex=i/32;
        int bitIndex=i%32;
        return (bitMap[numIndex]>>bitIndex)&1;
    }

    public void Set0(int i){
        int numIndex=i/32;
        int bitIndex=i%32;
        bitMap[numIndex]=bitMap[numIndex]&(~(1<<bitIndex));
    }

    public void Set1(int i){
        int numIndex=i/32;
        int bitIndex=i%32;
        bitMap[numIndex]=bitMap[numIndex]|(1<<bitIndex);
    }
}

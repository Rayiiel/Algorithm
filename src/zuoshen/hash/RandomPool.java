package zuoshen.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: IIE
 * @name: RandomPool
 * @Date: 2024/9/2
 * 增、删、随机等概率返回
 */
public class RandomPool {
    private Map<Integer,String> index2Key;
    private Map<String,Integer> key2Index;
    private int size;
    public RandomPool(){
        index2Key=new HashMap<>();
        key2Index=new HashMap<>();
        size=0;
    }

    public boolean insert(String key){
        if(key2Index.containsKey(key)){
            return false;
        }else{
            index2Key.put(size,key);
            key2Index.put(key,size++);
            return true;
        }
    }

    public boolean delete(String key){
        if(!key2Index.containsKey(key)){
            return false;
        }else{
            int index=key2Index.get(key);
            String lastKey=index2Key.get(size-1);
            key2Index.put(lastKey,index);
            index2Key.put(index,lastKey);

            key2Index.remove(key);
            index2Key.remove(--size);

            return true;
        }
    }

    public String getRandom(){
        if(size==0){return null;}
        //随机产生
        return index2Key.get((int)(Math.random()*size));
    }
}


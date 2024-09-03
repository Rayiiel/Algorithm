package zuoshen.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: IIE
 * @name: UnionAndFind
 * @Date: 2024/9/3
 */
public class UnionAndFind<V>{
    Map<V,Element> valueMap;
    Map<Element,Element> fatherMap;
    Map<Element,Integer> sizeMap;
    private class Element{
        private V value;
        Element(V v){
            this.value=v;
        }
    }

    public UnionAndFind(List<V> vList){
        valueMap=new HashMap<>();
        fatherMap=new HashMap<>();
        sizeMap=new HashMap<>();
        for(V v:vList){
            Element ev=new Element(v);
            valueMap.put(v,ev);
            fatherMap.put(ev,ev);
            sizeMap.put(ev,1);
        }
    }

    public Element findFather(Element v){
        Stack<Element> st=new Stack<>();
        while(v!=fatherMap.get(v)){
            st.push(v);
            v=fatherMap.get(v);
        }
        //扁平化操作
        while(!st.isEmpty()){
            fatherMap.put(st.pop(),v);
        }
        return v;
    }

    public void union(V v1,V v2){
        if(isSameSet(v1,v2)){
            return;
        }
        Element fv1=findFather(valueMap.get(v1));
        Element fv2=findFather(valueMap.get(v2));
        if(fv1!=fv2) {
            Element big = sizeMap.get(fv1) >= sizeMap.get(fv2) ? fv1 : fv2;
            Element small = big == fv1 ? fv2 : fv1;
            fatherMap.put(small, big);
            sizeMap.put(big, sizeMap.get(fv1) + sizeMap.get(fv2));
            sizeMap.remove(small);
        }
    }
    public boolean isSameSet(V v1,V v2){
        return fatherMap.get(v1)==fatherMap.get(v2);
    }
}
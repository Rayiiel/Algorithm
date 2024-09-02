package hot100;

import org.w3c.dom.NodeList;

/**
 * @Author: IIE
 * @name: Q2_addTwoNumbers
 * @Date: 2024/4/8
 */
public class Q2_addTwoNumbers {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head=null,tail=null;
       int carry=0;
       while(l1!=null || l2!=null){
           int n1=l1==null?0:l1.val;
           int n2=l2==null?0:l2.val;

           if(head==null){
               head=tail=new ListNode((n1+n2+carry)%10);
           }else{
               tail.next=new ListNode((n1+n2+carry)%10);
               tail=tail.next;
           }
           carry=(n1+n2+carry)/10;
           if(l1!=null){
               l1=l1.next;
           }
           if(l2!=null){
               l2=l2.next;
           }
       }
       if(carry==1){
           tail.next=new ListNode(1);
       }
       return head;
    }
}

package hot100;

/**
 * @Author: IIE
 * @name: Q21_mergeTwoLists
 * @Date: 2024/4/2
 */
public class Q21_mergeTwoLists {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }

        ListNode prehead=new ListNode(-1);
        ListNode result=prehead;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                result.next=list1;
                list1=list1.next;
            }
            if(list1.val>list2.val){
                result.next=list2;
                list2=list2.next;
            }
            result=result.next;
        }
        result.next=list1==null?list2:list1;
        return prehead.next;
    }
}

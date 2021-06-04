package learnLine.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName man
 * @Description TODO
 * @Author noah
 * @Date 5/8/21 4:59 PM
 * @Version 1.0
 **/
public class demo {
    public static void main(String[] args) {
    }


      public class ListNode {
         int val;
         ListNode next;
        ListNode(int x) { val = x; }
  }
    public int[] reversePrint(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp.next != null){
            count ++ ;
            temp = temp.next;
        }
        int[] ints = new int[count];
        while(temp.next != null){
            ints[count--] = temp.val;
            temp = temp.next;
        }
        return ints;
    }


}

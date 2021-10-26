package arithmetic.list;

import apple.laf.JRSUIConstants;

public class MergeTwoList {

    public static void main(String[] args) {

        ListNode first = new ListNode();
        first.value = 1;
        getList(first, 1);

        ListNode two = new ListNode();
        getList(two, 2);

        ListNode listNode = mergeToList(first, two);

        System.out.println(1);
    }


    public static ListNode mergeToList(ListNode listNode1, ListNode listNode2) {
        if (null == listNode1) {
            return listNode2;
        }

        if (null == listNode2) {
            return listNode1;
        }

        if (listNode1.value < listNode2.value) {
            listNode1.next = mergeToList(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeToList(listNode1, listNode2.next);
            return listNode2;
        }
    }


    public static void getList(ListNode first, int part) {
        if (first.value > 6) {
            return;
        }
        first.next = new ListNode();
        first.next.value = first.value + part;
        getList(first.next, part);
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;


        Queue<ListNode> minHeap = new PriorityQueue<>(
            lists.length,
            (obj1, obj2) -> Integer.compare(obj1.val, obj2.val)
        );


        for (ListNode listHead : lists)
            if (listHead != null)
                minHeap.add(listHead);


        if (minHeap.isEmpty())
            return null;


        ListNode root = minHeap.poll();
        ListNode n = root;


        if (n.next != null)
            minHeap.add(n.next);


        while (!minHeap.isEmpty()) {
            ListNode nxtNode = minHeap.poll();


            if (nxtNode.next != null)
                minHeap.add(nxtNode.next);


            n.next = nxtNode;
            n = n.next;
        }


        return root;
    }
}
public class Class {
    public static boolean isSorted(Node subHead) {
        if (subHead == null || subHead.next == null) {
            return true;
        }
        Node cur = subHead;
        while (cur.next != null) {
            if (cur.value > cur.next.value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    public static void printList(Node head) {
        System.out.print("[");
        Node cur = head;
        while (cur != null) {
            if (cur.sub != null) {
                printList(cur.sub);
            } else {
                System.out.print(cur.value); 
            }
            if (cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
        System.out.print("]");
    }
    public static Node removeUnsorted (Node head) {
        Node prev = null; //предыдущий
        Node cur = head;
        while (cur != null) {
            if (cur.sub != null && !isSorted(cur.sub)) {
                if (prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                cur =  cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
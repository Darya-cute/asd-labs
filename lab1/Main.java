// Списки. Стеки. Очереди.
// Вариант 27
// Задача 27. Удалить из списка неупорядоченные подсписки

public class Main {
    public static void main (String[] arg) {
        //для подсписков
        Node s1 = new Node(1);
        s1.next = new Node(2);
        s1.next.next = new Node(3);

        Node s2 = new Node(5);
        s2.next = new Node(7);
        s2.next.next = new Node(3);

        Node s3 = new Node(7);
        s3.next = new Node(8);

        Node s4 = new Node(3);
        s4.next = new Node(1);
        s4.next.next = new Node(4);

        //внешний список
        Node head = new Node(s1);
        head.next = new Node(s2);
        head.next.next = new Node(s3);
        head.next.next.next = new Node(s4);

        System.out.print("Было: ");
        Class.printList(head);
        System.out.println();

        head = Class.removeUnsorted(head);

        System.out.print("Стало: ");
        Class.printList(head);
        System.out.println();
    } 
}
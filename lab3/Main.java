// Рекурсия. Бинарные деревья.
// Вариант 27
// Задача 27. Дано бинарное дерево. Каждая вершина имеет некоторое значение. В каждую вершину вставить сумму значений всех его предков.

public class Main {
    public static void main(String[] args) {
        // собираем дерево
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        //вывод до
        System.out.println("До:");
        printTree(root, 0);
        System.out.println();

        // применяем
        addAncestorsSum(root, 0);

        // вывод после
        System.out.println("После:");
        printTree(root, 0);
    }

    // печать дерева с отступами
    public static void printTree(Node node, int level) {
        if (node == null) return;
        // отступы
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.value);
        printTree(node.left, level + 1);
        printTree(node.right, level + 1);
    }

    // сумма предков
    public static void addAncestorsSum(Node node, int sumFromAncestors) {
        if (node == null) return;

        int newSum = sumFromAncestors + node.value;   // что передать детям
        node.value = newSum;                           // обновляем значение

        addAncestorsSum(node.left, newSum);
        addAncestorsSum(node.right, newSum);
    }
}


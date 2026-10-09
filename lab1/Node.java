public class Node {
    public int value;
    public Node sub;
    public Node next;
    public Node(int value){
        this.value = value;
    }
    public Node(Node sub){
        this.sub = sub;
    }
}
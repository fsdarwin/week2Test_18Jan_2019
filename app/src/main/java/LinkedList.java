
public class LinkedList {
    public static LinkedList List;

    public static void main(String[] args) {

        //constructor.
        List list = new List();
        String testString  ="ThisIsTestString";
        char[] testArray = testString.toCharArray();
        for (int i = 0; i < testArray.length; i++){
            list.add(testArray[i]);
        }
    }

}

class List {

    private static int counter;
    private Node head;

    //constructor
    public List() {

    }

    // appends the specified element to the end of this list.
    public void add(char data) {

        // Initialize Node only in case of first element
        if (head == null) {
            head = new Node(data);
        }

        Node Temp = new Node(data);
        Node current = head;

        if (current != null) {
            // find the end of the list and then add element after last node
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // the last node's "next" reference
            current.setNext(Temp);
        }

        incrementCounter();
    }

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    // inserts the specified element at the specified position in this list
    public void add(char data, int index) {
        Node temp = new Node(data);
        Node current = head;

        //
        if (current != null) {
            //findthe requested index or the last element in the list
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }

        //set the new node's next-node reference to this node's next-node reference
        temp.setNext(current.getNext());

        //next-node reference to the new node
        current.setNext(temp);

        incrementCounter();
    }

    public char get(int index)
    // returns the element at the specified position
    {
        if (index < 0)
            return 0;
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return 0;

                current = current.getNext();
            }
            return current.getData();
        }
        return current.getData();

    }

    public boolean remove(int index) {

        if (index < 1 || index > size())
            return false;

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;

                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());

            decrementCounter();
            return true;

        }
        return false;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }



    private class Node {
        //reference to the next node in the chain, or null if there isn't one.
        Node next;

        // data carried by this node.
        char data;

        // head Node constructor
        public Node(char dataValue) {
            next = null;
            data = dataValue;
        }

        // Node constructor for next Node.
        @SuppressWarnings("unused")
        public Node(char dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public char getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(char dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }

    }
}

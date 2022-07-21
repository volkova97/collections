public class CustomList {
    private Node head;
    private Node end;
    public void add(int element) {
        if (head == null) {
            head = new Node(element);
            return;
        }
        Node node = new Node(element);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public int get(int index) {
        int counter = 0;
        Node temp = head;
        while (counter != index && temp != null) {
            counter++;
            temp = temp.next;
        }
        try {
            if (temp == null) {
                throw new Exception("Нет элемента с таким индексом");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp.getValue();
    }

    public boolean remove(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        if (temp == null) {
            return false;
        } else if (index == 0) {
            head = temp.next;
            return true;
        } else if (temp.next.next == null) {
            temp.next = null;
            return true;
        }

        while (temp.next.next != null) {
            temp.next.setValue(temp.next.next.getValue());
            temp = temp.next;
        }
        temp.next = null;
        return true;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "List is empty";
        }
        Node temp = head;
        StringBuilder result = new StringBuilder(String.valueOf(head.getValue()));
        while (temp.next != null) {
            result.append(", ").append(temp.next.getValue());
            temp = temp.next;
        }
        return result.toString();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

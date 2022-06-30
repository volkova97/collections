public class CustomList {
    private Node head;
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
            if (temp.equals(null)) {
                throw new Exception("Нет элемента с таким индексом");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp.getValue();
    }

    public boolean remove(int index) {
        int counter = 0;
        Node temp = head;
        while (counter != index && temp != null) {
            counter++;
            temp = temp.next;
        }
        if (temp.equals(null)) {
            return false;
        } else if (temp.next.equals(null)) {
            temp = null;
            return true;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
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
            result.append(", " + temp.next.getValue());
            temp = temp.next;
        }
        return result.toString();
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

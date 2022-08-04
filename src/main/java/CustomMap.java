public class CustomMap<K, V> {

    private Node<K, V> head;

    public void put(K key, V value) {
        if (head == null) {
            head = new Node<>(key, value);
            return;
        }
        Node<K, V> node = new Node<>(key, value);
        Node<K, V> temp = head;

        if (head.getKey() == node.getKey()) {
            throw new RuntimeException("Field with the same key already exists");
        }

        while (temp.next != null) {
            if (temp.next.getKey() == node.getKey()) {
                throw new RuntimeException("Field with the same key already exists");
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public V get (K key) {
        if (head == null) {
            throw new RuntimeException("Map is empty");
        }
        Node<K, V> temp = head;
        while (temp != null) {
            if (temp.getKey() == key) {
                return temp.getValue();
            }
            temp = temp.next;
        }
        throw new RuntimeException("There is no value in the map with this key");
    }

    public void remove (K key) {
        if (head == null) {
            throw new RuntimeException("Map is empty");
        }
        if (head.next == null && head.getKey() == key) {
            head = null;
            return;
        } else if (head.next != null && head.getKey() == key) {
            head = head.next;
            return;
        }
        Node<K, V> temp = head;

        while (temp.next.next != null) {
            if (temp.next.getKey() == key) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

        if (temp.next.getKey() == key) {
            temp.next = null;
            return;
        }
        throw new RuntimeException("There is no value in the map with this key");
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}

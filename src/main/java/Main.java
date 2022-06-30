public class Main {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        list.add(2);
        list.add(4);
        list.add(8);
        System.out.println(list);
        list.remove(1);
    }
}
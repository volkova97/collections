import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        new ArrayList<>();
        list.add(2);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }
}
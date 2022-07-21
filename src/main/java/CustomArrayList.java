public class CustomArrayList {
    private int[] array;
    private int lastIndex;
    public CustomArrayList(int size) {
        this.array = new int[size];
    }

    public void add(int element) {
        if (lastIndex == array.length) {
            int[] temp = new int[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[lastIndex] = element;
        lastIndex++;
    }

    public int get(int index) {
        return array[index];
    }

    public boolean remove(int index) {
        if (array.length == 0) {
            System.out.println("Array is empty");
            return false;
        } else if (array.length == 1) {
            int[] temp = new int[(int) (0)];
            array = temp;
            return true;
        }
        int[] temp = new int[(int) (array.length - 1)];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        for (int i = index; i < array.length - 1; i++) {
            temp[i] = array[i + 1];
        }
        array = temp;
        return true;
    }

    @Override
    public String toString() {
        if (array.length == 0) {
            return "Array is empty";
        }
        StringBuilder result = new StringBuilder();
        result.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            result.append(", " + array[i]);
        }
        return result.toString();
    }
}

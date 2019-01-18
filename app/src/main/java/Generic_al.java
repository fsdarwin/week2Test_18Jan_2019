import java.util.Arrays;

public class Generic_al<E> {
    private Object object[];
    private E e;
    int index = 0;

    public Generic_al() {
        object = new Object[6];
    }

    public void addE(E e) {
        this.e = e;

        if (index == object.length - 1) {
            object = Arrays.copyOf(object, object.length + object.length);
            System.out.println("Size of array doubled.");
        }
        object[index] = this.e;
        index++;
    }

    public int length() {
        return object.length;
    }

    public String printArray() {
        String temp = "";
        for (Object obj : object) {
            if (obj != null) {
                temp += temp + ", ";
            }
        }
        return temp;
    }

    public Object getAtIndex(int index) {
        if (object[index] != null) {
            return object[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("No object at index " + index);
        }
    }

    public static void main(String[] args) {
        Generic_al<Integer> intAl = new Generic_al<Integer>();
        Generic_al<String> strAl = new Generic_al<String>();

        intAl.addE(5);
        intAl.addE(7);
        intAl.addE(3);
        intAl.addE(1);
        intAl.addE(0);
        intAl.addE(4);
        intAl.addE(9);

        strAl.addE("Mike");
        strAl.addE("Joel");
        strAl.addE("Josh");
        strAl.addE("Albert");
        strAl.addE("Rickey");
        strAl.addE("Brandon");
        strAl.addE("Nafis");
        strAl.addE("Frank");
        strAl.addE("The other Mike");

        for (int i = 0; i < intAl.length() - 1; i++) {
            System.out.println(intAl.getAtIndex(i));
        }
        System.out.println();
        for (int i = 0; i < strAl.length() - 1; i++) {
            System.out.println(strAl.getAtIndex(i));
        }
    }

}

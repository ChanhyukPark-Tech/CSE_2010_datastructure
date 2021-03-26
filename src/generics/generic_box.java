package generics;

class IntBox{
    int value;

    public IntBox(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}

class StringBox{
    String value;

    public StringBox(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}

class Box<T> {
    T value ;

    public Box(T value){
        this.value = value;
    }


    public T getValue() {
        return value;
    }
}


public class generic_box {

    public static void main(String[] args) {
        IntBox box = new IntBox(1234);

        int value = box.getValue();
        System.out.println(value);

        StringBox box_str = new StringBox("Hello");

        String value_str = box_str.getValue();
        System.out.println(value_str);

        Box<Integer> box_generic = new Box(1234);
        Integer value_generic = box_generic.getValue();
        System.out.println(value_generic);


    }
}

package maps;


import java.util.Objects;

class Key{
    public int value;

    public Key(int value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return value == key.value;
    }

    @Override
    public int hashCode() {
        int low = value & 0xffff;
        int high = value >>> 16 & 0x0ffff;
//        System.out.println("low : " + low);
//        System.out.println("high : " + high);
//        System.out.println(0x0ffff);
        return (low + high) & 0x0ffff;
     }
}

public class hashdemo{
    public static void main(String[] args) {
        Key foo = new Key(1234);

        System.out.println(foo);

        System.out.println(
                Integer.toHexString(foo.hashCode())
        );
        System.out.println(foo.hashCode()       );
    }
}
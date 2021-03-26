package intro_01;


import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class WrapperANDEquality {
    public static final double Threshold = 0.0001;

    public static void main(String[] args) {
//        Person p1 = new Person("terry",33);
//        Person p2 = new Person("terry",33);
//        System.out.println(p1.equals(p2));

//        Integer i1 = Integer.valueOf(160);
//        Integer i2 = Integer.valueOf(160);
//
//        System.out.println(i1==i2);


//        String s1 = new String("hello");
//        String s2 = new String("hello");
//        System.out.println(s1.equals(s2));
//
//        String s3 = "hello";
//        String s4 = "hello";
//        System.out.println(s3 == s4);

//        System.out.println(34.22==34.22f);


        double x = 1.0 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        double y = 1.0 + 0.1 * 5;

        if (Math.abs(x - y) < Threshold) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
                                         // Never use ' == ' operator for floating-point comparison!!
        
    }
}

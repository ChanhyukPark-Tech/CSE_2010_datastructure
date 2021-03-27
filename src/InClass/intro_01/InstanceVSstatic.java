package InClass.intro_01;


class Car{
    private static int count ; // 이 공장에서 뽑은 차 대 수
    protected int odometer;
    protected String make;

    public Car(String make){
        this.make = make;
        ++count;
    }

    public int getOdometer(){
        return odometer;
    }

    public String getMake() {
        return make;
    }

    public void drive(int distance){
        odometer += distance;
    }

    public static int getCount(){
        return count;
    }

    @Override
    public String toString() {
        return "Car{" +
                "odometer=" + odometer +
                ", make='" + make + '\'' +
                '}';
    }
}
public class InstanceVSstatic {
    public static void main(String[] args) {

        Car ford = new Car("Ford");
        System.out.println(ford);

        ford.drive(1000);

        System.out.println(ford);
        System.out.println("count = " + ford.getMake());
        System.out.println("count = " + ford.getOdometer());

        System.out.println("count = " + Car.getCount());
        System.out.println("count = " + ford.getCount());

        Car ferrari = new Car("Ferrari");
        System.out.println(ferrari);

        ferrari.drive(3000);

        System.out.println(ferrari);
        System.out.println("count = " + ferrari.getMake());
        System.out.println("count = " + ferrari.getOdometer());

        System.out.println("count = " + Car.getCount());
        System.out.println("count = " + ferrari.getCount());
    }
}

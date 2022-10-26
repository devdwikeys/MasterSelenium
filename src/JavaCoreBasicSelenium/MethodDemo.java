package JavaCoreBasicSelenium;

public class MethodDemo {

    public static void main(String[] args) {

        //how to calling some method we should create an object from that class
        MethodDemo callMethod = new MethodDemo();
        callMethod.getData();

        // how to store the value return is storing in a new object
        String hai = callMethod.getReturn();
        System.out.println(hai);

        //how to calling method from other class
        MethodDemo2 number = new MethodDemo2();
        number.getUserReturn();
        System.out.println(number.getUserReturn());

        //how to calling static method
        String halo = getUserData();
        System.out.println(halo);

    }

    //for public status can use on global class, exlude outside from this class
    //void means the method didnt return any datatype
    public void getData(){
        System.out.println("hello qarenina");

    }

    //how to create method with return value
    public String getReturn(){
        return "hai qaren";
    }

    //how to create method static, using static we dont need create an object cause statis is mean calling a class too
    public static String getUserData(){
        return "halo qaren";
    }
}

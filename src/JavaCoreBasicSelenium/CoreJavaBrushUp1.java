package JavaCoreBasicSelenium;

public class CoreJavaBrushUp1 {

    public static void main(String[] args) {

        //lecture for Java variables and data type

        int number = 5;
        String website = "Rahul shetty academy";
        char letter = 'r';
        double dec = 5.99;
        boolean status = true;

        //how to print into console
        System.out.println("this datatype integer : " + number);
        System.out.println("this datatype String : " + website);
        System.out.println("this datatype char : " + letter);
        System.out.println("this datatype double/Float : " + dec);
        System.out.println("this datatype boolean : " + status);

        //Arrays--
        int [] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        //how to straight iniate value of array
        int [] arr2 = {6,7,8,9,10};
        System.out.println("this value from indef of array : " + arr2[2]);

        //for loop -- arr.length = 5
        for (int i = 0; i <arr.length; i++){
            System.out.println("this value will print looping from array : " + arr[i]);
        }

        // how to printing from the reverse loop
        String [] food = {"pizza", "burger", "hotdog"};
        for (int j = food.length - 1 ; j >= 0 ; j--){
            System.out.println("this will print food with decrement array : " + food[j]);
        }

        //enhanced for loop
        String [] name = {"qaren", "dwiki"};
        for (String s : name){
            System.out.println("this will print enhanced for loop syntax : " + s);
        }

    }
}

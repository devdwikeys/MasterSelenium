package JavaCoreBasicSelenium;

import java.util.ArrayList;

public class CoreJavaBrushUp2 {

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6,7,8,9,10,124};

        //we are trying create output that only element of array can be modulus 2
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                System.out.println("this printing index can be divided by 2 : " + arr[i]);
            }
            else {
                System.out.println(arr[i] + " is invalid divided by 2");
            }
        }

        //just checking if array has multiple of 2
        for (int j = 0; j < arr.length; j++){
            if (arr[j] % 2 == 0){
                System.out.println("this check for only has multiple 2 : " + arr[j]);
                break;
            }
            else {
                System.out.println(arr [j] + " is invalid checking multiple 2");
            }
        }

        /*
        why we should using arrayList?
        cause if we facing some dynamic memory for store element of array we should arrayList to store it
        array can be store value with static method, its mean we should declare first length of array
         */

        ArrayList<String> name = new ArrayList<String>();
        name.add("dwiki");
        name.add("qaren");
        name.add("jocam");
        name.add("jipong");
        name.add("rifki");
        name.remove("jipong");
        name.remove(3);
        System.out.println("this will print index 1 from arrayList : " + name.get(1));
    }
}

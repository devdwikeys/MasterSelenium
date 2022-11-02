package JavaChallenge;

import java.util.Scanner;

public class Fizzbuzz {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input range number here : ");
        int masukan = input.nextInt();
        System.out.println("Fizzbuzz number are : ");

        for (int i = 1; i <= masukan; i++){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println("Fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");

            } else if (i % 5 == 0) {
                System.out.println("Buzz");

            }else {
                System.out.println(i);
            }
        }
        /*
         for (int i = 1; i <= n; i++){
            String output = "";

            if (i % 3 == 0) {
                output = "fizz";

            }if (i % 5 == 0 ) {
                output = output + "buzz";

            } if (output == ""){
                output = String.valueOf(i);
            }
            System.out.println(output);

        }
         */
        input.close();

    }
}

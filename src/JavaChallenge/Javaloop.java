package JavaChallenge;

import java.util.Scanner;

public class Javaloop {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input ur number here : ");
        int n = input.nextInt();


        for (int i = 1; i <=10; i++){
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }
}

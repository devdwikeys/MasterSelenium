package JavaChallenge;

import java.util.Scanner;

public class Oddeven {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input range number here : ");
        int masukan = input.nextInt();
        System.out.println("Output : ");

        for (int i = 1; i<= masukan; i++){
            for (int j = 1; j<= i; j++){
                if (i % 2 == 0) {
                    System.out.print("$ ");
                }else {
                    System.out.print("@ ");
                }
            }
            System.out.println();
        }
    }
}

package JavaChallenge;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input ur words to check palindrome here : ");
        String original, reverse = "";
        original = input.nextLine();
        original = original.replace(" ", "");
        int length = original.length();

        for (int i = length - 1; i >= 0; i--){
            reverse += original.charAt(i);
            System.out.println(reverse);
        }
        boolean palindrome = true;
        for (int i = 0; i< original.length(); i++){
            if (original.charAt(i) != reverse.charAt(i)){
                palindrome = false;
            }
        }
        if (palindrome){
            System.out.println("valid palindrome");
        }else {
            System.out.println("invalid palindrome");
        }
    }
}

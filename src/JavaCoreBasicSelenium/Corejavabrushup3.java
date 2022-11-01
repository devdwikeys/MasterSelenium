package JavaCoreBasicSelenium;

public class Corejavabrushup3 {

    public static void main(String[] args) {

        //how to declare string literal

        //String s1 = "This is dwiki anggoro";
        String s2 = "This is qarenina";

        //how to declare string in new a located memory
        String s3 = new String("Hello qarenina");
        String s4 = new String("Hello qarenina");

        //how we can split the String into array
        String s = "This dwiki anggoro";
        String[] splittedString = s.split("dwiki");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        //method trim for deleted all whitespace after/before the words
        System.out.println(splittedString[1].trim());

        //how to reverse looping and set an object into array
        for (int i = s3.length() - 1; i >= 0; i--){
            System.out.println(s3.charAt(i));
        }
    }
}

package bitoperator;

public class ConvertUpperTOLowerLowerToUpper {

    public static void main(String[] args) {
        //converting UPPERCASE to lowercase ascii of A = 65 and ' '(Space) = 32 and OR operation will increase it by 32 so it will be 97
        for (char i ='A';i<='Z';i++){
            int c = i | ' ';
            char r = (char)c;
            System.out.print(r);
        }
        System.out.println();
        //converting lowercase to Uppercase ascii for a = 97 and '_' = 95 so doing and operation decrease it by 32.
        for (char i ='a';i<='z';i++){
            int c = i & '_';
            char r = (char)c;
            System.out.print(r);
        }

        // Convert lowercase alphabet to uppercase
        System.out.println();
        for (char ch = 'a'; ch <= 'z'; ch++){
            int r = (ch ^ ' ');
            char re = (char)r;
            System.out.print(re); // prints ABCDEFGHIJKLMNOPQRSTUVWXYZ
        }

// Convert uppercase alphabet to lowercase
        System.out.println();
        for (char ch = 'A'; ch <= 'Z'; ch++){
            int r = (ch ^ ' ');
            char re = (char)r;
            System.out.print(re);
        }

        //find letter position in alphabet
        System.out.println();
        System.out.println('t' & 31);
    }
}

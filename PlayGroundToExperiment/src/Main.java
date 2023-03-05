public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(21312));
    }

    //METHOD BELOW DETERMINES IF A INPUT NUMBER IS A PALINDROME OR NOT
    public static boolean isPalindrome(int number) {

        //if the number is a negative, multiply by -1 to make it positive
        if (number < 0) {
            number *= -1;
        }
            //test var is a copy of the number parameter
        int test = number;
            //reverse is going to be the variable to hold the palindrome in question
        int reverse = 0;
            //puts the lastDigit of the number (test variable) to this variable
        int lastDigit;

            //in a loop while the number is not 0
        while (test != 0) {
            //lastDigit resets each iteration to get the last number of the cutDown number. ex-> 21312 -> 2131 -> 213 -> 21
            lastDigit = 0;

            //stores the last digit from the iteration so 21312 would store 2.. next iter -> 2131 would store 1
            lastDigit = test % 10;

            //reverse *= 10 and reverse += lastDigit go hand-in-hand.
            // reverse *10 expands the placeholder value. ex-> (2) turns to (20) first iteration we have 0.
                // if 21312 is our number then we get 2 as out last digit. And said 2, LD, is added to Reverse which beoomes
            // 20 bc reverse*10
            // next iteration last digit is reset to 0 and 2131 is our number now which 1 is our L.D.. which is added to reverse
            // so now it is 21.. and see the pattern? our initial number was 21312 and reverse working backwards is now 21.. :)
            reverse *= 10;
            reverse += lastDigit;

            test /= 10;
            //this cuts the number parameter by one digit short. 21312 -> 2131 -> until it is 0
        }
        return number == reverse;
        //return true if it is a palindrome or not !! :)
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(312));
        System.out.println(getEvenDigitSum(123456789));
    }

    public static int sumFirstAndLastDigit(int number) {
        //method to add the first and last digit of the input number

        if (number < 0) {
            return -1;
        }

        int lastDigit;
        //LastDigit will get the last digit of the parameter
        lastDigit = number % 10;

        int placeHolder;
        placeHolder = number;

        while (placeHolder > 9) {
            //we put greater than 9 to get the First number of the value by dividing 10 to reduce the place value.
            //so 312 -> 31 -> 3. and it stays at 3 since 3 is NOT greater than 9 and 3 is out first value.

            placeHolder /= 10;
        }//the final value of placeHolder will carryOn to the return statement below.
        return lastDigit + placeHolder;
    }

    public static int getEvenDigitSum(int number) {
        //method to add all even number from the int number var
        if (number < 0) { //if the input value is a negative, return -1
            return -1;
        }
        int evenNums = 0; //adding the even numbers
        int lastNum; //getting the last values from each iteration

        while (number != 0) {
            lastNum = number % 10; //getting the last value out of the number var
            if ((lastNum % 2) == 0) {//if even
                evenNums += lastNum;
            }
            number /= 10;
        }
        return evenNums;
    }

}

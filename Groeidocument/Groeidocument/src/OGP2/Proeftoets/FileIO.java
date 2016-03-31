package OGP2.Proeftoets;

import java.util.Scanner;

/**
 * Created by BloodOrk on 28/03/2016.
 * File I/O, Object I/O and Exception Handling
 */
public class FileIO {

    public FileIO () {

    }

    public static double division (double firstNumber, double secondNumber){

        if(secondNumber == 0){
            throw new ArithmeticException("Divisor cannot be zero");
        }

        return firstNumber / secondNumber;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter two integers: ");
        int firstNumber = input.nextInt();
        int secondNumber = input.nextInt();

        try{

            double result = division(firstNumber, secondNumber);
            System.out.println(firstNumber + " / " + secondNumber + " = " + result);

        }
        catch(ArithmeticException ex){

            System.out.println("Exception: an integer " + "cannot be divided by zero.");

        }

        System.out.println("Execution continues ...");

    }

}

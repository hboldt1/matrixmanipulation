/**
* Proj7.java
* Hudson Boldt / Lab Section 02B | Thu 4:30
* 

EDIT EACH CLASS DESCEIPTION
* This program utilised two classes to manipulate matrices. All of the methods are in the matrix
* class while everything else stays in Proj7.java. 
*
* The program takes input from a command line argument then has uses a switch case inside a while
* loop. Each case utilizes methods from Matrix.java
*
* EXTRA CREDIT INCLUDED
*/
import java.util.*;
import java.io.*;

public class Proj7{
    public static void main(String [] args) throws IOException {
        String fn = "";
         // fn = "matrix4.txt";

        
        if (args.length > 0) {
            fn = args[0];
        } else {
            System.out.print("Usage: java Proj7 \"filename.txt\"... exiting");
            System.exit(0);
        }
        

        File file = new File(fn);

        while (!file.exists()) {
            System.out.print("Error: File does not exist... exiting");
            System.exit(0);
        }
        

        Scanner fileReader = new Scanner(file);

        int rows1 = fileReader.nextInt();
        int cols1 = fileReader.nextInt();

        Matrix whatever = new Matrix();

        // System.out.println(whatever.BigMatrix());

        // debugging
        // int[][] bigmatrix1 = new int[rows1][cols1];
        
        //Matrix starter = new Matrix();     


        Matrix m1 = new Matrix(rows1, cols1);     
        for (int i = 0; i < rows1; i++) { 
            for (int j = 0; j < cols1; j++) {
                m1.setElem(i, j, fileReader.nextInt());
            }
        }
        //System.out.println(rows1 + cols1);



        // Skip the empty line between matrices
        fileReader.nextLine();

        int rows2 = fileReader.nextInt();
        int cols2 = fileReader.nextInt();
        //int[][] matrix2 = new int[rows2][cols2];

            
        Matrix m2 = new Matrix(rows2, cols2);
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                m2.setElem(i, j, fileReader.nextInt());
            }
        }
        fileReader.close();
        Scanner scnr = new Scanner(System.in);

        String userInput = "";
        int a = 0;

        if(m1.equals(m2)){
            System.out.println("Two Matrices are EQUAL");
        }
        else{
            System.out.println("Two Matrices are NOT EQUAL");

        }

        while (true) {
            System.out.print("Enter (d)isplay, (a)dd, (s)ubtract, (m)ultiply, (t)ranspose, or (q)uit: ");
            userInput = scnr.nextLine();
            userInput = userInput.toLowerCase();
            System.out.println();

            switch (userInput){
                case "d": //display
                    System.out.println("First Matrix: ");
                    System.out.println(m1.toString());

                    System.out.println("Second Matrix: ");
                    System.out.println(m2.toString());
                    break;

                case "a": //add
                    
                    Matrix addMatrix = m1.plus(m2);

                    System.out.println("Resulting Matrix: ");
                    System.out.println(addMatrix);
                    break;
                    
    
                case "s": //subtract

                    Matrix subMatrix = m1.minus(m2);

                    System.out.println("Resulting Matrix: ");
                    System.out.println(subMatrix);
                    
                    break;
    
                case "m": // multiply

                    Matrix prodMatrix = m1.times(m2);

                    if (prodMatrix != null){
                    System.out.println("Product of Matrices: ");
                    System.out.println(prodMatrix);
                    }
                    
                    break;
    
                case "t": // transpose (switch rows and columns)
                    
                    Matrix transMatrix1 = m1.transpose();
                    Matrix transMatrix2 = m2.transpose();
                    System.out.println("First Matrix:");
                    System.out.println(transMatrix1);
                    System.out.println("Second Matrix:");
                    System.out.println(transMatrix2);
                    break;
                case "q": // quit
                    System.out.println("Quitting...");
                    return;
                default: //invalid
                    System.out.println(userInput + " is not a valid option");
            }
            // kept having issues quitting and this worked
            if(a == 1){
                break;
            }
            
        }
        scnr.close();

    }
    
}
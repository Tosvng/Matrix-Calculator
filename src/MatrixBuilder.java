import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MatrixBuilder {
    private int token;
    private int rows;
    private int columns;
    private int[][] templateMatrix;

    public MatrixBuilder(String f){

        try{
            //File file = new File(f);
            FileReader reader = new FileReader(f);
            
            BufferedReader buff = new BufferedReader(reader);

            //read the first line
            String line = buff.readLine();

            //first line is always the size of the matrix
            Scanner scan = new Scanner(line);
            while(scan.hasNextInt()){
                //first integer is the number of rows
                token = scan.nextInt();
                rows = token;

                //second is the number of columns
                token = scan.nextInt();
                columns = token;
                
            }

            //create the 2d array with the matric dimensions
            templateMatrix = new int[rows][columns];


            //next line is the matrix values
            line = buff.readLine();
            int i = 0;
            int j =0;
            while(line != null){
                System.out.println(line);
                scan = new Scanner(line);
                while(scan.hasNextInt()){
                    token = scan.nextInt();
                    templateMatrix[i][j] = token;
                    j++;
                }

                //get the next line
                line = buff.readLine();
            }

            scan.close();
            reader.close();
            
        }
        catch(IOException e){
            System.out.println("Can't find file. Make sure you spelt it right.");
            
        }
        catch (InputMismatchException e){
            System.out.println("The information in your file is not correct.");

        }
        catch (NoSuchElementException e){
            System.out.println("Oops, you might have used the wrong file");   
        }
        catch (Exception e){
            System.out.println("Oops, somethings not right");  
        }
        


    }
}

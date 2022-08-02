public class Test {
    public static void main(String[] args){
        //create new matric
        int rows = 2;
        int col = 2;
        int[][] arr = new int[rows][col];
        int[][] arr2 = new int[rows][col];

        arr[0][0]= 1;
        arr[0][1]= 2;
        arr[1][0]= 3;
        arr[1][1]= 4;

        //arr2
        arr2[0][0]= 5;
        arr2[0][1]= 6;
        arr2[1][0]= 7;
        arr2[1][1]= 8;

        Matrix m = new Matrix(arr);
        Matrix m2 = new Matrix(arr2);


        //get the number of rows of the matric
        int numRows = m.getNumberOfRows();
        if(numRows == rows){
            System.out.println("NUMBER OF ROWS IS "+ rows);
        }
        else{
            System.out.println("NUMBER OF ROWS SHOULD BE "+ rows);
        }

        int numCol = m.getNumberOfCol();
        if(numCol == col){
            System.out.println("NUMBER OF Columns IS "+ col);
        }
        else{
            System.out.println("NUMBER OF Columns SHOULD BE "+ col);
        }
        //============================

        //get the values of a row 
        int[] rowValues = m.getRow(0);
        for(int i = 0; i < rowValues.length; i++){
            System.out.print(rowValues[i] + " ");
            
        }
        System.out.print("\n");
        //get the values of a row 
        int[] colValues = m.getColumn(0);
        for(int i = 0; i < colValues.length; i++){
            System.out.println(colValues[i] + " ");
        }
        System.out.print("\n");
        //========================================

        //=============ADDITION===================
        Add val = new Add(m, m2);
        Matrix res = val.add();
        m.printMatrix();
        System.out.print(" + \n");
        m2.printMatrix();
        System.out.print(" = \n");
        res.printMatrix();
    }

}

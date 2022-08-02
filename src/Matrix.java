public class Matrix {
    private int[][] matrix;

    //Marix constructor
    public Matrix(int[][] newMatrix){
        matrix = newMatrix;
        // for(int i =0 ; i< matrix.length ; i++){
        //     for (int j = 0 ; j< matrix[i].length; j++){
        //         System.out.print(this.matrix[i][j] + " ");
        //     }
        //     System.out.print("\n");
        // }
    }

    //getters

    //return -1 if the matrix is not valid
    public int getNumberOfRows(){
        int result = -1;
        if (matrix.length > 0)
        {
            result = matrix.length;
        }
        return result;
    }

    //return -1 if the matrix is not valid
    public int getNumberOfCol(){
        int result = -1;
        if (matrix[0].length > 0)
        {
            result = matrix[0].length;
        }
        return result;
    }

    //get the values of a particular row
    public int[] getRow(int row){
        int[] result = null;
        if (getNumberOfRows() > 0){
            result = matrix[row];
        }

        return result;
    }

    //get the values of a particular column
    //this function loops through the rows of a particular column and stores the value at each spot in the result array
    public int[] getColumn(int col){
        int[] result = null;
        if (getNumberOfCol() > 0){
            
            result = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++){
                result[i] = matrix[i][col];
            }
            
        }

        return result;
    }

    public void printMatrix(){
        for(int i =0 ; i< matrix.length ; i++){
            for (int j = 0 ; j< matrix[i].length; j++){
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
    



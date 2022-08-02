public class Add {
    private Matrix m1;
    private Matrix m2;

    public Add (Matrix newM1, Matrix newM2){
        m1 = newM1;
        m2 = newM2;
    }
    
    /*
     * To do matric addition, the dimension of the two matricies must be the same.
     */
    public Matrix add(){
        Matrix result = null;
        int[][] tempResult;
        //check the dimentions
        if((m1.getNumberOfRows() == m2.getNumberOfRows()) && (m1.getNumberOfCol() == m2.getNumberOfCol()))
        {
            //do the addition of the two matrices
            tempResult = doAddition();

            //create the result matrix
            result = new Matrix(tempResult);
        }
        return result;
    }

    /*
     * This function performs the maths addition of the matric. It adds each row of both matricies together
     * then saves it in the matrix template 
     */
    public int[][] doAddition(){

        int[][] result = new int[m1.getNumberOfRows()][m1.getNumberOfCol()]; // create the result array
        int[] firstMatrix;// used to hold the values of a row in the first matric given
        int[] secondMatrix;// used to hold the values of a row in the second matric given

        //get each row of both matricies, add them, and store the result
        for(int i = 0 ; i < m1.getNumberOfRows() ; i++){
            firstMatrix = m1.getRow(i);
            secondMatrix = m2.getRow(i);
            for(int j = 0; j < firstMatrix.length ; j++){
                result[i][j] = firstMatrix[j] + secondMatrix[j];
            }
        }
        return result;
    }
    
}

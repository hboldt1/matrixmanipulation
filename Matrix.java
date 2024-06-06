/**
* Matrix.java
* Hudson Boldt / Lab Section 02B | Thu 4:30
* 
* This program utilised two classes to manipulate matrices. All of the methods are in the matrix
* class while everything else stays in Proj7.java. The program takes input from a command line
* argument.
*
* This class creates methods used in the switch case in Proj7.java. This is done using private variables
* Stringbulders, for loops among other syntax's.
*
* EXTRA CREDIT INCLUDED
*/

public class Matrix {
    private int rows;
    private int columns;
    private int[][] values;

    /* 
    public String BigMatrix(){
        return "hello";
    }
    */

    /**
     * Initializes 1x1 Matrix
     */
    public Matrix() {
        this.rows = 1;
        this.columns = 1;
        this.values = new int[rows][columns];
    }

    /**
     * Creates matrix with set rows and columns.
     *
     * @param row    the number of rows in the matrix
     * @param column the number of columns in the matrix
     */
    public Matrix(int row, int column) {
        this.rows = row;
        this.columns = column;
        this.values = new int[rows][columns];
        
        //filling with 0's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                values[i][j] = 0;
            }
        }
    }

    /**
     * Sets the element at the specified row and column to the given value.
     *
     * @param row   the row index
     * @param col   the column index
     * @param value the value to set
     */
    public void setElem(int row, int col, int value) {
        values[row][col] = value;
    }

    /**
     * Adds this matrix to the given matrix.
     *
     * @param m the matrix to add to this matrix
     * @return the sum of the two matrices, or null if the matrices have different dimensions
     */
    public Matrix plus(Matrix m) {
        if (rows != m.rows || columns != m.columns) {
            System.out.println("Matrices must have the same dimensions for addition.");
            return null;        }
        
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[i][j] = values[i][j] + m.values[i][j];
            }
        }
        return result;
    }

    /**
     * Subtracts the given matrix from this matrix.
     *
     * @param m the matrix to subtract from this matrix
     * @return the difference of the two matrices, or null if the matrices have different dimensions
     */
    public Matrix minus(Matrix m) {
        if (rows != m.rows || columns != m.columns) {
            System.out.println("Matrices must have the same dimensions for subtraction.");
            return null;
        }

        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[i][j] = values[i][j] - m.values[i][j];
            }
        }
        return result;
    }

    /**
     * Multiplies this matrix by the given matrix.
     *
     * @param m the matrix to multiply with this matrix
     * @return the product of the two matrices, or null if the dimensions are incompatible for multiplication
     */
    public Matrix times(Matrix m) {
        if (columns != m.rows) {
            System.out.println("The number of columns in the first matrix must match the number of rows in the second matrix for multiplication.");
            return null;
        }

        Matrix result = new Matrix(rows, m.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                for (int k = 0; k < columns; k++) {
                    result.values[i][j] += values[i][k] * m.values[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Transposes this matrix by interchanging rows and columns.
     *
     * @return the transpose of this matrix
     */
    public Matrix transpose() {
        Matrix result = new Matrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[j][i] = values[i][j];
            }
        }
        return result;
    }

    /**
     * Returns a string representation of this matrix.
     *
     * @return a string representation of this matrix
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(values[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Checks if this matrix is equal to the given matrix.
     *
     * @param m the matrix to compare with this matrix
     * @return true if the matrices are equal, false otherwise
     */
    public boolean equals(Matrix m) {
        if (rows != m.rows || columns != m.columns) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (values[i][j] != m.values[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test your Matrix class here
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        //step1 check if first row has any zero
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        //step2 check if first col has any zero
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        //step3 use first row and col as marker storage
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //step4 set elements to zero based on marker
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //step5 update first row
        if(firstRowZero) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        //step6 update first column
        if(firstColZero) {
            if(firstColZero) {
                for(int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
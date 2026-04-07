class Solution {
    public String convert(String s, int numRows) {
        //edge case
        if(numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        int direction = 1;
        for(char c : s.toCharArray()) {
            rows[currRow].append(c);

            // Change direction
            if (currRow == 0) {
                direction = 1;
            } else if (currRow == numRows - 1) {
                direction = -1;
            }
            currRow += direction;
        }

        //combine all rows
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
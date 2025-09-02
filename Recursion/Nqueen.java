import java.util.*;

class Main {
    public static void main(String[] args) {
        int n=4;
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
       for (char[] row : board) {
        //   System.out.println(Arrays.toString(row));
        Arrays.fill(row,'.');
       }
       int[] leftRow = new int[n];
       int[] lowerDiagonal = new int[2*n-1];
       int[] upperDiagonal = new int[2*n-1];
       f(0,n,board,ans,leftRow,lowerDiagonal,upperDiagonal);
        for (List<String> solution : ans) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
    public static void f(int col, int n, char[][] board, List<List<String>> ans, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
        if(col==n){ List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row=0;row<n;row++){
            if (leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0) {

            board[row][col]='Q';
            leftRow[row]=1;
            lowerDiagonal[row+col]=1;
            upperDiagonal[n-1+col-row]=1;
            f(col+1,n,board,ans,leftRow,lowerDiagonal,upperDiagonal);
            board[row][col]='.';
            leftRow[row]=0;
            lowerDiagonal[row+col]=0;
            upperDiagonal[n-1+col-row]=0;
        }
    }
    }

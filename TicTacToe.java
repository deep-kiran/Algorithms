class TicTacToe {

    char[][]board;
    int N;
    public void printBoard(char[][] board){
        System.out.println();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board =new char[n][n];
        //System.out.print(board[0][0]);
        N =n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        //printBoard(board);
        if(player==1){
            board[row][col]='X';
            int colcnt=0;
            int rowcnt=0;
            int oppdig =0;
            int dig=0;
            for(int i=0;i<N;i++){
                if(board[i][col]!='X')
                    break;
                else colcnt++;
            }
            for(int i=0;i<N;i++){
                if(board[row][i]!='X')
                    break;
                else rowcnt++;
            }
            if(row==col){
                for(int i=0;i<N;i++){
                 if(board[i][i]!='X')
                    break;
                else
                    dig++;
                }
            }
          
            if(row==N-col-1){
                for(int i=0;i<N;i++){ 
                   if(board[i][N-i-1]!='X')
                      break;
                   else
                      oppdig++;
                }
            }
            if(colcnt==N||rowcnt==N||dig==N||oppdig==N)return 1; 
        }
        else{
            board[row][col]='O';
            int colcnt=0;
            int rowcnt=0;
            int oppdig =0;
            int dig=0;
            for(int i=0;i<N;i++){
                if(board[i][col]!='O')
                    break;
                else colcnt++;
            }
            for(int i=0;i<N;i++){
                if(board[row][i]!='O')
                    break;
                else rowcnt++;
            }
            if(row==col){
                for(int i=0;i<N;i++){
                    if(board[i][i]!='O')
                        break;
                    else
                        dig++;
                }
            }
            if(row==N-col-1){
                for(int i=0;i<N;i++){ 
                   if(board[i][N-i-1]!='O')
                      break;
                   else
                      oppdig++;
                }
            }
            if(colcnt==N||rowcnt==N||dig==N||oppdig==N)return 2; 
        }
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

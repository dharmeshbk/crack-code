public class NQueens {

	public static void main(String[] args) {

		Integer[] board = new Integer[3];
		
		NQ(3,board,0);
    }
	
	
	
	
	public static void NQ(int queenSize,Integer[] board,int i) {
		if (i == queenSize) {
			printBoard(board);
			return;
		}
		
		for (int col=0; col<queenSize; col++) {
			if (!hasConflict(board,i,col)) {
				board[i]=col;
				NQ(queenSize,board,i+1);
			}
		}
		
		
	}
	
	public static boolean hasConflict(Integer[] board,int row,int col) {
		
        //Last queen would be at slate.size-1 and rowIndex
        for (int q=0; q < row; q++ ) {
        	
        	if (board[row-1] == board[q]) {
        		return true;
        	}        	
        	int colDiff = Math.abs(board[row-1]) - board[q];
        	int rowDiff = Math.abs(row-1 -q);
        	if (colDiff == rowDiff) {
        		return true;
        	}
        }
        return false;
    }
	
	public static void printBoard(Integer[] board) {
		System.out.println("Board "+board);
	}
}

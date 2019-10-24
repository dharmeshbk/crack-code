import java.util.ArrayList;
import java.util.List;

public class ChessQueen {

	public static void main(String[] args) {

		String[][] results = find_all_arrangements(4);
		System.out.println("Results :"+results);
    }
	
	public static String[][] find_all_arrangements(int n) {
		List<Integer> board = new ArrayList<>();
		List<List<String>> results = new ArrayList<>();
		arrangeQueen(n,0, board,results);
		String[][] finalRes = new String[results.size()][n];
		int i=0;
		for (List<String> result : results) {
			if (result != null) {
				finalRes[i]=result.toArray(new String[n]);
			}
			i++;
		}
		return finalRes;
    }
	
	public static void arrangeQueen(int chessSize,int col,List<Integer> board,List<List<String>> results) {
		//Base case
		if (chessSize == col) {
			print(board,results);
			return;
		}		
		//Recursive call
		for (int newRow=0; newRow < chessSize; newRow++) {
			if (!hasConflict(board, newRow, col)) {
				board.add(newRow);
				arrangeQueen(chessSize,col+1,board,results);
				board.remove(board.size()-1);
			}
		}
		
	}
	
	public static boolean hasConflict(List<Integer> board,int newRow,int newCol) {
		
		for (int i=0; i< board.size(); i++) {
			//Check for same column and same row exist
			if (board.get(i) != null ) {
				if (i == newCol || newRow == board.get(i)) {
					return true;
				}				
				int colDiff = Math.abs(i - newCol);
				int rowDiff = Math.abs(newRow - board.get(i));				
				if (colDiff == rowDiff) {
					return true;
				}
				
			}
		}
		return false;
		
	}
	
	public static void print(List<Integer> board,List<List<String>> results) {
		
		List<String> oneResult = new ArrayList<String>();
		for (int i=0; i<board.size(); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=0; j< board.size(); j++) {
				//first row value
				if (board.get(i) != null && j == board.get(i) ) {
					sb.append("q");
				} else {
					sb.append("-");
				}
			}
			oneResult.add(sb.toString());
		}
		results.add(oneResult);
	}
	
	
}

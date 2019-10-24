import java.util.ArrayList;
import java.util.List;

public class ChaseQueenArrangements {
	
	 public static void main(String[] args) {
		 String[][] results = find_all_arrangements(3);
		 
	 }
	
	public  static String[][] find_all_arrangements(int n) {
		List<Integer> slate = new ArrayList<Integer>();
		List	<String[]> resultList = new ArrayList<String[]>();
		
		arrangeQueen(slate,0,n,resultList);
		
		int resSize = resultList.size();
		String[][] results = new String[resSize][n];
		for (int i=0; i <resSize; i++) {
			results[i] = resultList.get(i);
			System.out.println(resultList.get(i));
		}
		return results;
	}
	
	public static void arrangeQueen(List<Integer> slate,int curCol,int n,List<String[]> result) {
		
		//Base Case
		
		if (n == curCol) {
			//printBoard , everything is completed.
			String[] curResult = new String[n];
			for (int rowIdx = 0; rowIdx < n; rowIdx++) {
				StringBuilder sb = new StringBuilder();
				for (int colIdx = 0; colIdx < n; colIdx++) {
					if (slate.get(colIdx) == rowIdx) {
						sb.append('q');
					} else {
						sb.append('-');
					}
				}
				curResult[rowIdx] = sb.toString();
			}
			result.add(curResult);
		}
		
		for (int newRow = 0; newRow < n; newRow++) {
			if (!isConflict(slate, newRow, n)) {
				slate.add(newRow);
				arrangeQueen(slate,curCol+1,n,result);
				slate.remove(slate.size()-1);
			}
		}
		
	}
	
	public static boolean isConflict(List<Integer> slate,int newRow,int n) {
		
		int newCol = slate.size();
		
		//Check for all previous placement of queens
		for (int i=0; i<slate.size(); i++) {
			int curCol = i;
			int curRow = slate.get(i);
			//Check for same row
			if (newRow == curRow) {
				return true;
			}
			
			//Check for diagnoal
			int rowDiff = Math.abs(newRow - curRow);
			int colDiff = Math.abs(newCol - curCol); 
			
			if (rowDiff == colDiff) {
				return true;
			}
			
		}
		return false;
	}

}

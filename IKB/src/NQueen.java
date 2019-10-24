import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {

        //Queen size
        nQueen(3);
    }

    public static void nQueen(int queenSize) {
        List<Integer> slate = new ArrayList<>();
        List<String> results = new ArrayList<>();
        helper(queenSize,0,slate,results);
        System.out.println("Result is "+results);
    }

    public static void helper(int queenSize,int rowIndex,List<Integer> slate,List<String> results) {

        //Backtracking case
        //Check the conflict between last queen and each of he previous queens
		/*
		 * if (isQueenAttacked(slate)) {
		 * System.out.println("IsQueenAttacked for the slate "+slate); return; }
		 */
        //Base Case
        if (queenSize == rowIndex) {
            //Append the result
			/*
			 * StringBuffer sb = new StringBuffer(); for (int i=0; i< slate.size(); i++) {
			 * sb.append(slate.get(i)); sb.append(","); }
			 */
        	String rowCol = rowIndex+","+slate.get(slate.size()-1);
            results.add(rowCol);
            return;
        }
        //Recursive case
        for (int col=0; col<queenSize; col++) {
        	  if (!isQueenAttacked(slate,col,queenSize)) {
                slate.add(col);
                helper(queenSize,rowIndex+1,slate,results);
                slate.remove(slate.size()-1);
                
        	  }
        }

    }

    public static boolean isQueenAttacked(List<Integer> slate,int newRow,int n) {

        for (int i=0; i<slate.size(); i++) {
        	
        }
    	
    	/**
         *
        if (rowIndex == slate.get(slate.size()-1) {
            return true;
        }
         **/
        //Last queen would be at slate.size-1 and rowIndex
        for (int q=0; q < slate.size()-2; q++ ) {
            //check if any of the previous queens are in the same column
            if (slate.get(slate.size()-1) == slate.get(q)) {
                System.out.println("same column for the  col is true " + q );
                return true;
            }
            //Check if any of the previous queens are at diagnols
            int colDiff = Math.abs(slate.get(slate.size()-1) - slate.get(q));
            int rowDiff = Math.abs(slate.size()-1 - q);
            if (colDiff == rowDiff) {
                int ds = slate.size() -1;
                System.out.println("ColDiff and RowDiff is same for the  col is " + q + " row is "+ ds);
                return true;
            }

        }
        return false;
    }
    
    public static void buildQueen(int row,int column) {
    	
    }
}

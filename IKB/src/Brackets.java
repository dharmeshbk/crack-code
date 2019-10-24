import java.util.ArrayList;
import java.util.List;

public class Brackets {

	 public static void main(String[] args) {
		 find_all_well_formed_brackets(3);
		 
	 }
	 
	 public static String[] find_all_well_formed_brackets(int n) {
		 List<String> results = new ArrayList<>();
		 formBrackets(n, n, "",results,n);
		 
		 System.out.println(results);
		 return results.toArray(new String[results.size()]);
		 

	 }
	 
	 public static void formBrackets(int remainingLBracket,int remainingRBracket,String buckets,List<String> results,int n) {
		 
		 //Base Case
		 if (remainingLBracket == 0 && remainingRBracket == 0) {
			/*
			 * if (isWelFormedBuckets(buckets,n)) { results.add(buckets); }
			 */
			 results.add(buckets);
			 return;
		 }
		 
		 //Short circuit
		 if (remainingLBracket > remainingRBracket) {
			 return;
		 }
		 
		 if (remainingLBracket != 0) {
			 formBrackets( remainingLBracket-1, remainingRBracket, buckets+"(",results,n);
			 //formBrackets( remainingLBracket-1, remainingRBracket, buckets,results,n);
		 }
		 
		 if (remainingRBracket != 0) {
			 formBrackets( remainingLBracket, remainingRBracket-1, buckets+")",results,n);
			 //formBrackets( remainingLBracket, remainingRBracket-1, buckets,results,n);
		 }
		 
	 }
	 
	 public static boolean isWelFormedBuckets(String buckets,int n) {
		// Deque<Character> stack = new ArrayDeque<>();
		 int leftBracket = 0;
		 int rightBracket = 0;
		 for (char c : buckets.toCharArray()) {
			 if (c == '(') {
				 leftBracket ++;
			 } else if (c == ')'){
				 rightBracket++;
			 }
		 }
		 
		 return (leftBracket == rightBracket) && leftBracket == n;
		 
	 }
	 
	 
}

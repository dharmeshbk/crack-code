
public class CountBST {

	public static void main(String[] args) {
		int n=5;
		System.out.print("BST Count "+how_many_BSTs(n));

	}
	
	public static long how_many_BSTs(int n) {
		return countBST(n);
    }
	
	public static long countBST(int n) {
		
		//Base Case 1 and 0
		
		if (n == 0 || n == 1) {
			return 1;
		}
		
		long bstTotalCount = 0;
		
		for (int i=1; i<= n;i++) {
			long leftCount = countBST(i-1); //Left Side of BST is i -1 (less than i)
			long rightCount = countBST(n-i);	 //Right side of the BST is n-1 greater than I but less than n
			bstTotalCount = bstTotalCount + (leftCount * rightCount);
		}
		
		return bstTotalCount;
		
	}
	
	

}

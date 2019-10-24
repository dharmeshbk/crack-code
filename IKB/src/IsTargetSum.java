
public class IsTargetSum {

	public static void main(String[] args) {
		
		long[] input = new long[5];
		input[0]=-5;input[1]=8;input[2]=2;input[3]=11;input[4]=-8;
		boolean res = check_if_sum_possible(input,14);
		System.out.println("check_if_sum_possible "+res);
	}
	
	public static boolean check_if_sum_possible(long[] arr, long k) {
		long sum = arr[0];
		return checkSum(arr, k, sum, 0);
		
		
    }
	
	public static boolean checkSum(long[] arr, long k,long sum,int index) {
		
		
		//If Sum is target then return
		if (k == sum) {
			return true;
		}
		
		//Base case return
		if (index >= arr.length-1) {
			return false;
		}
		if (arr[index] == 11) {
			System.out.println("sum +"+ sum+ " and index is "+index);
		}
		//System.out.println("Include:"+"index "+index +" sum is "+sum+" array  index+1 is  "+String.valueOf(sum)+"+"+String.valueOf(arr[index+1]));
		//Recursive call		
		if (checkSum(arr, k, sum+arr[index+1], index+1)) {//Include
			return true;
		}
		//System.out.println("Exclude: sum is array  index+1 is  "+String.valueOf(sum)+"+"+String.valueOf(arr[index+1]));
		if (checkSum(arr, k, arr[index+1], index+1)) {//Exclude
			return true;
		}
		
		return false;
	}


}

import java.util.ArrayList;
import java.util.List;

public class SumTargetExpressions {


	public static void main(String[] args) {
		generate_all_expressions("12",3);

	}
	
	static String[] generate_all_expressions(String s, long target) {
		List<String> results = new ArrayList<String>();
		sumTargetWithExpression(s,target,0,"",0,results);
		
		//results.toArray(new String[results.size()]);
		String[] res = results.stream().toArray(String[] ::new);
		System.out.println("result is :"+results);
		return res;
    }
	
	public static void sumTargetWithExpression(String input,long targetSum, int expEvalRes,String expression,int inputIndex,List<String> results) {
		
		//Backtesting case
		
		if (expEvalRes > targetSum) {
			return;
		}
		
		//Reached to the end
		if (inputIndex == input.length()) {
			//check the Sum and gather the expression if sum is equal to target
			if (expEvalRes == targetSum) {
				results.add(expression);
			}
			return;
		}
		
		//Ignore first record (expEvalRes is 0)
		
		String joinS = "";
		String joinExpression = null;
		String addExpression = null;
		String multiExpression = null;
		
		if (expEvalRes == 0 ) {
			joinS = String.valueOf(input.charAt(inputIndex));
			joinExpression=joinS+"**";
			addExpression=joinS+"+";
			multiExpression = joinS+"*";
		} else {
			joinS = String.valueOf(input.charAt(inputIndex));
			joinExpression=expression+joinS+"**";
			addExpression=expression+joinS+"+";
			multiExpression = expression+joinS+"*";
		}
		
		
		
		sumTargetWithExpression(input, targetSum, Integer.parseInt(String.valueOf(expEvalRes)+String.valueOf(input.charAt(inputIndex))), /**expression+"**"+joinS**/joinExpression, inputIndex+1, results);
		
		//Add
		sumTargetWithExpression(input, targetSum, expEvalRes+Integer.parseInt(String.valueOf(input.charAt(inputIndex))), addExpression, inputIndex+1, results);
		
		//multiplication
		sumTargetWithExpression(input, targetSum, expEvalRes*Integer.parseInt(String.valueOf(input.charAt(inputIndex))), multiExpression, inputIndex+1, results);
		
	}
}

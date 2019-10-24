import java.util.ArrayList;
import java.util.List;

public class GenerateExpression {

	public static void main(String[] args) {
		String[] res = generate_all_expressions("222",24);
		
		//long res = getSum("3+2*5**0");
		//System.out.println(res);
		//String a = "3**2+3*4**4";
		//System.out.println(a.replace("**", ""));
		//long res = getSum("1+2*2+3**1");
		//System.out.println(res);
	}
	
	static String[] generate_all_expressions(String s, long target) {
		List<String> results = new ArrayList<String>();
		genExpression(s,target,0,String.valueOf(s.charAt(0)),results);
		System.out.println(results);
		return results.toArray(new String[results.size()]);
	}
	
	public static void genExpression(String input,long target,int index,String expression,List<String> results) {
		
		//Base Case
		if (input.length()-1 == index) {
			//results.add(expression);
			if (target == getSum(expression)) {
				//System.out.println("Results adding "+expression);
				results.add(expression.replace("**", ""));
			}
			//System.out.println("More expression "+expression);
			return;
		}
		
		//Recursive case
		
		//Join the expression
		genExpression(input, target, index+1, expression+"**"+String.valueOf(input.charAt(index+1)), results);
		genExpression(input, target, index+1, expression+"+"+String.valueOf(input.charAt(index+1)), results);
		genExpression(input, target, index+1, expression+"*"+String.valueOf(input.charAt(index+1)), results);
		
	}
	
	public static long getSum(String expression) {
		
		expression = expression.replace("**", "");
		//Base case
		String[] addExp = expression.split("\\+");
		if (addExp.length==1) {		
			String[] mExp = expression.split("\\*");			
			if (mExp.length==1) {
				return Long.parseLong(mExp[0]);
			} else {
				long sum=1;
				for (int i=0; i<mExp.length; i++) {
					sum = sum * getSum(mExp[i]);
				}
				return sum;
			}
			
		} else {			
			
			long sum=0;
			for (int i=0; i<addExp.length; i++) {
				sum = sum+ getSum(addExp[i]);
			}
			return sum;
		}
		
	}
	
	
	
}

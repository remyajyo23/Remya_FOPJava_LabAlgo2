package PayMoney;

import java.util.Scanner;

public class PayMoney {
	
	public int checkTarget(int targetValue,int values[]){
		
		int sum = 0;int count = 0;
		for(int i = 0;i<values.length;i++) {
			sum = sum+values[i];
			count++;
			if(sum>targetValue) {
				return count;
			}
		}
		
		return 0;
		
	}

	public static void main(String[] args) {
		PayMoney p1 = new PayMoney();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of transaction array");
		int trans = sc.nextInt();

		System.out.println("enter the values of array");
		int[] values = new int[trans];

		for (int i = 0; i < trans; i++) {
			values[i] = sc.nextInt();
		}

		System.out.println("enter the total no of targets that needs to be achieved");
		int target = sc.nextInt();

		for (int i = 0; i < target; i++) {
			System.out.println("enter the value of target");
			int targetValue = sc.nextInt();
			int result = p1.checkTarget(targetValue,values);
			if(result>0) {
				System.out.println("Target achieved after "+result+" transactions");
			}else {
				System.out.println("Given target is not achieved");
			}
			
		}
		sc.close();
	}

}

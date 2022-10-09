package PayMoney;

import java.util.*;

public class CurrencyDenomination {

	public static int[] sortArray(int[] denomValues) {

		int temp;
		for (int i = 0; i < denomValues.length; i++) {
			for (int j = i + 1; j < denomValues.length; j++) {
				if (denomValues[i] < denomValues[j]) {
					temp = denomValues[i];
					denomValues[i] = denomValues[j];
					denomValues[j] = temp;
				}
			}
		}
		return denomValues;
	}

	public static void findDenom(int[] denomValues, int amount) {
		int tempAmount = amount;
		int count = 0;
		TreeMap<Integer, Integer> h1 = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		for (int i = 0; i < denomValues.length; i++) {
			count = 0;
			while (tempAmount >= 0) {
				if (tempAmount >= denomValues[i]) {
					tempAmount = tempAmount - denomValues[i];
					count++;
				} else {
					break;
				}
			}
			if (count != 0) {
				h1.put(denomValues[i], count);
			}
			if (tempAmount != 0) {
				continue;
			}
		}
		if (tempAmount > 0) {
			System.out.println("Amount cannot be paid in given denomination");
		} else {
			for (Map.Entry<Integer, Integer> hashValue : h1.entrySet()) {
				System.out.println(hashValue.getKey() + ":" + hashValue.getValue());
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of currency denominations");
		int size = sc.nextInt();
		System.out.println("enter the currency denominations value");
		int[] denomValues = new int[size];
		for (int i = 0; i < size; i++) {
			denomValues[i] = sc.nextInt();
		}
		System.out.println("enter the amount you want to pay");
		int amount = sc.nextInt();
		int[] sortArray = sortArray(denomValues);
		findDenom(sortArray, amount);
		sc.close();
	}

}

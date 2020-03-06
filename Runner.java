package org.point.buy;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Runner {

	public static void main(String... args) {
		BigDecimal statsAvg = new BigDecimal(0);
		for(int i = 1; i < Double.MAX_VALUE; i++) {
			ThreeD6DropLowplus1net td = new ThreeD6DropLowplus1net();
			int current = td.stat();
			statsAvg = statsAvg.add(new BigDecimal(current));
			try {
				System.out.println("Average stats Value Approximate = " + (Double.parseDouble(statsAvg.toString()) / i));
				if (i % 10 == 0) {
					System.out.println("Average stats Value = " + statsAvg.divide(new BigDecimal(i)).toString());
				}
				System.out.println("Current Stat Sum = " + statsAvg);
				System.out.println("Current Iteration = " + i);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
		}
		//average result is 12.245 but point buy gives 12.5.. so point buy is better
	}
}

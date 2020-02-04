package com.dspohn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class ChangeSort {
	// Used MathContext to set the decimal places and the type of rounding to be used.
	public static MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
	
	// Set the default values for all of the coins
	public static final BigDecimal QUARTER = new BigDecimal(0.25, mc);
	public static final BigDecimal DIME = new BigDecimal(0.10, mc);
	public static final BigDecimal NICKEL = new BigDecimal(0.05, mc);
	public static final BigDecimal PENNY = new BigDecimal(0.01, mc);
	
	// Formats the BigDecimal values to be displayed
	public static NumberFormat format = new DecimalFormat("0.###");
	
	public static void main(String[] args) {
		BigDecimal change = new BigDecimal(0.03, mc);
		System.out.println("Number of coins for " + format.format(change) + " in change is " + coins(change).toString());
		BigDecimal change1 = new BigDecimal(0.91, mc);
		System.out.println("Number of coins for " + format.format(change1) + " in change is " + coins(change1).toString());
		BigDecimal change2 = new BigDecimal(0.75, mc);
		System.out.println("Number of coins for " + format.format(change2) + " in change is " + coins(change2).toString());
		BigDecimal change3 = new BigDecimal(0.40, mc);
		System.out.println("Number of coins for " + format.format(change3) + " in change is " + coins(change3).toString());
	}
	
	/**
	 * A function which takes a monetary amount, less than $1.00, and 
	 * determines the combination of highest value coins needed.
	 * 
	 * @param monetary amount as type BigDecimal
	 * @return coins as type Map<String, Integer>
	 */
	public static Map<String, Integer> coins(BigDecimal amount) {
		Map<String, Integer> sortedCoins = new HashMap<>();
		sortedCoins.put("Quarters", 0);
		sortedCoins.put("Dimes", 0);
		sortedCoins.put("Nickels", 0);
		sortedCoins.put("Pennies", 0);

		while(amount.compareTo(BigDecimal.ZERO) > 0) {
			if(amount.compareTo(QUARTER) >= 0) {
				amount = amount.subtract(QUARTER);				
				sortedCoins.replace("Quarters", sortedCoins.get("Quarters") + 1);
			
			} else if(amount.compareTo(DIME) >=0) {
				amount = amount.subtract(DIME);
				sortedCoins.replace("Dimes", sortedCoins.get("Dimes") + 1);
			
			} else if(amount.compareTo(NICKEL) >= 0) {
				amount = amount.subtract(NICKEL);
				sortedCoins.replace("Nickels", sortedCoins.get("Nickels") + 1);
			
			} else if(amount.compareTo(PENNY) >= 0) {
				amount = amount.subtract(PENNY);
				sortedCoins.replace("Pennies", sortedCoins.get("Pennies") + 1);
			
			} else {
				break;
			}
				
		}
		return sortedCoins;
	}

}

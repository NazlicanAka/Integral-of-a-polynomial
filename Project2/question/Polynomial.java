
package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Polynomial {

	private double deltaX = 0.0001;

	//Example solution:
	//Index 0: Coef. of x^0
	//Index 1: Coef. of x^1
	//Index 2: Coef. of x^2
	//Index 3: Coef. of x^3
	//Index 4: Coef. of x^4
	//If there is no x^n, that coefficient should be 0.

	private ArrayList<Integer> coefficients = new ArrayList<Integer>();
	private ArrayList<Character> plusAndMinus = new ArrayList<>();
	private ArrayList<String> splitStrArr = new ArrayList<>();
	
	

	//Fill in coefficients inside the constructor
	
	public Polynomial(String polynomial) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		
		if(polynomial.charAt(0) != '-') {
			plusAndMinus.add('+');
		}
		for(int i=0; i<polynomial.length(); i++) {

			if(polynomial.charAt(i) == '+'|| polynomial.charAt(i) == '-') {
				plusAndMinus.add(polynomial.charAt(i));
			}
		}
		
		String str1 = polynomial.replace("-", " ");
		String str2 = str1.replace("+", " ");
		String[] splitStr = str2.split(" ");
		
	
		
		// Put splitStr array to ArrayList
		for(int i=0; i<splitStr.length; i++) {
			splitStrArr.add(splitStr[i]);
		}
		
		// Remove from ArrayList of divided strings, if there is a empty string
		for(int i=0; i<splitStr.length; i++) {
			if(splitStr[i] == "") {
				splitStrArr.remove(i);
			}
		}
		
		for(int i=0; i<splitStrArr.size(); i++) {
			splitStr[i] = plusAndMinus.get(i) + splitStr[i];
			splitStrArr.set(i, plusAndMinus.get(i) + splitStrArr.get(i));
		}
		
		
		
		for(int i=0; i<splitStrArr.size(); i++) {
			
				String strCo = "";
				for(int j=0; j<splitStrArr.get(i).length(); j++) {
					// When we bump into x, we will stop concatenate string coefficients 
					if(splitStrArr.get(i).charAt(j) == 'x') {
						break;
					// concatenate string coefficients	
					}else {
						String charCo = String.valueOf(splitStrArr.get(i).charAt(j));
						strCo = strCo + charCo;
						// If coefficient if x is 1 or -1 add 1 to the string coefficient
						if(splitStrArr.get(i).charAt(1) == 'x') {
							strCo = strCo + "1";
						}
						
					}
					
		        }
				// turn string coefficients to integer 
				int intCo = Integer.parseInt(strCo);
                // Add integer coefficients into integer Array List
				coefficients.add(intCo);
				
	}

		
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}


	public double valueAt(double point) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		ArrayList<Integer> powers = new ArrayList<>();
		
		
		double value;
		double sumOfValues = 0;
		
		for(int i=0; i<splitStrArr.size(); i++) {
			String strPow = "";
			// When our one piece of string has "^", enter this for loop and concatenate string powers
			if(splitStrArr.get(i).contains("^")) {
			for(int j=0; j<splitStrArr.get(i).length(); j++) {
				
				
					if(splitStrArr.get(i).charAt(j) == '^') {
						
						for(int k=j+1; k<splitStrArr.get(i).length(); k++) {
							strPow = strPow + splitStrArr.get(i).charAt(k);
							
						}
						
					}
			}
			// If not equalize strPow to 1 or 0 by looking at whether contain "x" or not.
			}else {
				if(splitStrArr.get(i).contains("x")) {
					strPow = "1";
				}else {
					strPow = "0";
				}
			}
			// Create powers array list by adding all powers into it.
			int intPow = Integer.parseInt(strPow);
			powers.add(intPow);
			
			value = coefficients.get(i) * Math.pow(point, powers.get(i));
			sumOfValues = sumOfValues + value;
			
			
		}
		
		
		return sumOfValues;

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public void setDeltaX(double deltaX) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		this.deltaX = deltaX;

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}


	public int computeIntegral(int min, int max) {
		
		double integration = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		double piece = (max-min)/deltaX;
		for(int i=0; i<piece; i++) {
			double val = deltaX * (valueAt(min + (i * deltaX)));
			integration = integration + val;
			
		}
		
		

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		return (int)integration;
	}

}


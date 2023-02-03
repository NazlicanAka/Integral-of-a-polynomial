
package question;

import java.util.ArrayList;

import java.util.Arrays;


public class Main
{
	// Main method is for you to test your code
	// You will not get any points here
	public static void main(String[] args) {
		
		Polynomial p1 = new Polynomial("6+x");
		
		p1.setDeltaX(0.00001);
//		
//		System.out.println(p1.valueAt(867));
	
		System.out.println(p1.computeIntegral(3,5));
//		
//    	String myP = new String("-23-x");
//		System.out.println(split(myP, 3));
		
		
//		char c='S';  
//		String s=String.valueOf(c);  
//		System.out.println(s + " hbk");
		
//		String str = "fbdhj^dbhj";
//		if(str.contains("^")) {
//			System.out.println("kullan");
//		}
		

	}
	
	public static int split(String polynomial, double point) {
		ArrayList<Integer> coefficients = new ArrayList<Integer>();
		ArrayList<Character> plusAndMinus = new ArrayList<>();
		ArrayList<String> splitStrArr = new ArrayList<>();
		
		if(polynomial.charAt(0) != '-') {
			plusAndMinus.add('+');
		}
		for(int i=0; i<polynomial.length(); i++) {

			if(polynomial.charAt(i) == '+'|| polynomial.charAt(i) == '-') {
				plusAndMinus.add(polynomial.charAt(i));
			}
		}
		
		System.out.println(plusAndMinus);		
		
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
		
		System.out.println(splitStrArr);
		
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
		
//		// If coefficient of x is 1
//		for(int i=0; i<splitStrArr.size(); i++) {
//			
//			if(splitStrArr.get(i).charAt(0) == 'x') {
//				splitStrArr.set(i, "1" + splitStrArr.get(i));
//				
//			}
//			
//			
//
//			
//			// convert char to string
//			String s1 = String.valueOf(plusAndMinus.get(i));
//			String s2 = String.valueOf(splitStrArr.get(i).charAt(0));
//			
//			//concatenate plusAndMinus and coefficient 
//			String coefficient = s1 + s2;
//			
//			// convert string to integer
//			int co = Integer.parseInt(coefficient);
//			
//			coefficients.add(co);
//			
//		}
		
		
		
//		System.out.println(splitStrArr);

		
	
	    
		double integration = 0;

		

//		double piece = (5-2)/0.0001;
//		for(int i=0; i<piece; i++) {
//			double val = 0.0001 * (valueAt1(splitStrArr,2 + (i * 0.0001),coefficients));
//			integration = integration + val;
//
//	}
		return (int)integration;
	}	
//		private static double valueAt1(ArrayList<String> splitStrArr, double point, ArrayList<Integer> coefficients) {
	    private static void valueAt1() {
			ArrayList<Integer> powers = new ArrayList<>();
			
			String strPow = "";
			double value;
			double sumOfValues = 0;
			
			for(int i=0; i<splitStrArr.size(); i++) {
				for(int j=0; j<splitStrArr.get(i).length(); j++) {
					if(splitStrArr.get(i).charAt(j) == '^') {
						strPow = strPow + String.valueOf(splitStrArr.get(i).charAt(j+1));
						System.out.println(strPow);
					}
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			return sumOfValues;
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			// add powers in an ArrayList
//			for(int i=0; i<splitStrArr.size(); i++) {
//				if(splitStrArr.get(i).length() == 2) {
//					power = 0;
//					powers.add(power);
//				}
//				else if(splitStrArr.get(i).length() == 3) {
//					power = 1;
//					powers.add(power);
//				}
//				else if(splitStrArr.get(i).length() == 5) {
//					power = Integer.parseInt(String.valueOf(splitStrArr.get(i).charAt(4)));
//					powers.add(power);
//				}
//				
//				value = coefficients.get(i) * Math.pow(point, powers.get(i));
//				sumOfValues = sumOfValues + value;
//				
//			}
//			return sumOfValues;
			
			
		}
	

	
		
		
		
		
	

	
	
	
	
		
}


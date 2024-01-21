package algo_ass1;
//Rami
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ass_1 {

	public static void main(String[] args) {
		for (int i = 0 ; i <= 20 ; i++) {
			System.out.print(i + ": ");
			double cat = q5(i);
			BigDecimal bigCat = new BigDecimal(cat);
			System.out.println(bigCat);
		}
	}
	public static int q1(int n) {
		int k,res;
		k = (int)(n/10);
		res = ((k+2) * (k+1))/2;
		return (int) res;				
	}// q1 func
	
	
	public static boolean q2_a(String input) {
		int count1 = 0,count2=0,count3=0,count4 = 0;
		char[] str = input.toCharArray();
		for (char st : str) {
			if ((st != '{') && (st != '}') && (st != '(') && (st != ')') &&
				    (st != '[') && (st != ']') && (st != '<') && (st != '>')) {
					return false;}			// Checks if the input is valid
			if (st == '{' || st == '}') {
				if (st == '{') {
					count1++;
				}
				else {				//st == }
					count1--;
				}
			}
			if (st == '[' || st == ']') {
				if (st == '[') {
					count2++;
				}
				else {				//st == ]
					count2--;
				}
			}
			if (st == '(' || st == ')') {
				if (st == '(') {
					count3++;
					}
				else {				//st == )
					count3--;
				}
			}
			if (st == '<' || st == '>') {
				if (st == '<') {
					count1++;
				}
				else {				//st == >
					count1--;
				}
			}
		} // for loop ends
		if (count4 != 0 || count3 != 0 || count2 != 0 || count1 != 0) {
			return false;
		}
		return true;
	}// Q2_a func ends
		
			
		
		
	public static boolean q2_b(String input) {
		boolean flag = q2_a(input); 
		ArrayList <Character> test = new ArrayList<>(); // Create an ArrayList for tests
		if (flag) {
			char[] str = input.toCharArray();
			for (char st : str) {
				if (st == '{' || st == '(' || st == '<' || st =='[') {
					test.add(st);
				}
				else {
					if (test.size() == 0) { // 
						return false; // Encounter with a "closer" without seeing a matching "opener" before
					}
					char last_char = test.get(test.size()-1);
					if ((st == '}' && last_char == '{') || 
						(st == ')' && last_char == '(') ||
						(st == '>' && last_char == '<') ||
						(st == ']' && last_char == '[')  ) {
						test.remove(test.size()-1);
						}
					else { 
						return (false); // "<}" -'opener' and 'closer' doesn't match-> case is already not valid 
						}
				} 
			}// for loop ends
			if (test.size() != 0) {
				flag = false;
			}
		}
		return flag;
	}//func ends

	
	
	public static boolean is_prime(double num) {
		if (num < 2) { 
			return false;
		}
		int sqr = (int) Math.pow(num, 0.5);
		sqr++;
		for(int i = 2; i <= sqr ; i++ ) { // prime check from 2 to the sqr of the number.
			if ( num % i == 0 ) {
				return false;
			}
		}//for loop ends
		return true;
	}
	
	public static int max_prime(int n) {
		for (int i =  n ; i > n/10 ; i--) {// check "if prime" one by one from max (999) to (99).  
			if (is_prime(i)) {
				return i;
			}
		}// for loop ends
		return 1; // in case of n = 0
	}
	
	public static void q3(int n) {
		if (n < 1) {
			System.out.println("Please try again, with a positive Integer");
			return;
		}
		double start = Math.pow(10, n);
		int prime_1 = max_prime((int)start - 1); // start = 99...99 
		int prime_2 = max_prime(prime_1-1);
		System.out.println(prime_1);
		System.out.println(prime_2);
	}
	
	
	public static Void q4(int num) {
		while (num < 1) {
			System.out.println("wrong input, please type a number greater then 0");
			Scanner input = new Scanner(System.in);
			num = input.nextInt();
			input.close();
		}
		double first = Math.pow(10, num-1);
		double last = Math.pow(10, num);
		System.out.println("The valid numbers with " + num + " digits are : ");
		for (int i = (int)first ; i < (int)last; i++ ) {
			boolean valid = true;
			String binary_str = Integer.toBinaryString(i);
			int sum = 0;
			int j = 0;
			while (j < binary_str.length() && valid) {
				if ((int)binary_str.charAt(j) == 49) {		// Char.at(j) == 1 (char(1) = 49 in ASCII)
					sum++;
				}
				if ((int)binary_str.charAt(j) == 48) {		// Char.at(j) == 0 (char(0) = 48 in ASCII)
					sum--;
				}
				j++;
				if (sum < 1) {
					valid = false;
				}
			}// while loop ends
			if (valid) {
				System.out.println(i + " " + binary_str);
			}
		}
		return(null);
	}
	
	
	public static double q5(int n) {
		if (n == 1 || n < 1 ) {
			//System.out.println(1);
			return 1;		
		}
		double res = 2;
		for (int i = 2; i<=n-1 ; i++) {

			res *= (n+i);
			res /=  i;
		}
		return res;

	}
	
	
}//class ends






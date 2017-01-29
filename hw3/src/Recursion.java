import java.util.Arrays;

/**
 
 */
public class Recursion {

	/**
	 * As a model, here is a minValue function, both iteratively and recursively
	 */
	/** iterative version */
	public static double minValueIterative(double[] list) {// list is an array
															// of doubles
		double result = list[0]; // first element of the array
		int i = 1;
		while (i < list.length) { // i range: 1-length-1, iterate through 2nd
									// element to last element
			if (list[i] < result)
				result = list[i]; // update result with the smallest value in
									// the array
			i = i + 1; // i++
		}
		return result;// return the smallest value in the array
	}

	/** recursive version */
	// write a recursive version of the function, but what is A. recursion, and
	// B. helper class...
	public static double minValue(double[] list) {
		return minValueHelper(list, 1, list[0]);
	}

	private static double minValueHelper(double[] list, int i, double result) {// create
																				// helper
																				// class
		if (i < list.length) {// i start from 1, till length-1
			if (list[i] < result)
				result = list[i];// if item in array is less than result, update
									// result with that particular value
			result = minValueHelper(list, i + 1, result);// add 1 to i each
															// time, or will be
															// infinite loop
		}
		return result;// after the loop is done, return the last updated result
						// value(smallest in the array)
	}

	/**
	 * PROBLEM 1: Translate the following sum function from iterative to
	 * recursive. You should write a helper method. You may not use any "fields"
	 * to solve this problem (a field is a variable that is declared "outside"
	 * of the function declaration --- either before or after).
	 */
	public static double sumIterative(double[] a) {// an array of doubles
		double result = 0.0;// result start value is 0
		int i = 0;
		while (i < a.length) {// i range: 0 ~ length-1
			result = result + a[i];// add each element to result
			i = i + 1;
		}
		return result;
	}

	public static double sum(double[] a) {
		if (a.length < 1) {
			return 0;
		}
		return sumHelper(a, 0, a[0]);
	}// i start with 1?

	private static double sumHelper(double[] a, int i, double result) {
		if (i < a.length - 1) {

			result = result + a[i + 1];
			result = sumHelper(a, i + 1, result);
		}
		return result;
	}

	// ask TA array index out of bound exception at java:71 and java:121 why?
	/**
	 * PROBLEM 2: Do the same translation for this in-place reverse function
	 *
	 * You should write a helper method. You may not use any "fields" to solve
	 * this problem (a field is a variable that is declared "outside" of the
	 * function declaration --- either before or after).
	 */
	public static void reverseIterative(double[] a) {
		int hi = a.length - 1;// high =n-1
		int lo = 0;
		while (lo < hi) {// only do it when n-1>0, n>1
			double loVal = a[lo];// low value=value of first item in array
			double hiVal = a[hi];// high value =value of last item in array
			a[hi] = loVal;
			a[lo] = hiVal;// switch places
			lo = lo + 1;
			hi = hi - 1;// change i, i++
		}
	}

	public static void reverse(double[] a) {
		// System.out.print(a);

		reverseHelper(a, 0, a.length - 1);// i start with 1 or 0?
		// System.out.print(a);
	}

	private static void reverseHelper(double[] a, int low, int high) {
		if (low < high) {
			double temp = a[low];
			a[low] = a[high];
			
			a[high] = temp;
			reverseHelper(a, low+1, high-1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] list0 = new double[] {};
		double[] list1 = new double[] { 5 };
		double[] list2 = new double[] { -3, 5 };
		double[] list3 = new double[] { 2, -3, 5 };
		double[] list4 = new double[] { -1, 2, -3, 5 };
		double[] list5 = new double[] { 33, 44, 55 };

		System.out.println("Display the sum of the array contents");
		System.out.println("list5: " + sum(list5));
		System.out.println("list0: " + sum(list0));
		System.out.println("list1: " + sum(list1));
		System.out.println("list2: " + sum(list2));
		System.out.println("list3: " + sum(list3));
		System.out.println("list4: " + sum(list4));

		System.out.println("Reversing the lists");
		reverse(list0);
		System.out.println("list0: " + Arrays.toString(list0));
		reverse(list1);
		System.out.println("list1: " + Arrays.toString(list1));
		reverse(list2);
		System.out.println("list2: " + Arrays.toString(list2));
		reverse(list3);
		System.out.println("list3: " + Arrays.toString(list3));
		reverse(list4);
		System.out.println("list4: " + Arrays.toString(list4));
		reverse(list5);
		System.out.println("list5: " + Arrays.toString(list5));
	}

}

import java.util.ArrayList;
import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

		System.out.println(Arrays.toString(recaman(17)));

	}

	public static int[] recaman(int n){
		if(n <= 0) {return new int[]{};}

		return recamanHelper(n);
	}

	public static int[] recamanHelper(int n){
		//make new output array with n elements
		int[] out = new int[n];

		//base case
		if(n <= 1){
			out[0] = 1;
			return out;
		}

		//recursively call helper for n-1
		int[] aPrev = recamanHelper(n-1);

		//calculate a(n-1) because there's a lot of comparisons
		int nextA = aPrev[aPrev.length - 1] - n;	

		//flag to make sure nextA isn't already in the array
		boolean flag = false;

		for(int i = 0; i < aPrev.length; i++){
			out[i] = aPrev[i];
		}


		//I get i didnt learn this here, but i like for each loops too much
		for(int i : aPrev){
			if(i == nextA){
				flag = true;
			}
		}

		//if nextA not in aPrev and is bigger than 0
		if((!flag) && nextA > 0){
			out[n-1] = (aPrev[aPrev.length - 1] - n);

		} else {
			//otherwise
			out[n-1] = (aPrev[aPrev.length - 1] + n);
		}

		return out;
	}

}

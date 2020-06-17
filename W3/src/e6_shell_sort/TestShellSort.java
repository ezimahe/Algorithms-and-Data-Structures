package e6_shell_sort;

public class TestShellSort {
	public static void main(int[] args) {
		int [] a = generateRandomArray(111, 1, 111);
		System.out.println (a);
	}
	
	
	public static int[] generateRandomArray(int size, int minValue, int maxValue) {
		int[] result = new int[size];
		for (int i=0; i<size; i++) {
			result[i] = minValue + (int) (Math.random()*(maxValue-minValue+1));
		}
		return result;
		
	}
	
}

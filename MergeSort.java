import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSort {
    public static void main(String[] args) {
		Map<Integer[], Integer[]> tests = new HashMap<>();
        tests.put(new Integer[] {1,3,2,4,6,5,7,9,8,0}, new Integer[] {0,1,2,3,4,5,6,7,8,9});
        tests.put(new Integer[] {17, 41, 12, 6, -5, 81, 101, 0, 3, 19}, new Integer[] {-5, 0, 3, 6, 12, 17, 19, 41, 81, 101});
        
        tests.forEach((key, value) -> {
            boolean correct = true;
            Integer[] sorted = mergeSort(key);
            for (int i = 0; i < sorted.length; i++) {
                if (sorted[i] != value[i]) {
                    correct = false;
                }
            }
            if (correct) {
                System.out.println("looking good");
            } else {
                System.out.println("you failed!");
            }
        });

    }

    public static Integer[] mergeSort(Integer[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		Integer[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        Integer[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        Integer[] splitLeft = mergeSort(left);
        Integer[] splitRight = mergeSort(right);

        return merge(splitLeft, splitRight);
    }

	public static Integer[] merge(Integer[] left, Integer[] right) {
		Integer[] result = new Integer[left.length + right.length];

		int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
				k++;
				i++;
            } else {
                result[k] = right[j];
				k++;
				j++;
            }
        }

        while (i < left.length) {
            result[k] = left[i];
			k++;
			i++;
        }

        while (j < right.length) {
            result[k] = right[j];
			k++;
			j++;
		}

		return result;
	}
}
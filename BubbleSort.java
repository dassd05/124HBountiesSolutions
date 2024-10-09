import java.util.HashMap;
import java.util.Map;

public class BubbleSort {
    public static void main(String[] args) {
        //random test cases of integer arrays of size 10
        Map<Integer[], Integer[]> tests = new HashMap<>();
        tests.put(new Integer[] {1,3,2,4,6,5,7,9,8,0}, new Integer[] {0,1,2,3,4,5,6,7,8,9});
        tests.put(new Integer[] {17, 41, 12, 6, -5, 81, 101, 0, 3, 19}, new Integer[] {-5, 0, 3, 6, 12, 17, 19, 41, 81, 101});
        
        tests.forEach((key, value) -> {
            boolean correct = true;
            Integer[] sorted = bubbleSort(key);
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

    public static Integer[] bubbleSort(Integer[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
            	if (nums[j] > nums[j + 1]) {
            		int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
            	}
            }
        }
		return nums;
    }
}
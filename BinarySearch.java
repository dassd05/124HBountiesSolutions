public class BinarySearch {
    public static void main(String[] args) {
        Integer[] test1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] test2 = {-5, 3, 7, 14, 21, 91, 103, 104, 178, 200, 225};
		
		// System.out.println(binarySearch(test1, 0) == 0);
		// System.out.println(binarySearch(test1, 1) == 1);
		// System.out.println(binarySearch(test1, 2) == 2);
		// System.out.println(binarySearch(test1, 3) == 3);
		// System.out.println(binarySearch(test1, 4) == 4);
		// System.out.println(binarySearch(test1, 5) == 5);
		// System.out.println(binarySearch(test1, 6) == 6);
		// System.out.println(binarySearch(test1, 7) == 7);
		// System.out.println(binarySearch(test1, 8) == 8);
		// System.out.println(binarySearch(test1, 9) == 9);
		// System.out.println(binarySearch(test1, 10) == 10);
		
		// System.out.println(binarySearch(test2, -5) == 0);
		// System.out.println(binarySearch(test2, 3) == 1);
		// System.out.println(binarySearch(test2, 7) == 2);
		// System.out.println(binarySearch(test2, 14) == 3);
		// System.out.println(binarySearch(test2, 21) == 4);
		// System.out.println(binarySearch(test2, 91) == 5);
		// System.out.println(binarySearch(test2, 103) == 6);
		// System.out.println(binarySearch(test2, 104) == 7);
		// System.out.println(binarySearch(test2, 178) == 8);
		// System.out.println(binarySearch(test2, 200) == 9);
		// System.out.println(binarySearch(test2, 225) == 10);
        
        boolean worked = true;
        for (int i : test1) {
            if (binarySearch(test1, i) == test1[binarySearch(test1, i)]) {
                System.out.println("seems to be working");
            } else {
                System.out.println("you failed!");
                worked = false;
            }
        }
        for (int i : test2) {
            if (i == test2[binarySearch(test2, i)]) {
                System.out.println("seems to be working");
            } else {
                System.out.println("you failed!");
                worked = false;
            }
        }

        System.out.println(worked);
    }

    public static int binarySearch(Integer[] array, int target) {
        int length = array.length;
        int index = length / 2;
        int[] bounds = {0, length - 1};
        int lastIndex = 0;

        while (array[index] != target) {
            int bound = target > array[index] ? 0 : 1;
            bounds[bound] = (bounds[0] + bounds[1] ) / 2;
            index = (bounds[0] + bounds[1]) / 2;
            if (index == lastIndex) index++;
            lastIndex = index;
        }

        return index;
    }
}
import java.util.Arrays;

public class InsertionSort {

    public int[] sort(int[] A) {

        for (int i=1; i<A.length; i++) {

            int j = i-1;
            int key = A[i];

            while (j >=0 && A[j] > key ) {

                A[j+1] = A[j];
                j--;
            }

            A[j+1] = key;

        }

        return A;
    }


    public static void main (String[] args) {

        System.out.println(Arrays.toString(new InsertionSort().sort(new int[]{5, 4, 2, 6, 1, 3})));

    }


}

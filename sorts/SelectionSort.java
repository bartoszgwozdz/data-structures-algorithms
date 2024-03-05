package sorts;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{12,6,3,9,7,1};
        System.out.println(Arrays.toString(array));
        selectionSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int minValue = array[i];
            for(int j = i+1; j<array.length; j++) {
                if(array[j] < minValue){
                    minIndex = j;
                    minValue = array[j];
                }
            }
            int temp = array[i];
            array[i] = minValue;
            array[minIndex] = temp;
        }

    }
}

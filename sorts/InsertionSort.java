package sorts;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[]{12,6,3,9,7,1};
        System.out.println(Arrays.toString(array));
        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array){
        for(int i =1; i<array.length; i++){
            int temp =  array[i];
            int j = i-1;
            while(j>=0 && temp < array[j]){
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
}

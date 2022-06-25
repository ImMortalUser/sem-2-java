package com.company;

public class Utils {

    public static <T> void sort(T[] data, int[] orderValues) {
        quickSort(orderValues, 0, orderValues.length-1, data);
    }

    private static  <T> void quickSort(int[] arr, int left, int right, T[] arr2) {
        int leftM = left;
        int rightM = right;
        int pivot = arr[(leftM + rightM) / 2];
        do {
            while (arr[leftM] < pivot) {
                leftM++;
            }
            while (arr[rightM] > pivot) {
                rightM--;
            }
            if (leftM <= rightM) {
                if (leftM < rightM) {
                    int tmp = arr[leftM];
                    arr[leftM] = arr[rightM];
                    arr[rightM] = tmp;



                    T tmp2 = arr2[leftM];
                    arr2[leftM] = arr2[rightM];
                    arr2[rightM] = tmp2;
                }
                leftM++;
                rightM--;
            }
        } while (leftM <= rightM);

        if (leftM < right) {
            quickSort(arr, leftM, right, arr2);
        }
        if (left < rightM) {
            quickSort(arr, left, rightM, arr2);
        }
    }
}

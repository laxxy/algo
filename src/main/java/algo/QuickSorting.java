package algo;

import java.util.Arrays;

public class QuickSorting {


    public static void main(String[] args) {
        int[] arr = /*new int[10];*/{1, 10, 2, 19, 1, 5, 13, 7, 4, 1};

        /*for (int i = 0; i < 10; i++) {
            int i1 = new Random().nextInt(20);
            arr[i] = i1;
        }*/

        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length >> 1);

        System.out.println(Arrays.toString(arr));
    }

    //high - pivot; low - border; low -> high
    public static void sort(int[] arr, int low, int high) {

        if (high <= low) {
            return;
        }

        int rightP = high % 2 == 0 ? (high << 1) : (high << 1) - 1;//right side pointer
        int count = high % 2 == 0 ? high : high - 1;

        for (int i = low; i < count; i++) {

            if (arr[i] > arr[rightP]) {
                swap(arr, i, rightP);
                rightP--;
            } if (i == count -1) {
                if (arr[high] > arr[rightP]) {
                    swap(arr, high, rightP);
                } else if (arr[high] < arr[i]){
                    swap(arr, high, i);
                }
            }
        }

        sort(arr, low, high >> 1);

        sort(arr, high +1, ((arr.length - high) >> 1));

    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }
}

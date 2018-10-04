
package algo;

import java.util.*;

public class MergeSorting {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[20];

        for (int i = 0; i < 20; i++) {
            int i1 = new Random().nextInt(20);
            list.add(i1);
            arr[i] = i1;
        }

        long startTime1 = System.nanoTime();
        int[] sort1 = sort(arr);
        long stopTime2 = System.nanoTime();

        System.out.println(Arrays.toString(sort1)  + " time: " + (stopTime2 - startTime1)  + " " + sort1.length);

        System.out.println("before : " + list.toString());
        long startTime = System.nanoTime();
        int[] sort = sort1(arr);
        long stopTime = System.nanoTime();
        System.out.println(Arrays.toString(sort) + " time: " + (stopTime - startTime)  + " " + arr.length);

    }

    private static int[] sort1(int[] list) {
        if (list.length < 2) return list;

        int[] sub1 = Arrays.copyOfRange(list, 0, list.length >> 1);
        int[] sub2 = Arrays.copyOfRange(list, list.length >> 1, list.length);

        return merge1(sort1(sub1), sort1(sub2));
    }

    private static int[] merge1(int[] sort, int[] sort1) {
        int p1 = 0;
        int p2 = 0;
        int[] list = new int[sort.length + sort1.length];
        for (int i = 0; i < sort.length + sort1.length; i++) {
            if (sort.length == p1)
                list[i] = sort1[p2++];
            else if (sort1.length == p2)
                list[i] = sort[p1++];
            else{
                if (sort1[p2] < sort[p1])
                    list[i] = sort1[p2++];
                else list[i] = sort[p1++];
            }
        }
        return list;
    }

    public static int[] sort(int[] arr){
        if(arr.length < 2) return arr;
        int m = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, m);
        int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return merge(sort(arr1), sort(arr2));
    }

    public static int[] merge(int[] arr1, int arr2[]){
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1=0;
        int i2=0;
        for(int i=0;i<n;i++){
            if(i1 == arr1.length){
                arr[i] = arr2[i2++];
            }else if(i2 == arr2.length){
                arr[i] = arr1[i1++];
            }else{
                if(arr1[i1] < arr2[i2]){
                    arr[i] = arr1[i1++];
                }else{
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;
    }
}

package data_structures;

import java.util.*;

public class Sorts<E extends Comparator> {
    public static <E> void print(E array[]){
        for(int i=0;i< array.length;i++){
            System.out.println(array[i].toString());
        }
    }

    public static <E extends Comparable<? super E>> void bubbleSort(E array[], Comparator<? super E> c){
        int length =  array.length;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(c != null){
                    if(c.compare(array[j],array[i])<0){
                        swap(array, i, j);
                    }
                }else{
                    if(array[j].compareTo(array[i])<0){
                        swap(array, i, j);
                    }
                }
            }
        }
    }

    public static <E extends Comparable<? super E>> void selectSort(E array[], Comparator<? super E> c){
        int length =  array.length;
        for(int i=0;i<length;i++){
            int min = i;
            for(int j=i+1;j<length;j++){
                if(c != null){
                    if(c.compare(array[j],array[min])<0){
                        min = j;
                    }
                }else{
                    if(array[j].compareTo(array[min])<0){
                        min = j;
                    }
                }
            }
            swap(array, i, min);
        }
    }

    public static <E extends Comparable<? super E>> void quickSort(E array[], int start, int end, Comparator<? super E> c){
        if(start < end){
            E key = array[start];
            int i = start;
            for(int j=start+1;j<=end;j++){
                if(c != null){
                    if(c.compare(key,array[j])>0){
                        swap(array, j, ++i);
                    }
                }else{
                    if(key.compareTo(array[j])>0){
                        swap(array, j, ++i);
                    }
                }
            }
            array[start] = array[i];
            array[i] = key;
            quickSort(array, start, i-1,c);
            quickSort(array, i+1, end,c);
        }
    }

    public static void  myquicksort(int[] arr, int start, int end){
        if(start<end){
            int key = arr[start];
            int i = start;
            for(int j=start+1;j<=end;j++){
                if(arr[j]<key){
                    myswap(arr, j, ++i);
                }
            }
            arr[start] = arr[i];
            arr[i] = key;
            myquicksort(arr, start, i-1);
            myquicksort(arr,i+1, end);
        }
    }
    static void myswap(int[] arr, int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static <E extends Comparable<? super E>> void insertSort(E array[], Comparator<? super E> c){
        int length =  array.length;
        for(int i=1;i<length;i++){
            E key = array[i];
            int position = i;
            for(int j=i-1;j>=0;j--){
                if(c != null){
                    if(c.compare(array[i],array[j])<0){
                        array[j+1] = array[j];
                        position --;
                    }else{
                        break;
                    }
                }else{
                    if(array[i].compareTo(array[j])<0){
                        array[j+1] = array[j];
                        position --;
                    }else{
                        break;
                    }
                }
            }
            array[position] = key;
        }
    }

    public static <E extends Comparable<? super E>> void mergeSort(E array[], int left, int right, Comparator<? super E> c){
        if(left < right){
            int center = (left + right) /2;
            mergeSort(array, left, center, c);
            mergeSort(array, center+1, right, c);
            merge(array, left, center, right,c);
        }
    }

    private static <E extends Comparable<? super E>> void merge(E[] array, int left, int center, int right, Comparator<? super E> c) {
        E[] tmp = (E[]) new Comparable[array.length];
        int tempIndex = left;
        int _left = left;
        int _right = center+1;
        while(_left <=center && _right <=right){
            if(c!=null){
                if(c.compare(array[_left],array[_right])<=0){
                    tmp[tempIndex++] = array[_left++];
                }else{
                    tmp[tempIndex++] = array[_right++];
                }
            }else{
                if(array[_left].compareTo(array[_right])<=0){
                    tmp[tempIndex++] = array[_left++];
                }else{
                    tmp[tempIndex++] = array[_right++];
                }
            }
            while(_right <= right){
                tmp[tempIndex++] = array[_right++];
            }
            while(_left <= center){
                tmp[tempIndex++] = array[_left++];
            }

            while(left <=right){
                array[left] = tmp[left++];
            }
        }
    }


    private static <E extends Comparable<? super E>> void swap(E[] array, int i, int j) {
        E temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static int[] shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int current = arr[i];
                int preIndex = i - gap;
                // Insertion sort
                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;

            }
            gap /= 2;
        }
        return arr;
    }

    // start和end为前闭后闭
    public static void nonRec_quickSort(int[] a, int start, int end) {
        // 用栈模拟
        Stack<Integer> stack = new Stack<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    private static int partition(int[] a, int start, int end) {
        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot)
                end--;
            a[start] = a[end];
            while (start < end && a[start] <= pivot)
                start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }


    /**
     * Gets the maximum and minimum values in the array
     *
     * @param arr
     * @return
     */
    private static int[] getMinAndMax(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            } else if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        return new int[] { minValue, maxValue };
    }

    /**
     * Counting Sort
     *
     * @param arr
     * @return
     */
    public static int[] countingSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] extremum = getMinAndMax(arr);
        int minValue = extremum[0];
        int maxValue = extremum[1];
        int[] countArr = new int[maxValue - minValue + 1];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - minValue] += 1;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = countArr[arr[i] - minValue] - 1;
            result[idx] = arr[i];
            countArr[arr[i] - minValue] -= 1;
        }
        return result;
    }

    public static int[] mycountingSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] extremum = getMinAndMax(arr);
        int minValue = extremum[0];
        int maxValue = extremum[1];
        int[] countArr = new int[maxValue - minValue + 1];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - minValue] += 1;
        }

        for (int i = 0,j=0; i <arr.length&&j<countArr.length;j++) {
            while(countArr[j]>0){
                countArr[j] = countArr[j]-1;
                result[i++] = minValue+j;
            }
        }
        return result;
    }


    /**
     * Radix Sort
     *
     * @param arr
     * @return
     */
    public static int[] radixSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int N = 1;
        int maxValue = arr[0];
        for (int element : arr) {
            if (element > maxValue) {
                maxValue = element;
            }
        }
        while (maxValue / 10 != 0) {
            maxValue = maxValue / 10;
            N += 1;
        }
        for (int i = 0; i < N; i++) {
            List<List<Integer>> radix = new ArrayList<>();
            for (int k = 0; k < 10; k++) {
                radix.add(new ArrayList<Integer>());
            }
            for (int element : arr) {
                int idx = (element / (int) Math.pow(10, i)) % 10;
                radix.get(idx).add(element);
            }
            int idx = 0;
            for (List<Integer> l : radix) {
                for (int n : l) {
                    arr[idx++] = n;
                }
            }
        }
        return arr;
    }
}

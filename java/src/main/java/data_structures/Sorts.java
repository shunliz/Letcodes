package data_structures;

import java.util.Comparator;

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
}

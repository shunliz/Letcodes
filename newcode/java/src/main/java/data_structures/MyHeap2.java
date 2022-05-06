package data_structures;

public class MyHeap2 {
    int[] data;
    int size;

    public MyHeap2(){
        data = new int[10];
        size = 0;
    }

    public boolean add(int x){
        if(size == 0){
            data[0] = x;
        }
        siftUp(x);
        size++;
        return true;
    }

    private void siftUp(int x) {
        data[size] = x;
        int s = size;
        while(s>0){
            int parent = s/2;
            int pData = data[parent];
            if(x >pData){
                break;
            }
            data[s] = pData;
            s = parent;
        }
    }

    public int remove(){
        if(size ==0){
            throw new IllegalArgumentException("empty heap ");
        }
        int res = data[0];
        data[size] = 0;
        size--;
        siftDown(0, data[size]);

        return data[size];
    }

    private void siftDown(int start, int x) {
        int indx = start;
        while(indx<size){
            int lc = indx*2+1;
            int rc = indx*2+2;
            int minchild =data[lc]>data[rc]?rc:lc;
            if(x<data[minchild]){
                break;
            }
            data[indx] = data[minchild];
            indx = minchild;
        }
        data[indx] = x;
    }

    public void heapfiy(){
        for(int j= size/2-1;j>=0;j--){
            siftDown(j, data[j]);
        }
    }

    public int[] sort(){
        int[] res = new int[size];
        for(int i=0;i<size;i++){
            res[i] = this.remove();
        }
        return res;
    }
}

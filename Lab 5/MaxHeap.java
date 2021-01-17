//Liam Strijckers
//strijckl
//400179278

public class MaxHeap {
    private Integer[] heapArr;
    
    private int MaxHeapSize; //the max size of the heap 
    private int HeapSize; //size of the heap/the number of nodes in the heap
    //setting up the getters
    public Integer[] getHeap() {return heapArr;}
    public int getCapacity() {return MaxHeapSize;}
    public int getSize() {return HeapSize;}
    //Constructors
    public MaxHeap(int n) {//creates an array to be the heap with a max size of n
        HeapSize = 0;
        heapArr = new Integer[n];
        MaxHeapSize = n;
    }
    
    public MaxHeap(Integer[] someArray) {//creates a heap with the max size of the length 
        //and puts all the values from the input array into the heap using the insert function
        heapArr = new Integer[someArray.length];
        MaxHeapSize = someArray.length;       
        for(int i = 0; i < MaxHeapSize; i++) {
            insert(someArray[i]);
        }
    }
    //functions
    public void insert(int n) {
        if(MaxHeapSize == HeapSize) { //checks to see if the heap array is full
            Integer[] tempArr = new Integer[HeapSize*2]; //if so it doubles the original size of the array
            for(int i = 0; i < HeapSize; i++) {//puts everything in the temp array
                tempArr[i] = heapArr[i];
            }
            MaxHeapSize *= 2;//doubles the size
            heapArr = tempArr;//makes the heap array the temp array
        }heapArr[HeapSize] = n;//inserts the values at the last node
        int index = HeapSize;
        int placeholder;
        while(heapArr[(index-1)/2] < heapArr[index]) {//while the child is larger than the parent it swaps the values at those nodes  
            //to maintain a heap
            placeholder = heapArr[(index-1)/2];
            heapArr[(index-1)/2] = heapArr[index];
            heapArr[index] = placeholder;
            index--;//i = (i-1)/2;
            index/=2;//moves the index back to the 
        }HeapSize++;
    }
    
    private int deleteMax(){
        int index = 0;
        int MaxValue = heapArr[index];//removes the max value 
        while(((index*2)+2) < (HeapSize)){ //while the index is less than the size of the heap
            if(heapArr[(index*2)+1] >= heapArr[(index*2)+2]){//if the left node is larger than the right node
                heapArr[index] = heapArr[(index*2)+1];//makes the left node the top node
                index*=2;//i = (i*2) + 1;
                index++;//changes the index to be at that node
            }else{//if the right node is larger it makes the top node the right node
                heapArr[index] = heapArr[(index*2) + 2];
                index*=2;//i = (i*2) + 2;
                index++;//changes the index to be at that node
                index++;
            }
        }HeapSize--;
        heapArr[index] = heapArr[HeapSize];
        int swap;
        while(heapArr[(index-1)/2] < heapArr[index]){//while the parent is smaller than the child
            swap = heapArr[(index-1)/2];//swaps the values of the parent and child node
            heapArr[(index-1)/2] = heapArr[index];
            heapArr[index] = swap;
            index--;//i = (i-1)/2;
            index/=2;//moves the index back to the parent
        }return MaxValue;
    }
    
    public String toString(){//returns the heap in a string
        String result = "";
        for(int i = 0; i < HeapSize; i++) {
            result = result + heapArr[i] + ", ";
        }return result;
    }
    
    public static void heapsort(Integer[] arrayToSort){//sorts the heap from largest to smallest uising the deleteMax()
        //to get the largest number ever time
        MaxHeap heapArr = new MaxHeap(arrayToSort);
        for(int i = 0; i<heapArr.MaxHeapSize; i++){
            arrayToSort[i] = heapArr.deleteMax();
        }
    }
}

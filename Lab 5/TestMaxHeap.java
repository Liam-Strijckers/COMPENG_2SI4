//Liam Strijckers
//strijckl
//400179278

public class testingHeaps {
     public static void main(String[] args) {
          Integer[] temp = new Integer[7];
        int s=1;
        for(int i=0;i<7;i++){
            temp[i]=s;
            s++;
        }
        System.out.println("Test 1");
        System.out.println(" ");
        System.out.println(" ");
        MaxHeap test = new MaxHeap(temp);
        System.out.println("The heap size is (should be 7): ");
        System.out.println(test.getSize());
        System.out.println("The heap capacity is (should be 7): ");
        System.out.println(test.getCapacity());
        System.out.println("The heap is (should be 7,4,6,1,3,2,5): ");
        System.out.println(test.toString());
        test.insert(51);
        System.out.println("Insert 51 into the heap");
        System.out.println("The heap size is (should be 8): ");
        System.out.println(test.getSize());
        System.out.println("The heap capacity is (should be 14): ");
        System.out.println(test.getCapacity());
        System.out.println("The heap is (should be 51,7,6,4,3,2,5,1): ");
        System.out.println(test.toString());
        test.insert(28);
        test.insert(65);
        test.insert(42);
        test.insert(9);
        test.insert(8);
        System.out.println("Insert 28,65,42,9,8 into the heap");
        System.out.println("The heap size is (should be 13): ");
        System.out.println(test.getSize());
        System.out.println("The heap capacity is (should be 14): ");
        System.out.println(test.getCapacity());
        System.out.println("The heap is (should be 65,51,9,7,42,8,5,1,4,3,28,2,6): ");
        System.out.println(test.toString());
        System.out.println("The heapsort is (should be 65,51,42,28,9,8,7,6,5,4,3,2,1): ");
        Integer [] heaptest = new Integer[]{65,51,42,28,9,8,7,6,5,4,3,2,1};
        test.heapsort(heaptest);
        for(int i=0; i<heaptest.length;i++){
            System.out.print(heaptest[i]+",");
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Test 2");
        System.out.println(" ");
        System.out.println(" ");
        MaxHeap test2 = new MaxHeap(2);
        System.out.println("The heap size is (should be 0): ");
        System.out.println(test2.getSize());
        System.out.println("The heap capacity is (should be 2): ");
        System.out.println(test2.getCapacity());
        System.out.println("The heap is (should be null): ");
        System.out.println(test2.toString());
        test2.insert(6);
        test2.insert(104);
        test2.insert(805);
        test2.insert(-9);
        test2.insert(23);
        System.out.println("Insert 6,104,805,-9,23 into the heap");
        System.out.println("The heap size is (should be 5): ");
        System.out.println(test2.getSize());
        System.out.println("The heap capacity is (should be 8): ");
        System.out.println(test2.getCapacity());
        System.out.println("The heap is (should be 805,23,104,-9,6): ");
        System.out.println(test2.toString());
        int[] insertheap = new int[]{85,45,72,2,0,-85,3};
        for(int i=0;i<insertheap.length;i++){
            test2.insert(insertheap[i]);
        }
        System.out.println("Insert 85,45,72,2,0,-85,3 into the heap");
        System.out.println("The heap size is (should be 11): ");
        System.out.println(test2.getSize());
        System.out.println("The heap capacity is (should be 16): ");
        System.out.println(test2.getCapacity());
        System.out.println("The heap is (should be 805,72,104,23,6,85,45,-9,2,0,-85,3): ");
        System.out.println(test2.toString());
        Integer [] heaptest2 = new Integer[]{805,72,104,23,6,85,45,-9,2,0,-85,3};
        System.out.println("The heap is (should be 805,104,85,72,45,23,6,3,2,0,-9,-85): ");
        test.heapsort(heaptest2);
        for(int i=0; i<heaptest2.length;i++){
            System.out.print(heaptest2[i]+",");
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Strijckers
 */
public class TestBSTSet {
    public static void main(String[] args) {
        
        
        int [] test1 = new int[]{5,3,2,7,4,8,6};
        int [] emptytest = new int[]{};
        int [] roottest = new int[]{6};
        int [] test2 = new int[]{20,22,18,21,23,17,19};
        int [] test3 = new int[]{2,5,7,13,16,3};
        
        
        System.out.println("Creating a tree and sorting from the input {5,3,2,7,4,8,6}");
        System.out.println("Expected output: {2,3,4,5,6,7,8}");
        BSTSet temp = new BSTSet(test1);
        temp.printBSTSet();
        System.out.println();
        System.out.println("check if 5 is in");
        System.out.println("Expected output: True");
        System.out.println(temp.isIn(5));
        System.out.println();
        System.out.println("check if 12 is in");
        System.out.println("Expected output: False");
        System.out.println(temp.isIn(12));
        System.out.println();
        System.out.println("adding 7");
        System.out.println("Expected output: {2,3,4,5,6,7,8}");
        temp.add(7);
        temp.printBSTSet();
        System.out.println();
        System.out.println("adding 1 and 12");
        System.out.println("Expected output: {1,2,3,4,5,6,7,8,12}");
        temp.add(1);
        temp.add(12);
        temp.printBSTSet();
        System.out.println();
        System.out.println("removing 13");
        System.out.println("Expected output: {1,2,3,4,5,6,7,8,12}");
        temp.remove(13);
        temp.printBSTSet();
        System.out.println();
        System.out.println("removing 1 and 12");
        System.out.println("Expected output: {2,3,4,5,6,7,8}");
        temp.remove(1);
        temp.remove(12);
        temp.printBSTSet();
        System.out.println();
        System.out.println("Union of {5,3,2,7,4,8,6} and {2,5,7,13,16,3}");
        System.out.println("Expected output: {2,3,4,5,6,7,8,13,16}");
        BSTSet temp2 = new BSTSet(test3);
        BSTSet union = temp.union(temp2);
        union.printBSTSet();
        System.out.println();
        System.out.println("Union of {5,3,2,7,4,8,6} and {}");
        System.out.println("Expected output: {2,3,4,5,6,7,8}");
        temp2 = new BSTSet(emptytest);
        union = temp.union(temp2);
        union.printBSTSet();
        System.out.println();
        System.out.println("difference of {5,3,2,7,4,8,6} and {}");
        System.out.println("Expected output: {2,3,4,5,6,7,8}");
        temp2 = new BSTSet(emptytest);
        BSTSet difference = temp.difference(temp2);
        difference.printBSTSet();
        System.out.println();
        System.out.println("difference of {5,3,2,7,4,8,6} and {20,22,21,18,19,21,17,23}");
        System.out.println("Expected output: {17,18,19,20,21,22,23}");
        temp2 = new BSTSet(test2);
        temp = new BSTSet(test1);
        difference = temp.difference(temp2);
        difference.printBSTSet();
        System.out.println();
        System.out.println("difference of {5,3,2,7,4,8,6} and {20,22,21,18,19,21,17,23}");
        System.out.println("Expected output: {13,16}");
        temp2 = new BSTSet(test3);
        temp = new BSTSet(test1);
        difference = temp.difference(temp2);
        difference.printBSTSet();
        System.out.println();
        System.out.println("Size and height of {5,3,2,7,4,8,6}");
        System.out.println("Expected output: size of 7, height of 2");
        temp = new BSTSet(test1);
        System.out.println("the size is: "+temp.size());
        System.out.println("the height is: "+temp.height());
        System.out.println();
        System.out.println("Size and height of {20,22,21,18,19,17,23}");
        System.out.println("Expected output: size of 7, height of 2");
        temp = new BSTSet(test2);
        System.out.println("the size is: "+temp.size());
        System.out.println("the height is: "+temp.height());
        System.out.println();
        temp = new BSTSet(emptytest);
        System.out.println("Size and height of {}(empty tree)");
        System.out.println("Expected output: size of 0, height of -1");
        System.out.println("the size of an is: "+temp.size());
        System.out.println("the height is: "+temp.height());
        System.out.println();
        System.out.println("tesing the printNonRec()");
        System.out.println("Expected output: {2,3,4,5,6,7,8}");
        temp = new BSTSet(test1);
        temp.printNonRec();
        
        
        
               
        /*int [] nullArray = new int []{};
        int [] oneNode = new int []{1};
        int [] baseOf2 = new int []{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int [] randArray = new int [] {48,859,223,395,97,765,45,23,4356,2,51,7,123,420,69,8235,329};
        int [] randDoubles = new int [] {12,76,36,284,12,253,99,420,282,638,5859,295,198,24,24};


        System.out.println("Creating a tree and sorting {48,859,223,395,97,765,45,23,4356,2,51,7,123,420,69,8235,329}");
        System.out.println("Expected output: {2, 7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 395, 420, 765, 859, 4356, 8235}");
        BSTSet randomTree = new BSTSet(randArray);
        randomTree.printBSTSet();
        System.out.println();

        System.out.println("Creating a tree and sorting a list with doubles {12,76,36,284,12,253,99,420,282,638,5859,295,198,24,24}");
        System.out.println("Expected output: {12, 24, 36, 76, 99, 198, 253, 282, 284, 295, 420, 638, 5859}");
        BSTSet randomTree2 = new BSTSet(randDoubles);
        randomTree2.printBSTSet();
        System.out.println();

        System.out.println("Creating a null tree {}");
        System.out.println("Expected output: The set is empty");
        BSTSet nullTree = new BSTSet(nullArray);
        nullTree.printBSTSet();
        System.out.println(); 

        System.out.println("Creating a tree with a single node {1}");
        System.out.println("Expected output: {1}");
        BSTSet singleNode = new BSTSet(oneNode);
        singleNode.printBSTSet();
        System.out.println(); 

        System.out.println("Checking to see if 420 is in {48,859,223,395,97,765,45,23,4356,2,51,7,123,420,69,8235,329}");
        System.out.println("Expected output: true");
        System.out.println(randomTree.isIn(420));
        System.out.println(); 

        System.out.println("Checking to see if 563 is in {48,859,223,395,97,765,45,23,4356,2,51,7,123,420,69,8235,329}");
        System.out.println("Expected output: false");
        System.out.println(randomTree.isIn(563));
        System.out.println();  

        System.out.println("Adding 333 to {48,859,223,395,97,765,45,23,4356,2,51,7,123,420,69,8235,329}");
        System.out.println("Expected output: {2, 7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        randomTree.add(333);
        randomTree.printBSTSet();
        System.out.println();  

        System.out.println("Adding 123 to {}");
        System.out.println("Expected output: {123}");
        BSTSet empty = new BSTSet(nullArray);
        empty.add(123);
        empty.printBSTSet();
        System.out.println();   

        System.out.println("Adding 1 to {1}");
        System.out.println("Expected output: {1}");
        singleNode.add(1);
        singleNode.printBSTSet();
        System.out.println();

        System.out.println("Removing 2 from {48,859,223,395,97,765,45,23,4356,2,51,7,123,420,69,8235,329}");
        System.out.println("Expected output: true;{7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        System.out.print(randomTree.remove(2)+";");
        randomTree.printBSTSet();
        System.out.println(); 

        System.out.println("Removing 49 from {48,3859,23,39,987,765,45,23,456,2,5,7,123,98,34,8375,328}");
        System.out.println("Expected output: false;{7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        System.out.print(randomTree.remove(49)+";");
        randomTree.printBSTSet();
        System.out.println();

        System.out.println("Removing 1 from {1}");
        System.out.println("Expected output: true;{}");
        System.out.print(singleNode.remove(1)+";");
        singleNode.printBSTSet();
        singleNode.add(1);
        System.out.println();

        System.out.println("Removing 1 from {}");
        System.out.println("Expected output: false;{}");
        System.out.print(nullTree.remove(1)+";");
        nullTree.printBSTSet();
        System.out.println();


        System.out.println("Union between {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235} and {12, 24, 36, 76, 99, 198, 253, 282, 284, 295, 420, 638, 5859}");
        System.out.println("Expected output: 7, 12, 23, 24, 36, 45, 48, 51, 69, 76, 97, 99, 123, 198, 223, 253, 282, 284, 295, 329, 333, 395, 420, 638, 765, 859, 4356, 5859, 8235}");
        BSTSet union = randomTree.union(randomTree2);
        union.printBSTSet();
        System.out.println();

        System.out.println("Union between {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235} and {}");
        System.out.println("Expected output: {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        BSTSet union2 = randomTree.union(nullTree);
        union2.printBSTSet();
        System.out.println();

        System.out.println("Union between {} and {}");
        System.out.println("Expected output: The set is empty");
        BSTSet union3 = nullTree.union(nullTree);
        union3.printBSTSet();
        System.out.println();

        System.out.println("Intersection between {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235} and {12, 24, 36, 76, 99, 198, 253, 282, 284, 295, 420, 638, 5859}");
        System.out.println("Expected output: {420}");
        BSTSet intersection = randomTree.intersection(randomTree2);
        intersection.printBSTSet();
        System.out.println();

        System.out.println("Intersection between {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235} and {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        System.out.println("Expected output: {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        BSTSet intersection1 = randomTree.intersection(randomTree);
        intersection1.printBSTSet();
        System.out.println();

        System.out.println("Intersection between {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235} and {1}");
        System.out.println("Expected output: The set is empty");
        BSTSet intersection2 = randomTree.intersection(singleNode);
        intersection2.printBSTSet();
        System.out.println(); 

        System.out.println("Intersection between {} and {1}");
        System.out.println("Expected output:The set is empty");
        BSTSet intersection3 = nullTree.intersection(singleNode);
        intersection3.printBSTSet();
        System.out.println();

        
        
        
        
        
        
        
        
        System.out.println("Difference between {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235} and {12, 24, 36, 76, 99, 198, 253, 282, 284, 295, 420, 638, 5859}");
        System.out.println("Expected output: {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 765, 859, 4356, 8235}");
        BSTSet difference = randomTree.difference(randomTree2);
        difference.printBSTSet();
        System.out.println();

        System.out.println("Difference between {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235} and {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        System.out.println("Expected output: {}");
        BSTSet difference1 = randomTree.difference(randomTree);
        difference1.printBSTSet();
        System.out.println();

        System.out.println("Intersection between {1} and {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        System.out.println("Expected output: {1}");
        BSTSet difference2 = singleNode.difference(randomTree);
        difference2.printBSTSet();
        System.out.println(); 

        System.out.println("Difference between {} and {1}");
        System.out.println("Expected output: The set is empty");
        BSTSet difference3 = nullTree.difference(singleNode);
        difference3.printBSTSet();
        System.out.println();

        System.out.println("Size of {1}");
        System.out.println("Expected output: 1");
        System.out.println(singleNode.size());
        System.out.println();

        System.out.println("Size of {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        System.out.println("Expected output: 17");
        System.out.println(randomTree.size());
        System.out.println();

        System.out.println("Size of {}");
        System.out.println("Expected output: 0");
        System.out.println(nullTree.size());
        System.out.println();

        System.out.println("Depth of {1}");
        System.out.println("Expected output: 1");
        System.out.println(singleNode.height());
        System.out.println();

        System.out.println("Depth of {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        System.out.println("Expected output: 5");
        System.out.println(randomTree.height());
        System.out.println();

        System.out.println("Depth of set with even depth {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}");
        System.out.println("Expected output: 4");
        BSTSet base2 = new BSTSet(baseOf2);
        System.out.println(base2.height());
        System.out.println();

        System.out.println("Depth of {}");
        System.out.println("Expected output: -1");
        System.out.println(nullTree.height());
        System.out.println();

        System.out.println("Depth of union {10, 11, 12, 13, 14, 15, 16, 17, 18} and {9, 8, 7, 6, 5, 4, 3, 2, 1");
        System.out.println("Expected output: 5");
        int[] higher = new int[] {10, 11, 12, 13, 14, 15, 16, 17, 18};
        BSTSet h1= new BSTSet (higher);
        int[] lower= new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        BSTSet h2= new BSTSet (lower);
        System.out.println(h1.union(h2).height());
        System.out.println();

        System.out.println("Depth of union {10, 11, 12, 13, 14, 15} and {9, 8, 7, 6, 5, 4, 3, 2, 1");
        System.out.println("Expected output: 4");
        int[] higher2 = new int[] {10, 11, 12, 13, 14, 15};
        BSTSet h3= new BSTSet (higher2);
        int[] lower2= new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        BSTSet h4= new BSTSet (lower2);
        System.out.println(h3.union(h4).height());
        System.out.println();  

        System.out.println("Printing non-recursivally {48,859,223,395,97,765,45,23,4356,2,51,7,123,420,69,8235,329}");
        System.out.println("Expected output: {7, 23, 45, 48, 51, 69, 97, 123, 223, 329, 333, 395, 420, 765, 859, 4356, 8235}");
        randomTree.printNonRec();
        System.out.println();

        System.out.println("Printing non-recursivally {12,76,36,284,12,253,99,420,282,638,5859,295,198,24,24}");
        System.out.println("Expected output: {12, 24, 36, 76, 99, 198, 253, 282, 284, 295, 420, 638, 5859}");
        randomTree2.printNonRec();
        System.out.println();

        System.out.println("Printing non-recursivally {}");
        System.out.println("Expected output: {}");
        nullTree.printNonRec();
        System.out.println(); 

        System.out.println("Printing non-recursivally {1}");
        System.out.println("Expected output: {1}");
        singleNode.printNonRec();
        System.out.println(); /*
		int[] d1 = {7, 0, 16, 3, 2, 11, 8, 9, 4}; //no repetitions
		int[] d2 = {5, 6, 5, 1, 2, 2, 4, 9, 8, 20, 32, 3, 17};//with repetitions
		int v1 = 11; //value in set d1
		int v2 = 10; //value not in set d1
		int v3 = 0; //another value in set d1

		int[] d3 = {17, 2, 9, 8, 30}; //has elements in common with d1
		int[] d4 = {6, 1, 10, 12, 5}; //no common elements with d1

		int[] d6 = {2, 4, 6, 8, 11, 10, 14, 15, 18, 24, 22, 35, 28, 29}; //almost sorted array
		int[] d7 = {1, 3, 6, 10, 11, 22, 28, 35}; // sorted; has elements in common with d6		

		System.out.println("Test1---constructor1" );
	        BSTSet a0 = new BSTSet();
		a0.printBSTSet();
		System.out.println("\n");
				 
		System.out.println("Test2---constructor2---no repetitions" );
		BSTSet a1 = new BSTSet(d1);
		a1.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test3---constructor2---with repetitions" );
		BSTSet a2 = new BSTSet(d2);
		a2.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test4---isIn(v1)---true" );
		System.out.println("v1 is in set d1");
		System.out.println(a1.isIn(v1));
		System.out.println("\n");
		
		System.out.println("Test5---isIn(v2)---false" );
		System.out.println("v2 is in set d1");
		System.out.println(a1.isIn(v2));
		System.out.println("\n");
		
		System.out.println("Test6---add(v1)---v1 was in the set; no change" );
		a1 = new BSTSet(d1);
		a1.add(v1);
		a1.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test7---add(v2)---v2 was not in the set; it is added" );
		a1 = new BSTSet(d1);
		a1.add(v2);
		a1.printBSTSet();
		System.out.println("\n");			
		
		System.out.println("Test9---remove(v2)--v2 was not in the set; no change" );
		a1 = new BSTSet(d1);
		System.out.println(a1.remove(v2)); //false
		a1.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test10---remove(v1)--v1 was in the set; it is removed" );
		a1 = new BSTSet(d1);
		System.out.println(a1.remove(v1)); //true
		a1.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test11---remove(v3)--v3 was in the set; it is removed" );
		a1 = new BSTSet(d1);
		System.out.println(a1.remove(v3)); //true
                a1.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test12---union()---sets with common elements" );
		a1 = new BSTSet(d1);
		BSTSet a3 = new BSTSet(d3);
		BSTSet a5 = a1.union(a3); //union of d1 and d3
		a5.printBSTSet();
		System.out.println("\n");
		
		
		System.out.println("Test13---union()---sets without common elements" );
		a1 = new BSTSet(d1);
		BSTSet a4 = new BSTSet(d4);
		a5 = a4.union(a1); //union of d1 and d4
		a5.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test14---intersection()---sets with common elements" );
		a1 = new BSTSet(d1);
		a3 = new BSTSet(d3);
		a5 = a3.intersection(a1); //intersection of d1 and d3
		a5.printBSTSet();
		System.out.println("\n");

		System.out.println("Test15---intersection()---sets with no common elements" );
		a1 = new BSTSet(d1);
		a4 = new BSTSet(d4);
		a5 = a1.intersection(a4); //intersection of d1 and d4; should be empty
		a5.printBSTSet();
		System.out.println("\n");
		
		
		System.out.println("Test16---intersection()---with empty set" );
		a0 = new BSTSet(); //empty set
		a1 = new BSTSet(d1);
		a5 = a1.intersection(a0); //intersection of d1 and the empty set; should be empty
		a5.printBSTSet();
		System.out.println("\n");
		
		System.out.println("Test17---size() + height()" );
		a1 = new BSTSet(d1);
		System.out.println("The size of d1 is " + a1.size());
		System.out.println("The height d1 is " + a1.height()); //height should be minimum for bonus
		a1 = new BSTSet(d6);
		System.out.println("The size of d6 is " + a1.size());
		System.out.println("The height of d6 is " + a1.height()); 

		
		System.out.println("Test18---size() + height()---empty set" );
		a0 = new BSTSet(); //empty set
		System.out.println("The size of the empty set is " + a0.size()); // should be 0
		System.out.println("The height of the empty set is " + a0.height());//should be -1
                System.out.println();

		System.out.println("Test19---printNonRec()--elements should be in increasing order" );
		a1 = new BSTSet(d1);
		a1.printNonRec(); //set d1
                System.out.println();
		a1 = new BSTSet(d6);
		a1.printNonRec(); //set d6
                System.out.println();


		//Test bonus
		System.out.println("Test21---bonus" );
		a1 = new BSTSet(d6);
		System.out.println("The height of d6 is " + a1.height());
		a2 = new BSTSet(d7);
		System.out.println("The height of d7 2 is " + a2.height());
		a3 = a1.union(a2); 
		a4 = a1.intersection(a2);
		System.out.println("Print union:");
		a3.printBSTSet(); 
		System.out.println("The height of the union is " + a3.height());
		System.out.println("Print intersection:");
		a4.printBSTSet(); 
		System.out.println("The height of the intersection is " + a4.height());
	*/	
	}

}

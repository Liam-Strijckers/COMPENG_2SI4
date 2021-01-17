/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Strijckers
 */

public class BSTSet {
    private TNode root;
    
    public BSTSet(){root=null;}
    
    public BSTSet(int[] input){//nlogn time complexity     
        int size = input.length;
        for(int a = 0; a<size; a++){//finds duplicate elements from the input      
            for(int b = a+1; b<size; b++){    
                if(input[b] ==input[a]){
                    int temp = b;
                    for(int c = b+1;c<size;c++){input[temp] = input[c];}//puts the duplicate as the next element after its original and moves everything over one 
                    size--;//makes the size of the array smaller by one since there is an duplicate
                    temp++;
                } 
            }
        }       
        int placeholder = input.length;
        for(int a=0; a<placeholder-1;a++){//this sorts the tree into increasing order    
            int temp = a;
            for(int b = a+1;b<placeholder;b++){        
                if(input[temp]>input[b]){temp = b;}
                int min = input[temp];
                input[temp] = input[a];
                input[a] = min;
            }
        }       
        this.Build(input, 0, input.length-1);//builds the tree from the given array
    }
    
    public void Build(int[] tree, int beginning, int last){//logn time complexity
        if(beginning<=last){   //adds all values from array until there is none left(when low = high all the values in array have been used)
            int middleNode = (beginning+last+1)/2;       //starts at the middle of the array and gives the root the middle value
            this.add(tree[middleNode]);           
            Build(tree,beginning,middleNode-1);    //cycles through left subtree
            Build(tree,middleNode+1,last);   //cycles through right subtree
        }     
    }
    
    public boolean isIn(int v){//n time complexity
        if(root == null){return false;}    //if the value is not in the tree return false
        TNode tempNode = root;
        while(tempNode!=null){//goes through all the nodes in the tree
            if(tempNode.element == v){return true;}//if the node is found it returns true
            if(tempNode.element >v){tempNode = tempNode.left;}//if the inputted values is smaller than the comparison then go left on the tree
            else{tempNode = tempNode.right;}//if the inputted values is larger than the comparison then go right on the tree
        }return false;//if it goes through the tree and can't find the value, return false 
    }
    
    public void add(int v){//logn time complexity
        TNode nextNode;
        TNode node = root;
        if(node == null){ //checks to see if the tree is empty
            root = new TNode(v, null, null);
            return;
        }nextNode=node;
        while(nextNode != null){//goes through the tree to find where to add it
            node = nextNode;
            if( node.element>v) {nextNode = node.left;}//if the inputted values is smaller than the comparison then go left on the tree
            else if(node.element<v) {nextNode = node.right;}//if the inputted values is larger than the comparison then go right on the tree
            else {return;}//if it gets to this point the value is already in the tree so it is not added
        }if(node.element>v){node.left = new TNode(v, null, null);}//decides which side of the node the inputted value goes on dependant on it's value and the node value
        else if(node.element<v){  node.right = new TNode(v, null, null);}
    }
    
    public boolean remove(int v){//logn time complexity
        if(isIn(v)==false){return false;}//if the inputted number is not in the tree, return false
        else{//if the value is in the tree delete the node and return true
            delNode(v,root);
            return true;
        }
    }
   
    private TNode delNode(int num, TNode tempNode){
        if(num<tempNode.element){tempNode.left = delNode(num,tempNode.left);}//uses recursion to find where the node with the inputted value is in the tree 
        else if(num>tempNode.element){tempNode.right = delNode(num,tempNode.right);}  
        else if(tempNode.left!=null && tempNode.right!=null){//if the node has two children then it's value is replaced with the smallest value from the right subtree 
            tempNode.element  = (MinInTree(tempNode.right)).element;//finding the min value in the right sub tree
            tempNode.right = minimumRemover(tempNode.right);//removes the node
        }else{tempNode = (tempNode.left!=null) ? tempNode.left : tempNode.right;}//if the node has one child, the child replaces that value
        return tempNode;
    }
    private TNode minimumRemover(TNode t){
        if(t.left != null){ t.left =minimumRemover(t.left);}//finds the left most/smallest leaf in the tree and removes it
        else{t= t.right;}
        return t;
    }
    private TNode MinInTree(TNode t){
        TNode min = t;//finds the minimum in the tree which is just the left most element
        while(t.left!=null){  
            t=t.left;
            min = t;
        }
        return min;
    }
    
   public BSTSet union(BSTSet s){//nlogn time complexity
       if(this.root ==null || s.root ==null){//if either one of the trees is empty then it returns the other tree since it's a union with nothing 
          if(s.root==null){return this;}
          else{return s;}
       }BSTSet merge = new BSTSet();//creates a new tree for the union
        TNode index = s.root;//defines a new root for the union
        newTreeBuilder(this.root,merge);//takes this root and tree to build a new tree
        merge.MergeTrees(index);//adds the element from both tree into the one tree
        return merge;             
    }
   private BSTSet MergeTrees(TNode tempNode){
       if(tempNode!=null){
           this.add(tempNode.element);//uses the add function to add to the new tree and to make sure the same numbers aren't added again
           this.MergeTrees(tempNode.left);//traverses the entire tree using recursion and add all the node in the tree
           this.MergeTrees(tempNode.right);
       }
       return this;
   }
   private void newTreeBuilder(TNode t, BSTSet s){
       if(t==null){return;}
       else{
           s.add(t.element);//generates a new tree wihtout any duplicatations
           if(t.left!=null){newTreeBuilder(t.left,s);}//uses recursion to create every node      
           if(t.right!=null){newTreeBuilder(t.right,s);}     
       }
   }
    
    public BSTSet intersection(BSTSet s){//nlogn time complexity
        if(s.root ==null || s.root==null){ return new BSTSet();}//if one of the tree is empty the intersection is empty
        BSTSet same = new BSTSet();//creates a new tree for the intersection
        TNode temp = s.root;//defines a new root for the intersection
        interOfTrees(temp,same);//calls to add the values that intersect
        return same;
    }
    private void interOfTrees(TNode tempNode, BSTSet set){
        if(tempNode!=null){
            if(this.isIn(tempNode.element)==true){set.add(tempNode.element);}//uses recursion to find which values in the trees are and add them to the new tre
            if(tempNode.right!=null){this.interOfTrees(tempNode.right,set);}   
            if(tempNode.left!=null){this.interOfTrees(tempNode.left,set);}            
        }
    }
    
    public BSTSet difference(BSTSet s){//nlogn time complexity
        if(this.root ==null){return s;}//if either of the trees are empty, the other tree is returned  
        else if(s.root==null){return this;}
        TNode current = s.root;//defines a new root for the difference
        BSTSet diff = new BSTSet();//creates a new tree for the difference
        diffOfTrees(current,diff);//calls to add the values that are different
        return diff;
    }
    private void diffOfTrees(TNode tempNode, BSTSet set){
        if(tempNode!=null){
            if(this.isIn(tempNode.element) == false){set.add(tempNode.element);}//uses recursion to find which values are not in the same and add them to the tree
            if(tempNode.right!=null){this.diffOfTrees(tempNode.right,set);}      
            if(tempNode.left!=null){this.diffOfTrees(tempNode.left,set);}        
        }
    }
    
   public int size(){return this.sizeOfTree(root);}//n time complexity
   
   private int sizeOfTree(TNode tempNode){
       if(tempNode!=null){return 1+sizeOfTree(tempNode.left)+sizeOfTree(tempNode.right);}//uses recursion to return root plus the left sub tree plus the right sub tree
       else if(tempNode==null){return 0;}//if the tree is empty then the size is 0      
       else{return 0;}
   }
    
    public int height(){//n time complexity 
        if(root == null) {return -1;}//return -1 if it an empty tree
        return HeightOfBST(root);
    }
    
    private int HeightOfBST(TNode tempNode){
        if(tempNode==null){return -1;}//return -1 if it an empty tree
        if(tempNode==root && root.left==null && root.right==null){return 0;}//if it's just the root then the height is 0
        else{
            int leftHeight = HeightOfBST(tempNode.left);//finds the largest height in the left side
            int rightHeight = HeightOfBST(tempNode.right);//finds the largest height in the right side
            if(leftHeight>rightHeight){return (1+leftHeight);}//checks to see which side has a larger height and returns that
            else{return (1+rightHeight);}
        }
    }
    
    public void printBSTSet(){//n time complexity 
        if(root==null)  //returns if the tree is empty
            System.out.println("The inputted set is null/empty");
        else{   
            System.out.print("The elements in the set are: ");//calls function to print every element in the tree
            printTree(root);  
            System.out.print("\n");
        }
    }
    
    private void printTree(TNode t){
        if(t!=null){//goes throught the tree until the the leafs are reached
            printTree(t.left);//prints out the left side of the tree starting at the very left most leaf 
            System.out.print(" " + t.element + ", ");
            printTree(t.right); //prints out the right side of the tree
        }
    }
    
    public void printNonRec(){//n complexity 
        if(root==null){//if the set is empty it returns nothing 
            System.out.println("The set is empty: ");
            return ;
        }
        else{
            Stack sort = new Stack();//creates a stack to sort the element in the tree
            TNode temp = root;//create a temp root starting at the root
            while(temp!=null){ 
                sort.push(temp);//pushes all of the left sub tree into the stack
                temp = temp.left;//traverses down the left of the tree till it gets to the smallest value
            }
            while(sort.getLength()!=0){//pops all the values from the stack so that they are in increasing ourder  //"pops" (removes) all values one by one from the stack and prints these popped values
                temp = sort.pop();
                System.out.print(""+ temp.element +",");
                if(temp.right!=null){
                    temp=temp.right;//goes back to the right node of the pareent after printing the left to see if it exists 
                    while(temp!=null){//then it find the min value again and pushes that element onto the stack to it can be popped
                        //and printed next so it remains in increasing order
                        sort.push(temp);
                        temp=temp.left;
                    }
                }
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Strijckers
 */
public class Stack {
    private TNode [] nodeStack;
    private int end;
    
    Stack(){
        nodeStack = new TNode[100];
        end = 0;
    }
    public int getLength(){
        return end;
    }
    public TNode pop(){
        end--;
        return nodeStack[end];
    }
    public void push (TNode v){
        nodeStack[end] = v;
        end++;
    }
    public TNode recent (){
        return nodeStack[end-1];
    }
}

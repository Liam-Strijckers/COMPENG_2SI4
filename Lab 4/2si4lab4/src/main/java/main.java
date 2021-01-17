/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Strijckers
 */
public class main {
    public static void main(String[] args){
        HashTableLin temp = new HashTableLin(5,0.4);
        temp.insert(12);
        temp.insert(24);
        temp.insert(8);
        temp.insert(7);
        temp.insert(59);
        temp.insert(45);
        temp.printKeysAndIndexes();
    }
}

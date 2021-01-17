/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Strijckers
 */
//import static java.lang.Math;
public class HashTableLin {
    //int primeNum = 13;
    
    public int primeNum(int num){
        while(!isPrime(++num)){
        }return num;
    }
    public boolean isPrime(int temp){
        for(int i=2;i<= temp; i++){
            if(temp %i ==0){
                return false;
            }
        }return true; 
    }
    
    int length;
    int[] hashtab;
    double Load;
    int MaxNum;
    public HashTableLin(int maxNum, double load){
        double temp = maxNum/load;
        Load = load;
        MaxNum =maxNum;
        temp++;
        length = (int)(temp);
        int[] hashtab;
        if (temp <=13){
            hashtab = new int[12]; 
        }else if(isPrime(length)==true){
           hashtab = new int[length-1];
        }else{
            hashtab = new int[primeNum(length)-1];
        }

    }
    public void insert(int n){
        int i=0;
        if(hashtab[n%length] == 0){
            hashtab[n%length] = n;
        }if(hashtab[n%length]!=0){
            while(hashtab[(n+i)%length]!=0){
                i++;
            }
            hashtab[(n+i)%length] = n;
        }if(MaxNum/length>=Load){
            rehash();
        }
    }
    
    public void rehash(){ 
        int[] temp = new int[primeNum((2*length)-1)];
        for(int i=0;i<length;i++){
            temp[i] = hashtab[i];
        }length = 2*length;
        hashtab =new int[primeNum(length)-1];
        for(int i=0;i<length;i++){
            hashtab[i]= temp[i];
        }
    }
    
    public boolean isIn(int n){
        boolean result =false;
        for(int i=0;i<length;i++){
            if (hashtab[i]==n){
                result = true;
            }
        }
        return result;
    }
    
    public void printKeys(){
        System.out.print("The Keys are: ");
        for(int i=0; i<length;i++){
            if(hashtab[i]!=0){
                System.out.print(hashtab[i]+ ",");
            }
        }
    }
     public void printKeysAndIndexes(){
        for(int i=0; i<length;i++){
            if(hashtab[i]!=0){
                System.out.print("The Keys is:" + hashtab[i]+ "\t and the array index is:" + i);
            }
         }
     }
}

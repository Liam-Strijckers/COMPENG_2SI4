import java.util.Random;
import java.lang.Math;
public class HugeInteger {
    boolean neg;
    int size;
    int[] hugeInt;
    public HugeInteger(String val){
        int length = val.length();
        if(length>1 && val.charAt(0) == '-'){//checking to see if the inputted number is a negative
            neg = true;
            int a =1 ;
            int count = 0; 
            while(Character.getNumericValue(val.charAt(a))==0){//checks to see if there are leading zero's 
                //and how many leading zero's there are to remove from the front of the string
                count++;
                a++;
            }int b=0;
            hugeInt = new int[length-1-count];
            for(int i=count; i<length-1;i++){
                if(val.charAt(i+1)<58 && val.charAt(i+1)>47){//checks that the inputted number 
                    hugeInt[b] = Character.getNumericValue(val.charAt(i+1));//gets the value from the inputted string
                    // and convert each one to it's numerical value and stores it in the array
                    b++;
                }else{
                    throw new IllegalArgumentException("Invalid input, please input a valid string");//throws error 
                    //if the inputted string isn't a numerical value
                 }
            }   
        }else if(length>0){//if it isn't negative
            
            neg = false;
            int a =0;
            int count = 0;
            while(Character.getNumericValue(val.charAt(a))==0){//checks to see if there are leading zero's 
                //and how many leading zero's there are to remove from the front of the string
                count++;
                a++;
                if(count>=length){//will equal if only zero's are inputted so if break to make 
                    //sure the while loop doesn't run out of the bounds
                    break;
                }
            }if(count>=length){//when only zero's are inputted assigns 0 to be the only value
                hugeInt = new int[1];
                hugeInt[0] = 0;
            }else{
                int b=0;
                hugeInt = new int[length-count];
                for(int i=count; i<length;i++){
                    if(val.charAt(i)<58 && val.charAt(i)>47){
                        hugeInt[b] = Character.getNumericValue(val.charAt(i));//gets the value from the inputted string
                        // and convert each one to it's numerical value and stores it in the array
                        b++;

                    }else{
                        throw new IllegalArgumentException("Invalid input, please input a valid string");
                        //throws error if the inputted string isn't a numerical value
                    }
                }
            }
        }else{throw new IllegalArgumentException("Invalid input, please input a valid string");}
        //if not any of the above it throws a error
    }
    
    public HugeInteger(int n){
        if(n<1){//checks to see if a positive number 
            throw new IllegalArgumentException("Invalid input please enter a valid number");//or else throws an error
        }Random rand = new Random();
        int r = rand.nextInt(2);//randomizer for positive or negative number, 1 for negative and 0 for positive 
        if(r==1){
            neg=true;
        }else{neg=false;}
        hugeInt = new int[n];
        for(int i=0;i<n;i++){
            if(n==1){
                hugeInt[i]=rand.nextInt(10);
            }
            else if(i==0){//checks to see if the most significant digit is being randomized, and makes sure its not a zero
                hugeInt[i]=rand.nextInt(9)+1;
            }
            else{
                hugeInt[i] = rand.nextInt(10);//randomizes a number from 0-9
            }
        }    
        
    }
    
    public HugeInteger add(HugeInteger h){
        int[] sumArr = null;
        int difference;
        String total= "";
        int placeholder=0;
        int overflow=0;
        int length;
        boolean setNeg=false;
        int hLength=h.hugeInt.length;
        int thisLength = this.hugeInt.length;
        if(thisLength == hLength){//check to see if the lengths are the same    
            sumArr = new int [hLength+1];
            placeholder = hLength;//setting up of variable
            if((this.neg == false && h.neg == false)||(this.neg==true && h.neg==true)){
                if(this.neg=true && h.neg==true){
                    setNeg=true;
                }
                length = hLength;
                for(int i=length-1;i>=0;i--){
                    sumArr[placeholder] = h.hugeInt[i]+this.hugeInt[i];//adds the numbers together
                    sumArr[placeholder]+=overflow;
                    if(sumArr[placeholder]>=10){//when the sum is 10 or greater the digit need to overflow over into the next
                        //segement of the array
                        sumArr[placeholder] = sumArr[placeholder]-10;
                        overflow = 1;
                    }else{
                        overflow=0;
                    }
                    if(overflow==1 && i==0){//if the sum of the last two numbers causes a overflow over
                        //the most significant digit in the array will be one
                        sumArr[placeholder-1]= overflow;
                    }placeholder--;
                }
            }else if(h.neg==true && this.neg==false){
                int temp=0;
                if(h.hugeInt[temp]>this.hugeInt[temp]){
                    for(int i= thisLength-1;i>=0;i--){
                        int totalSub = overflow+this.hugeInt[i];
                        sumArr[placeholder]=h.hugeInt[i];
                        sumArr[placeholder]-=totalSub;
                        if(0>sumArr[placeholder]){
                            sumArr[placeholder]= sumArr[placeholder]+10;
                            overflow=1;
                            placeholder--;
                        }else{
                            placeholder--;
                            overflow=0;
                            
                        }
                        
                    }
                    setNeg=true;
                }
                else {
                    for(int i =thisLength-1;i>=0;i--){
                        int totalSub=overflow+h.hugeInt[i];
                        sumArr[placeholder]=this.hugeInt[i];
                        sumArr[placeholder]-=totalSub;
                        if(0>sumArr[placeholder]){
                            sumArr[placeholder]= sumArr[placeholder]+10;
                            overflow=1;
                            placeholder--;
                        }else{
                            placeholder--;
                            overflow=0;
                        }
                    }
                    setNeg=true;
                }
            }
            else if(h.neg==true && this.neg==false){
                int temp=0;
                if(this.hugeInt[temp]>h.hugeInt[temp]){
                    for(int i =thisLength-1;i>=0;i--){
                        int totalSub=overflow+h.hugeInt[i];
                        sumArr[placeholder]=this.hugeInt[i];
                        sumArr[placeholder]-=totalSub;
                        if(0>sumArr[placeholder]){
                            sumArr[placeholder]= sumArr[placeholder]+10;
                            overflow=1;
                            placeholder--;
                        }else{
                            placeholder--;
                            overflow=0;
                        }
                    }
                }else{
                    for(int i =thisLength-1;i>=0;i--){
                        int totalSub=overflow+h.hugeInt[i];
                        sumArr[placeholder]=this.hugeInt[i];
                        sumArr[placeholder]-=totalSub;
                        if(0>sumArr[placeholder]){
                            sumArr[placeholder]= sumArr[placeholder]+10;
                            overflow=1;
                            placeholder--;
                        }else{
                            placeholder--;
                            overflow=0;
                        }
                    }
                }
                    //setNeg=true;
                
            }
            for(int i = 0;i<sumArr.length;i++){//converts from an array to a string to be printed
                if((setNeg==true) && i==0){
                    total=total+"-";
                }
                if(i==0 && sumArr[i]==0){
                    continue;
                }
                //System.out.println(sumArr[i]);
                total = total + sumArr[i];
            }
        }
        else if(hLength>thisLength){//check to see which string is larger
            difference = hLength-thisLength;
            placeholder = hLength;//setting up of variables
            sumArr = new int[placeholder+1];
            if((this.neg==false && h.neg==false)||(this.neg==true && h.neg == true)){
                if(this.neg=true && h.neg==true){
                    setNeg=true;
                }
                length = thisLength-1;                          
                for(int i=length;i>=0;i--){//loops the length of the shorter array 
                    sumArr[placeholder] = h.hugeInt[i+difference];//adds them together with the overflow
                    sumArr[placeholder]+=this.hugeInt[i];
                    sumArr[placeholder]+=overflow;
                    if(sumArr[placeholder]>=10){//when the sum is 10 or greater the digit need to overflow over into the next
                        //segement of the array
                        sumArr[placeholder] = sumArr[placeholder]-10;
                        overflow = 1;

                    }else{
                        overflow=0;
                    }placeholder--;
                    
                }
                for(int i = difference-1;i>=0;i--){//loops for the remander of the length of the larger array
                    sumArr[i+1]=overflow+h.hugeInt[i];//adds without the shorter array so it doesn't go out of bounds
                    if(sumArr[i+1]>=10){//when the sum is 10 or greater the digit need to overflow over into the next
                        //segement of the array
                        sumArr[i+1] = sumArr[i+1]-10;
                        overflow = 1;
                    }else{
                        overflow = 0;
                    }
                    if( overflow == 1 && i==0){//if the sum of the last two numbers causes a overflow over
                               //the most significant digit in the array will be one
                    sumArr[0]= overflow;
                    }
                }

                
            }else if(h.neg==true && this.neg==false){//smaller in length positive plus a larger in length negative number
                for(int i=thisLength-1;i>=0;i--){//runs for the length of the smaller number
                    sumArr[placeholder]=h.hugeInt[i+difference];//sets the addition array to the the value in the larger array
                    int totalSub = overflow+this.hugeInt[i];
                    sumArr[placeholder]= sumArr[placeholder]-totalSub;//subtracts the smaller number and the carry over
                    if(0<=sumArr[placeholder]){//if the result of the subtraction is positive, no need to reduce the number beside it 
                        placeholder--;
                        overflow=0;
                    }else{//if the result of the subtraction is negative the result is added ten to make it positive again and the one is subtracted from the 
                        //number to the left to represent the shifting of the value 
                        sumArr[placeholder]= sumArr[placeholder]+10;
                        overflow=1;
                        placeholder--;
                    }
                }for(int i=difference-1;i>=0;i--){//runs for the difference between the larger and smaller number
                    sumArr[i+1]=h.hugeInt[i];
                    sumArr[i+1]-=overflow;//takes the larger number and subtracts it by the carryover if there is one
                    if(0<=sumArr[i+1]){//if the result of the subtraction is positive, no need to reduce the number to the left of it 
                        overflow=0;
                    }else{//if the result of the subtraction is negative the result is added ten to make it positive again and the one is subtracted from the 
                        //number to the left to represent the shifting of the value
                        sumArr[i+1]= sumArr[i+1]+10;
                        overflow=1;
                    }
                }
                setNeg=true;//since the larger number is negative and the smaller number is positive the result will be negative
                //so we set the result to be negative
                if(overflow==1){//checks to see if the very last subtraction has a overflow if so it subtracts the by overflow if it is 
                    sumArr[placeholder-1]=overflow;
                }
            }else if(h.neg==false && this.neg==true){//larger in length  positive number plus a smaller in length negative number
                for(int i=thisLength-1;i>=0;i--){//runs for the length of the smaller number
                    int totalSub=overflow+this.hugeInt[i];
                    sumArr[placeholder]=h.hugeInt[i+difference];//sets the result to be the value of the larger in length number
                    sumArr[placeholder]-=totalSub;//subtracts it by the overflow and the smaller in length number
                    if(0<=sumArr[placeholder]){//if the result of the subtraction is positive, no need to reduce the number beside it 
                        placeholder--;
                        overflow=0;
                    }else{//if the result of the subtraction is negative the result is added ten to make it positive again and the one is subtracted from the 
                        //number to the left to represent the shifting of the value
                        sumArr[placeholder]=sumArr[placeholder]+10;
                        placeholder--;
                        overflow=1;
                    }
                }for(int i=difference-1;i>=0;i--){//runs for the difference in length between the larger and smaller
                    sumArr[i+1]=h.hugeInt[i]-overflow;//subtracts the larger of the larger number in length by the overflow
                    if(0<=sumArr[i+1]){//if the result of the subtraction is positive, no need to reduce the number beside it
                        overflow=0;
                    }else{//if the result of the subtraction is negative the result is added ten to make it positive again and the one is subtracted from the 
                        //number to the left to represent the shifting of the value
                        sumArr[i+1]=sumArr[i+1]+10;
                        overflow = 1;
                    }
                }
                if(overflow==1){//checks to see if the very last subtraction has a overflow if so it subtracts the by overflow if it i
                    sumArr[placeholder-1]=overflow;
                }
            }
            for(int i = 0;i<sumArr.length;i++){//converts from an array to a string to be printed
                if((setNeg==true)&&i==0){
                    total=total+"-";
                }
                if(i==0 && sumArr[i]==0){
                    continue;
                }
                //System.out.print(sumArr[i]);
                total = total + sumArr[i];
            }
        }

        else if (thisLength>hLength){//check to see which string is larger
            difference = thisLength - hLength;
            placeholder = thisLength;//setting up of variables
            sumArr = new int [thisLength+1];
            if((this.neg==false && h.neg==false)||(this.neg==true && h.neg==true)){
                if(this.neg=true && h.neg==true){//if adding two negative number is a negative number
                    setNeg=true;
                }
                //System.out.println(placeholder);
                length = hLength-1;
                for(int i = length;i>=0;i--){//loops the length of the shorter array 
                    sumArr[placeholder] =h.hugeInt[i]+this.hugeInt[i+difference];//adds them together with the overflow
                    sumArr[placeholder]+=overflow;
                    if(sumArr[placeholder]>=10){//when the sum is 10 or greater the digit need to overflow over into the next
                        //segement of the array
                        sumArr[placeholder] = sumArr[placeholder]-10;
                        overflow = 1;
                    }else{
                        overflow =0;
                    }placeholder--;
                }
                for(int i = difference -1;i>=0;i--){//loops for the remander of the length of the larger array
                    sumArr[i+1] = overflow + this.hugeInt[i];//adds without the shorter array so it doesn't go out of bounds
                    if(sumArr[i+1]>=10){//when the sum is 10 or greater the digit need to overflow over into the next
                        //segement of the array
                        sumArr[i+1]= sumArr[i+1]-10;
                        overflow = 1;
                    }else{
                        overflow = 0;
                    }if( overflow == 1 && i==0){//if the sum of the last two numbers causes a overflow over
                               //the most significant digit in the array will be one
                    sumArr[0]= overflow;
                    }
                }
                
            }else if(h.neg==true && this.neg ==false){//smaller in length negative number plus a larger in length positive number
                for(int i=hLength-1;i>=0;i--){//runs the length of the shorter nuumber
                    int totalSub = overflow+h.hugeInt[i];
                    sumArr[placeholder]=this.hugeInt[i+difference];//subracts the larger number by the smaller number and overflow
                    sumArr[placeholder]-=totalSub;
                    if(0<=sumArr[placeholder]){//if the result isn't negative no change
                        placeholder--;
                        overflow=0;
                    }else{//if it is negative create carrover from the number to the left
                        sumArr[placeholder]=sumArr[placeholder]+10;
                        placeholder--;
                        overflow=1;
                    }
                }for(int i=difference-1;i>=0;i--){//runs for the difference between lengths
                    sumArr[i+1]=this.hugeInt[i];
                    sumArr[i+1]-=overflow;//larger number minus overflow
                    if(0<=sumArr[i+1]){//if the result isn't negative no change
                        overflow=0;
                    }else{//if it is negative create carrover from the number to the left
                        sumArr[i+1] = sumArr[i+1]+10;
                        overflow=1;
                    }
                }
                if(overflow==1){//if last number has an overflow subtract by one
                    sumArr[placeholder-1]=overflow;
                }
            }else if (h.neg==false && this.neg==true){//larger negative number plus a smaller positive number
                for(int i=hLength-1;i>=0;i--){//runs the length the smaller number
                    int totalSub=overflow+h.hugeInt[i];
                    sumArr[placeholder]=this.hugeInt[i+difference];//larger number minus smaller number minus overflow
                    sumArr[placeholder]-=totalSub;
                    if(0<=sumArr[placeholder]){//if positive result no change
                        placeholder--;
                        overflow=0;
                    }else{//if it is negative create carrover from the number to the left
                        sumArr[placeholder]=sumArr[placeholder]+10;
                        placeholder--;
                        overflow=1;
                    }
                }for(int i=difference-1;i>=0;i--){//runs the difference
                    sumArr[i+1]=this.hugeInt[i];//larger number minus oveflow
                    sumArr[i+1]-=overflow;
                    if(0<=sumArr[i+1]){//if positive result no change
                        overflow=0;
                    }else{//if it is negative create carrover from the number to the left
                        sumArr[i+1]= sumArr[i+1]+10;
                        overflow=1;
                    }
                }setNeg =true;//since large negative minus small positive result will be negative
                if(overflow==1){//if last number has an overflow subtract by one
                    sumArr[placeholder-1]=overflow;
                }
            }
            for(int i = 0;i<sumArr.length;i++){//converts from an array to a string to be printed
                if((setNeg==true)&&i==0){
                    total=total+"-";
                }
                if(i==0 && sumArr[i]==0){
                    continue;
                }
                //System.out.print(sumArr[i]);
                total = total + sumArr[i];
            }
        }
        HugeInteger add;//creates a new object of hugeInteger 
        add = new HugeInteger(total); // uses the total string as the input for the add object
        return add; 
    }
    
    public HugeInteger subtraction(HugeInteger h){
        HugeInteger sub1;
        String total;
        if(this.neg==false && h.neg==false){//all subtractions can be done as additions
            HugeInteger sub = new HugeInteger("-"+h.toString());
            return sub1 = this.add(sub);
        }
        else if(this.neg=false && h.neg == true){
            HugeInteger sub = new HugeInteger(h.toString());
            return sub1 = this.add(sub);
            
        }else if(this.neg=true && h.neg ==false){
            HugeInteger sub = new HugeInteger(h.toString());//when subtracking a positive minus a negative it can be redone
            //as a postive plus a negative
            //but this doesn't work correctly
            return sub1 = this.add(sub);
            //return sub1;
        }else if(this.neg==true && h.neg==true){
            HugeInteger sub = new HugeInteger(h.toString());//this doesn't work correctly
            return sub1 = this.add(sub);
        }else{
            return sub1=new HugeInteger("0");
        }
    }
    
    public HugeInteger(int a, int b){ //creates an array of length a filling each element in the with the value of b
        int length=a;
        hugeInt= new int [length];
        for(int i=0; i<length; i++){
            hugeInt[i]= b;
        }
    }
    
    public HugeInteger multiply(HugeInteger h){
        int hLength=h.hugeInt.length;//setting up variables
        int thisLength = this.hugeInt.length;
        int totalLength = hLength+thisLength;
        int overflow=0;
        HugeInteger multi = new HugeInteger(totalLength,0);
        for(int i=0;i<hLength;i++){
            overflow=0;
            HugeInteger temp;
            temp=new HugeInteger(totalLength,0);//creates an empty array object;
            for(int j=0;j<thisLength;j++){
                temp.hugeInt[totalLength-1-j-i] = (h.hugeInt[hLength-i-1]*this.hugeInt[thisLength-j-1]);
                temp.hugeInt[totalLength-1-j-i]+=overflow%10;//multiplys the indexes and adds the overflow
                temp.hugeInt[totalLength-1-j-i]=temp.hugeInt[totalLength-1-j-i]%10;
                overflow=((this.hugeInt[thisLength-j-1]*h.hugeInt[hLength-i-1])+overflow)/10;
                if((thisLength-1)==j){
                    temp.hugeInt[totalLength-2-i-j]=overflow;
                }
            }multi=multi.add(temp);//adds all the numbers together
        }if((h.neg==true && this.neg==false)||(h.neg==false && this.neg==true)){//checks to see if the result will be negative
            multi.neg=true;
        }        
        return multi;
    }
    
    
    
    public int compareTo(HugeInteger h){
        int temp = 0;
        if(this.neg==true && h.neg==false){//if negative and positive, positive is larger
            temp=-1;
        }else if (h.neg==true && this.neg==false){//if negative and positive, positive is larger
            temp=1;
        }
        else if((this.neg==false && h.neg==false)||(this.neg ==true&&h.neg==true)){//both has same sign
            if(this.neg==false && h.neg==false){
                if(h.hugeInt.length>this.hugeInt.length){//checks lengths
                    temp=-1;
                }else if(this.hugeInt.length>h.hugeInt.length){//checks lengths
                    temp=1;
                }else if(this.hugeInt.length == h.hugeInt.length){//they're the same length
                    for(int i=0;i<this.hugeInt.length;i++){//loops though to see if they have the exact same numbers
                        if(this.hugeInt[i]>h.hugeInt[i]){
                            temp=1;
                            break;
                        }else if(h.hugeInt[i]>this.hugeInt[i]){
                            temp=-1;
                            break;
                        }else if(i==this.hugeInt.length &&(this.hugeInt[i]==h.hugeInt[i])){
                            temp=0;
                            break;
                        }
                    }
                }
            }else if(this.neg ==true&&h.neg==true){//they're the same length
                if(h.hugeInt.length>this.hugeInt.length){//checks lengths
                    temp=1;
                }else if(this.hugeInt.length>h.hugeInt.length){//checks lengths
                    temp=-1;
                }else if(this.hugeInt.length == h.hugeInt.length){//loops though to see if they have the exact same numbers
                    for(int i=0;i<this.hugeInt.length;i++){
                        if(this.hugeInt[i]>h.hugeInt[i]){
                            temp=-1;
                            break;
                        }else if(h.hugeInt[i]>this.hugeInt[i]){
                            temp=1;
                            break;
                        }else if(i==this.hugeInt.length &&(this.hugeInt[i]==h.hugeInt[i])){
                            temp=0;
                            break;
                        }
                    }
                }
            }
        }
        return temp;
    }
    
    
    public String toString(){
        String totalstr = "";
        if(neg){//adds a negative sign at the front of the string if the number is negative
            totalstr = "-";
        }for(int i =0; i<hugeInt.length;i++){
            totalstr = totalstr + hugeInt[i];//converts the array to a string 
        }
        return totalstr;//returns the answer as a string
    }
}

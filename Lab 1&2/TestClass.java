public class Main {
    public static void main(String arg []){
        System.out.println("Testing Constructor of an integer more than 9 digits: 123456789012345678901234567890");
        HugeInteger bigPos = new HugeInteger("123456789012345678901234567890");
        System.out.println("Actual Outcome: ");
        System.out.println(bigPos.toString());
        System.out.println();
        
        System.out.println("Testing Constructor of a negative integer: -357184");
        HugeInteger bigNeg = new HugeInteger("-357184");
        System.out.println("Actual Outcome: ");
        System.out.println(bigNeg.toString());
        System.out.println();
        
        System.out.println("Testing Constructor of positive integer with leading zeroes: 00000");
        HugeInteger zeroPos = new HugeInteger("00000");
        System.out.println("Actual outcome: ");
        System.out.println(zeroPos.toString());
        System.out.println();
        
        System.out.println("Testing Constructor of negative integer with leading zeroes: -00871162");
        HugeInteger zeroNeg = new HugeInteger("-00871162");
        System.out.println("Actual outcome: ");
        System.out.println(zeroNeg.toString());
        System.out.println();
        
        try{
            System.out.println("Testing Constructor of invalid inputs: 00-4671");
            HugeInteger temp1 = new HugeInteger("00-4671");
            System.out.println("Actual outcome: ");
            System.out.println(temp1.toString());
            System.out.println();
        }catch(IllegalArgumentException temp1){
            System.out.println("Invalid input, please input a valid string");
        }
        System.out.println();
        try{
            System.out.println("Testing Constructor of invalid input: 3.141596535");
            HugeInteger temp = new HugeInteger("3.141596535");
            System.out.println("Actual outcome: ");
            System.out.println(temp.toString());
            System.out.println();
        }catch(IllegalArgumentException temp){
            System.out.println("Invalid input, please input a valid string");
        }
        System.out.println();
        try{
            System.out.println("Testing Constructor of empty string: ");
            HugeInteger temp2 = new HugeInteger("");
            System.out.println("Actual outcome: ");
            System.out.println(temp2.toString());
            System.out.println();
        }catch(IllegalArgumentException temp2){
            System.out.println("Invalid input, please input a valid string");
        }
        System.out.println();
        System.out.println("Testing Constructor of a random integer of 26 digits: ");
        HugeInteger rand26 = new HugeInteger(26);
        System.out.println("Actual Outcome: ");
        System.out.println(rand26.toString());
        System.out.println();
        
        try{
            System.out.println("Testing Constructor of a random integer of 0 digits: ");
            HugeInteger rand0 = new HugeInteger(0);
            System.out.println("Actual Outcome: ");
            System.out.println(rand0.toString());
            System.out.println();
        }catch (IllegalArgumentException rand0){
            System.out.println("Invalid input, please input a valid string");
        }
        System.out.println();
        try{
            System.out.println("Testing Constructor with a invalid input: 123$# Expected: error");
            HugeInteger invalid = new HugeInteger("123$#");
            System.out.print("Actual Outcome: ");
            System.out.println(invalid.toString());
            System.out.println();
        }catch(IllegalArgumentException invalid){
            System.out.println("Invalid input, please input a valid string");
        }
        System.out.println();
        System.out.println("Adding two positive numbers: 7 + 6 = 13");
        HugeInteger bigPos2 = new HugeInteger("22");
        HugeInteger bigPos3 = new HugeInteger("9999999999999999999999999999999999");
        System.out.println("Actual Outcome: ");
        HugeInteger ans = bigPos3.add(bigPos2);
        System.out.println(ans.toString());
        System.out.println();
        
        System.out.println("Adding two positive numbers: 678 + 90 = 768");
        HugeInteger bigPos4 = new HugeInteger("678");
        HugeInteger bigPos5 = new HugeInteger("99999999999999");
        System.out.println(bigPos5.toString());
        System.out.println("Actual Outcome: ");
        HugeInteger ans1 = bigPos5.add(bigPos4);
        System.out.println(ans1.toString());
        System.out.println();
        
        
        System.out.println("Adding two positive numbers: 456 + 34567 = 35023");
        HugeInteger bigPos6 = new HugeInteger("123456789");
        HugeInteger bigPos7 = new HugeInteger("987654321");
        System.out.println("Actual Outcome: ");
        HugeInteger ans2 = bigPos6.add(bigPos7);
        System.out.println(ans2.toString());
        System.out.println();
        
        System.out.println("Adding a positive and negative number: 90 + (-1) = 89");
        HugeInteger bigPos122 = new HugeInteger("90");
        HugeInteger bigPos133 = new HugeInteger("-1");    
        System.out.println("Actual Outcome: ");
        HugeInteger but = bigPos122.add(bigPos133);
        System.out.println(but.toString());
        System.out.println();
        
        System.out.println("Adding a positive and negative number: (-78) + 2 = -76");
        HugeInteger bigPos166 = new HugeInteger("-78");
        HugeInteger bigPos177 = new HugeInteger("2");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp1 = bigPos166.add(bigPos177);
        System.out.println(pp1.toString());
        System.out.println();
        
        System.out.println("Adding a positive and negative number: 645 + (-9999) = -769");
        HugeInteger bigPos144 = new HugeInteger("645");
        HugeInteger bigPos155 = new HugeInteger("-9999");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp = bigPos144.add(bigPos155);
        System.out.println(pp.toString());
        System.out.println();
        
        System.out.println("Adding two negative numbers: -1000000 + -357184 = -1357184");
        HugeInteger bigNeg2 = new HugeInteger("-1000000");
        System.out.println("Actual Outcome: ");
        HugeInteger ansNeg = bigNeg.add(bigNeg2);
        System.out.println(ansNeg.toString());
        System.out.println();
        
        System.out.println("Subtracting positive from positive number 420 - 69 = 351");
        System.out.print("Actual Outcome: ");
        HugeInteger Sub1 = new HugeInteger("420");
        HugeInteger Sub2 = new HugeInteger("69");
        HugeInteger ansSub = Sub1.subtraction(Sub2);
        System.out.println(ansSub.toString());
        System.out.println();
        
        System.out.println("Subtracting positive from positive number 34567898765 - (-5678976) = 3.457357775*10^10");
        System.out.print("Actual Outcome: ");
        HugeInteger Sub3 = new HugeInteger("-5678976");
        HugeInteger Sub4 = new HugeInteger("34567898765");
        HugeInteger ansSub1 = Sub3.subtraction(Sub4);
        System.out.println(ansSub1.toString());
        System.out.println();
        
        System.out.println("Multiplying 2 numbers: 6789 * 2345 = 15920205");
        System.out.print("Actual Outcome: ");
        HugeInteger Mult1 = new HugeInteger("6789");
        HugeInteger Mult2 = new HugeInteger("2345");
        HugeInteger ansMult = Mult1.multiply(Mult2);
        System.out.println(ansMult.toString());
        System.out.println();
        
        System.out.println("Comparing 2 numbers: 6789 >2345 = 1");
        System.out.println("Actual Outcome: ");
        System.out.println(Mult1.compareTo(Mult2));
        System.out.println();
        
        
        System.out.println("Adding a positive and negative number: (-545) + (-800) = -1345");
        HugeInteger bigPos14 = new HugeInteger("-545");
        HugeInteger bigPos15 = new HugeInteger("-800");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp2 = bigPos14.add(bigPos15);
        System.out.println(pp2.toString());
        System.out.println();
        
        System.out.println("Adding a positive and negative number: (-7891) + (-8765) = -16656");
        HugeInteger bigPos16 = new HugeInteger("-7891");
        HugeInteger bigPos17 = new HugeInteger("-8765");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp3 = bigPos16.add(bigPos17);
        System.out.println(pp3.toString());
        System.out.println();
        
        System.out.println("Adding a positive and negative number: 6917 + (-4884) = -2033");
        HugeInteger bigPos18 = new HugeInteger("6917");
        HugeInteger bigPos19 = new HugeInteger("-4884");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp4 = bigPos18.add(bigPos19);
        System.out.println(pp4.toString());
        System.out.println();
        
        
        System.out.println("Adding a positive and negative number: 5999 - (-9946) = 15945");
        HugeInteger bigPos20 = new HugeInteger("5999");
        HugeInteger bigPos21 = new HugeInteger("-9946");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp5 = bigPos20.subtraction(bigPos21);
        System.out.println(pp5.toString());
        System.out.println();
        
        System.out.println("Adding a positive and negative number: 7561 - 1128 = 6433");
        HugeInteger bigPos22 = new HugeInteger("7561");
        HugeInteger bigPos23 = new HugeInteger("1128");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp6 = bigPos22.subtraction(bigPos23);
        System.out.println(pp6.toString());
        System.out.println();
        
        System.out.println("Adding a positive and negative number: (-12345) - (-45678) = 33,333");
        HugeInteger bigPos24 = new HugeInteger("-12345");
        HugeInteger bigPos25 = new HugeInteger("-45678");    
        System.out.println("Actual Outcome: ");
        HugeInteger pp7 = bigPos24.subtraction(bigPos25);
        System.out.println(pp7.toString());
        System.out.println();
        
        
        System.out.println("Multiplying 2 numbers: 34159535 * 2718289 = 9.285548824*10^13");
        System.out.print("Actual Outcome: ");
        HugeInteger Mult3 = new HugeInteger("34159535");
        HugeInteger Mult4 = new HugeInteger("2718289");
        HugeInteger ansMult10 = Mult3.multiply(Mult4);
        System.out.println(ansMult10.toString());
        System.out.println();
        
        System.out.println("Multiplying 2 numbers: (-817421) * 1879982 = -1.536736766*10^12");
        System.out.print("Actual Outcome: ");
        HugeInteger Mult5 = new HugeInteger("-817421");
        HugeInteger Mult6 = new HugeInteger("1879982");
        HugeInteger ansMult2 = Mult5.multiply(Mult6);
        System.out.println(ansMult2.toString());
        System.out.println();
        
        System.out.println("Multiplying 2 numbers: (-79999) * (-111111) = 8888768889");
        System.out.print("Actual Outcome: ");
        HugeInteger Mult7 = new HugeInteger("3749");
        HugeInteger Mult8 = new HugeInteger("2769");
        HugeInteger ansMult3 = Mult7.multiply(Mult8);
        System.out.println(ansMult3.toString());
        System.out.println();
        
        
        System.out.println("comparing 2 numbers: (-9999)>(-20000) = 1");
        System.out.print("Actual Outcome: ");
        HugeInteger comp = new HugeInteger("-9999");
        HugeInteger comp1 = new HugeInteger("-20000");
         System.out.println( comp.compareTo(comp1));
        //System.out.println(anscomp.toString());
        System.out.println();
        
         
        System.out.println("Comparing 2 numbers: 999<1000 = -1");
        System.out.print("Actual Outcome: ");
        HugeInteger comp2 = new HugeInteger("999");
        HugeInteger comp3 = new HugeInteger("1000");
         System.out.println(  comp2.compareTo(comp3));
        //System.out.println(anscomp1.toString());
        System.out.println();
        
        System.out.println("Comparing 2 numbers: 1001=1001 = 0");
        System.out.print("Actual Outcome: ");
        HugeInteger comp4 = new HugeInteger("1001");
        HugeInteger comp5 = new HugeInteger("1001");
         System.out.println( comp4.compareTo(comp5));
        //System.out.println(anscomp2.toString());
        System.out.println();
        
        System.out.println("Comparing 2 numbers: 3486>1234 = 1");
        System.out.print("Actual Outcome: ");
        HugeInteger comp6 = new HugeInteger("3486");
        HugeInteger comp7 = new HugeInteger("1234");
        System.out.println( comp6.compareTo(comp7));
        //System.out.println(anscomp3.toString());
        System.out.println();
        
        
    }
}

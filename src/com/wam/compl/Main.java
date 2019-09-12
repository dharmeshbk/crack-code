package com.wam.compl;

public class Main {

    public static void main(String[] args) {

        Boolean res = isUniqueChars("Dharmesh");
        System.out.println("Result is :"+res);

    }

    //Characters are uniques in the String

    /**
     * Questions :
     * 1. Is this ASCII characters only (Unicode) A--> 65 , a --> 97 Deltee -->127
     * 2. Is that okay to use other Data Structure like Set
     * 3. Do we need to loop through all the String and find out the how many are duplicate or as soon as we get the duplicate return false
     */

    public static boolean isUniqueChars(String str) {
        Boolean[] res = new Boolean[128];
        for (char c : str) {
            if (res[c] == true) {
                return false;
            }
        }
        return  true;
    }


}

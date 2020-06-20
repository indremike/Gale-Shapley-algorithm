package com.company;

public class StableMatching {

    static int[] match(int menPrefList[][], int womenPrefList[][]) {
        System.out.println("");
        System.out.println("=======STABLE MATCHING==============");
        System.out.println("");

        int S = 0, T = 0;
        int size = menPrefList.length;
        int pairs[] = new int[size]; //index = woman, value - man

        boolean takenMen[] = new boolean[size];
        boolean takenWomen[] = new boolean[size];

        int freeCount = size;

        while (freeCount > 0) {
            System.out.println("There are " + freeCount + " free men left");

            int freeMan = -1;
            for (int i = 0; i < size; ++i) {
                freeMan = i;

                if (takenMen[freeMan] == false) {
                    System.out.println("Free man : " + freeMan);
                    break;
                }
            }
            for (int i = 0; i < size; ++i) {
                int possibleWoman = menPrefList[freeMan][i];
                System.out.println("Can woman " + possibleWoman + " and man " + freeMan + " be a pair?");

                if (takenWomen[possibleWoman] == false) {

                    System.out.println("Woman " + possibleWoman + " is free");
                    System.out.println("Man " + freeMan + " engaged to a woman " + possibleWoman);

                    pairs[possibleWoman] = freeMan;
                    takenMen[freeMan] = true;
                    takenWomen[possibleWoman] = true;

                    freeCount--;
                    break;
                } else {
                    if (womanPrefersFreeManOverCurrentMan(womenPrefList, possibleWoman, freeMan, pairs[possibleWoman]) == true) {

                          System.out.println("Woman " + possibleWoman + " is taken");
                          System.out.println("Man " + freeMan + " engaged to a woman " + possibleWoman);
                          System.out.println("Man " + pairs[possibleWoman] + " is free again");

                        takenMen[pairs[possibleWoman]] = false;

                        pairs[possibleWoman] = freeMan;

                        takenMen[freeMan] = true;
                        takenWomen[possibleWoman] = true;

                        break;
                    }
                    else{
                        System.out.println("Woman " + possibleWoman + " prefers her current man " + pairs[possibleWoman] + " over " + freeMan);
                    }
                }
            }
        }
        int Tmax = 0;
        int Smax = 0;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs.length; j++) {
                if (pairs[i] == womenPrefList[i][j]) {
                    if(Tmax < j+1)
                        Tmax = j+1;
                    T = T + j + 1;
                }
                if (i == menPrefList[pairs[i]][j]) {
                    S = S + j + 1;
                    if(Smax < j+1)
                        Smax = j+1;
                }
            }

        }
        System.out.println("S = " + S);
        System.out.println("T = " + T);
        System.out.println("Smax = " + Smax);
        System.out.println("Tmax = " + Tmax);

        printPairs(pairs);
        return pairs;
    }
    static private boolean womanPrefersFreeManOverCurrentMan(int womenPrefList[][], int woman, int freeMan, int currentMan) {

        // Check if woman prefers freeMan over
        // her current engagment currentMan
        int size = womenPrefList.length;
        for (int i = 0; i < size; i++) {

            if (womenPrefList[woman][i] == freeMan)
                return true;

            if (womenPrefList[woman][i] == currentMan)
                return false;
        }
        return false;
    }

    static void printPairs(int pairs[]) {
        int size = pairs.length;
        System.out.println("---PAIRS---");
        System.out.println("Woman" + "   " + "Man");
        for (int i = 0; i < size; ++i) {
            System.out.println(i + "       " + pairs[i]);
        }


    }

}

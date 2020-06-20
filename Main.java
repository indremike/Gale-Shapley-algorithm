package com.company;
public class Main {

    public static void main(String[] args) {

        int[] menList = {1, 2, 3, 4, 5};
        char menPrefList[][] = {
                {'B', 'A', 'E', 'C', 'D'},
                {'A', 'D', 'E', 'C', 'B'},
                {'D', 'C', 'B', 'A', 'E'},
                {'A', 'C', 'E', 'D', 'B'},
                {'A', 'B', 'D', 'E', 'C'}
        };
        char womenList[] = {'A', 'B', 'C', 'D', 'E'};
        int womenPrefList[][] = {
                {3, 5, 2, 1, 4},
                {5, 1, 2, 4, 3},
                {4, 3, 5, 1, 2},
                {1, 2, 3, 4, 5},
                {1, 3, 4, 2, 5}
        };

        int size = menPrefList.length;
        int menPrefListInt[][] = new int[size][size];
        int womenPrefListInt[][] = new int[size][size];

        //convert menList and womenList to Integer
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                for (int k = 0; k < size; ++k) {

                    if (menList[k] == womenPrefList[i][j]) {
                        womenPrefListInt[i][j] = k;
                    }
                    if (womenList[k] == menPrefList[i][j]) {
                        menPrefListInt[i][j] = k;
                    }
                }
            }
        }

        int pairsMen[] = StableMatching.match(menPrefListInt, womenPrefListInt);

        int menListPairs[] = new int[size];

        //convert from Integer
        for (int i = 0; i < size; ++i) {
                    menListPairs[i] = menList[pairsMen[i]];
        }

        System.out.println("---CONVERTED PAIRS---");
        for (int i = 0; i < size; ++i) {
            System.out.println(womenList[i] + "       " + menListPairs[i]);
        }

        int pairsWomen[] = StableMatching.match(womenPrefListInt, menPrefListInt);
        char womenListPairs[] = new char[size];

        //convert from Integer
        for (int i = 0; i < size; ++i) {
                    womenListPairs[i] = womenList[pairsWomen[i]];
            }

        System.out.println("---CONVERTED PAIRS---");
        for (int i = 0; i < size; ++i) {
            System.out.println(menList[i] + "       " + womenListPairs[i]);
        }

    }
}
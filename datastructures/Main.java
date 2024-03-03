package datastructures;


import datastructures.binarySearchTree.BinarySearchTree;
import datastructures.hashtable.HashTable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();

        myHashTable.set("paint", 20);
        myHashTable.set("bolts", 40);
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        System.out.println( myHashTable.keys() );
        Map<?,?> map = new HashMap<>();
        Set<?> set = new HashSet<>();
        int x = 3;
        System.out.format("%.1f",Math.pow(x, 3));
        int[] arr1 = new int[]{1,3,5};
        int[] arr2 = new int[]{2,4,6};
        System.out.println(itemInCommon(arr1, arr2));
    }

    public static boolean itemInCommon(int[] arr1, int[] arr2){
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i : arr1){
            map.put(i, true);
        }
        for(int i : arr2){
            if(map.get(i)!=null) return true;
        }
        return false;
    }
}
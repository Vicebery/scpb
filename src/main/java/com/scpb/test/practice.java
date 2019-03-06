package com.scpb.test;

import java.util.Scanner;
import java.util.Arrays;


public class practice {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int num[] = new int[n];
        for(int i = 0;i<n;i++){
            num[i]=in.nextInt();

        }
        Arrays.sort(num);
        for(int i = 0;i<k;i++){
            System.out.print(num[i]);
            System.out.print(" ");
        }
    }
}

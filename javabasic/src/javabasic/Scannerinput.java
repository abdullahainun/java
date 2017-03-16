package javabasic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javabasic;

import java.util.Scanner;

/**
 *
 * @author aal
 */
public class Scannerinput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int i = scan.nextInt();
        
        System.out.println(s+" - "+i);
    }
    
}

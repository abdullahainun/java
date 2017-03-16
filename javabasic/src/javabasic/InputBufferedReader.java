/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aal
 */
public class InputBufferedReader {
    public static void main(String[] args) throws IOException{
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            int i = Integer.parseInt(br.readLine());
        }catch(IOException e){
            System.out.println(e);
        }

    }

}

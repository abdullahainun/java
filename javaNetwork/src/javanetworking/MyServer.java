/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import  java.io.*;
import  java.net.*;


/**
 *
 * @author aal
 */
public class MyServer {
    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(6666); //instance
            Socket s=ss.accept(); //establise connection
            
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String str=(String)dis.readUTF();
            System.out.println("message " + str);
            ss.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

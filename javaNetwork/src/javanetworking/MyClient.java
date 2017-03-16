/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author aal
 */
public class MyClient {
    public static void main(String[] args) throws IOException{
        Socket s=new Socket("localhost",6666);                
       
        try{
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("hello Server");
            dout.flush();
            dout.close();
            s.close();   
        }catch(Exception e){
            System.out.println(e);
        }        
    }
}

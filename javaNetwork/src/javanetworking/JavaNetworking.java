/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;
import java.net.*;

/**
 *
 * @author aal
 */
public class JavaNetworking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
        
        try{                    
        InetAddress address = InetAddress.getByName("localhost");
        InetAddress[] address2 = InetAddress.getAllByName("localhost");
        
        System.out.println("Host =" + address);
        System.out.println("Host Name =" + address.getHostName());
        System.out.println("Host Address=" + address.getHostAddress());
        
        System.out.println("All Address 2 = " + address2);

        
        }catch(Exception e){
            System.out.println("e");
        }
        
        
    }
    
}

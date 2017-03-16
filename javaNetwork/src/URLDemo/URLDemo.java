/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URLDemo;

import java.io.IOException;
import java.net.URL;

/**
 *
 * @author aal
 */
public class URLDemo {
    public static void main(String[] args)
    {
        try
        {
            URL url =new URL("http://localhost:80/index.html?language=en#j2se");
            System.out.println("URL is " + url.toString());
            System.out.println("Protocol is " + url.getProtocol());
            System.out.println("authority is " + url.getAuthority());
            System.out.println("file name is " + url.getFile());
            System.out.println("host is " + url.getHost());
            System.out.println("path is " + url.getPath());
            System.out.println("port is " + url.getPort());
            System.out.println("default port is " + url.getDefaultPort());
            System.out.println("query is " + url.getQuery());
            System.out.println("ref is " + url.getRef());
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

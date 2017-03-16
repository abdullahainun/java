/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package URLDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author aal
 */
public class URLConnDemo {
    public static void main(String[] args) throws MalformedURLException, IOException{
        try
        {
            URL url= new URL("http://localhost");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }
            else
            {
                System.out.println("Please enter an HTTP URl");
            }
            BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
            String urlString="";
            String current;
            while((current = in.readLine())!=null)
            {
                urlString += current;
            }            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

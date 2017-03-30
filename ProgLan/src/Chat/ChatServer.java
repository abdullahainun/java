package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;


public class ChatServer {

    private static final int PORT = 9001;  //port

    private static HashSet<String> names = new HashSet<String>(); //hashset untuk menampung nama user

    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>(); //hashset untuk menampung nama chat

    public static void main(String[] args) throws Exception {
        System.out.println("Chat Server sedang berjalan.");
        ServerSocket listener = new ServerSocket(PORT); //membuat listener dengan port tertentu
//        menunggu client
        try {
            while (true) {
                new Handler(listener.accept()).start(); //handler digunakan untuk 
            }
        } finally {
            listener.close(); //menutup koneksi
        }
    }
    private static class Handler extends Thread {
        private String name; 
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket; //socket akan menerima method accept melalui contructur ini
        }
//           run merupakan method default dari thread
        public void run() {
            try {
//               
//                 membuat identitas user pada saat stream.
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));//sebagai inputan client.
                
                //class print writer digunakan untuk menampung data yang akan dikirimkan ke host lain melalui stream
                out = new PrintWriter(socket.getOutputStream(), true); 
                
//                dilakukan perulangan untuk menunggu nama pengguna dari client
//
                while (true) {
//                    mengirimkan kata SUBMITNAME melalui stream, serta data ini ditampung dengan menggunakan class Printwriter
                    out.println("SUBMITNAME");
//                    membaca data dari stream, kemudian data tersebut di parsing ke variabel String biasa.
                    name = in.readLine();
//                    bila nama yang diterima oleh server null maka
                    if (name == null) {
                        return;
                    }
                    //proses syncronisasi, supaya antar thread yang berbeda tidak berebutan menggunakan resource komputer pada satu waktu yang sama
                    synchronized (names) {
                        if (!names.contains(name)) {
                            names.add(name);
                            break;
                        }
                    }
                }
//                setelah server menunggu, maka server mengirimkan data ke client berupa kalimat NAMEACCEPTED
                out.println("NAMEACCEPTED");                
                writers.add(out); //menyimpan pesan antar client pada hashset
                
//              proses mengirimkan pesan ke semua client
                while (true) {
//                  membaca pesan pada aliran stream, kemudian setiap pesan akan di distribusikan ke client
                    String input = in.readLine(); 
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class server_thread {

    public static void main (String[] args) throws IOException{

        int port = 4999;    //Integer.parseInt(args[0]); // same as client file

        try {
            ServerSocket ss = new ServerSocket(4999);
            Socket s = ss.accept();

            
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader sintwo = new BufferedReader(new InputStreamReader(System.in));             
            
            
            String usinptwo; String usinpthree;

            while ((usinptwo= in.readLine())!=null)   {
                System.out.println("read: "+ usinptwo);
                
                usinpthree= sintwo.readLine();
                out.println(usinpthree); 
            }

        }

        catch (IOException e){

            System.out.println(" Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        }
        

    }
}



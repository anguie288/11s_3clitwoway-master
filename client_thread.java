import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;




public class client_thread {
    public static void main (String[] args)throws IOException, UnknownHostException{

        String host = "127.0.0.1";   //args[0];
        int port = 4999;             //Integer.parseInt(args[1]);

        try {
            Socket es = new Socket(host, port);
            
            PrintWriter out = new PrintWriter(es.getOutputStream(), true);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            
            
            BufferedReader in = new BufferedReader(new InputStreamReader(es.getInputStream()));

            // read and out
            String usinp;

            while ((usinp= sin.readLine())!=null)   {
                 out.println(usinp);   // read and out
                 
                 System.out.println("read: "+ in.readLine());  

            }
     
        }

        catch (UnknownHostException e){
            System.err.println("Don't know about host "); // + host
            System.exit(1);
        }

        catch(IOException e) {
            System.out.println("Couldn't get I/O for connection"); //+host
            System.exit(1);
        }



    }
}





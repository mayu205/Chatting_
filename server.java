import java.io.*;
import java.net.*;

public class server{
    public static void main(String args[])throws Exception
    {
        System.out.println(" server RUnning...");
        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("server is listening at port no. 2100...");

        Socket sobj = ssobj.accept();
        System.out.println("Connection is succesful...");

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Chat messenger started...");

        String str1 , str2;
        while((str1 = br1.readLine())!= null)
        {
            System.out.println("client says : "+str1);
            System.out.println("Enter msg for client : ");
            str2 = br2.readLine();
            ps.println(str2);
        }
        System.out.println("Thankyou for using the chat messanger...");
        sobj.close();
        ssobj.close();
        ps.close();
        br1.close();
        br2.close();


    }

}
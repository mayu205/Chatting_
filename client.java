import java.io.*;
import java.net.*;

public class client{
    public static void main(String args[])throws Exception
    {
        System.out.println(" client RUnning...");
        Socket sobj = new Socket("Localhost" ,2100);
        System.out.println(" client is waiting for server to accept the request...");

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Chat messenger started...");

        String str1 , str2;

        while(!(str1 = br2.readLine()).equals("end"))
        {
            ps.println(str1);
            System.out.println("Enter msg for server : ");
            str2 = br1.readLine();
            System.out.println("Server says : "+str2);
        }
        System.out.println("Thankyou for using chat msgner...");

        sobj.close();
        ps.close();
        br1.close();
        br2.close();

    }

}
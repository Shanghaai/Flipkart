package abc.def;

import java.io.*;
import java.net.*;

public class JavaSourceViewer 
{
    public static void main(String[] args) throws IOException 
    {
        System.out.print("Enter your fuck*** url of local address");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url = br.readLine();
        try {
            FileOutputStream fout = new FileOutputStream("D://web-content.txt");
            writeURL2Stream(url, fout);
            fout.close();
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a valid URL.");
        } catch (IOException ie) {
            System.out.println("Input/Output Error: " + ie.getMessage());
        }
    }

    static void writeURL2Stream(String url, OutputStream fout)
    throws MalformedURLException, IOException
    {
        URL u = new URL(url);
        HttpURLConnection uc = (HttpURLConnection) u.openConnection();
        int code = uc.getResponseCode();
        String response = uc.getResponseMessage();
        System.out.println("HTTP/1.x " + code + " " + response);

        //to print the data on the console
        InputStream in = new BufferedInputStream(uc.getInputStream());
        Reader r = new InputStreamReader(in);
        int ch;

        while ((ch = r.read()) != -1) 
        {
            System.out.print((char) ch);
            fout.write(ch);
        }
    }
}
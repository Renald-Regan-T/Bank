package org.example;

import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

public class File_handling
{
    public void file_write(String file,String data)
    {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(file,true)))
        {
            bw.write(data);
            bw.newLine();
        }
        catch (IOException e)
        {
            System.out.println("Error writting to file: "+e.getMessage());
        }
    }

    public List<String> file_read(String file)
    {
        List<String>data=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line=br.readLine())!=null)
                data.add(line);
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return data;
    }

    public void file_write2(Map<Integer,Customer>customers,String file)
    {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(file)))
        {
            for(Customer i:customers.values())
            {
                String s=i.id+" "+i.acNo+" "+i.name+" "+i.balance+" "+i.encryptedPwd;
                bw.write(s+"\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error writting to file: "+e.getMessage());
        }

    }
}

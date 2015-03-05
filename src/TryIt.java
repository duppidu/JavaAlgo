/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author thomas.duppenthaler
 */
public class TryIt
{
    Properties prop = new Properties();
    OutputStream output;
    InputStream input;
    public String fileName;

    public TryIt(String fileName) throws FileNotFoundException
    {
        this.fileName = fileName;

    }

    public void setNewUser(String Name, String Age)
    {
        prop.setProperty(Name, Age);
    }

    public void saveFile()
    {int y=1;
        boolean x=false;
do{
        try
        {
            this.output = new FileOutputStream("d:\\" + y + ".txt");
            prop.store(output, null);
            y++;
        } catch (IOException ex)
        {
            System.out.println("File not found!!");
        }
       }while( x=true);
    }

    public void loadFile()
    {

        try
        {
            this.input = new FileInputStream("d:\\" + fileName + ".txt");
            prop.load(input);
        } catch (IOException ex)
        {
            System.out.println("File not found!!");
        }

    }

    public void getUsers() throws FileNotFoundException
    {

        System.out.println(prop);

    }

    public void getUserAge(String Name)
    {
        System.out.println(prop.getProperty(Name));
    }

    public void deletUser(String userName)
    {
        prop.remove(userName);
    }

    public static void main(String[] args) throws IOException
    {
        TryIt p1 = new TryIt("p1");
       // p1.loadFile();
         p1.setNewUser("ken", "12");
         p1.setNewUser("flo", "12");

        p1.deletUser("flo");
        p1.getUserAge("ken");
        p1.getUserAge("flo");
        p1.saveFile();
    }

}

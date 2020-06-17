/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package falconserver;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
// * @author strea
 */
public class LoginDB {
    public static ArrayList<User> users = new ArrayList();
    public static DefaultListModel usersModel = new DefaultListModel(); //Database Variable

    static {
	try
        {
            File userFile = new File("db/users");
            userFile.createNewFile();
            FileInputStream f = new FileInputStream(userFile);
            ObjectInputStream o = new ObjectInputStream(f);
            users = (ArrayList<User>) o.readObject();
            for (int i = 0; i < users.size(); ++i) {
                usersModel.add(i, users.get(i).username);
            }
            o.close();
            f.close();
            System.out.println("load users.");
        } catch (EOFException eof) {
            System.out.print("EOF exception occur: " + eof);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean login(String username, String password)
    {
        System.out.println("login: " + username + " " + password);
        for (int i = 0; i < users.size(); ++i) {
            User user = users.get(i);
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("user" + i + ": " + user.username + " " + user.password);
                return true;
            }
        }
        return false;
    }
    public static void addUser(String username, String password, String email)
    {
        users.add(new User(username, password, email));
        try
        {
            File userFile = new File("db/users");
            userFile.createNewFile();
            FileOutputStream f = new FileOutputStream(userFile, false);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(users);
            o.close();
            f.close();
            usersModel.addElement(username);
            System.out.println("add a user.");
        } catch (EOFException eof) {
            System.out.print("EOF exception occur");
            eof.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteUser(int index)
    {
        users.remove(index);
        try
        {
            File userFile = new File("db/users");
            userFile.createNewFile();
            FileOutputStream f = new FileOutputStream(userFile, false);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(users);
            o.close();
            f.close();
            usersModel.remove(index);
            System.out.println("delete a user.");
        } catch (EOFException eof) {
            System.out.print("EOF exception occur");
            eof.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean findUser(String u)
    {
        for (int i = 0; i < users.size(); ++i) {
            User user = users.get(i);
            if (user.username.equals(u)) {
                return true;
            }
        }
        return false; 
    }
}

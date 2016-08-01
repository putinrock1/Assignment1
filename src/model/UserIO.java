package model;

import utils.LinkedListIndexedList;

import java.io.*;

/**
 * User File input output
 */
public class UserIO {
    /**
     * writes usersDB to users.dat
     *
     * @param users
     * @throws IOException
     */
    public static void writeUsers(LinkedListIndexedList<User> users) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));

        output.writeObject(users);
    }

    /**
     * reads usersDB from users.dat
     *
     * @return
     * @throws IOException
     */
    public static Object readUsers() throws IOException {
        Object obj = new Object();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.dat"));

            obj = input.readObject();
        } catch (ClassNotFoundException e) {
            System.err.print("Cannot find User Class");
            e.printStackTrace();
        }

        return obj;
    }
}

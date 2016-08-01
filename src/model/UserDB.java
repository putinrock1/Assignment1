package model;

import utils.LinkedListIndexedList;
import utils.LinkedListStack;

import java.util.LinkedList;

/**
 * User database
 */
public class UserDB {
    private static LinkedListIndexedList<User> users = new LinkedListIndexedList<User>();

    /**
     * returns out users data object
     *
     * @return LinkedListIndexedList
     */
    public static LinkedListIndexedList<User> getUsers() {
        return users;
    }

    /**
     * sets our users data object (after reading from file)
     *
     * @param users
     */
    public static void setUsers(LinkedListIndexedList<User> users) {
        UserDB.users = users;
    }

    /**
     * checks if a username exists in our user data list
     *
     * @param username
     * @return boolean
     */
    public static boolean usernameExists(String username) {
        for (int i = 0; i < UserDB.getUsers().size(); i++) {
            if (UserDB.getUsers().get(i).getUsername().equals(username)) return true;
        }
        return false;
    }
}

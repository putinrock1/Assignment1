package model;

public class Session {
    private static User currentUser;

    /**
     * returns if the user is logged in
     *
     * @return boolean
     */
    public static boolean isUserLoggedIn() {
        return currentUser != null;
    }

    /**
     * returns the session's current user
     *
     * @return User
     */
    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the session's current user
     *
     * @param user User
     */
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}

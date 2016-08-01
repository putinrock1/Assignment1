package model;

import java.io.Serializable;

/**
 * User object
 */
public class User extends Person implements Serializable, Comparable<User> {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String photo;

    /**
     * User Constructor
     *
     * @param username
     * @param email
     * @param phone
     * @param password
     * @param photo
     */
    public User(String username, String email, String phone, String password, String photo) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.photo = photo;
    }

    /**
     * User Constructor
     *
     * @param firstName
     * @param lastName
     * @param gender
     * @param dob
     * @param ssn
     * @param username
     * @param email
     * @param phone
     * @param password
     * @param photo
     */
    public User(String firstName, String lastName, String gender, String dob, String ssn, String username, String email, String phone, String password, String photo) {
        super(firstName, lastName, gender, dob, ssn);
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.photo = photo;
    }

    /**
     * @return String
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo String
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone String
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    /**
     * @param user User
     * @return boolean
     */
    public boolean equals(User user) {
        return this.username.equals(user.username);
    }

    /**
     * @param user User
     * @return int
     */
    @Override
    public int compareTo(User user) {
        return this.username.compareTo(user.username);
    }
}

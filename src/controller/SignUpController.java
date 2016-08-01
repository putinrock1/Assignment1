package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.User;
import model.UserDB;
import model.UserIO;
import view.LoginJavaFXView;

import java.io.File;
import java.util.regex.Pattern;

public class SignUpController {
    @FXML
    TextField firstName, lastName, username, email, phone, gender;
    @FXML
    PasswordField pw1, pw2;
    @FXML
    DatePicker dob;
    @FXML
    Button photo;
    @FXML
    Label alert, photo_url;

    String photoPath;

    /**
     * Sign, validates and if valid, saves User to UserDB
     *
     * @throws Exception
     */
    public void signUp() throws Exception {
        /*
         *
         * Validation
         *
         */
        // check required fields
        if (!areAllRequiredFieldsFilled()) {
            errorAlert("Fields in RED are REQUIRED");
            return;
        } else if (this.photoPath == null) {
            errorAlert("Please supply a Photo");
            return;
        } else if (!pw1.getText().equals(pw2.getText())) { // pw1 and pw2 are not the same
            errorAlert("Password fields are not the same");
            styleTextField(pw1, "#c66");
            styleTextField(pw2, "#c66");
            return;
        } else if (UserDB.usernameExists(username.getText())) {
            errorAlert("That username is not available");
            return;
        } else if (!isValidEmail(email.getText())) {
            errorAlert("Email does not appear to be valid. `xxxx@mail.xxx`");
            return;
        } else if (!isValidPassword(pw1.getText())) {
            errorAlert("Password needs 1 number, upper case & lower case letter and 1 special character");
            return;
        }

        /*
         *
         * Success, create the account
         *
         */
        User user = new User(username.getText(), email.getText(), phone.getText(), pw1.getText(), this.photoPath);

        UserDB.getUsers().add(user);

        try {
            UserIO.writeUsers(UserDB.getUsers());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        this.openLoginView();
    }

    /**
     * Helper to style a textfield
     *
     * @param field
     * @param color
     */
    public void styleTextField(TextField field, String color) {
        field.setStyle("-fx-background-color: " + color + ";");
    }

    /**
     * Helper to style a datapicker
     *
     * @param field
     * @param color
     */
    public void styleTextField(DatePicker field, String color) {
        field.setStyle("-fx-background-color: " + color + ";");
    }

    /*
     *
     * Open new window methods
     *
     */

    /**
     * Opens select Photo window
     */
    public void selectPhoto() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File file = chooser.showOpenDialog(photo.getScene().getWindow());

        if (file != null) {
            this.photoPath = file.getAbsolutePath();

            photo_url.setText(file.getName());
        }
    }

    /**
     * Opens login view
     *
     * @throws Exception
     */
    public void openLoginView() throws Exception {
        new LoginJavaFXView().loadView();

        this.closeWindow();
    }

    /**
     * Closes the currently opened window
     */
    private void closeWindow() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }

    /*
     *
     * Validation methods
     *
     */

    /**
     * Validates password has 1 number, capital letter, lowercase letter and a special character
     *
     * @param password
     * @return boolean
     */
    private boolean isValidPassword(String password) {
        Pattern number = Pattern.compile("[0-9]");
        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern specialCharacter = Pattern.compile("[^A-Za-z0-9\\s]");

        return (number.matcher(password).find()
                && upperCase.matcher(password).find()
                && lowerCase.matcher(password).find()
                && specialCharacter.matcher(password).find());
    }

    /**
     * validates email based on assignment's definition of an email
     *
     * @param email
     * @return
     */
    private boolean isValidEmail(String email) {
        return email.contains("@mail.");
    }

    /**
     * Checks all required fields contain some value
     *
     * @return
     */
    private boolean areAllRequiredFieldsFilled() {
        boolean result = true;

        if (!checkRequiredField(firstName)) result = false;
        if (!checkRequiredField(lastName)) result = false;
        if (!checkRequiredField(dob)) result = false;
        if (!checkRequiredField(gender)) result = false;
        if (!checkRequiredField(username)) result = false;
        if (!checkRequiredField(email)) result = false;
        if (!checkRequiredField(pw1)) result = false;
        if (!checkRequiredField(pw2)) result = false;

        return result;
    }

    /**
     * Draws a red outline around empty required field
     *
     * @param field
     * @return
     */
    private boolean checkRequiredField(TextField field) {
        if (field.getText().isEmpty()) {
            styleTextField(field, "#c66");
            return false;
        }

        styleTextField(field, "white");
        return true;
    }

    /**
     * Draws a red outline around empty required field
     *
     * @param field
     * @return
     */
    private boolean checkRequiredField(DatePicker field) {
        if (field.getValue() == null) {
            styleTextField(field, "#c66");
            return false;
        }

        styleTextField(field, "white");
        return true;
    }

    /*
     *
     * Alert methods
     *
     */

    /**
     * Shows an alert box
     *
     * @param alertString
     * @param color
     */
    private void showAlert(String alertString, String color) {
        alert.setText(alertString);
        alert.setStyle("-fx-text-fill: " + color + ";");
    }

    /**
     * Shows an error box
     *
     * @param alertString
     */
    public void errorAlert(String alertString) {
        showAlert(alertString, "#c66");
    }
}

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Session;
import model.User;
import model.UserDB;
import view.SignUpJavaFXView;
import view.WelcomeJavaFXView;

/**
 *
 */
public class LoginController {
    @FXML
    TextField username;
    @FXML
    TextField pw;
    @FXML
    Label alert;

    /**
     * checks against the UserDB to see if the credentials are correct
     *
     * @throws Exception
     */
    public void authenticate() throws Exception {
        User user = this.attemptLogin(username.getText(), pw.getText());

        if (user != null) {
            Session.setCurrentUser(user);
            this.openWelcomeView(user);
        } else {
            alert.setText("Couldn't log you in.");
            alert.setStyle("-fx-text-fill: #c66;");
        }
    }

    /**
     * searched through UserDB by credentials
     *
     * @param username
     * @param password
     * @return
     */
    public User attemptLogin(String username, String password) {
        for (int i = 0; i < UserDB.getUsers().size(); i++) {
            if (UserDB.getUsers().get(i).getUsername().equals(username)) {
                if (UserDB.getUsers().get(i).getPassword().equals(password)) return UserDB.getUsers().get(i);
            }
        }

        return null;
    }

    /**
     * opens signup view
     *
     * @throws Exception
     */
    public void openSignUpView() throws Exception {
        new SignUpJavaFXView();
        this.closeWindow();
    }

    /**
     * opens welcome view
     *
     * @param user
     * @throws Exception
     */
    public void openWelcomeView(User user) throws Exception {
        new WelcomeJavaFXView(user.getUsername());
        this.closeWindow();
    }

    /**
     * closes currently open window
     */
    private void closeWindow() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }
}

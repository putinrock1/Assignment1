package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeJavaFXView {

    public WelcomeJavaFXView(String name) throws Exception {
        Stage signupStage = new Stage();
        Parent signUpView = FXMLLoader.load(getClass().getResource("WelcomeJavaFX.fxml"));
        signupStage.setTitle("Welcome " + name + " Using LinkedListIndexedList!");
        signupStage.setScene(new Scene(signUpView, 700, 600));
        signupStage.show();
    }
}

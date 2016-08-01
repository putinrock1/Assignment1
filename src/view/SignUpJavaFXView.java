package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpJavaFXView {

    public SignUpJavaFXView() throws Exception {
        Stage signupStage = new Stage();
        Parent signUpView = FXMLLoader.load(getClass().getResource("SignUpJavaFX.fxml"));
        signupStage.setTitle("Sign Up");
        signupStage.setScene(new Scene(signUpView, 800, 600));
        signupStage.show();
    }
}

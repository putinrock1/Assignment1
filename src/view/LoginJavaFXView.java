package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.UserDB;
import model.UserIO;
import utils.LinkedListIndexedList;

import java.io.IOException;

public class LoginJavaFXView extends Application {

    public void loadView() throws Exception {
        Stage signupStage = new Stage();
        start(signupStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loginView = FXMLLoader.load(getClass().getResource("LoginJavaFX.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(loginView, 600, 400));
        primaryStage.show();
    }

    public static void loadDB() {
        try {
            UserDB.setUsers((LinkedListIndexedList<User>) UserIO.readUsers());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.print("Fail to open users.dat file.");
        }
    }


    public static void main(String[] args) {
        loadDB();
        launch(args);
    }
}

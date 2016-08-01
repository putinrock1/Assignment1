package view;

import controller.HospitalShowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Hospital;

public class HospitalShowJavaFXView {

    public HospitalShowJavaFXView(Hospital hospital) throws Exception {
        Stage hospitalShowStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HospitalShowJavaFX.fxml"));

        Parent root = (Parent)fxmlLoader.load();
        HospitalShowController controller = fxmlLoader.<HospitalShowController>getController();
        controller.setHospital(hospital);
        Scene scene = new Scene(root);

        hospitalShowStage.setScene(scene);

        hospitalShowStage.show();
    }
}

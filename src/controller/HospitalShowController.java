package controller;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Hospital;

/**
 * Welcome Screen Controller
 */
public class HospitalShowController {

    public Label name;
    public ImageView image;
    public Label address;
    public Label phone;
    public Label longlat;

    public void setHospital(Hospital hospital) {
        name.setText(hospital.getName());
        address.setText("Address: " + hospital.getAddress());
        phone.setText("Phone: " + hospital.getPhone());
        longlat.setText(hospital.getLocation().toString());

        image.setImage(new Image(hospital.getImage()));
    }
}

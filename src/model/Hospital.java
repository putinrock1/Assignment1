package model;

public class Hospital implements Comparable<Hospital> {
    private String name;
    private String  address;
    private Location location;
    private String phone;
    private String image;

    public Hospital(String address, String image, Location location, String name, String phone) {
        this.address = address;
        this.image = image;
        this.location = location;
        this.name = name;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Hospital hospital) {
        return this.location.compareTo(hospital.getLocation());
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

package CH1.Person;

public class Address {
    private String streetName;
    private String city;
    private double zipCode;

    public Address(String streetName, String city, double zipCode) {
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getZipCode() {
        return zipCode;
    }

    public void setZipCode(double zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}

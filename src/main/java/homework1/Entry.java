package homework1;

public class Entry implements Comparable<Entry> {
    private String fullName;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry() {
    }

    public Entry(String fullName, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        return this.fullName.compareTo(other.getFullName());
    }

    @Override
    public String toString() {
        return "Name: " + fullName + "\n" +
                "Street address: " + streetAddress + "\n" +
                "City: " + city + "\n" +
                "Postal code: " + postcode + "\n" +
                "Country: " + country + "\n" +
                "Phone number: " + phoneNumber + "\n";
    }
}
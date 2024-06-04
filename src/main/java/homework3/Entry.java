package homework3;
public class Entry implements Comparable<Entry> {
    private String name;
    private String surname;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry() {
    }

    public Entry(String name, String surname, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        int surnameComparison = this.surname.compareTo(other.surname);
        if (surnameComparison != 0) {
            return surnameComparison;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return  "Name: " + this.surname + ", " + this.surname  + "\n" +
                "Street address: " + this.streetAddress + "\n" +
                "City: " + this.city + "\n" +
                "Postal code: " + this.postcode + "\n" +
                "Country: " + this.country + "\n" +
                "Phone number: " + this.phoneNumber + "\n";

    }
}
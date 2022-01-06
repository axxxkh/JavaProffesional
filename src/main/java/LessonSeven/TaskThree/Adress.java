package LessonSeven.TaskThree;

public class Adress {
    private String citySize;
    private String city;
    private String street;
    private String house;

    public Adress() {
    }

    public Adress(String citySize, String city, String street, String house) {
        this.citySize = citySize;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCitySize() {
        return citySize;
    }

    public void setCitySize(String citySize) {
        this.citySize = citySize;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "citySize='" + citySize + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }
}

package LessonSeven.TaskFour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "adress")
public class Adress {
    @XmlElement (name = "CitySize")
    private String citySize;
    @XmlElement (name = "city")
    private String city;
    @XmlElement (name = "street")
    private String street;
    @XmlElement(name = "house")
    private String house;

    public Adress(String citySize, String city, String street, String house) {
        this.citySize = citySize;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Adress() {
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

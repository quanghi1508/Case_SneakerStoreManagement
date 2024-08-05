package Model;

public class Customer {
    private int code;
    private String name;
    private int dayofbirth;
    private String gender;
    private int phone;
    private String address;

    public Customer(int code, String name, int dayofbirth, String gender, int phone, String address) {
        this.code = code;
        this.name = name;
        this.dayofbirth = dayofbirth;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDayofbirth() {
        return dayofbirth;
    }

    public void setDayofbirth(int dayofbirth) {
        this.dayofbirth = dayofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", dayofbirth=" + dayofbirth +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}

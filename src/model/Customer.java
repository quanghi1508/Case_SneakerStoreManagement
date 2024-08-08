package model;

public class Customer {
    private String code;
    private String name;
    private String dayofbirth;
    private String gender;
    private String phone;
    private String address;

    public Customer(String code, String name, String dayofbirth, String gender, String phone, String address, String value) {
        this.code = code;
        this.name = name;
        this.dayofbirth = dayofbirth;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayofbirth() {
        return dayofbirth;
    }

    public void setDayofbirth(String dayofbirth) {
        this.dayofbirth = dayofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Customer fromCSV(String csvLine){
        String[] values = csvLine.split(",");
        return new Customer(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
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

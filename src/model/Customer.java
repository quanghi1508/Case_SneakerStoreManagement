package model;

public class Customer {
    private String code;
    private String name;
    private String dateofbirth;
    private String gender;
    private String phone;
    private String address;

    public Customer(String code, String name, String dateofbirth, String gender, String phone, String address) {
        this.code = code;
        this.name = name;
        this.dateofbirth = dateofbirth;
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

    public String getDataofbirth() {
        return dateofbirth;
    }

    public void setDataofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
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
        return new Customer(values[0], values[1], values[2], values[3], values[4], values[5]);
    }

    public String convertData(){
        return String.join(",", code,name,dateofbirth,gender,phone,address);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", dayofbirth=" + dateofbirth +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}

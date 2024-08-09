package model;

public class Employee {
    private String code;
    private String name;
    private String dateofbirth;
    private String gender;
    private String cccd;
    private String phone;
    private String position;

    public Employee(String code, String name, String dateofbirth, String gender, String cccd, String phone, String position) {
        this.code = code;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.cccd = cccd;
        this.phone = phone;
        this.position = position;
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

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static Employee fromCSV(String csvLine){
        String[] values = csvLine.split(",");
        return new Employee(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
    }

    public String convertData() {
        return String.join(",", code,name,dateofbirth,gender,cccd,phone,position);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", dayofbirth=" + dateofbirth +
                ", gender='" + gender + '\'' +
                ", cccd=" + cccd +
                ", phone=" + phone +
                ", position='" + position + '\'' +
                '}';
    }
}

package model;

public class Employee {
    private int code;
    private String name;
    private int dayofbirth;
    private String gender;
    private int cccd;
    private int phone;
    private String position;

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

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(int code, String name, int dayofbirth, String gender, int cccd, int phone, String position) {
        this.code = code;
        this.name = name;
        this.dayofbirth = dayofbirth;
        this.gender = gender;
        this.cccd = cccd;
        this.phone = phone;
        this.position = position;

    }

    public String convertData() {
        return "" + code + "," + name + "," + dayofbirth + "," + gender + "," + cccd + "," + phone+ "," +position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", dayofbirth=" + dayofbirth +
                ", gender='" + gender + '\'' +
                ", cccd=" + cccd +
                ", phone=" + phone +
                ", position='" + position + '\'' +
                '}';
    }
}

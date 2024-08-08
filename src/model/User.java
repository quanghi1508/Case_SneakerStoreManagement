package model;

public class User {
    private String name;
    private String dateofbirth;
    private String email;
    private String phone;
    private String username;
    private String password;


    public User(String name, String dateofbirth, String email, String phone, String username, String password) {
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User fromCSV(String csvLine){
        String[] values = csvLine.split(",");
        return new User(values[0], values[1], values[2], values[3], values[4], values[5]);

    }

    public String convertData(){
        return  name + "," + dateofbirth + "," + email + "," + phone + "," + username + "," + password;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

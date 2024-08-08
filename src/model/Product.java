package model;

public class Product {
    private String code;
    private String name;
    private String size;
    private String quantity;
    private String type;
    private int price;

    public Product(String code, String name, String size, String quantity, String type, int price) {
        this.code = code;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Product fromCSV(String csvLine){
        String[] values = csvLine.split(",");
        return new Product(values[0], values[1], values[2], values[3], values[4], Integer.parseInt(values[5]));
    }

    public String convertData(){
        return " " + code + "," + name + "," + size + "," + quantity + "," + type + "," + price ;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", quantity='" + quantity + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

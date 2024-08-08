package model;

public class Cart {
    private String code;
    private String name;
    private String size;
    private String type;
    private int price;

    public Cart(String code, String name, String size, String type, int price) {
        this.code = code;
        this.name = name;
        this.size = size;
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

    public String convertData(){
        return " " + code + "," + name + "," + size + "," + type + "," + price;
    }

    public static Cart fromCSV(String csvLine){
        String[] values = csvLine.split(",");
        return new Cart(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

package model;

public class CartLine {
    private String codeProduct;
    private String codeCart;
    private String code;

    public CartLine(String codeProduct, String codeCart, String code) {
        this.codeProduct = codeProduct;
        this.codeCart = codeCart;
        this.code = code;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getCodeCart() {
        return codeCart;
    }

    public void setCodeCart(String codeCart) {
        this.codeCart = codeCart;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static CartLine fromCSV(String csvLine){
        String[] values = csvLine.split(",");
        return new CartLine(values[0], values[1], values[2]);
    }

    public String convertData(){
        return "" + codeProduct + " " + codeCart + " " + code;
    }
    @Override
    public String toString() {
        return "CartLine{" +
                "codeProduct='" + codeProduct + '\'' +
                ", codeCart='" + codeCart + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

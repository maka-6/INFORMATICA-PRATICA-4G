package Makaoui_verifica_22_1_2025;

public class Prodotto {
    private String name;
    private String category;
    private double price;
    private int code;

    public Prodotto( String name, String category, double price, int code ){
        this.name = name;
        this.category = category;
        this.price = price;
        this.code = code;
    }

    public Prodotto(){
        name = "null";
        category = "null";
        price = 0;
        code = 0;
    }

    void setName( String name ){
        this.name = name;
    }
    void setCategory( String category ){
        this.category = category;
    }
    void setPrice( double price ){
        this.price = price;
    }
    void setCode( int code ){
        this.code = code;
    }

    String getName(){
        return name;
    }
    String getCategory(){
        return category;
    }
    Double getPrice(){
        return price;
    }
    int getCode(){
        return code;
    }

    @Override
    public String toString(){
        return "Categoria: " + category + " Nome: " + name + " " + price + "$ " + " Codice: " + code;
    }
}
package ead3.assignment3;

public class Services {
    private int id;
    private String name;
    private Double price;

    public Services(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Services() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

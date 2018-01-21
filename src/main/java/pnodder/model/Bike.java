package pnodder.model;

public class Bike {

    private String make;
    private String model;
    private Integer price;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String desciption() {
        return getMake() + " " + getModel();
    }
}

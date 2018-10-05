package test.min.com.mytest.view;

public class Food {
    private int imageId;
    private String name;
    private String address;
    private String price;
    private String telephone;
    private String recommend;

    public Food() {

    }

    public Food(int imageId, String name, String address, String price, String telephone, String recommend) {
        this.imageId = imageId;
        this.name = name;
        this.address = address;
        this.price = price;
        this.telephone = telephone;
        this.recommend = recommend;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}

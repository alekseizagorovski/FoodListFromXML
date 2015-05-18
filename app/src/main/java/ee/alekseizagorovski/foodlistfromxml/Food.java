package ee.alekseizagorovski.foodlistfromxml;

public class Food {
    private String name;
    private String price;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private String description;

    public String getCalories() {
        return calories;
    }
    public void setCalories(String calories) {
        this.calories = calories;
    }
    private String calories;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    private String id;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public Food(String id, String name, String price){

        this.id=id;
        this.name=name;
        this.price=price;

    }
    public Food(){

    }

}

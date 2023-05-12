package lt.viko.eif.vskuder.soap.gameStore.Test;

public class GameModel {

    int id;
    String title;
    double price;
    DeveloperModel developer;
    CategoryModel category;

    public GameModel(int id, String title, double price, DeveloperModel developer, CategoryModel category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.developer = developer;
        this.category = category;
    }

    public GameModel(String title, double price, DeveloperModel developer, CategoryModel category) {
        this.title = title;
        this.price = price;
        this.developer = developer;
        this.category = category;
    }

    public GameModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DeveloperModel getDeveloper() {
        return developer;
    }

    public void setDeveloper(DeveloperModel developer) {
        this.developer = developer;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}

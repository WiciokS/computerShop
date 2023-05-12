package lt.viko.eif.vskuder.soap.gameStore.Test;

public class DeveloperModel {

    int id;
    String name;

    public DeveloperModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DeveloperModel(String name) {
        this.name = name;
    }

    public DeveloperModel() {

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
}

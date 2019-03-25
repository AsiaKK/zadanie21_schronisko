package pl.jkk.schronisko.model;

public class Animal implements Comparable<Animal> {

    private String name;
    private String category;
    private String description;
    private String imgUrl;

    public Animal() {
    }

    public Animal(String name, String category, String description, String imgUrl) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Animal o) {

        if (this.name.compareToIgnoreCase(o.name) > 0)
            return 1;
        else if (this.name.compareToIgnoreCase(o.name) == 0) {
            return 0;
        } else
            return -1;

    }
}
package examples.nine_9.homeWork;

@Table(title = "authors")
public class Author {

    @Column
    String name;

    @Column
    String surName;

    public Author(String name, String surName){
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
}

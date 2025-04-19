package ComposerApp;

public class Composer {
    /* Class to represent a composer. */
    private Integer id;
    private String name;
    private String genre;

    /* No-argument constructor that creates a default composer.*/
    Composer() {
        id = 0;
        name = "";
        genre = "";
    }

    /*
     * Argument constructor that creates a composer using all
     * three data fields of id, name, and genre.
     */
    Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    /*Returns id to MemoComposerDoa.findBy()*/
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
    /*Overriding toString inherited from the Object class 
    * provides a string representation of an object.*/
    @Override
    public String toString() {

        return "Id:  " + id + "\nName:  " + name + "\nGenre:  " + genre;
    }

}

package ComposerApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemComposerDao implements ComposerDao {
    /* Class to represent the operations in a composer data persistence layer. */
    private List<Composer> composers;

    /*
     * No-argument constructor that creates a default list of five composer objects.
     */
    public MemComposerDao() {
        /* Composer #1 */
        this.composers = new ArrayList<>();
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        /* Composer #2 */
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        /* Composer #3 */
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        /* Composer #4 */
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        /* Composer #5 */
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    /*
     * Override GenericDa0 interface to represent the operations in a data
     * persistence layer
     * import java.util.List added to GenericDao.java to prevent List error.
     */
    @Override
    /* Return list of composers from ArrayList. */
    public List<Composer> findAll() {
        return new ArrayList<>(this.composers);
    }

    /*
     * Override GenericDa0 interface to represent the operations in a data
     * persistence layer.
     */
    @Override
    /* Return composer data from ArrayList. */
    public Composer findBy(Integer key) {
        /* Loop through ArrayList until composer found. */
        for (Composer composer : composers) {
            if (composer.getId() == key) {
                return composer; // Return the found composer
            }
        }
        return null; // No composer found after checking all
    }

    /*
     * Override GenericDa0 interface to represent the operations in a data
     * persistence layer.
     */
    @Override
    /* Insert new composer data into ArrayList. */
    public void insert(Composer entity) {
        composers.add(entity);
        System.out.println("Inserted: " + entity);
    }
}

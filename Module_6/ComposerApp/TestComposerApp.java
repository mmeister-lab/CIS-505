package ComposerApp;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*TestComposerApp to test the classes Composer and MemComposerDao.*/
public class TestComposerApp {
    /* Menu method */
    public static String menu() {
        return "MENU OPTIONS\n" +
                "1. View Composers\n" +
                "2. Find Composer\n" +
                "3. Add Composer\n" +
                "4. Exit\n\n" +
                "Please choose an option:  ";
    }

    public static void main(String[] args) {

        /*
         * Scanner class is used to get user input, and it is found in the java.util
         * package.
         * If static, a Unresolved compilation problem error will result
         */

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        int input = 0;
        System.out.println("Welcome to the Composer App\n");
        /*
         * Create an instance of MemComposerDao class create and default populate array
         * and
         * manage input/output
         */
        MemComposerDao memcomposerDao = new MemComposerDao();
        /*
         * Create an ArrayList of composers. This is a class level to support list of
         * composers when a new composer is inserted
         */
        List<Composer> allComposers = new ArrayList<>();

        /*
         * Display a list of composers. Uses the MemComposerDao classes findAll method.
         */
        while (input != 4) {
            /* User prompt. */
            System.out.print(menu());
            input = sc.nextInt();

            allComposers = memcomposerDao.findAll();
                /*Display title*/
                System.out.println("\n--DISPLAY COMPOSERS--");        

            if (input == 1) {
                if (!allComposers.isEmpty()) {
                    /* Loop through composers in ArrayList and print. */
                    for (Composer composer : allComposers)
                        System.out.println(composer + "\n");

                } else {
                    System.out.println("\nNo composers found.\n\n");
                }
            }
            /*
             * Prompt the user to enter an id and display the selected composer object.
             * Uses the MemComposerDao classes findBy method.
             */
            else if (input == 2) {

                /* User prompt. */
                System.out.print("Enter an id: ");
                int input2;
                input2 = sc2.nextInt();
                /* Search for and return composer or not found. */
                Composer oneComposer = memcomposerDao.findBy(input2);

                /*Display title*/
                System.out.println("\n--DISPLAY COMPOSER--");               
                /* Determine if a composer is found that matches input. */
                if (oneComposer != null) {
                    System.out.println(oneComposer + "\n");
                } else {
                    System.out.println("Composer with id " + input2 + " not found.\n\n");
                }
            }
            /*
             * The user to create a new composer. Uses the MemComposerDao classes insert
             * method.
             */
            else if (input == 3) {
                /* User prompts. */
                System.out.print("Enter an id:  ");
                Integer id = sc3.nextInt();

                /*
                 * The next() method in Java's Scanner class reads input only up to the next
                 * whitespace.
                 * To read the entire line of input, including spaces, the nextLine() method
                 * used instead.
                 */
                /*
                 * Consume the newline character left by nextInt() The nextLine() method in
                 * Java's Scanner class might appear to not stop for input when it is called
                 * immediately
                 * after methods like nextInt(), nextFloat(), or next(). This behavior occurs
                 * because
                 * these methods do not consume the newline character ("\n") that is generated
                 * when the user
                 * presses the Enter key after providing input. Consequently, when nextLine() is
                 * called
                 * subsequently, it reads this leftover newline character as an empty string,
                 * and thus appears
                 * to skip waiting for actual input. To resolve this issue, a common approach is
                 * to add
                 * an extra nextLine() call after using methods like nextInt() or next(). This
                 * additional
                 * call consumes the remaining newline character in the input buffer, allowing
                 * the
                 * subsequent nextLine() call to correctly wait for the user's actual input.
                 */
                sc3.nextLine();
                System.out.print("Enter a name:  ");
                String name = sc4.nextLine();

                System.out.print("Enter a genre: ");
                String genre = sc5.nextLine();

                /* Insert new composer. */
                Composer insertComposer = new Composer(id, name, genre);
                memcomposerDao.insert(insertComposer);
                System.out.println("\n");
            }
            /* Exit the program. */
            else if (input != 4) {
                System.out.println("Invalid entry");
            }

        }

        System.out.print("Program terminated by the user...");
        /*
         * Close scanners to prevent memory leaks. If scanner closed in if conditional
         * expression, an error will be thrown.
         */
        sc.close();
        sc2.close();
        sc3.close();
        sc4.close();
        sc5.close();
    }
}
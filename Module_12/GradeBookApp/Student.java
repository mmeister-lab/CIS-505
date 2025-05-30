
/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package GradeBookApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    /* Private variables */
    private String firstName;
    private String lastName;
    private String course;
    private String grade;
    private String printString = "In Student";
    private static final String FILE_NAME = "grades.csv";
    private static File file = new File(FILE_NAME);
    private static Path filePath = Paths.get(FILE_NAME);
    /*
     * Constructor with 4 arguments
     * 
     * @firstName
     * 
     * @lastName
     * 
     * @course
     * 
     * @grade
     */

    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    }

    /* Default constructor with no arguments */
    public Student() {
        /* Initialize private variables. */
        this.firstName = "";
        this.lastName = "";
        this.course = "";
        this.grade = "";

    }

    /* Getters and setters. */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String buildString() throws IOException {
        /* Create string to store data from grades.csv. */
        String printString = "";
        /* Create scanner to read file grades.csv. */
        try {
            /* Scanner to read file lines. */
            Scanner input = new Scanner(file);

            /* Loop while grades.csv lines can be read. */
            while (input.hasNext()) {
                /* Create a String array of 4 columns to store line of grades.csv file. */
                String[] values = new String[4];
                /*
                 * Read line from grades.csv into string array separating columns base on comma
                 * delimiter.
                 * Use nextLine or spaces in data will generate errors.
                 */
                values = input.nextLine().split(",");
                /*
                 * Append data to string with String.format.
                 * Format values[0] (first name) as 20 spaces left justified and padded with
                 * spaces.
                 * Format values[1] (last name) as 20 spaces left justified and padded with
                 * spaces.
                 * Format values[2] (course) as 5 spaces left justified and padded with spaces.
                 * Format values[3] (grade) as center justified.*/
                printString = printString + String.format("%-20s", values[0]) + String.format("%-20s", values[1])
                        + String.format("%-8s", values[2])
                        + String.format("%" + ((5 - values[3].length()) / 2 + values[3].length()) + "s", values[3])
                        + "\n";
            }
            /* Close the scanner to prevent memory leaks. */
            input.close();
        } catch (Exception e) {
            // TODO: handle exception
            printString = "File read error.";
        }
        /* Return string containing student data. */
        return printString;

    }

    public String deleteRecord() {
        /* Create a string to return message with status of write attempt. */
        String strDeleteStatus = "";
        /* Create list of Strings to save file lines. */
        List<String> stringList = new ArrayList<>();
        /* Count of file records. */
        int lineCount = 0;
        /* Count of records not equal to student record to be deleted. */
        int lineCount2 = 0;

        /* Read file into stringList */
        try {
            /* New scanner to read file. */
            Scanner input2 = new Scanner(file);
            /* String to store line read. */
            String stringRecord = "";

            /* Loop while grades.csv lines can be read. */
            while (input2.hasNext()) {
                /* Read line to string. */
                stringRecord = input2.nextLine();
                /* Increment count of record lines. */
                lineCount++;
                /*
                 * Compare to determine if the record to delete matches file line. If not, save
                 * to ArrayList.
                 */
                if (!stringRecord.equals(firstName + "," + lastName + "," + course + "," + grade)) {
                    /* Do not add an empty line to ArrayList. */
                    if (!stringRecord.trim().isEmpty()) {
                        /* Add file line to ArrayList of student records. */
                        stringList.add(stringRecord);
                    }
                    /* Increment count of student records that do not match record to be deleted. */
                    lineCount2++;
                }

            }

            /* Close the scanner to prevent memory leaks. */
            input2.close();
        }

        catch (IOException e) {
            /* Populate error message to status string for return. */
            strDeleteStatus = "An error occurred while writing to the file: " + e.getMessage();
        }

        if (lineCount != lineCount2) {
            /* If the counts do not match, a student record to delete was found. */
            /* Write file */
            /* Check if the file exists */
            if (file.exists()) {
                /* Try to delete existing file to be rewritten without delete student record. */
                try {
                    Files.delete(filePath);

                } catch (IOException e) {
                    /* Populate error message to status string for return. */
                    strDeleteStatus = "An error occurred while writing to the file: " + e.getMessage();
                }
                try (FileWriter writer = new FileWriter(file, true)) {
                    for (int i = 0; i < stringList.size(); i++) {
                        /* Write first name, last name, course, and grade to grades.csv file */
                        writer.write(stringList.get(i) + "\n");
                        strDeleteStatus = "Successfully wrote data to the file.";
                    }
                } catch (IOException e) {
                    /* Populate error message to status string for return. */
                    strDeleteStatus = "An error occurred while writing to the file: " + e.getMessage();
                }

            }
        } else {
            /* Return message that no match found because counts are equal. */
            strDeleteStatus = "Student record not found.";
        }
        /* Return status. */

        return strDeleteStatus;
    }

    public String writeFile() {
        /* Create a string to return message with status of write attempt. */
        String strWriteStatus = "";

        /* Check if the file exists */
        if (!file.exists()) {
            /* Format data header string for grades.csv file. */
            String header = "First Name,Last Name,Course,Grade\n";
            /* Write to the file (will overwrite if the file exists) */
            try (FileWriter writer = new FileWriter(file, true)) {
                /* Write header to grades.csv */
                writer.write(header);
                /* status message to return */

                strWriteStatus = "Successfully wrote header to the file. ";
            } catch (IOException e) {
                /* Populate error message to status string for return. */
                strWriteStatus = "An error occurred while writing to the file: " + e.getMessage();
            }
        }
        // Write data
        try (FileWriter writer = new FileWriter(file, true)) {
            /* Write first name, last name, course, and grade to grades.csv file */
            writer.write(firstName + "," + lastName + "," + course + "," + grade + "\n");
            strWriteStatus = strWriteStatus + "Successfully wrote data to the file.";
        } catch (IOException e) {
            /* Populate error message to status string for return. */
            strWriteStatus = strWriteStatus + "An error occurred while writing to the file: " + e.getMessage();
            ;
        }
        /* Return status. */
        return strWriteStatus;
    }

    @Override
    public String toString() {
        try {
            /* Copy results of file read to printString string. */
            this.printString = buildString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /* Return grades.csv data or error message. */
        return this.printString;

    }

}

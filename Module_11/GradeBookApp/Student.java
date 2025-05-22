
package GradeBookApp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
private String firstName;
private String lastName;
private String course;
private String grade;
private String printString = "In Student";
private static final String FILE_NAME = "grades.csv";
private static File file = new File(FILE_NAME);


public Student(String firstName, String lastName, String course, String grade) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.course = course;
    this.grade = grade;
}
public Student(){
    this.firstName = "";
    this.lastName = "";
    this.course = "";
    this.grade = "";
    
}
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

public  String buildString() throws IOException{
        String printString = "";
       Scanner input = new Scanner(file);

        while (input.hasNext()) {
        String [] values = new String[4];
        values = input.next().split(",");
        //printString = printString + input.next() + "\n" ;
        System.out.println("Padding: " + Math.subtractExact(25,values[0].length()));
        System.out.println("length "+values[0].length());
        printString = printString + String.format("%-"+ Math.subtractExact(22,values[0].length()) + "s",values[0]) + String.format("%-"+ Math.subtractExact(22,values[1].length()) + "s",values[1]) + String.format("%-"+ Math.subtractExact(20,values[2].length()) + "s",values[2])+values[3]+"\n";
        }
        input.close();
    return printString;
    
}

public String writeFile(){
            String strWriteStatus = "";

            // Check if the file exists
           if (!file.exists()) {
               /*Format file header */
            String header = "First_Name,Last_Name,Course,Grade";         
               // Write to the file (will overwrite if the file exists)
            try (FileWriter writer = new FileWriter(file,true)) {
                writer.write(header);
                strWriteStatus = "Successfully wrote to the file.";
            } catch (IOException e) {
                strWriteStatus ="An error occurred while writing to the file: " + e.getMessage();}
           }
          // Write data
            try (FileWriter writer = new FileWriter(file,true)) {
                writer.write("\n"+firstName+","+lastName+","+course+","+grade);
                strWriteStatus="Successfully wrote to the file.";
            } catch (IOException e) {
                strWriteStatus="An error occurred while writing to the file: " + e.getMessage();;
            }
    return strWriteStatus;
}

@Override
public String toString() {
        try {
            this.printString = buildString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return this.printString;


}



}

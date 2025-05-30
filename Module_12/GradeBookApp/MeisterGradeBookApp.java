/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package GradeBookApp;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;

public class MeisterGradeBookApp extends Application {

    /* Two TextField nodes */
    private TextField tfFirstName = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfCourse = new TextField();
    /* TextArea node */
    private TextArea tArea = new TextArea();

    /* 5 Label nodes */
    private Label lblFirstName = new Label("First Name:");
    private Label lblLastName = new Label("Last Name:");
    private Label lblCourse = new Label("Course:");
    private Label lblInstructions = new Label(
            "Enter First Name, Last Name, Course, and choose Grade to save or delete." +
                    "\nFirst Name and Last Name character limit 20 and Course character limit 7.");

    private Label lblGrade = new Label("Grade:");
    private Label lblMessage = new Label();
    /* ComboBox node */
    private ComboBox<String> cbGrades = new ComboBox<>();
    /* Add Button node */
    private Button btnAdd = new Button("Add");
    /* Lookup Button node */
    private Button btnViewGrades = new Button("View Grades");
    /* Clear Button node */
    private Button btnDelete = new Button("Delete");
    /* Clear Button node */
    private Button btnClear = new Button("Clear");
    /* Create String Array to populate dropdown list. */
    private String[] gradesList = new String[5];

    @Override
    public void start(Stage primaryStage) {
        /*
         * Assign Lucida Console font to tArea TextArea. This is a
         * monospace font. A monospaced font, also known as a fixed-width
         * or non-proportional font, is a typeface where each character
         * occupies the same amount of horizontal space.
         */
        tArea.setFont(Font.font("Lucida Console",
                FontWeight.BOLD, FontPosture.REGULAR, 12));
        /* Assign tArea TextArea font weight bold. */
        tArea.setStyle("-fx-font-weight: bold");
        /* Set tArea TextArea's font color to black. */
        tArea.setStyle("-fx-text-fill: black");
        /* If Licida Console is not on device, another monospace font will be assign. */
        tArea.setStyle("-fx-font-family: Monospaced;");
        /* Set tArea TextArea preferred width */
        tArea.setPrefWidth(450);
        /* Set tArea TextArea minimum width. */
        tArea.setMinWidth(450);
        /*
         * Setting tArea editable to false will prevent useless adding of text to tArea.
         */
        tArea.setEditable(false);
        /*
         * Prevents tab focus on text area, which does not have editable text. Scroll
         * bars still work.
         */
        tArea.setFocusTraversable(false);

        /* define height of lblInstructions label so text fits on screen at startup. */
        lblInstructions.setMinHeight(50);

        /* GridPane arranges nodes in a grid (matrix) formation. */
        GridPane pane = new GridPane();
        /* Set node properties */
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        /* Populate dropdown array items. */
        gradesList[0] = "A";
        gradesList[1] = "B";
        gradesList[2] = "C";
        gradesList[3] = "D";
        gradesList[4] = "F";
        /*
         * ObservableArrayList is a String[] array that allows listeners to track
         * changes
         * when they occur. In order to track changes, the internal array is
         * encapsulated
         * and there is no direct access available from the outside. Bulk operations are
         * supported but they always do a copy of the data range.
         */
        ObservableList<String> items = FXCollections.observableArrayList(gradesList);
        /* Populate combobox. */
        cbGrades.getItems().addAll(items);
        /* Set default value of combobox. */
        cbGrades.setValue("");
        /*
         * Add First Name Label to first column and TextField to first column
         * of first row of grid.
         */
        pane.add(lblFirstName, 0, 0);
        pane.add(tfFirstName, 1, 0);

        /*
         * Add Last Name Label first column and TextField to second column
         * of second row of grid.
         */
        pane.add(lblLastName, 0, 1);
        pane.add(tfLastName, 1, 1);

        /*
         * Add Course Label first column and TextField to second column
         * of second row of grid.
         */
        pane.add(lblCourse, 0, 2);
        pane.add(tfCourse, 1, 2);

        /*
         * Add Grades Label to first column and ComboBox to second column
         * of fourth row of grid.
         */
        pane.add(lblGrade, 0, 3);
        pane.add(cbGrades, 1, 3);

        /* Add Instructions Format Label second column of third row of grid. */
        pane.add(lblInstructions, 0, 4, 2, 1);
        /* position the label to the right of the pane. */
        GridPane.setHalignment(lblInstructions, HPos.LEFT);

        /* Create a new HBox container for buttons */
        HBox actionBtnContainer = new HBox();
        /* Set the containers padding. */
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        /* Set the container's spacing. */
        actionBtnContainer.setSpacing(10);
        /* Add the brnAdd to the container. */
        actionBtnContainer.getChildren().add(btnAdd);
        /* Add the brnLookup to the container. */
        actionBtnContainer.getChildren().add(btnViewGrades);
        /* Add the btnDelete to the container. */
        actionBtnContainer.getChildren().add(btnDelete);
        /* Add the btnClear to the container. */
        actionBtnContainer.getChildren().add(btnClear);
        /* Set buttons to right alignment. */
        actionBtnContainer.setAlignment(Pos.CENTER_RIGHT);
        /* Add the container to the second column of the fifth row of the grid. */
        pane.add(actionBtnContainer, 1, 5);

        /* Add Future Value Date Label to the first column of the sixth row of grid. */
        pane.add(lblMessage, 0, 6, 2, 1);

        /* Add TextArea to the seventh row of the grid spanning columns 1 and 2. */
        pane.add(tArea, 0, 7, 2, 1);

        /* Create scene and place it in the stage. */
        Scene scene = new Scene(pane, 500, 500);
        /* Primary stage's title to “Meister GradeBook App” */
        primaryStage.setTitle("Meister GradeBook App");
        /* Place the scene in the stage. */
        primaryStage.setScene(scene);
        /* Display the stage */
        primaryStage.show();

        /*
         * Krasso, R., (2021). CIS 505 Intermediate Java Programming.
         * Bellevue University, all rights reserved.
         */
        /* Call clearFormFields method on click of Clear button. */
        btnClear.setOnAction(e -> clearFormFields());
        /* Call viewGrades method on click of View Grades button. */
        btnViewGrades.setOnAction(e -> viewGrades());
        /* Call saveGrade method on click of Add button. */
        btnAdd.setOnAction(e -> saveGrade());
        /* Call deleteGrade method on click of Delete button. */
        btnDelete.setOnAction(e -> deleteGrade());
    }

    public static void main(String[] args) {
        /* Launch the application. */
        Application.launch(args);
    }

    private void clearFormFields() {
        /* Clear form fields. */
        tArea.setText("");
        tfFirstName.setText("");
        tfLastName.setText("");
        tfCourse.setText("");
        lblMessage.setText("");
        cbGrades.getSelectionModel().clearSelection();
    }

    private void viewGrades() {
        /* Shows grades from csv file. */
        /* Clear any leftover messages in lblMessage TextField. */
        lblMessage.setText("");
        /* Set lblMessage Label's font color black. */
        lblMessage.setStyle("-fx-text-fill: black");
        /* Create an instance of Student class using default constructor. */
        Student student = new Student();
        /*
         * Set text in tArea TextArea with string returned from toString method of
         * student instance.
         */
        tArea.setText(student.toString());
    }

    private void saveGrade() {
        /* Saves student grade data to csv file. */
        /* Clear any leftover messages in lblMessage TextField. */
        lblMessage.setText("");
        /* Set lblMessage Label's default font color black. */
        lblMessage.setStyle("-fx-text-fill: black");
        /*
         * If all fields have data, save student first name, last name, course, and
         * grade to csv file.
         */
        if (tfFirstName.getLength() > 20) {
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            lblMessage.setText("First Name limit 20 characters.");
        } else if (tfLastName.getLength() > 20) {
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            lblMessage.setText("Last Name limit 20 characters.");
        } else if (tfCourse.getLength() > 7) {
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            lblMessage.setText("Course limit 7 characters.");
        } else if (!tfCourse.getText().isEmpty() && !tfFirstName.getText().isEmpty() && !tfLastName.getText().isEmpty()
                && !cbGrades.getValue().isEmpty()) {
            /* Create an instance of the Student class using four-parameter constructor. */
            Student student = new Student(tfFirstName.getText(), tfLastName.getText(), tfCourse.getText(),
                    cbGrades.getValue());
            /*
             * Call writeFile method of instance of Student class. Returns success status to
             * lblMessage label.
             */

            lblMessage.setText(student.writeFile());

            /* Set lblMessage Label's font color gree if successful write. */
            lblMessage.setStyle("-fx-text-fill: green");
        } else {
            /*
             * If field information is missing, error message is displayed in lblMessage
             * label.
             */
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            /* Set lblMessage Label's text. */
            lblMessage.setText("Please complete all fields");
        }
    }

    private void deleteGrade() {
        /* Deletes student grade data to csv file. */
        /* Clear any leftover messages in lblMessage TextField. */
        lblMessage.setText("");

        /* Set lblMessage Label's default font color black. */
        lblMessage.setStyle("-fx-text-fill: black");

        /* If all fields have data, save student first name, last name, course, and
         * grade to csv file.*/
        if (tfFirstName.getLength() > 20) {
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            lblMessage.setText("First Name limit 20 characters.");
        } else if (tfLastName.getLength() > 20) {
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            lblMessage.setText("Last Name limit 20 characters.");
        } else if (tfCourse.getLength() > 7) {
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            lblMessage.setText("Course limit 7 characters.");
        } else if (!tfCourse.getText().isEmpty() && !tfFirstName.getText().isEmpty() && !tfLastName.getText().isEmpty()
                && !cbGrades.getValue().isEmpty()) {
            /* Create an instance of the Student class using four-parameter constructor. */
            Student student = new Student(tfFirstName.getText(), tfLastName.getText(), tfCourse.getText(),
                    cbGrades.getValue());

            /* Call deleteFile method of instance of Student class. Returns success status
             * to lblMessage label.*/

            String result = student.deleteRecord();

            if (result == "Successfully updated file.") {
                /* Set lblMessage Label's font color green if successful delete. */
                lblMessage.setStyle("-fx-text-fill: green");
            } else {
                /* Set lblMessage Label's font color red if not successful delete. */
                lblMessage.setStyle("-fx-text-fill: red");
            }
            /* Set lblMessage text from return string from delete attempt. */
            lblMessage.setText(result);

        } else {
            /*
             * If field information is missing, error message is displayed in lblMessage label.*/
            /* Set lblMessage Label's font color red. */
            lblMessage.setStyle("-fx-text-fill: red");
            /* Set lblMessage Label's text. */
            lblMessage.setText("Please complete all fields.");
        }
    }
}

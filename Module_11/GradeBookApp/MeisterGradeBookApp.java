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
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;

public class MeisterGradeBookApp extends Application {

    /* Two TextField nodes */
    private TextField tfFirstName = new TextField();
    private TextField tfLastName  = new TextField();
    private TextField tfCourse = new TextField();
    /* TextArea node */
    private TextArea tArea = new TextArea();

  
    /* 5 Label nodes */
    private Label lblFirstName = new Label("First Name:");
    private Label lblLastName = new Label("Last Name:");
    private Label lblCourse = new Label("Course:");
    private Label lblInstructions = new Label("Enter First Name, Last Name, Course, and choose Grade to save.");
   
    private Label lblGrade = new Label("Grade:");
    private Label lblMessage = new Label();
    /* ComboBox node */
    private ComboBox<String> cbGrades = new ComboBox<>();
    /* Add Button node */
    private Button btnAdd = new Button("Add");
    /* Lookup Button node */
    private Button btnViewGrades = new Button("View Grades");
    /* Clear Button node */
    private Button btnClear = new Button("Clear");
     /* Create String Array to populate dropdown list. */
    private String[] gradesList = new String[5];

    @Override
    public void start(Stage primaryStage) {
    tArea.setFont(Font.font("Lucida Console", 
       FontWeight.BOLD,FontPosture.REGULAR,12));
        tArea.setStyle("-fx-font-weight: bold");
       tArea.setStyle("-fx-text-fill: black;");
        tArea.setStyle("-fx-font-family: Monospaced;");


        /*define height of lblInstructions label so text fits on screen at startup.*/
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
        /* Add First Name Label to first column and TextField to first column
        of first row of grid. */
        pane.add(lblFirstName, 0, 0);
        pane.add(tfFirstName, 1, 0);

        /* Add Last Name Label first column and TextField to second column
        of second row of grid. */
        pane.add(lblLastName, 0, 1);
        pane.add(tfLastName, 1, 1);

        /* Add Course Label first column and TextField to second column
        of second row of grid. */
        pane.add(lblCourse, 0, 2);
        pane.add(tfCourse, 1, 2);

        /* Add Grades Label to first column and  ComboBox to second column
         of fourth row of grid. */
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
        /* Call clearFormFields method on click of Clear button. */
        btnClear.setOnAction(e -> clearFormFields());
        btnViewGrades.setOnAction(e -> viewGrades());
        btnAdd.setOnAction(e -> saveGrade());
    }

    public static void main(String[] args) {

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

    private void viewGrades(){
        Student student = new Student();
        tArea.setText(student.toString());
    }

    private void saveGrade(){
        /*If all fields have data, save student first name, last name, course, and grade to csv file.*/
        if(!tfCourse.getText().isEmpty()&&!tfFirstName.getText().isEmpty()&&!tfLastName.getText().isEmpty()&&!cbGrades.getValue().isEmpty()){
            /*Write student data and header if file is created */
        Student student = new Student(tfFirstName.getText(), tfLastName.getText(), tfCourse.getText(), cbGrades.getValue()); 
            lblMessage.setText(student.writeFile());
        }else{
            lblMessage.setText("Please complete all fields");
        }
    }

}


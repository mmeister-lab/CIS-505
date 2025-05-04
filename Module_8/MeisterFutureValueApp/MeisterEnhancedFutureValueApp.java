/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc
Oracle. (n.d.). Interface ObservableIntegerArray. Retrieved May 4, 2025, from 
https://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableIntegerArray.html*/
package MeisterFutureValueApp;

import javafx.scene.paint.Color;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class MeisterEnhancedFutureValueApp extends Application {

    /* Two TextField nodes */
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    /* TextArea node */
    private TextArea txtResults = new TextArea();
    /* 5 Label nodes */
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears = new Label("Years:");
    private Label lblFutureValueDate = new Label();
    /* ComboBox node */
    private ComboBox<Integer> cbYears = new ComboBox<>();

    /* Calculate Button node */
    private Button btnCalculate = new Button("Calculate");
    /* Clear Button node */
    private Button btnClear = new Button("Clear");
    /* Create Integer Array to populate dropdown list. */
    private Integer[] yearsList = new Integer[6];
    /* Create double for future value and set to 0. */
    double futureValue = 0.0;

    @Override
    public void start(Stage primaryStage) {

        /* GridPane arranges nodes in a grid (matrix) formation. */
        GridPane pane = new GridPane();
        /* Set node properties */
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        /* Populate dropdown array items. */
        yearsList[0] = 0;
        yearsList[1] = 1;
        yearsList[2] = 2;
        yearsList[3] = 3;
        yearsList[4] = 4;
        yearsList[5] = 5;
        /*
         * ObservableIntegerArray is a int[] array that allows listeners to track
         * changes
         * when they occur. In order to track changes, the internal array is
         * encapsulated
         * and there is no direct access available from the outside. Bulk operations are
         * supported but they always do a copy of the data range.
         */
        ObservableList<Integer> items = FXCollections.observableArrayList(yearsList);
        /* Populate combobox. */
        cbYears.getItems().addAll(items);
        /* Set default value of combobox. */
        cbYears.setValue(0);
        /* Set the font color of the interest rate instructions to red. */
        lblInterestRateFormat.setTextFill(Color.RED);

        /*
         * Add Monthly Payment Label to first column and TextField to second column
         * of first row of grid.
         */
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);

        /*
         * Add Interest Rate Label first column and TextField to second column
         * of second row of grid.
         */
        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);

        /* Add Interest Rate Format Label second column of third row of grid. */
        pane.add(lblInterestRateFormat, 1, 2);
        /* position the label to the right of the pane. */
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        /*
         * Add years Label to first column and ComboBox to second column
         * of fourth row of grid.
         */
        pane.add(lblYears, 0, 3);
        cbYears.prefWidthProperty().bind(txtInterestRate.widthProperty());
        pane.add(cbYears, 1, 3);

        /* Create a new HBox container for buttons */
        HBox actionBtnContainer = new HBox();
        /* Set the containers padding. */
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        /* Set the container's spacing. */
        actionBtnContainer.setSpacing(10);
        /* Add the btnClear to the container. */
        actionBtnContainer.getChildren().add(btnClear);
        /* Add the brnCalc to the container. */
        actionBtnContainer.getChildren().add(btnCalculate);
        /* Set buttons to right alignment. */
        actionBtnContainer.setAlignment(Pos.CENTER_RIGHT);
        /* Add the container to the second column of the fifth row of the grid. */
        pane.add(actionBtnContainer, 1, 4);

        /* Add Future Value Date Label to the first column of the sixth row of grid. */
        pane.add(lblFutureValueDate, 0, 5, 2, 1);

        /* Add TextArea to the seventh row of the grid spanning columns 1 and 2. */
        pane.add(txtResults, 0, 6, 2, 1);

        /* Create scene and place it in the stage. */
        Scene scene = new Scene(pane, 300, 400);
        /* Primary stage's title to “Meister Future Value App.” */
        primaryStage.setTitle("Meister Future Value App");
        /* Place the scene in the stage. */
        primaryStage.setScene(scene);
        /* Display the stage */
        primaryStage.show();
        /* Call clearFormFields method on click of Clear button. */
        btnClear.setOnAction(e -> clearFormFields());
        /* Call calculateResults method on click of Calculate button. */
        btnCalculate.setOnAction(e -> calculateResults());
    }

    public static void main(String[] args) {

        Application.launch(args);
    }

    private void clearFormFields() {
        /* Clear form fields. */
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        cbYears.getSelectionModel().clearSelection();
        cbYears.setValue(0);
    }

    private void calculateResults() {
        /* Collects the users's entered values and calls financeCalculator class. */
        /* Creates new instance of FinanceCalculator class */
        FinanceCalculator calculator = new FinanceCalculator();

        /* Calls calculateFutureValue method in calculator class. */
        futureValue = calculator.calculateFutureValue(Double.parseDouble(txtMonthlyPayment.getText()),
                Double.parseDouble(txtInterestRate.getText()), cbYears.getSelectionModel().getSelectedItem());

        /* Set formatted string to txtResults textArea */
        txtResults.setText(toString());
        /* Set text in future value date label */
        lblFutureValueDate.setText("Calculation as of " + todayDate());
    }

    private String todayDate() {
        /* Create a SimpleDateFormat object with the desired pattern */
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        /* Get the current date */
        Date today = new Date();
        /* Format the date using the format() method */
        String formattedDate = sdf.format(today);
        return formattedDate;
    }

    /* Override the toString method. Return a string. */
    @Override
    public String toString() {
        return String.format("The future value is $%,6.2f ", futureValue);
    }
}

/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class MeisterFutureValueApp extends Application {

    private TextField tfMessage1 = new TextField();
    private TextField tfMessage2 = new TextField();
    private TextArea tArea = new TextArea();
    private Label lblMonthlyPayment = new Label("Monthly Payment:  ");
    private Label lblInterestRate = new Label("Interest Rate");
    private Label lblInterestRateFormat = new Label();
    private Label lbl4 = new Label();
    private Label lbl5 = new Label();
    private ComboBox<Integer> cbo = new ComboBox<>();
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button();

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(tfMessage1, 0, 0);
        pane.add(tfMessage2, 0, 1);
        pane.add(tArea, 0, 2);
        pane.add(lblInterestRate, 0, 3);
        pane.add(lblMonthlyPayment, 0, 4);
        pane.add(lblInterestRateFormat, 0, 5);
        pane.add(lbl4, 0, 6);
        pane.add(lbl5, 0, 7);
        pane.add(cbo, 0, 8);
        pane.add(btnCalculate, 0, 9);
        pane.add(btnClear, 0, 10);

        lblInterestRateFormat.setTextFill(Color.RED); // Set the font color of the interest rate instructions to red.
        pane.add(lblInterestRateFormat, 1, 20); // Add the label to the grid pane.
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT); // position the label to the right of the pane.

        HBox actionBtnContainer = new HBox(); // Create a new HBox container;
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30)); // Set the containers spacing.
        actionBtnContainer.setSpacing(10); // S et the container's spacing.
        actionBtnContainer.getChildren().add(btnClear); // Add the btnClear to the container.
        actionBtnContainer.getChildren().add(btnCalculate); // Add the brnCalc to the container.
        pane.add(actionBtnContainer, 1, 4); // Add the container to the GridPanel

        Scene scene = new Scene(btnCalculate, 200, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
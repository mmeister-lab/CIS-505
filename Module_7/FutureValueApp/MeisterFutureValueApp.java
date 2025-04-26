/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
import javafx.scene.paint.Color;
import javafx.application.Application;
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

public class MeisterFutureValueApp extends Application {

    /*Two TextField nodes */
    private TextField tfMessage1 = new TextField();
    private TextField tfMessage2 = new TextField();
    /*Textarea node*/
    private TextArea tArea = new TextArea();
    /*5 Label nodes*/
    private Label lblMonthlyPayment = new Label("Monthly Payment:  ");
    private Label lblInterestRate = new Label("Interest Rate");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears = new Label("Years");
    private Label lbl5 = new Label();
    /*Combobox node*/
    private ComboBox<Integer> cbo = new ComboBox<>();
    /*Calculate Button node*/
    private Button btnCalculate = new Button("Calculate");
    /*Clear Button node*/
    private Button btnClear = new Button();

    @Override
    public void start(Stage primaryStage) {

        /*GridPane arranges nodes in a grid (matrix) formation. */
        GridPane pane = new GridPane();
        /*Set node properties*/
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        /*Place nodes in the pane */
        pane.add(tfMessage1, 0, 0);
        pane.add(tfMessage2, 0, 1);
        pane.add(tArea, 0, 2);
        pane.add(lblInterestRate, 0, 3);
        pane.add(lblMonthlyPayment, 0, 4);
        pane.add(lblInterestRateFormat, 0, 5);
        pane.add(lblYears, 0, 6);
        pane.add(lbl5, 0, 7);
        pane.add(cbo, 0, 8);
        pane.add(btnCalculate, 0, 9);
        pane.add(btnClear, 0, 10);

        /*set the text fill to red */
        /*Set the font color of the interest rate instructions to red.*/
        lblInterestRateFormat.setTextFill(Color.RED);
        /*Add the label to the grid pane. */
        pane.add(lblInterestRateFormat, 1, 20);
        /*position the label to the right of the pane.*/
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        /*Create a new HBox container*/
        HBox actionBtnContainer = new HBox();
        /*Set the containers spacing.*/
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30)); 
        /*Set the container's spacing.*/
        actionBtnContainer.setSpacing(10);
        /*Add the btnClear to the container.*/
        actionBtnContainer.getChildren().add(btnClear);
        /*Add the brnCalc to the container.*/
        actionBtnContainer.getChildren().add(btnCalculate);
        /*Add the container to the GridPanel*/
        pane.add(actionBtnContainer, 1, 4);

        /*Create scene and place it in teh stage.*/
        Scene scene = new Scene(pane);
        /*Primary stage's title to “Meister Future Value App.”*/
        primaryStage.setTitle("Meister Future Value App");
        /*Place the scene in the stage.*/
        primaryStage.setScene(scene);
        /*Display the stage*/
        primaryStage.show();
    }

   public static void main(String[] args) {
    
    launch(args);
   }
        
}
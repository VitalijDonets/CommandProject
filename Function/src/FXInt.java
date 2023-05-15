import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import Function.*;



import java.text.NumberFormat;


public class FXInt extends Application {
    private Function currentFunction = Abs.of(Linear.X);
    private Function currentFunctionDX = null;

    TextField textl;
    TextField textr;
    @Override
    public void start(Stage stage) throws Exception {



        String[] functions = {"|x|", "cos(x)", "e^x", "x", "x^2", "sin(x)", "sqrt(x)"};
        ComboBox<String> ComboBox = new ComboBox<>();
        ComboBox.getItems().addAll(functions);
        ComboBox.getSelectionModel().selectFirst();
        ComboBox.setOnAction(e -> {
            currentFunctionDX = null;
            String selectedFunction = ComboBox.getValue();
            switch (selectedFunction) {
                case "|x|":
                    currentFunction = Abs.of(Linear.X);
                    break;
                case "cos(x)":
                    currentFunction = Cos.of(Linear.X);
                    break;
                case "e^x":
                    currentFunction = Exp.of(Linear.X);
                    break;
                case "x":
                    currentFunction = Linear.X;
                    break;
                case "x^2":
                    currentFunction = Pow.of(Linear.X, 2);
                    break;
                case "sin(x)":
                    currentFunction = Sin.of(Linear.X);
                    break;
                case "sqrt(x)":
                    currentFunction = Sqrt.of(Linear.X);
                    break;
            }
        });
        Button buttonDraw = new Button("Намалювати графік");
        buttonDraw.setOnAction(e -> openGraphWindow());
        Label textf = new Label("f(x) = ");
        Label textd = new Label("Діапазон");
        textl = new TextField("-5");
        textr = new TextField("5");
        HBox hBoxFunction = new HBox();
        hBoxFunction.setSpacing(10);
        hBoxFunction.setPadding(new Insets(10, 10, 10, 10));
        hBoxFunction.getChildren().addAll(textf, ComboBox,textd,textl,textr,buttonDraw);
        Label labeldx = new Label();


        labeldx.setVisible(false);
        Button buttonDX = new Button("Знайти похідну");
        buttonDX.setOnAction(e -> {if(currentFunctionDX == null) currentFunctionDX = currentFunction.dx();
        else currentFunctionDX = currentFunctionDX.dx();
            labeldx.setText("f'(x) = " + currentFunctionDX.toPrettyString(NumberFormat.getInstance()));
            labeldx.setVisible(true);
        });
        HBox dx = new HBox();
        dx.setSpacing(10);
        dx.setPadding(new Insets(10, 10, 10, 10));
        dx.getChildren().addAll(buttonDX,labeldx);

        BorderPane root = new BorderPane();
        root.setLeft(hBoxFunction);
        root.setBottom(dx);
        stage.setTitle("f");
        stage.setScene(new Scene(root,800,100));
        stage.show();
    }
    private void openGraphWindow() {
        Stage graphStage = new Stage();
        graphStage.setTitle("Graph");

        final NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Graph of y="+currentFunction.toPrettyString(NumberFormat.getInstance()));

        final XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("f(x)");

        for (double x = Double.valueOf(textl.getText()); x <= Double.valueOf(textr.getText()); x += 0.1) {
            double y = currentFunction.calculate(x);
            XYChart.Data<Number, Number> data = new XYChart.Data<>(x, y);
            data.setNode(new Circle(0));
            series.getData().add(data);
        }

        lineChart.getData().add(series);

        Scene graphScene = new Scene(lineChart, 800, 600);
        graphStage.setScene(graphScene);
        graphStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }


}

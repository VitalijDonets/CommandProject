package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import Function.*;
import org.knowm.xchart.*;

public class MyFrame extends JFrame implements ActionListener {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    JButton buttonDX;
    JComboBox Flist;
    JButton buttonDraw;
    JTextField textFieldDiapasonLeft;
    JTextField textFieldDiapasonRight;
    JLabel textdx;
    XChartPanel<XYChart> chartPanel = null;

    public MyFrame() {

        String[] functions = {"|x|", "cos(x)","e^x","x","x^2","sin(x)","sqrt(x)"};
        Flist = new JComboBox(functions);
        Flist.addActionListener(this);

        buttonDraw = new JButton("Намалювати графік");
        buttonDraw.addActionListener(this);

        buttonDX = new JButton("Знайти похідну");
        buttonDX.addActionListener(this);

        textFieldDiapasonLeft = new JTextField();
        textFieldDiapasonLeft.setPreferredSize(new Dimension(100, 20));
        textFieldDiapasonLeft.setText("-5");

        textFieldDiapasonRight = new JTextField();
        textFieldDiapasonRight.setPreferredSize(new Dimension(100, 20));
        textFieldDiapasonRight.setText("5");

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setResizable(false);

        panel1.setPreferredSize(new Dimension(50, 50));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));

        panel3.setLayout(new GridLayout(2,0));

        JLabel textf = new JLabel("f(x) = ");
        JLabel textd = new JLabel("Діапазон: ");
        textdx = new JLabel();
        textdx.setVisible(false);

        panel1.add(textf);
        panel1.add(Flist);
        panel1.add(textd);
        panel1.add(textFieldDiapasonLeft);
        panel1.add(textFieldDiapasonRight);
        panel1.add(buttonDraw);
        panel3.add(buttonDX);
        panel3.add(textdx);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
    }
    Function currentFunction = Abs.of(Linear.X);
    Function currentFunctionDX = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedFunction;
        if(e.getSource() == Flist)
        {
            currentFunctionDX = null;
            selectedFunction = (String) Flist.getSelectedItem();
            if(selectedFunction == "|x|") currentFunction = Abs.of(Linear.X);
            else if(selectedFunction == "cos(x)") currentFunction = Cos.of(Linear.X);
            else if(selectedFunction == "e^x") currentFunction = Exp.of(Linear.X);
            else if(selectedFunction == "x") currentFunction = Linear.X;
            else if(selectedFunction == "x^2") currentFunction = Pow.of(Linear.X,2);
            else if(selectedFunction == "sin(x)") currentFunction = Sin.of(Linear.X);
            else if(selectedFunction == "sqrt(x)") currentFunction = Sqrt.of(Linear.X);
         }
        if(e.getSource() == buttonDraw)
        {
            if(chartPanel != null) panel2.remove(chartPanel);
            double left = Double.valueOf(textFieldDiapasonLeft.getText());
            double right = Double.valueOf(textFieldDiapasonRight.getText());
            if(left > right)
            {
                double t = left;
                left = right;
                right = t;
            }
            int size = (int)((right - left)/0.1) + 1;
            double[] xData = new double[size], yData = new double[size];
            double t = left;
            for(int j = 0; j < size; t += 0.1, j++)
            {
                xData[j] = (double) Math.round(t * 100) / 100;
                yData[j] = currentFunction.calculate(xData[j]);
            }

            XYChart chart = QuickChart.getChart("f(x) = " + currentFunction.toPrettyString(NumberFormat.getInstance()),
                    "X", "Y", "f(x)", xData, yData);

            chartPanel = new XChartPanel<>(chart);
            chartPanel.setSize(new Dimension(400, 400));
            panel2.add(chartPanel);
            chartPanel.setVisible(true);
            chartPanel.revalidate();
        }
        if(e.getSource() == buttonDX)
        {
            if(currentFunctionDX == null) currentFunctionDX = currentFunction.dx();
            else currentFunctionDX = currentFunctionDX.dx();
            textdx.setText("f'(x) = " + currentFunctionDX.toPrettyString(NumberFormat.getInstance()));
            textdx.setVisible(true);
        }
    }
}

package Lavoro_gruppi_Calcolatrice_Scientifica_Grafica.src;

// latex
import org.scilab.forge.jlatexmath.Char;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CalcolatriceScientifica2 extends JFrame {

    private JTextArea outputArea;
    private OperazioniMatematiche2 operazioniMatematiche2;

    // modalita di risoluzione
    private boolean mode; // true scientifica; false grafica

    private DisplayGrafico displayGrafico;
    //
    private String expression;
    private ArrayList<Function> functions;
    private ArrayList<Char> operators;

    private TeXFormula formula;
    private TeXIcon icon;
    JLabel latexLabel;
    JPanel latexPanel;

    public CalcolatriceScientifica2() {

        setTitle("Calcolatrice Scientifica Grafica di Makaoui e Zennaro");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(169, 169, 169));

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Courier New", Font.PLAIN, 18));
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(169, 169, 169));
        outputArea.setForeground(Color.BLACK);
        outputArea.setBorder(new LineBorder(new Color(128, 128, 128), 2));

        latexLabel = new JLabel();
        latexPanel = new JPanel();
        latexPanel.setBackground(new Color(169, 169, 169));
        latexPanel.add(latexLabel);

        add(latexPanel, BorderLayout.NORTH); // O dove preferisci nel layout

        operazioniMatematiche2 = new OperazioniMatematiche2();

        JPanel buttonPanel = createButtonPanel();

        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        expression = "";
        functions = new ArrayList<>();
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(128, 128, 128));

        String[] buttons = {"x"+"\u1D3A","\u1D3A"+"√x", "Log", "+",
                            "Sin", "Cos", "Tan", "-",
                            "Ln", "Cot", "ArcCot", "/",
                            "ArcSin", "ArcCos", "Arctan", "*",
                            "n!", "Multiply for π", "Clear", "=",
                            "Graphic", "Scientific"};

        for (String button : buttons) {
            JButton b = new JButton(button);
            b.setFont(new Font("Arial", Font.BOLD, 12));
            b.setBackground(new Color(192, 192, 192));
            b.setForeground(Color.BLACK);
            b.setFocusPainted(false);
            b.addActionListener(new ButtonListener());
            buttonPanel.add(b);
        }

        return buttonPanel;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            try {
                expression = operazioniMatematiche2.buildExpression(command, functions, expression);
                TeXFormula formula = new TeXFormula(expression);
                TeXIcon icon = formula.createTeXIcon(TeXFormula.SERIF, 20);
                latexLabel.setIcon(icon);
                latexLabel.repaint(); // forza aggiornamento
                System.out.println(functions.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalcolatriceScientifica2().setVisible(true));
    }
}

class OperazioniMatematiche2 {

    public String buildExpression(String operazione, ArrayList<Function> functions, String expression) {
        double num1, num2;
        String[] arguments;

        switch (operazione) {

            case "+":
                expression += " + ";
                break;

            case "-":
                expression += " - ";
                break;

            case "*":
                expression += " * ";
                break;

            case "/":
                expression += " / ";
                break;

            case "x"+"\u1D3A":
                num1 = getInput("Inserisci X:");
                num2 = getInput("Inserisci n:");

                expression += num1 + "^" + num2;
                break;

            case "\u1D3C"+"√x":
                num1 = getInput("Inserisci N > 0");
                num2 = getInput("Inserisci X ");
                if (num1 < 0 && num2 % 2 == 0) throw new ArithmeticException("Errore: radice pari di X < 0");

                expression += "\u1D3A" + num1 + num2;
                break;

            case "Log":
                num1 = getInput("Inserisci N");
                num2 = getInput("Inserisci a");
                if (num1 <= 0 || num2 <= 0 || num2 == 1) throw new ArithmeticException("Errore: a > 1 e X > 0");

                expression += "log_{"+ num2 + "}{" + num1 + "}";
                arguments = new String[2];
                arguments[0] = Double.toString(num1);
                arguments[1] = Double.toString(num2);

                Function Log = new Function("log",arguments);
                functions.add(Log);
                break;

            case "Ln":
                num1 = getInput("Inserisci N > 0");
                if (num1 <= 0) throw new ArithmeticException("Errore: Ln è definito solo per N > 0");

                expression += "ln{" + num1 + "}";
                arguments = new String[1];
                arguments[0] = Double.toString(num1);
                Function Ln = new Function("Ln",arguments);
                functions.add(Ln);
                break;

            case "Sin":
                num1 = getInput("Inserisci N:");

                expression += "Sin(" + num1 + ")";

                arguments = new String[1];
                arguments[0] = Double.toString(num1);
                Function Sin = new Function("Sin",arguments);
                functions.add(Sin);
                break;

            case "Cos":
                num1 = getInput("Inserisci N:");

                expression += "Cos(" + num1 + ")";
                arguments = new String[1];
                arguments[0] = Double.toString(num1);
                Function Cos = new Function("Cos",arguments);
                functions.add(Cos);
                break;

            case "Tan":
                num1 = getInput("Inserisci N:");

                expression += "Tan(" + num1 + ")";
                arguments = new String[1];
                arguments[0] = Double.toString(num1);
                Function Tan = new Function("tan",arguments);
                functions.add(Tan);
                break;

            case "n!":
                num1 = (int) getInput("Inserisci N > 0 e intero:");
                if (num1 < 0) throw new ArithmeticException("Errore: N! con N < 0");
                expression += num1 + "!";
                break;

            default:
                throw new IllegalArgumentException("Errore: operazione non valida!");

        }
        return expression;
    }

    private double getInput(String message) throws NumberFormatException {
        String input = JOptionPane.showInputDialog(message);
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input non valido!");
        }
        return Double.parseDouble(input);
    }
}

class Function {

    String name;
    String[] argument;

    public Function(String name, String[] argument) {
        this.name = name;
        this.argument = argument;
    }

    public double calculate(String name, String[] argument) {
        return 0f;
    }

    private long fattoriale(int numero) {
        if (numero <= 1) return 1;
        return numero * fattoriale(numero - 1);
    }

    @Override
    public String toString() {
        return name + "(" + argument[0] + ")";
    }
}
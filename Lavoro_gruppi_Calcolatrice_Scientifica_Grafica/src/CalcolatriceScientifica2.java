// latex
import org.scilab.forge.jlatexmath.Char;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class CalcolatriceScientifica2 extends JFrame {

    //
    private JTextArea outputArea;
    private OperazioniMatematiche2 operazioniMatematiche2;

    // modalità di risoluzione
    public boolean mode; // true scientifica; false grafica

    // display della calcolatrice
    private DisplayGrafico displayGrafico;

    // componenti espressione
    private String expression;
    private ArrayList<Function> functions;
    private ArrayList<String> operators;

    // la formula in formato icona con laTex
    private TeXFormula formula;
    private TeXIcon icon;

    //
    JLabel latexLabel;
    JPanel latexPanel;

    public CalcolatriceScientifica2() {

        mode = true;

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
        displayGrafico = new DisplayGrafico(600, 400);
        GraficoPanel graficoPanel = new GraficoPanel(displayGrafico);
        add(graficoPanel, BorderLayout.CENTER);

        JPanel buttonFunctionPanel = createFunctionPanel();
        JPanel buttonNumberPanel = createNumberPanel();
        JPanel buttonOperatorPanel = createOperatorPanel();

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonFunctionPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonOperatorPanel, BorderLayout.EAST);
        bottomPanel.add(buttonNumberPanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        //add(new JScrollPane(outputArea), BorderLayout.CENTER);

        expression = "";
        functions = new ArrayList<>();
        operators = new ArrayList<>();
    }

    private JPanel createFunctionPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        panel.setBackground(new Color(128, 128, 128));

        String[] functions = {
                "x","x"+"\u1D3A", "\u1D3A"+"√x", "Log", "Ln",
                "Sin", "Cos", "Tan", "Cot",
                "n!", "π", "Graphic",
                "Scientific", "Clear"
        };

        for (String text : functions) {
            JButton b = new JButton(text);
            b.setFont(new Font("Arial", Font.PLAIN, 10)); // ridotto
            b.setPreferredSize(new Dimension(20, 20)); // Imposta dimensioni preferite
            b.setBackground(new Color(192, 192, 192));
            b.setForeground(Color.BLACK);
            b.setFocusPainted(false);
            b.addActionListener(new ButtonListener());
            panel.add(b);
        }

        return panel;
    }

    private JPanel createOperatorPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBackground(new Color(112, 112, 112));

        String[] operators = {"+", "-", "*", "/", "="};

        for (String text : operators) {
            JButton b = new JButton(text);
            b.setFont(new Font("Arial", Font.BOLD, 12));
            b.setBackground(new Color(200, 200, 200));
            b.setForeground(Color.BLACK);
            b.setFocusPainted(false);
            b.addActionListener(new ButtonListener());
            panel.add(b);
        }

        return panel;
    }

    private JPanel createNumberPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBackground(new Color(112, 112, 112));

        String[] operators = {"0", "1", "2", "3", "4","5","6","7","8","9"};

        for (String text : operators) {
            JButton b = new JButton(text);
            b.setFont(new Font("Arial", Font.BOLD, 12));
            b.setBackground(new Color(200, 200, 200));
            b.setPreferredSize(new Dimension(5, 20)); // Imposta dimensioni preferite
            b.setForeground(Color.BLACK);
            b.setFocusPainted(false);
            b.addActionListener(new ButtonListener());
            panel.add(b);
        }

        return panel;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // stampa
            if (mode) {
                outputArea.setText("Mode: Scientific");
            } else {
                outputArea.setText("Mode: Graphic");
            }

            String command = e.getActionCommand();

            try {
                // Se il comando è "Graphic" o "Scientific"
                if (command.equals("Graphic")) {
                    mode = false;
                    return;
                } else if (command.equals("Scientific")) {
                    mode = true;
                    return;
                }

                expression = operazioniMatematiche2.buildExpression(command, functions, expression, operators, mode);
                TeXFormula formula = new TeXFormula(expression);
                TeXIcon icon = formula.createTeXIcon(TeXFormula.SERIF, 20);
                latexLabel.setIcon(icon);
                latexLabel.repaint();
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

    // costruisco l'espressione
    public String buildExpression(String operazione, ArrayList<Function> functions, String expression, ArrayList<String> operators, boolean mode) {

        // primo controllo
        if (mode) { // modalità scientifica
            if (operazione.contains("x") || operazione.contains("X")) {
                throw new IllegalArgumentException("La variabile x è disponibile solo in modalità grafica.");
            }
        }


        String num1, num2;
        String[] arguments;

        switch (operazione) {

            case "0":
                expression += "0";
                break;
            case "1":
                expression += "1";
                break;
            case "2":
                expression += "2";
                break;
            case "3":
                expression += "3";
                break;
            case "4":
                expression += "4";
                break;
            case "5":
                expression += "5";
                break;
            case "6":
                expression += "6";
                break;
            case "7":
                expression += "7";
                break;
            case "8":
                expression += "8";
                break;
            case "9":
                expression += "9";
                break;

            case "+":
                expression += " + ";
                operators.add("+");
                break;

            case "-":
                expression += " - ";
                operators.add("-");
                break;

            case "*":
                expression += " * ";
                operators.add("*");
                break;

            case "/":
                expression += " / ";
                operators.add("/");
                break;

            case "x":
                expression += " x";
                break;

            case "x"+"\u1D3A":
                num1 = getInput("Inserisci X:");
                num2 = getInput("Inserisci n:");

                expression += num1 + "^" + num2;
                break;

            case "\u1D3A"+"√x":
                num1 = getInput("Inserisci N > 0");
                num2 = getInput("Inserisci X ");
                if (Integer.parseInt(num1) < 0 && Integer.parseInt(num2) % 2 == 0) throw new ArithmeticException("Errore: radice pari di X < 0");

                expression += num1 + "\\sqrt{" + "}" + num2;
                break;

            case "Log":
                num1 = getInput("Inserisci N:");
                num2 = getInput("Inserisci A:");
                if (Integer.parseInt(num1) <= 0 || Integer.parseInt(num2) <= 0 || Integer.parseInt(num2) == 1) throw new ArithmeticException("Errore: A != 0 e A > 0 e X > 0");

                expression += "log_{"+ num2 + "}{" + num1 + "}";
                arguments = new String[2];
                arguments[0] = num1;
                arguments[1] = num2;

                Function Log = new Function("log",arguments);
                functions.add(Log);
                break;

            case "Ln":
                num1 = getInput("Inserisci N > 0");
                if (Integer.parseInt(num1) <= 0) throw new ArithmeticException("Errore: Ln è definito solo per N > 0");

                expression += "ln{" + num1 + "}";
                arguments = new String[1];
                arguments[0] = num1;
                Function Ln = new Function("Ln",arguments);
                functions.add(Ln);
                break;

            case "Sin":
                num1 = getInput("Inserisci N:");

                expression += "Sin(" + num1 + ")";

                arguments = new String[1];
                arguments[0] = num1;
                Function Sin = new Function("Sin",arguments);
                functions.add(Sin);
                break;

            case "Cos":
                num1 = getInput("Inserisci N:");

                expression += "Cos(" + num1 + ")";
                arguments = new String[1];
                arguments[0] = num1;
                Function Cos = new Function("Cos",arguments);
                functions.add(Cos);
                break;

            case "Tan":
                num1 = getInput("Inserisci N:");

                expression += "Tan(" + num1 + ")";
                arguments = new String[1];
                arguments[0] = num1;
                Function Tan = new Function("tan",arguments);
                functions.add(Tan);
                break;

            case "Cot":
                num1 = getInput("Inserisci N:");
                expression += "Cot(" + num1 + ")";
                arguments = new String[1];
                arguments[0] = num1;
                Function Cot = new Function("Cot",arguments);
                functions.add(Cot);
                break;

            case "n!":
                num1 = getInput("Inserisci N > 0 e intero:");
                if (Integer.parseInt(num1) < 0) throw new ArithmeticException("Errore: N! con N < 0");
                expression += num1 + "!";
                break;

            // pulisco la calcolatrice
            case "Clear":
                expression = "";
                functions.clear();
                operators.clear();
                break;

            case "=":
                //Lestgoski();
                break;

            default:
                throw new IllegalArgumentException("Errore: operazione non valida!");

        }
        return expression;
    }

    // verifico l'espressione
    public boolean verifyExpression(ArrayList<String> operators, ArrayList<String> arguments) {

        return true;
    }

    private String getInput(String message) throws NumberFormatException {
        String input = JOptionPane.showInputDialog(message);
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input non valido!");
        }
        return input;
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

class GraficoPanel extends JPanel {
    private DisplayGrafico display;

    public GraficoPanel(DisplayGrafico display) {
        this.display = display;
        setPreferredSize(new Dimension(600, 400)); // oppure adatta alle tue misure
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(display.getImage(), 0, 0, null);
    }
}

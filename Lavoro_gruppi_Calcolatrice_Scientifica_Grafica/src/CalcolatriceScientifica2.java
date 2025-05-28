// latex
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalcolatriceScientifica2 extends JFrame {

    //
    private JTextArea outputArea;
    private OperazioniMatematiche2 operazioniMatematiche2;

    private JPanel cardPanel; // Campo per il pannello con CardLayout

    // modalità di risoluzione
    public boolean mode; // true scientifica; false grafica

    // display della calcolatrice
    private DisplayGrafico displayGrafico;

    private GraphicPanel graficoPanel;

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
        setResizable(false);
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

        displayGrafico = new DisplayGrafico(600, 600);

        graficoPanel = new GraphicPanel(displayGrafico);

        // **Qui correggo: inizializzo il campo cardPanel (NON variabile locale)**
        cardPanel = new JPanel(new CardLayout());
        cardPanel.setBackground(new Color(169, 169, 169)); // opzionale

        graficoPanel.setVisible(true); // per sicurezza
        outputArea.setVisible(true); // per sicurezza

        cardPanel.add(new JScrollPane(outputArea), "scientific");
        cardPanel.add(graficoPanel, "graphic");

        add(cardPanel, BorderLayout.CENTER);

        JPanel buttonFunctionPanel = createFunctionPanel();
        JPanel buttonNumberPanel = createNumberPanel();
        JPanel buttonOperatorPanel = createOperatorPanel();

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonFunctionPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonOperatorPanel, BorderLayout.EAST);
        bottomPanel.add(buttonNumberPanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

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

            String command = e.getActionCommand();
            CardLayout cl = (CardLayout)(cardPanel.getLayout());  // usa il campo cardPanel

            if (command.equals("Graphic")) {
                mode = false;
                cl.show(cardPanel, "graphic");
                displayGrafico.reset();
                graficoPanel.repaint();
                return;
            } else if (command.equals("Scientific")) {
                mode = true;
                cl.show(cardPanel, "scientific");
                expression = "";
                return;
            }

            try {
                // gestione normale dei comandi
                expression = operazioniMatematiche2.buildExpression(command, functions, expression, operators, mode);

                TeXFormula formula = new TeXFormula(expression);
                TeXIcon icon = formula.createTeXIcon(TeXFormula.SERIF, 20);
                latexLabel.setIcon(icon);
                latexLabel.repaint();

                boolean isValid = operazioniMatematiche2.verifyExpression(functions, operators, mode, expression);

                if (!isValid && command.equals("=")) {
                    throw new IllegalArgumentException("Syntax Error!");
                } else {

                    if (mode && command.equals("=")){
                        double result = operazioniMatematiche2.calculateExpression(functions, operators, expression);
                        outputArea.setText("= " + String.valueOf(result));
                    } else if (command.equals("=")) {
                        displayGrafico.reset();
                        graficoPanel.setExpression(expression);
                        graficoPanel.setOperators(operators);
                        graficoPanel.setFunctions(functions);
                        graficoPanel.repaint();

                    }
                }

                System.out.println("Funzioni: " + functions);
                System.out.println("Operatori: " + operators);
                System.out.println("Espressione: " + expression);

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

        String num1, num2;
        String[] arguments;

        switch (operazione) {

            //
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                expression += operazione;
                break;

            //
            case "+":
            case "-":
            case "*":
            case "/":
                expression += " " + operazione + " ";
                operators.add(operazione);
                break;

            case "x":
                //if ( mode )
                //    throw new ArithmeticException("Errore: variabile non ammessa in questa modalità");
                expression += " x ";
                break;

            case "x" + "\u1D3A":
                num1 = getInput("Inserisci X:", mode);
                num2 = getInput("Inserisci N:", mode);

                expression += num1 + "^" + num2;
                break;

            case "π":
                expression += " π ";
                break;

            case "\u1D3A" + "√x":
                num1 = getInput("Inserisci N>0:", mode);
                num2 = getInput("Inserisci X:", mode);
                if ( mode && (Integer.parseInt(num1) < 0 && Integer.parseInt(num2) % 2 == 0) )
                    throw new ArithmeticException("Errore: radice pari di X < 0");

                expression += "\\sqrt[" + num1 + "]{" + num2 + "}";
                break;

            case "Log":
                num1 = getInput("Inserisci N:", mode);
                num2 = getInput("Inserisci A:", mode);
                if ( mode && (Integer.parseInt(num1) <= 0 || Integer.parseInt(num2) <= 0 || Integer.parseInt(num2) == 1)  )
                    throw new ArithmeticException("Errore: A != 0 e A > 0 e X > 0");

                expression += "log_{" + num2 + "}{" + num1 + "}";
                arguments = new String[2];
                arguments[0] = num1;
                arguments[1] = num2;

                Function Log = new Function("Log", arguments);
                functions.add(Log);
                break;

            case "Ln":
                num1 = getInput("Inserisci N>0:", mode);
                if ( mode &&(Integer.parseInt(num1) <= 0) )
                    throw new ArithmeticException("Errore: Ln è definito solo per N > 0");

                expression += "ln{" + num1 + "}";
                arguments = new String[1];
                arguments[0] = num1;
                Function Ln = new Function("Ln", arguments);
                functions.add(Ln);
                break;

            case "Sin":
                num1 = getInput("Inserisci N (Radianti):", mode);

                expression += "Sin{" + num1 + "}";

                arguments = new String[1];
                arguments[0] = num1;
                Function Sin = new Function("Sin", arguments);
                functions.add(Sin);
                break;

            case "Cos":
                num1 = getInput("Inserisci N:", mode);

                expression += "Cos{" + num1 + "}";

                arguments = new String[1];
                arguments[0] = num1;
                Function Cos = new Function("Cos", arguments);
                functions.add(Cos);
                break;

            case "Tan":
                num1 = getInput("Inserisci N (Radianti):", mode);

                expression += "Tan{" + num1 + "}";
                arguments = new String[1];
                arguments[0] = num1;
                Function Tan = new Function("Tan", arguments);
                functions.add(Tan);
                break;

            case "Cot":
                num1 = getInput("Inserisci N (Radianti):", mode);
                expression += "Cot{" + num1 + "}";
                arguments = new String[1];
                arguments[0] = num1;
                Function Cot = new Function("Cot", arguments);
                functions.add(Cot);
                break;

            case "n!":
                num1 = getInput("Inserisci N>0 intero:", mode);
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
                break;

            default:
                throw new IllegalArgumentException("Errore: operazione non valida!");

        }

        return expression;
    }

    // verifico l'espressione
    public boolean verifyExpression(ArrayList<Function> functions,ArrayList<String> operators, boolean mode, String expression) {

        /*
        if ( functions.size() <= operators.size() && !operators.isEmpty() && !functions.isEmpty())
            return false;
        */

        if ( mode && (expression.contains("x")) )
            return false;

        return !expression.isEmpty();
    }

    //
    public double calculateExpression(ArrayList<Function> functions, ArrayList<String> operators, String expression) {

        double result = 0;
        int idFunction = 0;

        // caso di una sola funzione
        if ( functions.size() == 1 && operators.isEmpty() ) {
            result = functions.get(0).getResult();
            return result;
        }

        if ( functions.isEmpty() && expression.isEmpty() )
            return result;

        // Pattern sqrt = Pattern.compile(".*sqrt\\{\\d}\\{\\d}*.$");
        // Pattern power = Pattern.compile(".*\\d\\^\\d*.");

        //
         /*
        Pattern radicalN = Pattern.compile("\\\\sqrt\\[(\\d+)]\\{(\\d+)}");
        Matcher matcherRadicalN = radicalN.matcher(expression);
        Pattern power = Pattern.compile("(\\d+)\\^(\\d+)");
        Matcher matcherPower = power.matcher(expression);

        Pattern tokenPattern = Pattern.compile("(Sin|Cos|Tan|Log|Sqrt)\\([^\\\\)]+\\)|\\d+(\\.\\d+)?");
        Matcher matcherFunction = tokenPattern.matcher(expression);
        */

        // token più compatto
        Pattern token = Pattern.compile(
                /*
                "(\\d+)\\\\sqrt\\{(\\d+)}" +                  // gruppo 1 e 2: n\sqrt{x}
                        "|(\\d+)\\^(\\d+)" +                          // gruppo 3 e 4: potenza a^b
                        "|(Ln|Sin|Cos|Tan|Cot|Log)\\{([^\\}]*)\\}" +  // gruppo 5 e 6: funzioni
                        "|(\\d+!)" +                                  // gruppo 7: fattoriale
                        "|(\\d+\\.?\\d*)"                             // gruppo 8: numeri normali

                 */
                        "\\\\sqrt\\[(\\d+)\\]\\{([^}]+)\\}" +               // radice n-esima
                        "|(\\d+)\\^(\\d+)" +                           // potenza
                        "|log_\\{([^}]+)}\\{([^}]+)}" +                  // log con due argomenti tra {}
                        "|(Sin|Cos|Tan|Cot|Ln)\\{([^}]+)\\}"
                                +
                                // funzioni con un argomento tra {}
                        "|(\\d+!)" +                                   // fattoriale
                        "|(\\d+\\.?\\d*)"                              // numeri normali
        );

        // Esegui parsing dell’espressione per speciali
        expression = expression.replaceAll("π", String.valueOf(Math.PI));

        // contiene i valori in ordine dell'espressione
        ArrayList<Double> valori = new ArrayList<>();

        /*
        if ( !functions.isEmpty() ) {

            for (Function f : functions) {
                valori.add(f.getResult());
            }

        }
        */

        Matcher matcher = token.matcher(expression);

        while (matcher.find()) {

            if (matcher.group(1) != null && matcher.group(2) != null) {

                // radice n-esima
                int indice = Integer.parseInt(matcher.group(1));
                int radicando = Integer.parseInt(matcher.group(2));
                result = Math.pow(radicando, 1.0 / indice);
                valori.add(result);

            } else if (matcher.group(3) != null && matcher.group(4) != null) {

                // potenza a^b
                int base = Integer.parseInt(matcher.group(3));
                int exp = Integer.parseInt(matcher.group(4));
                result = Math.pow(base, exp);
                valori.add(result);

            } else if (matcher.group(5) != null && matcher.group(6) != null) {

                // logaritmo con base: Log(x, base)
                double x = Double.parseDouble(matcher.group(5));
                double base = Double.parseDouble(matcher.group(6));
                result = Math.log(x) / Math.log(base);
                valori.add(result);

            } else if (matcher.group(7) != null && matcher.group(8) != null) {

                // funzioni a un argomento
                System.out.println("value: " + functions.get(idFunction).getArgument(0));
                result = functions.get(idFunction).getResult();
                valori.add(result);
                idFunction++;

            } else if (matcher.group(9) != null) {

                // fattoriale
                int number = Integer.parseInt(matcher.group(9).replace("!", ""));
                valori.add((double) fattoriale(number));

            } else if (matcher.group(10) != null) {

                // numero singolo
                double number = Double.parseDouble(matcher.group(10));
                valori.add(number);

            }
        }

        /*
        while (matcherFunction.find()) {
            String token = matcherFunction.group();

            if (token.matches("(sin|cos|tan|log|sqrt)\\([^\\\\)]+\\)")) {

                // È una funzione: prendi dalla lista delle Function
                result = functions.get(idFunction).getResult();
                valori.add(result);
                idFunction++;

            } else {

                // È un numero
                double number = Double.parseDouble(token);
                valori.add(number);
            }
        }

        while (matcherPower.find()) {
            String token = matcherPower.group();
            if (token.matches("(\\d+)\\^(\\d+)")) {
                int base = Integer.parseInt(matcherPower.group(1));
                int exponent = Integer.parseInt(matcherPower.group(2));
                result = Math.pow(base, exponent);
                valori.add(result);
            }
        }
        */

        /*
        // Gestione manuale di n!
        if (expression.matches(".*\\d+!.*")) {
            expression = expression.replaceAll("(\\d+)!", m -> {
                int n = Integer.parseInt(m.group(1));
                return String.valueOf(fattoriale(n));
            });
        }

        if (expression.matches(".*sqrt{d}{d}.*")) {
            expression = expression.replaceAll("sqrt{d}{d}", "");

        }
        */
        System.out.println(valori);

        // Prima: gestisco * e /
        int i = 0;
        while (i < operators.size()) {
            String op = operators.get(i);
            if (op.equals("*") || op.equals("/")) {
                double a = valori.get(i);
                double b = valori.get(i + 1);
                double res = op.equals("*") ? a * b : a / b;

                valori.set(i, res);
                valori.remove(i + 1);
                operators.remove(i);
                // NON incremento i, perché lista si è accorciata
            } else {
                i++;  // Incrementa solo se non hai rimosso
            }
        }

        // Poi: gestisci + e -
        result = valori.getFirst();

        for (i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            double val = valori.get(i + 1);
            if (op.equals("+")) result += val;
            else if (op.equals("-")) result -= val;
        }

        System.out.println("Expression values: " + valori);

        return result;
    }

    //
    private long fattoriale(int numero) {
        if (numero <= 1) return 1;
        return numero * fattoriale(numero - 1);
    }

    // input
    private String getInput(String message, boolean mode) throws NumberFormatException {
        String input = JOptionPane.showInputDialog(message);
        // primo controllo
        if (mode) { // modalità scientifica
            if (input.contains("x") || input.contains("X")) {
                throw new IllegalArgumentException("La variabile x è disponibile solo in modalità grafica.");
            }
        }
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input non valido!");
        }
        return input;
    }

}
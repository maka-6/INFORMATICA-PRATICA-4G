import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalcolatriceScientifica2 extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private OperazioniMatematiche2 operazioniMatematiche2;

    private DisplayGrafico displayGrafico;
    private String expression;
    private ArrayList<Function> functions;
    private String[] operators;

    public CalcolatriceScientifica2() {
        setTitle("Calcolatrice Scientifica");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(169, 169, 169));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setBackground(new Color(192, 192, 192));
        inputField.setForeground(Color.BLACK);
        inputField.setBorder(new LineBorder(new Color(128, 128, 128), 2));

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Courier New", Font.PLAIN, 18));
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(169, 169, 169));
        outputArea.setForeground(Color.BLACK);
        outputArea.setBorder(new LineBorder(new Color(128, 128, 128), 2));

        operazioniMatematiche2 = new OperazioniMatematiche2();

        JPanel buttonPanel = createButtonPanel();

        add(inputField, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(128, 128, 128));

        String[] buttons = {"x"+"\u1D3A","\u1D3A"+"√x", "Log", "+",
                            "Sin", "Cos", "Tan", "-",
                            "Ln", "Cot", "ArcCot", "/",
                            "ArcSin", "ArcCos", "Arctan", "*",
                            "n!", "Multiply for π", "Clear", "="};

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
                double result = operazioniMatematiche2.eseguiOperazione(command);
                outputArea.append(command + " = " + result + "\n");
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

    public double eseguiOperazione(String operazione) throws Exception {
        double result = 0;
        int numCount;

        switch (operazione) {
            case "Sum":
                numCount = (int) getInput("Quanti numeri vuoi sommare?");
                result = 0;
                for (int i = 0; i < numCount; i++) {
                    result += getInput("Inserisci il numero " + (i + 1));
                }
                break;
            case "Sottrazione":
                numCount = (int) getInput("Quanti numeri vuoi sottrarre?");
                if (numCount < 2) throw new IllegalArgumentException("Per la sottrazione servono almeno due numeri!");
                result = getInput("Inserisci il primo numero");
                for (int i = 1; i < numCount; i++) {
                    result -= getInput("Inserisci il numero " + (i + 1));
                }
                break;

            default:
                result = eseguiOperazioneStandard(operazione);
        }

        return result;
    }

    private double eseguiOperazioneStandard(String operazione) throws Exception {
        double num1, num2, result = 0;

        switch (operazione) {
            case "Multiply":
                int numCount = (int) getInput("Quanti numeri vuoi moltiplicare?");
                if (numCount < 2) throw new IllegalArgumentException("Errore: la moltiplicazione richiede almeno due numeri!");
                result = 1;
                for (int i = 0; i < numCount; i++) {
                    result *= getInput("Inserisci il numero " + (i + 1));
                }
                break;
            case "Division":
                num1 = getInput("Inserisci il numeratore");
                num2 = getInput("Inserisci il denominatore");
                if (num2 == 0) throw new ArithmeticException("Errore: divisione per zero non consentita!");
                result = num1 / num2;
                break;
            case "x"+"\u1D3A":
                num1 = getInput("Inserisci il numero da elevare");
                num2 = getInput("Inserisci l'esponente");
                result = Math.pow(num1, num2);
                break;
            case "\u1D3A"+"√x":
                num1 = getInput("Inserisci N > 0");
                num2 = getInput("Inserisci M");
                if (num1 < 0 && num2 % 2 == 0) throw new ArithmeticException("Errore: radice pari di un numero negativo non consentita!");
                result = Math.pow(num1, 1.0 / num2);
                break;
            case "Log":
                num1 = getInput("Inserisci il numero su cui calcolare il logaritmo");
                num2 = getInput("Inserisci la base del logaritmo");
                if (num1 <= 0 || num2 <= 0 || num2 == 1) throw new ArithmeticException("Errore: il logaritmo è definito solo per numeri positivi e base maggiore di 1!");
                result = Math.log(num1) / Math.log(num2);
                break;

            case "Ln":
                num1 = getInput("Inserisci il numero positivo");
                if (num1 <= 0) throw new ArithmeticException("Errore: il logaritmo naturale è definito solo per numeri positivi!");
                result = Math.log(num1);
                break;
            case "Sin":
                num1 = getInput("Inserisci il valore in gradi");
                result = Math.sin(Math.toRadians(num1));
                break;
            case "Cos":
                num1 = getInput("Inserisci il valore in gradi");
                result = Math.cos(Math.toRadians(num1));
                break;
            case "Tan":
                num1 = getInput("Inserisci il valore in gradi");
                result = Math.tan(Math.toRadians(num1));
                break;
            case "n!":
                int numero = (int) getInput("Inserisci un numero intero non negativo");
                if (numero < 0) throw new ArithmeticException("Errore: fattoriale di numero negativo non consentito!");
                result = fattoriale(numero);
                break;
            default:
                throw new IllegalArgumentException("Errore: operazione non valida!");
        }

        return result;
    }

    private double getInput(String message) throws NumberFormatException {
        String input = JOptionPane.showInputDialog(message);
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input non valido!");
        }
        return Double.parseDouble(input);
    }

    private long fattoriale(int numero) {
        if (numero <= 1) return 1;
        return numero * fattoriale(numero - 1);
    }
}

class Function {
    String name;
    String expression;

    public Function(String name, String expression) {
        this.name = name;
        this.expression = expression;
    }

    public double calculate() {
        return 0f;
    }


}
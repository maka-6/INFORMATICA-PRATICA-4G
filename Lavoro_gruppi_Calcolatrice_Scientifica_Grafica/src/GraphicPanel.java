import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicPanel extends JPanel {
    private DisplayGrafico displayGrafico;
    private String expression = "";

    private ArrayList<Function> functions;
    private ArrayList<String> operators;

    public GraphicPanel(DisplayGrafico displayGrafico) {
        this.displayGrafico = displayGrafico;
        setPreferredSize(new Dimension(600, 600));
    }

    public void setExpression(String expression) {
        this.expression = expression;
        repaint();  // chiama paintComponent di nuovo
    }

    public void setFunctions(ArrayList<Function> functions) {
        this.functions = functions;
    }

    public void setOperators(ArrayList<String> operators) {
        this.operators = operators;
    }

    private void drawAxes(Graphics2D g2d, int width, int height, double xMin, double xMax, double yMin, double yMax) {
        // Asse X a y=0 (converti y=0 in pixel)
        int zeroY = (int) ((yMax - 0) / (yMax - yMin) * height);
        g2d.setColor(Color.GRAY);
        g2d.drawLine(0, zeroY, width, zeroY);

        // Asse Y a x=0 (converti x=0 in pixel)
        int zeroX = (int) ((0 - xMin) / (xMax - xMin) * width);
        g2d.drawLine(zeroX, 0, zeroX, height);

        // Puoi aggiungere tacche e numeri per renderlo più leggibile
    }

    public void drawExpression(Graphics2D g2d, int width, int height, double xMin, double xMax, double yMin, double yMax, String expression) {
        double step = 1;
        OperazioniMatematiche2 op = new OperazioniMatematiche2();
        for (int px = 0; px < width; px++) { double x = xMin + (px * step);
            // Sostituisci x nell’espressione
            String exprWithX = expression.replace("x", String.valueOf(x) );
            // Copia delle funzioni originali, con argomenti aggiornati per ogni x
            ArrayList<Function> currentFunctions = new ArrayList<>();
            for (Function f : functions) {
                String[] originalArgs = f.getArguments();
                String[] updatedArgs = new String[originalArgs.length];
                for (int i = 0; i < originalArgs.length; i++) {
                    updatedArgs[i] = originalArgs[i].replace("x", String.valueOf(x));
                }
                currentFunctions.add(new Function(f.getName(), updatedArgs));
            } try { double y = op.calculateExpression(currentFunctions, operators, exprWithX);
                //System.out.println(y);
                if (!Double.isFinite(y)) continue; // ignora valori infiniti o NaN
                double scaleFactor = 7; int py = (int) ((yMax - (y * scaleFactor)) / (yMax - yMin) * height);
                if ( py < height && py >= 0 ) {
                    //System.out.println(px + " " + py);
                    g2d.fillOval(px, py, 2, 2); // disegna un punto 2x2 pixel
                    }
            } catch (Exception e) { // se errore, salta
                }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = 600;
        int height = 600;

        double xMin = -25;
        double xMax = 25;
        double yMin = -25;
        double yMax = 25;

        // Disegna assi
        drawAxes(g2d, width, height, xMin, xMax, yMin, yMax);

        if (expression != null && !expression.trim().isEmpty()) {
            g2d.setColor(Color.RED);
            drawExpression(g2d, width, height, xMin, xMax, yMin, yMax, expression);
        }
    }

}
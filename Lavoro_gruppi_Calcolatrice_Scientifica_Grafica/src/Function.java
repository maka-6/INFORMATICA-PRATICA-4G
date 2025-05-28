public class Function {

    private final String name;
    private final String[] argument;

    private double result;

    public Function(String name, String[] argument) {
        this.name = name;
        this.argument = argument;

    }

    private void calculate() {
        double radiant;

        switch (name) {
            case "Sin":
                radiant = Math.toRadians(Double.parseDouble(argument[0]));
                result = Math.sin(radiant);
                break;

            case "Cos":
                radiant = Math.toRadians(Double.parseDouble(argument[0]));
                result = Math.cos(radiant);
                break;

            case "Tan":
                radiant = Math.toRadians(Double.parseDouble(argument[0]));
                result = Math.tan(radiant);
                break;

            case "Cot":
                radiant = Math.toRadians(Double.parseDouble(argument[0]));
                double tanValue = Math.tan(radiant);
                if (tanValue == 0)
                    throw new ArithmeticException("Cotangente indefinita per tan(x) = 0");
                result = 1.0 / tanValue;
                break;

            case "Ln":
                double lnArg = Double.parseDouble(argument[0]);
                if (lnArg <= 0)
                    throw new ArithmeticException("Ln è definito solo per valori positivi");
                result = Math.log(lnArg);
                break;

            case "Log":
                // log_b(a) = log(a) / log(b)
                double a = Double.parseDouble(argument[0]);
                double base = Double.parseDouble(argument[1]);
                if (a <= 0 || base <= 0 || base == 1)
                    throw new ArithmeticException("Logaritmo non definito per questi valori");
                result = Math.log(a) / Math.log(base);
                break;

            default:
                throw new IllegalArgumentException("Funzione non riconosciuta: " + name);
        }
    }

    public String getName() {
        return name;
    }

    public double getResult(){
        calculate();
        return result;
    }

    public String getArgument(int i){
        return argument[i];
    }

    public String[] getArguments(){
        return argument;
    }

    public void setArgument(int i, String arg){
        argument[i] = arg;
    }

    @Override
    public String toString() {
        return name + "(" + argument[0] + ")";
    }
}
package Makaoui_FAD_03;

public class Main {
    public static void main(String[] args) {
        Barbershop shop = new Barbershop();
        System.out.println(shop);

        shop.addClient(); // Aggiunge un cliente
        shop.addClient(); // Aggiunge un altro cliente
        System.out.println(shop);

        shop.addClient(); // Aggiunge un altro cliente
        shop.addClient(); // Aggiunge un altro cliente
        shop.addClient(); // Aggiunge un altro cliente

        shop.serveClient(); // Serve un cliente
        shop.serveClient(); // Serve un cliente
        shop.serveClient(); // Serve un cliente
        System.out.println(shop);

        shop.serveClient(); // Serve un altro cliente
        System.out.println(shop);

        shop.addClient(); // Aggiunge un altro cliente
        shop.addClient(); // Aggiunge un altro cliente

        shop.serveClient(); // Tenta di servire un cliente, ma non ce ne sono
        shop.serveClient(); // Tenta di servire un cliente, ma non ce ne sono
        System.out.println(shop);
    }
}
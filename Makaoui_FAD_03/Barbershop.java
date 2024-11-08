package Makaoui_FAD_03;

public class Barbershop {
    private boolean busy;
    private boolean sleep;
    private int clients;
    private int maxClients;

    public Barbershop() {
        busy = false;
        sleep = true;
        clients = 0;
        maxClients = 5;
    }
    public Barbershop(boolean busy, boolean sleep, int clients, int maxClients) {
        this.busy = busy;
        this.sleep = sleep;
        this.clients = clients;
        this.maxClients = maxClients;
    }
    // Metodo per aggiornare lo stato del barbiere
    private void updateState() {
        if (clients > 0) {
            busy = true;
            sleep = false;
        } else {
            busy = false;
            sleep = true;
        }
    }
    int addClient(){
        if ( this.clients < maxClients ) {
            return this.clients++;
        } else {
            System.out.println("Negozio pieno ritornare piú tardi");
            return this.clients;
        }
    }
    public boolean serveClient() {
        if ( this.clients > 0 ) {
            this.clients--;
            updateState();
            System.out.println("Cliente servito, In attesa: " + clients);
            return true;
        } else {
            System.out.println("Nessun cliente in coda.");
            updateState();
            return false;
        }
    }
    // set
    void setClients(int clients) {
        this.clients = clients;
    }
    void setMaxClients(int maxClients) {
        this.maxClients = maxClients;
    }

    // get
    boolean getBusy() {
        return busy;
    }
    boolean getSleep() {
        return sleep;
    }
    int getClients() {
        return clients;
    }
    int getMaxClients() {
        return maxClients;
    }


    @Override
    public String toString() {
        if (busy) {
            return "Barbiere occupato, Clienti in coda: " + clients;
        } else {
            return "Il barbiere sta dormendo";
        }
    }
}
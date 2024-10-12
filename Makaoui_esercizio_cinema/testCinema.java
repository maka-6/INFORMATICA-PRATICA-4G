package Makaoui_esercizio_cinema;

public class testCinema {
    public static void main(String[] args) {
        int i;
        Seat[] cinema;
        // il cinema ha 95 posti
        cinema = new Seat[95];
        boolean state = false;
        int seat = 0;
        char row = 'A';
        double vip = 0;

        // inizializzazione della sla con posti vip e base
        for (i = 0; i < 95; i++) {

            seat++;
            if (seat == 21) {
                seat = 1;
            }

            switch (i) {

                case 0:
                    row = 'A';
                    // vip e l'aggiunta al prezzo del biglietto in base al posto e alla vicinanza alla fila vip
                    vip = 0;
                    break;

                case 20:
                    System.out.println();
                    row = 'B';
                    vip = 2;
                    break;

                case 40:
                    System.out.println();
                    row = 'C';
                    state = true;
                    vip = 5;
                    break;

                case 55:
                    System.out.println();
                    row = 'D';
                    state = false;
                    if (seat == 16) {
                        seat = 1;
                    }
                    vip = 1;
                    break;

                case 75:
                    System.out.println();
                    row = 'E';
                    vip = 0;
                    break;
            }

            cinema[i] = new Seat( row, seat, true, state , 20.5 + vip );
            cinema[i].printSeatInfo();

        }
    }
}
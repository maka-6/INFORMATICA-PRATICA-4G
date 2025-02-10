package Makaoui_verifica_22_1_2025;
import java.util.ArrayList;

public class ArchivioProdotti{

    int i;
    ArrayList<Prodotto> archivio = new ArrayList<Prodotto>();

    public ArchivioProdotti(){
        Prodotto prodotto = new Prodotto();
        archivio.add(prodotto);
    }
    
    void AggiungiProdotto( String name, String category, double price, int code ){
        Prodotto prodotto = new Prodotto( name, category, price, code );
        archivio.add(prodotto);
    }

    Prodotto cercaProdotto( int code ){
        for( i = 0; i < archivio.size(); i++){
            Prodotto prodotto = archivio.get(i);
            if ( prodotto.getCode() == code ){
                return prodotto;
            }
        }
        return null;
    }

    void RimuoviProdotto( int code ){
        for( i = 0; i < archivio.size(); i++){
            Prodotto prodotto = archivio.get(i);
            if ( prodotto.getCode() == code ){
                archivio.remove(i);
                i--;
            }
        }
    }

    @Override
    public String toString() {
        for (i = 0; i < archivio.size(); i++) {
            Prodotto prodotto = archivio.get(i);
            System.out.println(prodotto.toString());
        }
        return "";
    }
}
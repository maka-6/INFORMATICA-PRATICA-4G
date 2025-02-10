package Makaoui_verifica_22_1_2025;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestArchivio {
    public static void main(String[] args)/* throws IOException */{

        ArchivioProdotti archivio = new ArchivioProdotti();
        archivio.AggiungiProdotto("ciao", "bella", 10.33, 43);
        archivio.toString();
        System.out.println("Prodotto rimosso");
        archivio.RimuoviProdotto(43);
        archivio.toString();
    }
}
package Makaoui_esercizio_Console_War;

import java.util.ArrayList;

public class FunWatTest {
    public static void main(String[] args) {

        int maxHeroesFight = 2;
        ArrayList<Eroe> Players = new ArrayList<Eroe>();

        // Creazione di alcuni eroi
        Eroe eroe1 = new Eroe();
        eroe1.name = "Pablo Escobar Zammito";
        eroe1.role = "God";
        eroe1.description = "Oltre a narcotraffico da Rescaldina fino al cartello messicano di sinaloa, insegna motoria nel per arrotondare";
        eroe1.life = 6000;
        eroe1.baseAttack = 500;
        eroe1.baseDefense = 200;


        Eroe eroe2 = new Eroe();
        eroe2.name = "Scopacasa surgeria capelli in Turchia";
        eroe2.role = "Rizzer";
        eroe2.description = "Con i suoi capelli freschi e nuovi ti rizza anche i cechi.";
        eroe2.life = 1000;
        eroe2.baseAttack = 150;
        eroe2.baseDefense = 80;

        Eroe eroe3 = new Eroe();
        eroe3.name = "Vecchi Admin del creato";
        eroe3.role = "Moder Discord";
        eroe3.description = "Lui decide chi vive, chi muore anche chi passerà l'anno, se ti ritiene degno ti regala l'effetto" +
                "pgr. Aka 'per grazia ricevuta'" +
                "attacca con frasi complesse che confondono l'avversario";
        eroe3.life = 1000;
        eroe3.baseAttack = 150;
        eroe3.baseDefense = 200;

        Eroe eroe4 = new Eroe();
        eroe4.name = "Contardi boss del 53bis";
        eroe4.role = "Odia li studenti";
        eroe4.description = "Puo decidere se darti la salvezza dall'Admin vecchi del creato, o lasciarti vivere" +
                "nella dannazione eterna dei debiti e recuperi, con la maledizione dell'insufficienza, l'eterno rosso";
        eroe4.life = 5000;
        eroe4.baseAttack = 150;
        eroe4.baseDefense = 200;

        Eroe eroe5 = new Eroe();
        eroe5.name = "Albe re di milano";
        eroe5.role = "Anti-sbarchi";
        eroe5.description = "anche se vive a milano, avverte gli sbarchi in tutta italia con cui riattacca" +
                "con dei leggerissimi elicotteri corazzati calibro 50, muniti di mitraglietta";
        eroe5.life = 5500;
        eroe5.baseAttack = 150;
        eroe5.baseDefense = 200;

        Eroe eroe6 = new Eroe();
        eroe6.name = "Galaxy";
        eroe6.role = "Imperatore della via lattea impartisce lezioni private";
        eroe6.description = "Con la forza avverte gli immigrati dal continente nero avvicinarsi in europa con cui punisce" +
                "severamente con le lezioni private.";
        eroe6.life = 10000;
        eroe6.baseAttack = 200;
        eroe6.baseDefense = 100;

        // Aggiunta degli eroi alla lista
        Players.add(eroe1);
        Players.add(eroe2);
        Players.add(eroe3);
        Players.add(eroe4);
        Players.add(eroe5);
        Players.add(eroe6);

    }
}
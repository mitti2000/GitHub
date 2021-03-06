package ch.mitti.domev1;

import java.util.ArrayList;

/**
 * Die Klasse Datenbank bietet Möglichkeiten zum Speichern
 * von CD- und DVD-Objekten. Eine Liste aller CDs und DVDs
 * kann auf der Konsole ausgegeben werden.
 * 
 * Diese Version speichert die Daten nicht im Dateisystem und
 * bietet keine Suchfunktion.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
public class Datenbank
{
    private ArrayList<Disc> discs;

    /**
     * Erzeuge eine leere Datenbank.
     */
    public Datenbank()
    {
        discs = new ArrayList<Disc>();
    }

    /**
     * Erfasse die gegebene CD in dieser Datenbank.
     * @param dieCD die einzutragende CD.
     */
    public void erfasseDisc(Disc disc)
    {
        discs.add(disc);
    }


    /**
     * Gib eine Liste aller aktuell gespeicherten CDs und
     * DVDs auf der Konsole aus.
     */
    public void auflisten()
    {
        // Liste der CDs ausgeben
        for(Disc disc : discs) {
            disc.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }


    }
}

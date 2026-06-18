package fahrzeuge.autos;

import fahrzeuge.base.FahrzeugBase;

/*
* Klasse fpr Autos - Erbt von FahrzeugBase
*
* Vererbung:
* Auto erbt Alle Attribute und Methoden von FahrzeugBase (hersteller, modell, geschwindigkeit,
* beschleunigen, bremsen, status...
* Auto KANN neue Attribute und Methoden hinzufügen (anzahlTueren, klimaanlage usw....)
* auto KANN geerbte Attribute überschreiben (@Override)
*
* super:
* Bezieht sich auf die Elternklasse (FahrzeugBase)
* Wird verwendet um:
* - den elternkonstruktor aufzurufen(super(....)
* - elternmethoden aufzurufen (super.methode())
* - Elternattribute zuzugreifen (super.attribute)
* */



public class Auto extends FahrzeugBase {
    // 1. Neue Attribute für die Auto-Klasse
    public int anzahlTueren;
    public boolean klimaanalage;

    // Konstruktor für Auto-Klasse
    /**
     * Initialisiert die neuen Attribute (anzahlTueren, klimaanlage)
     *
     * super():
     * ruft den Konstruktor der Elternklasse (FahrzeugBase) auf
     * Muss die eRSTE Anweisung im Konstuktor sein
     * Übergeben der Parameter an die Elternklasse
     *
     * @param hersteller Der Hersteller des Autos
     * @param modell Das Modell des Autos
     * @param baujahr Das Baujahr des Autos
     * @param anzahlTueren Die Anzahl der türen
     * @param klimaanalage Ob das Auto eine Klimaanlage hat (true/falss)*/

    public Auto(String hersteller, String modell, int baujahr, int anzahlTueren, boolean klimaanalage){
        // super() => Die Parameter werden an FahrzeugBase (Konstruktor) weitergegeben
        super(hersteller, modell, baujahr);
        // Initialisierung der neuen Attribute (nur Auto)
        this.anzahlTueren = anzahlTueren;
        this.klimaanalage = klimaanalage;
    }

    // 3. Implementierung der Abstrakten Methode

    /**
     * Da getMaxGeschwindigkeit() in FahrzeugBase abstrakt ist, MUSS Auto diese Methode implementieren,
     *
     * @return Die maximale Geschwindigkeit eine Autos in km/h (220 km/h)
     *
     */
    @Override
    public int getMaxGeschwindigkeit(){
        return 220;
    }

    // 4. Überschreiben von Default_Methoden aus dem Interface
    /**
     * Überschreiben der Default-Methoden aus dem Interface "Fahrzeug:"
     * getFahrzeugArt() ist eine default-Methode im Interface Fahrzeug.
     * Auto überschreibt sie, um "Auto" zurück zugeben.
     *
     * @param "Auto" als String
     */
    @Override
    public String getFahrzeugArt(){
        // super.getFahrzeugArt() würde die Elternimplementierung aufrufen.
        // Hier sie komplett überschrieben.
        return "Auto";
    }

    // 5. Neue Methoden, spezifisch für Auto
    /**
     * Spezifische Methoden für Autos: Aktiviert/Deaktiviert die Klimaanlage
     * @param aktiv true = Klimaanlage, false = Klimaanlage aus*/

    public void setKlimaanalage(boolean aktiv){
        this.klimaanalage = aktiv;
        System.out.println("Klimaanlage " + (aktiv ? "aktiviert" : "deaktiviert"));  // ? Tenere Operator fragt nach Zustand.
    }

    // 6. Überschreiben von geerbten Methoden
    /**
     * Überschreiben der status()-Methode aus FahrzeugBase:
     * super.status() auf, um die Elternimplemenierung zu nutzen
     * Fügt zusätzliche Informationen für Auto hinzu
     *
     * Gibt den Basiszustand aus der Elternklasse zurück (hersteller, modell, baujahr usw...)*/
    @Override
    public String status(){
        // Gibt den Basiszustand zurück (hersteller, modell, baujahr usw...)
        return super.status() + String.format(", Türen: %d, Klimaanlage: %s",
                this.anzahlTueren,
                this.klimaanalage ? "an" : "aus");

    }

    // 7. getter und Setter für die neuen Attribute

    public int  getAnzahlTueren(){
        return anzahlTueren;
    }

    public boolean hatKlimaanlage(){
        return klimaanalage;
    }
    /***/





}

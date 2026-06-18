package fahrzeuge.fahrraeder;

import fahrzeuge.base.FahrzeugBase;


// Klasse für Fahrräder - erbt von FahrzeugBase
// Fahrräder sind nicht motorisiert, aber sie implementieren trotzdem das Fahrzeug-Interface
// Das zeigt, dass das Interface für alle Fahrzeuge gilz, nicht nur für Autos/Motorräder
public class Fahrrad extends FahrzeugBase {

    //1. Neue Attribute spezifisch für Fahrräder

    private int anzahlGaenge;
    private boolean hatLicht;

    // 2. Konstruktor für Fahrrad
    /**
     * Konstruktor für Fahrrad:
     * ruft den Elternkonstruktor (FahrzeugBase) mit super() auf
     * Initialisiert die neuen Attribute
     *
     * @param hersteller Hersteller
     * @param modell Modell
     * @param baujahr Baujahr
     * @param anzahlGaenge Anzahl der Gänge
     * @param hatLicht Ob das Fahrrd Licht hat (true/false)*/

    public Fahrrad(String hersteller, String modell, int baujahr, int anzahlGaenge, boolean hatLicht){
        super(hersteller, modell, baujahr);
        this.anzahlGaenge = anzahlGaenge;
        this.hatLicht = hatLicht;
    }

    // 3. Implementierung der abstrakten Methode
    @Override
    public double getMaxGeschwindigkeit(){
        return 50.0; // Rennräder können bis zu 50 km/h erreichen
    }

    @Override
    public String getFahrzeugArt(){
        return  "Fahrrad";
    }


}

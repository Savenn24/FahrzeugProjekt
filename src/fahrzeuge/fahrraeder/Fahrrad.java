package fahrzeuge.fahrraeder;

import fahrzeuge.base.FahrzeugBase;


// Klasse für Fahrräder - erbt von FahrzeugBase
// Fahrräder sind nicht motorisiert, aber sie implementieren trotzdem das Fahrzeug-Interface
// Das zeigt, dass das Interface für alle Fahrzeuge gilz, nicht nur für Autos/Motorräder
public class Fahrrad extends FahrzeugBase {

    // 1. Neue Attribute spezifisch für Fahrräder

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
     * @param hatLicht Ob das Fahrrad Licht hat (true/false)*/

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

    @Override
    public void beschleunigen(double wert){
        if(wert > 0){
            // Math.min(..., 50.0) stellt sicher, dass die Geschwindigkeit nicht über 50.0 km/h geht.
            double neueGeschwindigkeit = Math.min(this.geschwindigkeit + wert, 50.0);
            this.geschwindigkeit = neueGeschwindigkeit;
            System.out.println("Fahrrad beschleunigt auf " + this.geschwindigkeit + " km/h");
        }
    }

    @Override
    public  String status(){
        return super.status() + String.format(", Gänge: %d, Licht: %s",
                this.anzahlGaenge,
                this.hatLicht ? "vorhanden" : "nicht vorhanden");
    }

    //4. Getter-Methode
    public int getAnzahlGaenge(){
        return anzahlGaenge;
    }

    public boolean getHatLicht(){
        return hatLicht;
    }


}

package fahrzeuge.autos;

/*
* Klasse für Elektroautos - erbt von Auto-Klasse, welches von FahrzeugBase erbt
* Mehrstufen Vererbung:
* Elektroauto -> Auto -> FahrzeugBase -> Fahrzeug
*
* Vorteil:
* Elektroauto erbt alles von Auto, ikl. anzahlTueren, klimaanlage
* Elektroauto kann neue Attribute hinzufügen, z.B. batterieKapazität, aktuelle Ladung
* Elektroauto kann Methoden überschreiben, z.B. getMaxGeschwindigkeit()
* */


public class Elektroauto extends Auto {
    // 1. Neue Attribute, spezifisch Elektroauto
    private double batterieKapazitaet;
    private double aktuelleLadung;

    // 2. Konstruktor für Elektroauto

    /**
     * Konstruktor für Elektroauto:
     * Ruft den Elternkonstruktor (Auto) mit super() auf
     * Initialisiert die neuen Attribute
     * Setzt die Klimaanlage immer auf true
     *
     * super():
     * Ruft den Konstruktor der direkten Elternklasse (Auto) auf
     * Auto ruft wiederum super() in FahrzeugBase auf
     *
     * @param hersteller Hersteller
     * @param modell Modell
     * @param baujahr Baujahr
     * @param anzahlTueren Anzahl der Türen
     * @param batterieKapazitaet batteriekapazität in KWh*/
    public Elektroauto(String hersteller, String modell, int baujahr, int anzahlTueren, double batterieKapazitaet){
        // super():
        // Ruft den Konstruktor der direkten Elternklasse (Auto) auf
        // Auto wiederum spuer() in FahrzeugBase auf
        super(hersteller, modell, baujahr, anzahlTueren,true);
        // INitialisierung der neuen Attribute
        this.batterieKapazitaet = batterieKapazitaet;
        this.aktuelleLadung= batterieKapazitaet; // Start voll geladen
    }

    // 3. Überschreiben von Methoden
    /**
     * Überschreiben von getMaxGeschwindigkeit():
     * Elektroautos haben typischerweise eine geringere Maximalgeschwindigkeit als Verbrenner.
     *
     * @return Maximale Geschwindigkeit des Elektroautos in km/h (180) km/h*/

    @Override
    public double getMaxGeschwindigkeit(){
        return 180.0;

    }

    // 4. Neue Methode spezifisch für Elektroauto
    /**
     * lädt die Batterie des Elektroautos
     * @param kwh Die Menge an Energie in KWh, die geladen werden soll.
     *
     * Logik:
     * Wenn die neueLadung die Kapazität übersteigt, wird auf volle Kapazität geladen
     * Sonst wird die angegebene Menge geladen*/

    public void laden(double kwh){
        if (kwh == 0) return;                           // Kein Laden bei negativem Wert
        double neueLadung = this.aktuelleLadung + kwh;  // Berechne die neue Ladung

        if (neueLadung > this.aktuelleLadung) {
            // Wenn die Ladung die Kapazität übersteigt
            this.aktuelleLadung = this.batterieKapazitaet;
            System.out.println("Batterie vollständig geladen!");
        } else {
            // Wenn die neue Ladung innerhalb der Kapazität liegt:
            this.aktuelleLadung = neueLadung;
            System.out.println("Geladen. Aktuelle Ladung: " + this.aktuelleLadung + " KWh");
        }
    }

    // Überschreiben von status()
    /**
     * Überschreiben von status():
     * Ruft super.status() auf (Auto.status()), um die Elternimplementierung zu nutzen
     * Fügt Batterie-Informationen hinzu
     *
     * */

    @Override
    public String status() {
        // berechne den Ladezustand in Prozent
        double ladestandProzent = (this.aktuelleLadung / this.batterieKapazitaet) * 100;
        return super.status() + String.format(", Batterie: %.1f/%.1f KWh (%.1f%%)",
                aktuelleLadung,
                batterieKapazitaet,
                ladestandProzent);
    }

    // getter-Methode

    public double getBatterieKapazitaet() {
        return batterieKapazitaet;
    }

    public double getAktuelleLadung() {
        return aktuelleLadung;
    }
}

package fahrzeuge.autos;

/*
* Klasse für Elektroautos - erbt von Auto-Klasse, welches von FahrzeugBase erbt
* Mehrstufen Vererbung:
* Elektroauto -> Auto -> FahrzeugBase -> Fahrzeug
*
* Vorteil:
* Elektroauto erbt alles von Auto, ikl. anzahlTueren, klimaanlage
* Elektroauto kannn neue Attribute hinzfügen, z.B. batterieKapazität, aktuelle Ladung
* Elektroauto kann Methoden überschreiben, z.B. getMaxGeschwindigkeit()
* */


public class Elektroauto {
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
     * @param batterieKapazität batteriekapazität in KWh*/
}

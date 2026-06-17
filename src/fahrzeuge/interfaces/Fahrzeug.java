package fahrzeuge.interfaces;

/* Dieses Interface definiert den Grundvertrag für alle Fahrzeuge im Projekt.
 * Was ist ein Interface?
 * Ein Interface ist eine reine Abstraktion (keine Implementierung von Code).
 * Es definiert nur WAS ein Fahrzeug können muss (Methoden), aber nicht WIE (Implementierung
 * Alle Klassen, die dieses Interface implementieren, MÜSSEN alle Methoden implementieren
 * (außer default- und static-Methoden
 *
 * Warum verwenden wir Interface?
 * Einheitlicher Vertrag: Jedes Fahrzeug muss dieselbe Grundmethoden haben.
 * Polymorphie: Wir können alle Fahrzeuge über den Typ "Fahrzeug" behandeln
 * Mehrfachvererbung: Eine Klasse kann mehrere Interface implementieren.*/



public interface Fahrzeug {
    /*
     * 1. Konstanten (public static final sind implizit)
     *
     * Interface-Konstanten sind automatisch:
     *  - public - sichtbar für alle
     *  - static - gehört zur Klasse, nicht zur Instanz
     *  - final  - können nicht verändert werden
     *
     * HERSTELLER ist Standartwer, der für alle Fahreuge gilt,
     * die diese Interfaces implementieren. Kann aber überschrieben werden
     * */

    String HERSTELLER = "Allgemein";                // Standard-Hersteller für alle Fahrzeuge

    /**
     * 2. Abstrakte Methode (müssen von implementierten Klassen definiert werden
     * <p>
     * Abstrakte Methoden haben keine Implementierung (kein {}-Block)
     * Sie definieren nur die Signatur (Name, Rückgabetyp, Parameter)
     * Jede Klasse, die "Fahrzeug" implementiert, muss diese Methode haben!
     * Der Compiler schlägt sonst Alarm und wirft einen Fehler.
     * <p>
     * Gibt die aktuelle Geschwindigkeit zurück.
     *
     * @return Geschwindigkeit in Kilometer pro Stunde (km/h)als double
     *
     */

    double getGeschwindigkeit();

    /**
     * Beschleunigt das Fahrzeug um die angegebenen Wert
     *
     * @param wert Die Geschwindigkeitsänderung in km/h (positiv = beschleunigen, negativ = bremsen
     *
     */

    void beschleunigen(double wert);

    /**
    * Bremst das Fahrzeug um den angegebenen Wert
    * @param wert Die Geschwindigkeitsreduzierung in km/h (muss positiv sein)
    *
     * Der Wert sollte immer Positiv sein.
    * Implementierung muss sicherstellen, dass die Geschwindigkeit nicht negativ wird.*/

    void bremsen(double wert);

    /**
    * gibt einen String mit dem aktuellen Status des Fahrzeugs zurück
    * @return Formatierter String mit Herstelle, Model, Baujahr und Geschwindigkeit
    *
    * Beispiel:
    * "Volkswagen Golf (2023), geschwindigkeit: 60.0 km/h"
    * */

    String status();

    /*
     * 3. Default-Methoden
     *
     * Default-Methoden haben eine Implementierung und können von implementierten Klassen
     * überschrieben werden (optional)
     *
     * Vorteil: Wir können neue Methoden zum Interface hinzufügen, ohne alle implementierte
     * Klassen zwingen zu müssen, sie zu überschreiben
     * */

    /**
     * Standard-Implementierung für Fahrzeuge
     * @return Fahrzeugtyp als String (Standard: "Unbekanntes Fahrzeug")
     *
     * Bedeutung:
     * Jedes Fahrzeug kann diese Methode überschreiben, um seinen spezifischen Typ zurückzugeben
     * Beispiel: Auto gibt "Auto" zurück, Fahrrad gibt "Fahrrad" zurück
     * */

    default String getFahrzeugArt() {
        return "Unbekanntes Fahrzeug";
    }

    /**
     * 4.Statische-Methoden (gehören zum Interface, nicht zur Instanz)
     * Statische.Methoden können dirket über das Interface aufgerufen werden, ohne ein Objekt
     * zu erstellen
     *
     * Fahrzeug.getMaxAutobahnGeschwindigkeit() kann ohne Fahrzeug-Objekt aufgerufen werden
     */
    /**
     * Gibt die maximale erlaubte Geschwindigkeit auf Italienische Autobahnen zurück.
     * @return Geschwindigkeit in km/h (Standard 130 km/h)
     *
     * int max = Fahrzeug.getMaxAutobahnGeschwindigkeit(); max = 130
     */
    static int getMaxAutobahnGeschwindigkeit(){
        return 130;
    }

}
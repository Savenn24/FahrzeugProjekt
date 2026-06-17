package fahrzeuge.base;

import fahrzeuge.interfaces.Fahrzeug;

/**
 * Abstrakte Klasse für alle Fahzeuge
 * Was ist eine abstrakte Klasse?
 * Eine Klasse, die NICHT instanziiert werden kann (kein "new FahrzeugBase()")
 * Kann sowohl abstrakte als auch konkrete Methoden haben.
 * Dient als gemeinsame Basis für Vererbung
 * Warum verwenden wir diese abstrakten Klassen?
 * gemeinsame Attribute: alle Fahrzeuge haben Hersteller, Modell, Baujahr, Geschwindigkeit.
 * Gemeinsame Implementierung: Methoden wie bescheleunigen(), bremsen(), status() sind
 * für alle gleich.
 * Abstrakte Methoden: erzwingen, dass Kindklassen bestimmte Methoden implementieren
 * (z.B. getMaxGeschwindigkeit()).
 *
 * Vererbungshirarchie:
 * FahrzeugBase (abstrakt)
 * |- Auto (konkret)
 * |- Elektroauto (konkret)
 * |- Fahrrad (konkret)
 * |- Motorrad (konkret)
 * */

// FahrzeugBase implementiert das Interface Fahrzeug
public abstract class FahrzeugBase implements Fahrzeug{
    /*
    1. Attribute (protected, damit Kindklassen Zugriff haben)
     */

    /**
     * protected:
     * - sichtbar in dieser Klasse UND allen Kindklassen
     * - nicht sichtbar für andere Klassen außerhalb der Vererbungshierarchie
     */

    protected String hersteller;
    protected String modell;
    protected double geschwindigkeit;
    protected int baujahr;

    /*
    * 2. Konstruktor der Basisklasse
    * */
    /**
     * Konstruktoren:
     * Methoden mit dem selben Namen wie die Klasse
     * Werden beim Erstellen eines Objekts mit "new" aufgerufen
     * Initialisiert die Attribute des Objekts
     *
     * this:
     * - bezieht sich auf das aktuelle Objekt (die Instanz der Klasse)
     * - Wird verwenden, um Instanzvariablen von lokalen Variablen zu unterscheiden
     * this.hersteller = Instanzvariable (Attribut der Klasse)
     * hersteller = Parameter des Konstruktors
     * @param hersteller Der Hersteller des Fahrzeuges
     * @param modell Das Modell des Fahrezuges
     * @param baujahr Das Baujahr des Fahrzeuges
     */

    public FahrzeugBase(String hersteller, String modell, int baujahr){
        this.hersteller = hersteller;
        this.modell = modell;
        this.baujahr = baujahr;
        // Standardwert für Geschwindigkeit
        this.geschwindigkeit = 0.0;
    }




}

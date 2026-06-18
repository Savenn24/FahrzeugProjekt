package fahrzeuge.base;

import fahrzeuge.interfaces.Fahrzeug;

/**
 * Abstrakte Klasse für alle Fahrzeuge
 * Was ist eine abstrakte Klasse?
 * Eine Klasse, die NICHT instanziiert werden kann (kein "new FahrzeugBase()")
 * Kann sowohl abstrakte als auch konkrete Methoden haben.
 * Dient als gemeinsame Basis für Vererbung
 * Warum verwenden wir diese abstrakten Klassen?
 * gemeinsame Attribute: alle Fahrzeuge haben Hersteller, Modell, Baujahr, Geschwindigkeit.
 * Gemeinsame Implementierung: Methoden wie beschleunigen(), bremsen(), status() sind
 * für alle gleich.
 * Abstrakte Methoden: erzwingen, dass Kindklassen bestimmte Methoden implementieren
 * (z.B. getMaxGeschwindigkeit()).
 *
 * Vererbungshierarchie:
 * FahrzeugBase (abstrakt)
 * |- Auto (konkret)
 * |- Elektroauto (konkret)
 * |- Fahrrad (konkret)
 * |- Motorrad (konkret)
 * */

// FahrzeugBase implementiert das Interface Fahrzeug
public abstract class FahrzeugBase implements Fahrzeug{

    // 1. Attribute (protected, damit Kindklassen Zugriff haben)


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
     * Methoden mit demselben Namen wie die Klasse
     * Werden beim Erstellen eines Objekts mit "new" aufgerufen
     * Initialisiert die Attribute des Objekts
     *
     * this:
     * - bezieht sich auf das aktuelle Objekt (die Instanz der Klasse)
     * - Wird verwendet, um Instanzvariablen von lokalen Variablen zu unterscheiden
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

    /*
     * Implementierung der Interface-Methoden
     * Da FahrzeugBase das Interface implementiert, MÜSSEN alle Methoden aus dem Interface hier
     * implementiert werden (außer default- und static-Methoden)
     */

    @Override
    public double getGeschwindigkeit(){
        // this.geschwindigkeit = Zugriff auf die Instanzvariable
        return this.geschwindigkeit;
    }

    @Override
    public void beschleunigen(double wert) {
        // Überprüfen, ob der Wert positiv ist (nur dann beschleunigen)
        if (wert > 0) {
            this.geschwindigkeit += wert;
            System.out.println("Beschleunigt auf " + this.geschwindigkeit + " km/h");
        }
        // Wenn wert <= 0 passiert nix. Kein else notwendig
    }

    @Override
    public void bremsen(double wert){
        // Überprüfen ob der Wet Positiv ist
        if (wert > 0) {
            // Math.max(0,....) stellt sicher, dass die Geschwindigkeit nicht negativ wird
            this.geschwindigkeit = Math.max(0, this.geschwindigkeit - wert);
            System.out.println("Gebremst auf " + this.geschwindigkeit + " km/h");
        }
    }


    @Override
    public String status() {
        // String.format() erstellt einen formatierten String(ähnlich wie printf)
        // %s = String, %.1f = double mit einer Nachkommastelle
        return String.format("%s %s (%d), Geschwindigkeit: %.1f km/h",
                this.hersteller,
                this.modell,
                this.baujahr,
                this.geschwindigkeit);
    }

    /* 4. Abstrakte Methoden (müssen von Kindsklassen implementiert werden)*/
    /**
     * Abstrakte Methoden haben KEINE IMPLEMENTIERUNG (kein {}-Block)
     * Sie zwingen alle Kindsklassen, diese Methode zu implementieren.
     *
     * @return Die maximale Geschwindigkeit des Fahrzeuges in km/h
     */

    public abstract double getMaxGeschwindigkeit();

    // 5. Konkrete Methode mit Implementierung
    /*
    * konkrete Methoden haben eine Implementierung und können von Kindklassen
    * überschreiben oder geerbt werden*/
    /**
     * Berechne die Fahrzeit für eine bestimmte Strecke
     * @param strecke die Strecke in Kilometer
     * @return die Fahrzeit in Stunden
     * @throws IllegalStateException wenn das Fahrzeug steht, Geschwindigkeit <= 0
     */

    public double berechneFahrzeit(double strecke) {
        // Überprüfen ob das Fahrzeug steht
        if(this.geschwindigkeit <= 0){
            throw new IllegalStateException(("Fahrzeug steht still! Geschwindigkeit muss > 0 sein"));
        }
        // berechnung: Zeit = Strecke / Geschwindigkeit
        return strecke / this.geschwindigkeit;

    }

    // 6. Getter.Methoden zum Auslesen der Attribute
    /* Getter.Methoden:
    * - öffentlich Methode zum Auslesen privater/geschützter Attribute
    * - Kein 'this.' nötig, da keine Namenskonflikte mit lokalen Variablen
    */

    public String getHersteller(){
        return hersteller;
    }

    public String getModell(){
        return modell;
    }

    public  int getBaujahr(){
        return baujahr;
    }



}

package fahrzeuge.motorraeder;


import fahrzeuge.base.FahrzeugBase;

// Klasse für Motorräder - erbt von FahrzeugBase
public class Motorrad extends FahrzeugBase {
    // 1. Attribute spezifisch für Motorräder
    private int hubraum;
    private boolean hatBeiwagen;

    // 2. Konstruktor für Motorräder
    /**
     * Konstruktor für Motorräder
     * ruft den Elternkonstruktor (FahrzeugBase) mit super() auf
     * Initialisiert die neuen Attribute
     *
     * @param hersteller Hersteller
     * @param modell Modell
     * @param baujahr Baujahr
     * @param hubraum Hubraum in cm2
     * @param hatBeiwagen Ob ein Beiwagen vorhanden ist (true/false)*/
    public Motorrad(String hersteller, String modell, int baujahr, int hubraum, boolean hatBeiwagen) {
        super(hersteller, modell, baujahr);
        //INitialisierung der neuen Attribute
        this.hubraum = hubraum;
        this.hatBeiwagen = hatBeiwagen;
    }

    // 3. Implementierung der abstrakten Methode
    @Override
    public  double getMaxGeschwindigkeit(){
        // Die maximale Geschwindigkeit hängt vom Hubraum ab
        if (hubraum >= 1000) return 250.0;
        else if (hubraum >= 600) return 200.0;
        else return 150.0;
        // Wenn es nur 1 Statement gibt, dann braucht man keine geschweiften Klammern
    }

    @Override
    public String getFahrzeugArt(){
        return "Motorrad";
    }

    // 4. Überschreiben von status()
    @Override
    public String status(){
        return super.status() + String.format(", Hubraum: %d cm³, Beiwagen: %s",
                this.hubraum,
                this.hatBeiwagen ? "vorhanden" : "nicht vorhanden");
    }

    // 5. Getter-Methode
    public int getHubraum(){
        return hubraum;
    }

    public boolean getHatBeiwagen(){
        return hatBeiwagen;
    }

    //  6. Setter-Methode
    public boolean setHatBeiwagen(boolean){
        this.hatBeiwagen = hatBeiwagen;
    }


}

import fahrzeuge.autos.Auto;
import fahrzeuge.base.FahrzeugBase;
import fahrzeuge.interfaces.Fahrzeug;

public class Main {
    public static void main(String[] args) {
        // 1. Programmheader und Grundeinstellung

        System.out.println("=======================================================");
        System.out.println("                    Fahrzeug-Projekt                   ");
        System.out.println("=======================================================");
        System.out.println("  Maximal erlaubte Autobahn-Geschwindigkeit: " + Fahrzeug.getMaxAutobahnGeschwindigkeit()
                            + " km/h");
        System.out.println("=======================================================");

        // 2. Fahrzeug Instanziieren
        // Erstelle verschiedene Fahrzeugtypen zur Demo
        // Ein normales Auto mit Verbrennungsmotor

        Auto auto1 = new Auto("Audi", "A6", 2020, 4, true);
        Auto auto2 = new Auto("Fiat", "Punto", 2022, 5, true);
        System.out.println(auto1);

        // 3. Fahrzeuge in einem Array Speicher
        // Demonstration von Polymorphie: verschieden Fahrzeugtypen werden als fahrzeugBase behandelt
        FahrzeugBase[] fahrzeuge = {
                auto1,
                auto2

        };

    }
}




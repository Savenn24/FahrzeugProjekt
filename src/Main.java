import fahrzeuge.autos.Auto;
import fahrzeuge.autos.Elektroauto;
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

        Elektroauto eAuto1 = new Elektroauto("Tesla", "Model 3", 2024, 4, 99);
        Elektroauto eAuto2 = new Elektroauto("BYD", "Dings", 2026, 5, 100);



        System.out.println(
                "\nFuhrpark:   " + auto1.status()
                + "\n\t\t\t" + auto2.status()
                + "\n\t\t\t" + eAuto1.status()
                + "\n\t\t\t" + eAuto2.status());

        // 3. Fahrzeuge in einem Array Speicher
        // Demonstration von Polymorphie: verschieden Fahrzeugtypen werden als fahrzeugBase behandelt
        FahrzeugBase[] fahrzeuge = {
                auto1,
                auto2,
                eAuto1,
                eAuto2
        };

        // 3. Grundinformationen aller Fahrezuge anzeigen
        System.out.println("\n\n============ Grundinformationen aller Fahrzeuge ================\n");

        for (int i = 0; i < fahrzeuge.length; i++){
            FahrzeugBase fahrzeug = fahrzeuge[i];
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Hersteller: " + fahrzeug.getHersteller());
            System.out.println("Modell: " + fahrzeug.getModell());
            System.out.println("Baujahr: " + fahrzeug.getBaujahr());
            System.out.println("Aktuelle Geschwindigkeit: " + fahrzeug.getGeschwindigkeit() + "Km/h");
            System.out.println("Fahrzeugtyp: " + fahrzeug.getFahrzeugArt());
            System.out.println("Maximale Geschwindigkeit: " + fahrzeug.getMaxGeschwindigkeit() + " Km/h");
            System.out.println("Status: " + fahrzeug.status());
        }

    }
}




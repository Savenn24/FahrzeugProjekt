import fahrzeuge.autos.Auto;
import fahrzeuge.autos.Elektroauto;
import fahrzeuge.base.FahrzeugBase;
import fahrzeuge.fahrraeder.Fahrrad;
import fahrzeuge.interfaces.Fahrzeug;
import fahrzeuge.motorraeder.Motorrad;

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

        Fahrrad fahrrad1 = new Fahrrad("Carver", "Schnell", 2011, 21, true);
        Fahrrad fahrrad2 = new Fahrrad("Diamant", "Schön", 2024, 12, true);

        Motorrad motorrad1 = new Motorrad("MotoGuzzi", "California", 1988, 1000, false);
        Motorrad motorrad2 = new Motorrad("Suzuki", "VL 1500 LC", 2005, 1500, false);


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
                eAuto2,
                fahrrad1,
                fahrrad2,
                motorrad1,
                motorrad2
        };

        // 4. Grundinformationen aller Fahrzeuge anzeigen
        System.out.println("\n\n============ Grundinformationen aller Fahrzeuge ================\n");

        for (int i = 0; i < fahrzeuge.length; i++) {
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
        // 5. Fahrzeuge Beschleunigen
        System.out.println("================== Beschleunigungsvorgang=========================");
        for (int i = 0; i < fahrzeuge.length; i++){
            FahrzeugBase fahrzeug = fahrzeuge[i];
            System.out.println("Vorher: " + fahrzeug.status());
            fahrzeug.beschleunigen(30);
            System.out.println("Nachher: " + fahrzeug.status());
            System.out.println();
        }

        // 6. Spezifische Aktionen für jedes Fahrzeug
        System.out.println("\n================ Spezifische Aktionen =======================");

        // Auto-Spezifische Aktionen
        if (auto1 instanceof Auto);{
            Auto auto = (Auto) auto1;
            System.out.println("Klimaanlage beim auto wird deaktiviert: ");
            auto.setKlimaanlage(true);
            System.out.println("Neuer Status: " + auto.status());
            System.out.println();
        }

        // Elektrospezifische Aktionen
        if (eAuto1 instanceof Auto) {
            Elektroauto eAutoIn = (Elektroauto) eAuto1;
            System.out.println("Elektroauto wird geladen:");
            eAutoIn.laden(20);
            System.out.println("Neuer Status: " + eAutoIn.status());
            System.out.println();
        }

        // Fahrradspezifische Aktion
        if(fahrrad1 instanceof Fahrrad){
            Fahrrad rad1 = (Fahrrad) fahrrad1;
            System.out.println("Fahrrad wird stark Beschleunigt (ist auf 50.0 begrenzt):");
            rad1.beschleunigen(13);
            System.out.println("Neuer Status: " + rad1.status());
            System.out.println();

        }

        // Motorradspezifische Aktion
        if(motorrad1 instanceof Motorrad){
            Motorrad mot1 = (Motorrad) motorrad1;
            mot1.setHatBeiwagen(true);
            System.out.println("Mororradspezifische Information:");
            System.out.println("Hubraum: " + (mot1.getHubraum() + " cm³"));
            System.out.println("Beiwagen vorhanden: " + (mot1.getHatBeiwagen() ? "Ja" : "Nein"));
            System.out.println("Neuer Status: " + mot1.status());
            System.out.println();

        }
        // 7. Fahrzeit berechnen
        System.out.println("\n=========================== Fahrzeit berechnen =========================");

        double strecke = 150.0;     // 150 Kilometer Streck
        for (int i = 0; i < fahrzeuge.length; i++){
            FahrzeugBase fahrzeug = fahrzeuge[i];
            try {
                // Nur Berechnen, wenn das Fahrzeug fährt (Geschwindigkeit > 0)
                if (fahrzeug.getGeschwindigkeit() > 0){
                    double fahrzeit = fahrzeug.berechneFahrzeit(strecke);
                    System.out.printf("%s braucht %.2f Stunden für %.1f km (bei %.1f km/h)%n",
                    fahrzeug.getFahrzeugArt(),
                    fahrzeit,
                    strecke,
                    fahrzeug.getGeschwindigkeit());
                } else {
                    System.out.println(fahrzeug.getFahrzeugArt() + ": Fahrzeug steht sill - Fahrzeit nicht berechnet.");
                }
            }catch (IllegalStateException e) {
                System.out.println(fahrzeug.getFahrzeugArt() + ": Fehler bei Fahrzeitberechnung -" + e.getMessage());
            }
        }
        System.out.println();

        // Status alles Fahrzeuge noch einmal anzeigen
        System.out.println("\n================= Status zum Schluss :-) =====================\n");

        for (int i = 0; i < fahrzeuge.length; i++){
            FahrzeugBase fahrzeug = fahrzeuge[i];
            System.out.println(fahrzeug.getFahrzeugArt() + ": " +fahrzeug.status());
        }


    }


}




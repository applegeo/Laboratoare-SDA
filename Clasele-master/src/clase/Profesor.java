package clase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Profesor {
    String nume;
    String prenume;

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Profesor(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public static Profesor[] CitesteProfesoriDinFisier(String numeFisier) {
        List<Profesor> listaProfesori = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] date = linie.split(" ");
                if (date.length == 2) {
                    String nume = date[0];
                    String prenume = date[1];
                    listaProfesori.add(new Profesor(nume, prenume));
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului de profesori: " + e.getMessage());
        }
        return listaProfesori.toArray(new Profesor[0]);
    }


    @Override
    public String toString() {
        return nume + " " + prenume;
    }

}
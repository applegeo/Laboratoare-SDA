package clase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Curs<note> {
    public Profesor[] profesori;
    String nume;
    String descriere;
    Set<Student> studenti;
    HashMap<Student, Integer > note;

    public Curs(String nume, String descriere,
                Profesor[] profesori, Student[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profesori = profesori;
        this.studenti = new HashSet<>();
        for(Student student : studenti) {
            this.studenti.add(student);
        }
        this.note = new HashMap<>();
    }
    public static Student[] CitesteStudentiDinFisier(String numeFisier) {
        List<Student> listaStudenti = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] date = linie.split(" ");
                if (date.length == 3) {
                    String nume = date[0];
                    String prenume = date[1];
                    int grupa = Integer.parseInt(date[2]);
                    listaStudenti.add(new Student(nume, prenume, grupa));
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }
        return listaStudenti.toArray(new Student[0]);
    }



    public void ModificaStudent(Student stu, String nums, String prenums) {
        studenti.remove(stu);
        stu.nume = nums;
        stu.prenume = prenums;
        studenti.add(stu);
    }


    public void AdaugaProf(Profesor deAdaugat) {

        int lungimenoua = profesori.length + 1;
        Profesor[] aux = new Profesor[lungimenoua];
        int index = 0;
        for (Profesor s : profesori) {
            aux[index++] = s;
        }
        aux[index] = deAdaugat;
        this.profesori = aux;
    }

    public void StergeProf(String numeS, String prenS) {
        int lungimenoua = profesori.length - 1;
        Profesor[] aux = new Profesor[lungimenoua];
        for (int i = 0; i <= lungimenoua; i++) {
            if (profesori[i].nume != numeS && profesori[i].prenume != prenS) {
                aux[i] = profesori[i];
            }
        }
        this.profesori = aux;
    }

    public void ModificaProf(Profesor prof, String nums, String prenums) {
        prof.nume = nums;
        prof.prenume = prenums;
    }

    public void ArataStud() {
        for (Student s : studenti) {
            System.out.println(s);
        }
    }
    public void ArataProf() {
        if (profesori != null && profesori.length > 0) {
            for (Profesor s : profesori) {
                System.out.println(s.getNume() + " " + s.getPrenume());
            }
        } else {
            System.out.println("Nu sunt profesori asignați acestui curs.");
        }
    }

    public void AdNota(int nota, Student student) {
        note.put(student, nota);
    }

    public void CalculeazaMedia() {
        int med=0;
        for(HashMap.Entry<Student, Integer> entry : note.entrySet()) {
            med=med+entry.getValue();
        }
        med=med/note.size();
        System.out.println("Media studentilor este :"+ med);
    }
    public void ArataNota() {
       for(HashMap.Entry<Student, Integer> entry : note.entrySet()) {
           System.out.println(entry.getKey() + " " + entry.getValue());
       }
    }

    public static Curs[] CitesteCursuriDinFisier(String numeFisier, Profesor[] profesori, Student[] studenti) {
        List<Curs> listaCursuri = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                linie = linie.trim();
                if (linie.isEmpty()) {
                    continue;
                }

                // Citește numele cursului
                String numeCurs = linie;

                // Citește descrierea cursului (următoarea linie)
                linie = br.readLine();
                if (linie == null) break;  // Dacă linia este null, întrerupe procesarea
                String descriereCurs = linie.trim();

                // Citește lista de profesori (următoarea linie)
                linie = br.readLine();
                if (linie == null) break;  // Dacă linia este null, întrerupe procesarea
                String profesoriLinie = linie.trim();

                // Dividerea liniei profesorilor în nume individuale
                String[] profesoriNume = profesoriLinie.split(" ");
                List<Profesor> profesoriCurs = new ArrayList<>();

                // Compară numele profesorilor din curs cu cei din lista de profesori
                for (String numeProfesor : profesoriNume) {
                    for (Profesor profesor : profesori) {
                        // Asigură-te că numele complet al profesorului se potrivește
                        if ((profesor.getNume() + " " + profesor.getPrenume()).equals(numeProfesor)) {
                            profesoriCurs.add(profesor);
                            break;
                        }
                    }
                }

                // Convertește lista de profesori într-un array
                Profesor[] profesoriArray = profesoriCurs.toArray(new Profesor[0]);

                // Adaugă cursul în lista de cursuri
                listaCursuri.add(new Curs(numeCurs, descriereCurs, profesoriArray, studenti));
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului de cursuri: " + e.getMessage());
        }

        return listaCursuri.toArray(new Curs[0]);
    }






}







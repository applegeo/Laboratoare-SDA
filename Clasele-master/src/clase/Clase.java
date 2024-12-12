package clase;
public class Clase {
    public static void main(String[] args) {


        Student[] studenti = Curs.CitesteStudentiDinFisier("studenti.txt");
        Profesor[] profesori = Profesor.CitesteProfesoriDinFisier("profesori.txt");
        Curs[] cursuri = Curs.CitesteCursuriDinFisier("cursuri.txt", profesori, studenti);


        Curs kiss = cursuri[0];

           for (Curs curs : cursuri) {
                  System.out.println("Curs: " + curs.nume);
                  System.out.println("Descriere: " + curs.descriere);
                  System.out.print("Profesori:");
                  kiss.ArataProf();
                  System.out.println();
           }

        kiss.ArataStud();
        System.out.println();
        kiss.ArataProf();
        System.out.println();


        kiss.AdNota(6,studenti[0]);
        kiss.AdNota(8,studenti[1]);
        kiss.ArataNota();
        kiss.CalculeazaMedia();


    }
}
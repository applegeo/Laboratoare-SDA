package clase;

import java.sql.Connection;

public class ManagerCursuri {
    Curs[] cursuri;

    public ManagerCursuri() {
        Connection conn = null;
        cursuri = new Curs[0];
    }


    public void AdaugaCurs(Curs deAdaugat) {

        int lungimenoua = cursuri.length + 1;
        Curs[] aux = new Curs[lungimenoua];
        int index = 0;
        for (Curs c : cursuri) {
            aux[index++] = c;
        }
        aux[index] = deAdaugat;
        this.cursuri = aux;
    }

    public void StergeCurs(String deSters) {

        int lungimenoua = cursuri.length - 1;
        Curs[] aux = new Curs[lungimenoua];
        int index = 0;
        for (int i = 0; i <= lungimenoua; i++) {
            if (cursuri[i].nume != deSters) {
                aux[index] = cursuri[i];
                index++;
            }
        }
        this.cursuri = aux;
    }

    public void AfiseazaCursuriLaConsola() {
        for (Curs c : cursuri)
            System.out.println(c);
    }

    public void ArataNoteCursuri() {

    }
}


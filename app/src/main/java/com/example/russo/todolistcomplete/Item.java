package com.example.russo.todolistcomplete;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by russo on 08/03/2017.
 */

public class Item {
    private int id;
    private String Titolo, Descrizione, DataCreazione, DataScadenza;
    private Boolean Speciale;

    public Item(int id, String titolo, String descrizione, String dataScadenza) {
        this.id = id;
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM yyyy");
        Titolo = titolo;
        Descrizione = descrizione;
        DataCreazione = date.format(new Date());
        DataScadenza = dataScadenza;
    }

    public Item(String titolo, String descrizione, String dataScadenza, Boolean speciale) {
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM yyyy");
        Titolo = titolo;
        Descrizione = descrizione;
        DataCreazione = date.format(new Date());
        DataScadenza = dataScadenza;
        Speciale = speciale;
    }

    public Item(int id, String titolo, String descrizione, String dataScadenza, Boolean speciale) {
        this.id = id;
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM yyyy");
        Titolo = titolo;
        Descrizione = descrizione;
        DataCreazione = date.format(new Date());
        DataScadenza = dataScadenza;
        Speciale = speciale;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public String getDataCreazione() {
        return DataCreazione;
    }

    public void setDataCreazione(String dataCreazione) {
        DataCreazione = dataCreazione;
    }

    public String getDataScadenza() {
        return DataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        DataScadenza = dataScadenza;
    }

    public Boolean getSpeciale() {
        return Speciale;
    }

    public void setSpeciale(Boolean speciale) {
        Speciale = speciale;
    }
}

package Analizadores;

import java.util.ArrayList;

public class AFD {
    public String iden;
    public String[][]Mueves;
    public ArrayList<String> Estados;
    public ArrayList<String> Terminales;

    public AFD(String iden, String[][] Mueves, ArrayList<String> Estados, ArrayList<String> Terminales) {
        this.iden = iden;
        this.Mueves = Mueves;
        this.Estados = Estados;
        this.Terminales = Terminales;
    }
}

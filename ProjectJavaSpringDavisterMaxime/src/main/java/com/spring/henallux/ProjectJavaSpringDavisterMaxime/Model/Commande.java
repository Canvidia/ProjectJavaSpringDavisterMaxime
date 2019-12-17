package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Commande {
    private int numero;
    private GregorianCalendar date;
    private ArrayList<Ligne> lignes;

    public Commande() {
        lignes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void addLigne(Ligne ligne){
        int i = iLigneDeArticle(ligne.getProduit().getId());
        if(i==-1) lignes.add(ligne);
        else lignes.get(i).setQuantite(ligne.getQuantite());
    }

    public void removeLigne(int idProduit){
        int i = iLigneDeArticle(idProduit);
        if(i !=-1){
            lignes.remove(i);
        }
    }

    public int iLigneDeArticle(int idProduit){
        int i = 0;
        while( i < lignes.size() && lignes.get(i).getProduit().getId() != idProduit){
            i++;
        }
        return i != lignes.size()?i:-1;
    }

    public ArrayList<Ligne> getLignes(){
        return lignes;
    }
}

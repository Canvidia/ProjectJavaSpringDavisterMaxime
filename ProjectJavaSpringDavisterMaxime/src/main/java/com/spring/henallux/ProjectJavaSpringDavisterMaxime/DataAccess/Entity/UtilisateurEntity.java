package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chemin_traverse_utilisateur")
public class UtilisateurEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "non_expired")
    private boolean nonExpired;
    @Column(name = "non_locked")
    private boolean nonLocked;
    @Column(name = "credential_non_expired")
    private boolean credentialNonExpired;
    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "maison")
    private int maison;
    @Column(name = "sexe")
    private char sexe;
    @Column(name = "rue")
    private String rue;
    @Column(name = "numero")
    private int numero;
    @Column(name = "telephonne")
    private String telephonne;
    @Column(name = "mail")
    private String mail;
    @Column(name = "patronus")
    private String patronus;

    public UtilisateurEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNonExpired() {
        return nonExpired;
    }

    public void setNonExpired(boolean nonExpired) {
        this.nonExpired = nonExpired;
    }

    public boolean isNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public boolean isCredentialNonExpired() {
        return credentialNonExpired;
    }

    public void setCredentialNonExpired(boolean credentialNonExpired) {
        this.credentialNonExpired = credentialNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getMaison() {
        return maison;
    }

    public void setMaison(int maison) {
        this.maison = maison;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTelephonne() {
        return telephonne;
    }

    public void setTelephonne(String telephonne) {
        this.telephonne = telephonne;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }
}

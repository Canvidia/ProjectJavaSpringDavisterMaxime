package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity;

import javax.persistence.*;

@Entity
@Table(name = "chemin_traverse_langue")
public class LangueEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "code_langue")
    private String codeLangue;

    public LangueEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeLangue() {
        return codeLangue;
    }

    public void setCodeLangue(String codeLangue) {
        this.codeLangue = codeLangue;
    }
}

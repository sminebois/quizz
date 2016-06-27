/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Quizz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    
    @OneToMany(mappedBy = "lquizz")
    private List<Question> lquestions;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Question> getLquestions() {
        return lquestions;
    }

    public void setLquestions(List<Question> lquestions) {
        this.lquestions = lquestions;
    }

    public Quizz() {
    }

    public Quizz(String nom, List<Question> lquestions) {
        this.nom = nom;
        this.lquestions = lquestions;
    }

    public Quizz(String nom) {
        this.nom = nom;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quizz)) {
            return false;
        }
        Quizz other = (Quizz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quizz.entity.Quizz[ id=" + id + " ]";
    }
    
}

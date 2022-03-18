package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Tache extends Model {

    public String title;
    public boolean done = false;
}

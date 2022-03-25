package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Tache extends Model {

    public String title;
    public boolean done = false;
    public LocalDateTime time =  LocalDateTime.now().plusMinutes(1);
    public Boolean notification = false;
}

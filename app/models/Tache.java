package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Entity
public class Tache extends Model {

    public String title;
    public boolean done = false;
    public LocalDateTime time =  LocalDateTime.now(ZoneId.of("Europe/Paris")).plusMinutes(1);
    public boolean notification = false;
}

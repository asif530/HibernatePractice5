package org.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//Know about GenericGenerator,GenericGenerators

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="Aliens")
public class UserDetails {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String userName;
    
    @ManyToMany //(mappedBy = "userDetails")
    private Collection<Songs> Playlist = new ArrayList<Songs>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Collection<Songs> getPlaylist() {
        return Playlist;
    }

    public void setPlaylist(Collection<Songs> playlist) {
        Playlist = playlist;
    }
}

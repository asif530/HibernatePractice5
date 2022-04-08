package org.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@SequenceGenerator(name="PRIVATE_SEQ", sequenceName="private_sequence")
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private int sid;
    private String sName;
    private String source;

    @ManyToMany(mappedBy = "Playlist")
   // @JoinColumn(name = "UserId", referencedColumnName = "userId")
    private Collection<UserDetails> userDetails = new ArrayList<UserDetails>();

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Collection<UserDetails> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Collection<UserDetails> userDetails) {
        this.userDetails = userDetails;
    }
}

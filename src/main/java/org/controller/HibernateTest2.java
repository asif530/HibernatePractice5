package org.controller;
/*
 * Continuation of hibernate 15
 * Here in place of collection we will use entity
 * Purpose: Many To Many
 * Parent: No
 * Child: No
 * Many to Many requires additional table to create relationship. We can have 2 tables or 1 table depending on configuration
 * Both of them will be shown here.
 * */

import org.dto.Songs;
import org.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Many to Many with mappedBy in any of the entity creates 1 additional table
 * We will add mapped by in UserDetails Entity
 * */
public class HibernateTest2 {
    public static void main(String[] args) {
        UserDetails userDetails1 = new UserDetails();
        UserDetails userDetails2 = new UserDetails();

        userDetails1.setUserName("First User");
        userDetails2.setUserName("Second User");

        Songs songs = new Songs();  //1
        Songs songs1 = new Songs(); //2
        Songs songs2 = new Songs(); //3
        Songs songs3 = new Songs(); //4
        Songs songs4 = new Songs(); //5
        Songs songs5 = new Songs(); //6


        songs.setsName("Hoist the colours");
        songs.setSource("Pirates of the Seas");

        songs1.setsName("The Willow Maid");
        songs1.setSource("Erutan");

        songs2.setsName("Jolly Sailor Bold");
        songs2.setSource("Pirates of the Seas");

        songs3.setsName("Here with you");
        songs3.setSource("Dido");

        songs4.setsName("White Flag");
        songs4.setSource("Dido");

        songs4.setsName("Issues");
        songs4.setSource("Julia Michel");

        songs5.setsName("Sanity.io");
        songs5.setSource("Kapeha");

        userDetails1.getPlaylist().add(songs);
        userDetails1.getPlaylist().add(songs2);
        userDetails1.getPlaylist().add(songs3);

        userDetails2.getPlaylist().add(songs);
        userDetails2.getPlaylist().add(songs2);
        userDetails2.getPlaylist().add(songs4);
        userDetails2.getPlaylist().add(songs5);

        songs.getUserDetails().add(userDetails1);
        songs2.getUserDetails().add(userDetails1);
        songs3.getUserDetails().add(userDetails1);

        songs.getUserDetails().add(userDetails2);
        songs2.getUserDetails().add(userDetails2);
        songs4.getUserDetails().add(userDetails2);
        songs5.getUserDetails().add(userDetails2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(userDetails1);
        session.save(userDetails2);

        session.save(songs);
        session.save(songs2);
        session.save(songs3);
        session.save(songs4);
        session.save(songs5);

        session.getTransaction().commit();

        //userDetails = (UserDetails)session.get(UserDetails.class,1);
        session.close();
    }
}

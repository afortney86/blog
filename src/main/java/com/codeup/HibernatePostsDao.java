package com.codeup;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonyfortney on 1/5/17.
 */
public class HibernatePostsDao implements Posts {
     private Session session;

    public HibernatePostsDao(Session session){
        this.session = session;

    }


    @Override
    public List<Post> all() {
        return session.createQuery("from Post").list();
    }

    @Override
    public void savePost(Post post) {
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();


        //to update session.update(post)
    }

    @Override
    public void updatePost() {

    }

    @Override
    public void deletePosts() {

    }
}

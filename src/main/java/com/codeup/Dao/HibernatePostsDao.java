package com.codeup.Dao;

import com.codeup.models.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;


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

    }

    @Override
    public Post findPostById(long id) {
        Query query = session.createQuery("FROM Post where id = :id");
        query.setParameter("id", id);
        return (Post) query.getSingleResult();
    }


    @Override
    public void updatePost(Post existingPost) {
        Transaction tx = session.beginTransaction();
        session.update(existingPost);
        tx.commit();

    }

    @Override
    public void deletePosts(long id) {
        Transaction tx = session.beginTransaction();
        session.delete(findPostById(id));
        tx.commit();

    }
}

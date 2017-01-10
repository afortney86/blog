package com.codeup.Dao;



import com.codeup.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoFactory {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    private static Posts PostsDao;

    public static Posts getPostsDao(){
        if (PostsDao == null){
            PostsDao = new HibernatePostsDao(session);
        }
        return PostsDao;
    }
}

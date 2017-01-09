package com.codeup.Dao;


import com.codeup.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoFactory {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    private static Posts HibernatePostsDao;

    public static Posts getHibernatePostsDao(){
        if (HibernatePostsDao == null){
            HibernatePostsDao = new HibernatePostsDao(session);
        }
        return HibernatePostsDao;
    }
}

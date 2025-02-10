package org.example;

import org.example.bibliotecafx.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

    }

}

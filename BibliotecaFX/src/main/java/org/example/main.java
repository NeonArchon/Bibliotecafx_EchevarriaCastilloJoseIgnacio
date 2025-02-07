package org.example;

import org.example.bibliotecafx.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

    }

}

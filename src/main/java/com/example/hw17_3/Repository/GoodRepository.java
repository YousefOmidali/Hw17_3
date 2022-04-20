package com.example.hw17_3.Repository;

import com.example.hw17_3.Entity.Good;
import org.hibernate.SessionFactory;


public class GoodRepository {

    protected SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Good save(Good good) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.save(good);
                transaction.commit();
                return good;
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void update(Good good) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.update(good);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void delete(Good good) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.delete(good);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void deleteById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.delete(id);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public Good findById(Integer id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Good.class, id);
            session.getTransaction().commit();
            return a;
        }
    }
}

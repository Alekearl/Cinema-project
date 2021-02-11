package com.dev.cinema.dao.daoimpl;

import com.dev.cinema.dao.TicketDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add ticket entry " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

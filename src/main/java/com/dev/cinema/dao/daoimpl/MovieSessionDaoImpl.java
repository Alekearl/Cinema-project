package com.dev.cinema.dao.daoimpl;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.lib.Dao;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> getAvailableMovieSessionsQuery = session
                    .createQuery("FROM MovieSession WHERE movie.id = :movieId "
                            + "AND DATE_FORMAT(showTime, 'YYYY-mm-DD') = "
                            + ":date", MovieSession.class);
            getAvailableMovieSessionsQuery.setParameter("movieId", movieId);
            getAvailableMovieSessionsQuery
                    .setParameter("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE));
            return getAvailableMovieSessionsQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can`t find available sessions with movieId: "
                    + movieId + " on date: " + date, e);
        }
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert movie session entry "
                    + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

package com.sda.weather.application.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class WeatherRepository {

    private final SessionFactory sessionFactory;

    public WeatherRepository() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    public WeatherEntry saveNewEntry(final WeatherEntry weatherEntry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(weatherEntry);
        transaction.commit();
        session.close();
        return weatherEntry;
    }

    public List<WeatherEntry> readSavedWeather() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<WeatherEntry> savedWeather = session.createQuery("FROM WeatherEntry").getResultList();

        transaction.commit();
        session.close();

        return savedWeather;
    }
}

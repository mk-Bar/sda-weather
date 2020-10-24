package com.sda.weather.application.localization;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class LocalizationRepository {

    private final SessionFactory sessionFactory;

    public LocalizationRepository() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    public LocalizationEntry saveNewEntry(final LocalizationEntry localizationEntry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(localizationEntry);
        transaction.commit();
        session.close();
        return localizationEntry;


    }

    public List<LocalizationEntry> readAllSavedPlaces() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List savedLocalizations = session.createQuery("FROM LocalizationEntry").getResultList();

        transaction.commit();
        session.close();

        return savedLocalizations;
    }
}

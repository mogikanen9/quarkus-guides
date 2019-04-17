package org.acme.persistence;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.loader.custom.NonUniqueDiscoveredSqlAliasException;

@ApplicationScoped
public class SantaClausService {

    @Inject
    EntityManager em;

    @Transactional
    public void createGift(String giftDescription) {
        Gift gift = new Gift();
        gift.setName(giftDescription);
        em.persist(gift);
    }

    @Transactional
    public Gift findGift(Long id) {
        return em.find(Gift.class, id);
    }

    @Transactional
    public Optional<Gift> findGiftByName(String name) {
        Query query = em.createQuery("from " + Gift.class.getName() + " where name = :name");
        query.setParameter("name", name);
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);
        Gift gift = null;
        try {
            gift = (Gift) query.getSingleResult();
        } catch (NoResultException | NonUniqueDiscoveredSqlAliasException e) {
            System.out.println(String.format("WARN: no or multiple results for searched name->%s", name));
        }
        return Optional.ofNullable(gift);
    }
}
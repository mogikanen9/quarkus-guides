package org.acme.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
}
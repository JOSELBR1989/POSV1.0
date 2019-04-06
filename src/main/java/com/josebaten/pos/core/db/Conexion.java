package com.josebaten.pos.core.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/*singleton*/
public class Conexion {

    private static Conexion instancia;

    private final String PERSISTENCE_UNIT_NAME = "PosPU"; // Constancia declarada en persistence. 
    private EntityManager em;   // Gestiona lo que har[a en base de datos, maneja transacciones

    public Conexion() {
        try {
            em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public void save(Object elemento) {
        try {
            em.getTransaction().begin();
            em.persist(elemento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Object elemento) {
        try {
            em.getTransaction().begin();
            em.merge(elemento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Object elemento) {
        try {
            em.getTransaction().begin();
            em.remove(elemento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<?> findAll(Class<?> elemento) {
        //String[] split = elemento.getTypeName().split(",");
        
        int posicion = elemento.getTypeName().indexOf(".");
        String clase = elemento.getTypeName().substring(0, posicion);
        
        return em.createNamedQuery(clase.concat(".findAll")).getResultList();
    }
    
    public Object findById(Class<?> clase, Long id)
    {
        return em.find(clase.getClass(), id);
    }
    
    public Object findById(Class<?> clase, String id)
    {
        return em.find(clase.getClass(), id);
    }
    
    public EntityManager getEm()
    {
        return this.em;
    }
    
}

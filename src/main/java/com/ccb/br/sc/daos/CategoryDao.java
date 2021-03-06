package com.ccb.br.sc.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;

import com.ccb.br.sc.models.Category;

public class CategoryDao
{

   @PersistenceContext(unitName = "default")
   private EntityManager manager;

   public List<Category> all()
   {
      return manager.createQuery("select c from Category c", Category.class).getResultList();
   }

   public void save(Category category)
   {
      manager.persist(category);
   }

   public Category findById(Integer id)
   {
      return manager.find(Category.class, id);
   }

   public void remove(Category category)
   {
      manager.remove(category);
   }

   public void update(Category category)
   {
      manager.merge(category);
   }

}

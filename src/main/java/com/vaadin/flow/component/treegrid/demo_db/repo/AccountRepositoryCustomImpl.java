package com.vaadin.flow.component.treegrid.demo_db.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.vaadin.flow.component.treegrid.demo_db.entity.Account;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public long getChildCount(Account parent) {
    List<Account> list = entityManager
        .createQuery("select t from Account t where t.parent = :parent", Account.class)
        .setParameter("parent", parent).getResultList();
    return list.size();
  }

  @Override
  public Boolean hasChildren(Account parent) {
    List<Account> list = entityManager
        .createQuery("select t from Account t where t.parent = :parent", Account.class)
        .setParameter("parent", parent).getResultList();
    return !list.isEmpty();
  }

  @Override
  public List<Account> getChildren(Account parent) {
    List<Account> list = entityManager
        .createQuery("select t from Account t where t.parent = :parent", Account.class)
        .setParameter("parent", parent).getResultList();
    return list;
  }

}

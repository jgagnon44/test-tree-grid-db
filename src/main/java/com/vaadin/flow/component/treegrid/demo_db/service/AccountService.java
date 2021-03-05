package com.vaadin.flow.component.treegrid.demo_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaadin.flow.component.treegrid.demo_db.entity.Account;
import com.vaadin.flow.component.treegrid.demo_db.repo.AccountRepository;

@Service
@Transactional
public class AccountService {

  private final AccountRepository repo;

  @Autowired
  public AccountService(AccountRepository repo) {
    this.repo = repo;
  }

  public long getChildCount(Account parent) {
    return repo.getChildCount(parent);
  }

  public Boolean hasChildren(Account parent) {
    return repo.hasChildren(parent);
  }

  public List<Account> fetchChildren(Account parent) {
    return repo.getChildren(parent);
  }

}

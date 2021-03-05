package com.vaadin.flow.component.treegrid.demo_db.repo;

import java.util.List;

import com.vaadin.flow.component.treegrid.demo_db.entity.Account;

public interface AccountRepositoryCustom {

  long getChildCount(Account parent);

  Boolean hasChildren(Account parent);

  List<Account> getChildren(Account parent);

}

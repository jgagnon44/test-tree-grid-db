package com.vaadin.flow.component.treegrid.demo_db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaadin.flow.component.treegrid.demo_db.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom {

  long getChildCount(Account parent);

  Boolean hasChildren(Account parent);

  List<Account> getChildren(Account parent);

}

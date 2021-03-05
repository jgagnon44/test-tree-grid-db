package com.vaadin.flow.component.treegrid.demo_db.ui;

import java.util.stream.Stream;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.component.treegrid.demo_db.entity.Account;
import com.vaadin.flow.component.treegrid.demo_db.service.AccountService;
import com.vaadin.flow.data.provider.hierarchy.AbstractBackEndHierarchicalDataProvider;
import com.vaadin.flow.data.provider.hierarchy.HierarchicalDataProvider;
import com.vaadin.flow.data.provider.hierarchy.HierarchicalQuery;
import com.vaadin.flow.router.Route;

@Route("vaadin-tree-grid")
@JsModule("@vaadin/flow-frontend/grid-demo-styles.js")
public class TreeGridDemo extends VerticalLayout {

  private static final long    serialVersionUID = 1L;

  private final AccountService accountService;

  public TreeGridDemo(AccountService accountService) {
    this.accountService = accountService;
    createLazyLoadingTreeGridUsage();
  }

  private void createLazyLoadingTreeGridUsage() {
    TreeGrid<Account> grid = new TreeGrid<>();
    grid.addHierarchyColumn(Account::toString).setHeader("Account Title");
    grid.addColumn(Account::getCode).setHeader("Code");

    HierarchicalDataProvider<Account, Void> dataProvider = new AbstractBackEndHierarchicalDataProvider<Account, Void>() {
      private static final long serialVersionUID = 1L;

      @Override
      public int getChildCount(HierarchicalQuery<Account, Void> query) {
        System.out.println("getChildCount: " + query.getParent());
        return (int) accountService.getChildCount(query.getParent());
      }

      @Override
      public boolean hasChildren(Account item) {
        System.out.println("hasChildren: " + item);
        return accountService.hasChildren(item);
      }

      @Override
      protected Stream<Account> fetchChildrenFromBackEnd(HierarchicalQuery<Account, Void> query) {
        System.out.println("fetchChildrenFromBackEnd: " + query.getParent());
        return accountService.fetchChildren(query.getParent()).stream();
      }
    };

    grid.setDataProvider(dataProvider);

    add(grid);
  }

}

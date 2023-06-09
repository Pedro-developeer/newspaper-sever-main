package com.puc.newspaper.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import com.puc.newspaper.model.Sale;
import com.puc.newspaper.model.User;
import com.puc.newspaper.repo.SaleRepo;

@Service
public class SaleDomain {

  private SaleRepo saleRepo;
  private UserDomain userDomain;

  public SaleDomain(SaleRepo saleRepo, UserDomain userDomain) {
    this.saleRepo = saleRepo;
    this.userDomain = userDomain;
  }

  public void save(Long userId, String plan, String typePlan, Integer price) {

    try {
      User user = null;
      try {
        user = userDomain.findById(userId);
      } catch (Exception e) {
        throw new RuntimeException("User not found");
      }

      Sale sale = new Sale();

      sale.setUser(user);
      sale.setPlan(plan);
      sale.setTypePlan(typePlan);
      sale.setPrice(price);

      saleRepo.save(sale);
    } catch (Exception e) {
      throw new RuntimeException("Sale could not be created");
    }

  }

  public Iterable<Sale> getAll() {
    return saleRepo.findAll();
  }

  public Sale getById(Long id) {

    try {
      return saleRepo.findById(id).get();
    } catch (Exception e) {
      throw new RuntimeException("Sale not found");
    }

  }

  public List<Sale> getReport() {


    try {
      return saleRepo.findAll();
    } catch (Exception e) {
      throw new RuntimeException("Sale not found");
    }

  }

}

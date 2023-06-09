package com.puc.newspaper.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.newspaper.DTO.SaleReport;
import com.puc.newspaper.DTO.SaleRequest;
import com.puc.newspaper.domain.SaleDomain;
import com.puc.newspaper.model.Sale;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/sale")
@CrossOrigin(origins = "*")
public class SaleController {

  private SaleDomain saleDomain;

  public SaleController(SaleDomain saleDomain) {
    this.saleDomain = saleDomain;
  }

  @PostMapping("/create")
  public ResponseEntity<String> createSale(@RequestBody SaleRequest saleRequest) {

    try {
      saleDomain.save(saleRequest.getUserId(), saleRequest.getPlan(), saleRequest.getTypePlan(),
          saleRequest.getPrice());
      return ResponseEntity.ok("Sale created");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @GetMapping("/get-all")
  public ResponseEntity<?> getAll() {

    try {

      Iterable<?> sales = saleDomain.getAll();

      return ResponseEntity.ok(sales);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @GetMapping("/get-by-id/{id}")
  public ResponseEntity<?> getById(@PathVariable Long id) {

    try {
      return ResponseEntity.ok(saleDomain.getById(id));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @GetMapping("/get-report")
  public void getReport(HttpServletResponse response) throws JRException, IOException {

    List<Sale> sales = saleDomain.getReport();

    List<SaleReport> salesReport = new java.util.ArrayList<>();

    //calcular valor total juntando todas as sales
    double total = 0;
    for (Sale sale : sales) {
      total += sale.getPrice();
    }
    //add os itens na tabela
    for (Sale sale : sales) {
      SaleReport saleReport = new SaleReport();
      saleReport.setClientName(sale.getUser().getName());
      saleReport.setEmail(sale.getUser().getEmail());
      saleReport.setPlan(sale.getPlan());
      saleReport.setTypePlan(sale.getTypePlan());
      saleReport.setAmount(sale.getPrice() / 100);
      salesReport.add(saleReport);
    }


    String filePath = "src\\main\\resources\\templates\\saleReport.jrxml";

    JasperReport report = JasperCompileManager.compileReport(filePath);

    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(salesReport);

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("orderDataSet", dataSource);
    parameters.put("total", total / 100);

    JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

    response.setContentType("application/pdf");
    response.setHeader("Content-disposition", "attachment; filename=relatorio.pdf");
    //export pdf
    try (OutputStream out = response.getOutputStream()) {
      JasperExportManager.exportReportToPdfStream(print, out);
      out.flush();
    }

  }

}

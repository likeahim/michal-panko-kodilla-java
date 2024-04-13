package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    void testInvoiceDaoSave() {
        //Given
        Product apple = new Product("Apple");
        Product cake = new Product("Cake");
        Product sandwich = new Product("Sandwich");
        Product milk = new Product("Milk");
        Item apples = new Item(apple, new BigDecimal(10), 5);
        Item cakes = new Item(cake, new BigDecimal(20), 2);
        Item sandwiches = new Item(sandwich, new BigDecimal(30), 8);
        Invoice invoice1 = new Invoice("13/4/2024/124665");
        invoice1.getItems().add(apples);
        invoice1.getItems().add(cakes);
        invoice1.getItems().add(sandwiches);
        apples.setInvoice(invoice1);
        cakes.setInvoice(invoice1);
        sandwiches.setInvoice(invoice1);
        //When
        invoiceDao.save(invoice1);
        int id1 = invoice1.getId();

        //Then
        assertNotEquals(0, id1);

        //CleanUp
        invoiceDao.deleteById(id1);
    }
}

package com.kodilla.good.patterns.challenges.order.services;

import com.kodilla.good.patterns.challenges.order.Client;
import com.kodilla.good.patterns.challenges.order.products.ProductWarehouse;
import com.kodilla.good.patterns.challenges.order.contact.InformationService;

public class ProductOrderService {
    private InformationService informationService;
    private OnlineBuyingService buyingService;
    private ProductWarehouse productWarehouse;

    public ProductOrderService(InformationService informationService, OnlineBuyingService buyingService, ProductWarehouse productWarehouse) {
        this.informationService = informationService;
        this.buyingService = buyingService;
        this.productWarehouse = productWarehouse;
    }

    public BuiyingDto process (BuyingService buyingService) {
        if (buyingService.orderProcessing()) {
            Client client = buyingService.getClient();
            Order order = buyingService.getOrder();
            BuiyingDto buiyingDto = new BuiyingDto(true);
            buiyingDto.setData(client, order);
            return buiyingDto;
        }
        return new BuiyingDto(false);
    }
}

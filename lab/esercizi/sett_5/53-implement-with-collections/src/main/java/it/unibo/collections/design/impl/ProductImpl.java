package it.unibo.collections.design.impl;

import it.unibo.collections.design.api.Product;

public class ProductImpl implements Product {
    private final String name;
    private final double quantity;

    public ProductImpl(final String name, final int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getQuantity() {
        return this.quantity;
    }

}

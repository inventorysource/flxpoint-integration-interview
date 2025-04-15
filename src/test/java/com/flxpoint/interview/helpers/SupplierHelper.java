package com.flxpoint.interview.helpers;

import com.flxpoint.interview.entity.Supplier;

public class SupplierHelper {
    public static Supplier createSupplier(Long id, String name) {
        var supplier = new Supplier();
        supplier.setId(id);
        supplier.setName(name);
        return supplier;
    }
}

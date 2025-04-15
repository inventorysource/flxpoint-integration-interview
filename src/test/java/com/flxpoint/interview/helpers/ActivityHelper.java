package com.flxpoint.interview.helpers;

import com.flxpoint.interview.entity.Activity;
import com.flxpoint.interview.entity.Supplier;

public class ActivityHelper {
    public static Activity createActivity(
        Long id,
        String title,
        int price,
        double rating,
        boolean specialOffer,
        Supplier supplier
    ) {
        var activity = new Activity();
        activity.setId(id);
        activity.setTitle(title);
        activity.setPrice(price);
        activity.setCurrency("$");
        activity.setRating(rating);
        activity.setSpecialOffer(specialOffer);
        activity.setSupplier(supplier);
        return activity;
    }
}

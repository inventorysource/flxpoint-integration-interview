package com.flxpoint.interview.service;

import com.flxpoint.interview.controller.SupplierController;
import com.flxpoint.interview.dto.ActivityDto;
import com.flxpoint.interview.entity.Activity;
import com.flxpoint.interview.repository.ActivityRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final SupplierController supplierController;
    public List<ActivityDto> getActivities() {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDto> result = new ArrayList<>();
        activities.stream().forEach(activity -> {
            result.add(ActivityDto.builder()
                    .id(activity.getId())
                    .title(activity.getTitle())
                    .price(activity.getPrice())
                    .currency(activity.getCurrency())
                    .rating(activity.getRating())
                    .specialOffer(activity.isSpecialOffer())
                    .supplierName(Objects.isNull(activity.getSupplier()) ? "" : activity.getSupplier().getName())
                    .build());
        });
        return result;
    }

    public ActivityDto getActivities(Long activityId) {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDto> result = new ArrayList<>();
        activities.stream().filter(activity -> activityId.equals(activity.getId())).forEach(activity -> {
            result.add(ActivityDto.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .price(activity.getPrice())
                .currency(activity.getCurrency())
                .rating(activity.getRating())
                .specialOffer(activity.isSpecialOffer())
                .supplierName(activity.getSupplier().getName())
                .build());
        });
        return result.get(0);
    }

    public List<ActivityDto> searchActivities(String search) {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDto> result = new ArrayList<>();
        activities.stream().filter(a -> a.getTitle().contains(search)).forEach(activity -> {
            result.add(ActivityDto.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .price(activity.getPrice())
                .currency(activity.getCurrency())
                .rating(activity.getRating())
                .specialOffer(activity.isSpecialOffer())
                .supplierName(activity.getSupplier().getName())
                .build());
        });
        return result;
    }
}

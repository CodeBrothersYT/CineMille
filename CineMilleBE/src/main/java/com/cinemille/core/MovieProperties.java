package com.cinemille.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "movie")
public class MovieProperties{
    private int maxAvailabilityDays;

    public int getMaxAvailabilityDays() {
        return maxAvailabilityDays;
    }

    public void setMaxAvailabilityDays(int maxAvailabilityDays) {
        this.maxAvailabilityDays = maxAvailabilityDays;
    }
}

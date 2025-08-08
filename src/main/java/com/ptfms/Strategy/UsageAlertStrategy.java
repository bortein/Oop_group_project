package com.ptfms.Strategy;

import com.ptfms.model.Component;

public class UsageAlertStrategy implements AlertStrategy {
    @Override
    public boolean shouldAlert(Component component) {
        return component.getUsageHours() >= component.getThreshold();
    }
}

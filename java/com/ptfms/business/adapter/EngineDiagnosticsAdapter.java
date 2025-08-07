package com.ptfms.business.adapter;

import com.external.engine.SensorData;      // hypothetical external sensor API
import com.ptfms.model.Component;
import com.ptfms.model.strategy.DefaultThresholdStrategy;

public class EngineDiagnosticsAdapter {
    public static Component adapt(SensorData data) {
        Component engine = new Component(
            999,
            "Engine Diagnostics",
            data.getRuntimeHours(),
            new DefaultThresholdStrategy()
        );
        engine.setThreshold(data.getWarningThreshold());
        return engine;
    }
}
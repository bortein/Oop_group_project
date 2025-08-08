package com.ptfms.builder;

import com.ptfms.model.Component;

public class ComponentBuilder {
    private final Component component;
    public ComponentBuilder(String name, double threshold) {
        component = new Component(name, (int) threshold);
    }
    public ComponentBuilder usage(double hrs) { component.setUsageHours(hrs); return this; }
    public Component build() { return component; }
}

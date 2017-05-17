package com.faendir.acra.util;

import com.vaadin.ui.Component;

/**
 * @author Lukas
 * @since 17.05.2017
 */
public enum Style {
    NO_PADDING("no-padding"),
    PADDING_LEFT("padding-left"),
    PADDING_TOP("padding-top"),
    PADDING_RIGHT("padding-right"),
    PADDING_BOTTOM("padding-bottom"),
    MARGIN_LEFT("margin-left"),
    MARGIN_TOP("margin-top"),
    MARGIN_RIGHT("margin-right"),
    MARGIN_BOTTOM("margin-bottom"),
    BACKGROUND_LIGHT_GRAY("background-light-gray");
    final String name;

    Style(String name) {
        this.name = name;
    }

    public void apply(Component component) {
        component.addStyleName(name);
    }

    public static void apply(Component component, Style... styles){
        for (Style style : styles){
            style.apply(component);
        }
    }
}

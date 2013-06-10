package com.github.veithen.ramsay.emf.cm.transform.impl;

import java.util.Arrays;

public class CompositeKey {
    private final Object[] components;

    public CompositeKey(Object[] components) {
        this.components = components;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CompositeKey) {
            return Arrays.equals(components, ((CompositeKey)obj).components);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Object component : components) {
            buffer.append(buffer.length() == 0 ? "(" : ",");
            buffer.append(Util.formatKey(component));
        }
        return buffer.toString();
    }
}

package org.example.limits.entity.enums;

import lombok.Getter;

public enum UtilizationState {
    HOLD(0),
    PROCESSED(1),
    CANCELED(-1);

    @Getter
    private final int state;

    UtilizationState(int state) {
        this.state = state;
    }
}

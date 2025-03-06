package org.example.limits.entity.enums;

public enum UtilizationState {
    HOLD(0),
    PROCESSED(1),
    CANCELED(-1);

    int state;

    UtilizationState(int state) {
        this.state = state;
    }
}

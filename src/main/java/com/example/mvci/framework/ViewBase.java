package com.example.mvci.framework;

import javafx.util.Builder;

import java.util.function.Consumer;

public abstract class ViewBase<T, M, MSG> implements Builder<T> {

    protected final M model;
    protected final Consumer<MSG> action;

    protected ViewBase(M model, Consumer<MSG> action) {
        this.model = model;
        this.action = action;
    }

    protected abstract void viewListener();
}

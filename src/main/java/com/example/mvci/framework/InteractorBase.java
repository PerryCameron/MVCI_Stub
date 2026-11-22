package com.example.mvci.framework;

public abstract class InteractorBase<M> {

    protected final M model;

    protected InteractorBase(M model) {
        this.model = model;
    }
}
package com.example.mvci.main;

import com.example.mvci.framework.ViewBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

import java.util.function.Consumer;

public class MainView extends ViewBase<Region, MainModel, MainMessage> {

    protected MainView(MainModel model, Consumer<MainMessage> action) {
        super(model, action);
    }

    @Override
    protected void viewListener() {

    }

    @Override
    public Region build() {
        BorderPane borderPane = new BorderPane();
        return borderPane;
    }
}

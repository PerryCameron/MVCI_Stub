package com.example;

import com.example.mvci.main.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        // this is for things you want to do before you launch the application.
        // This method is not called on the JavaFX Application Thread.
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.setScene(new Scene(new MainController().getView()));
        primaryStage.show();
    }

    @Override
    public void stop() {
        // This method is called when the application should stop, and provides a convenient place to prepare for application exit and destroy resources.
        // NOTE: This method is called on the JavaFX Application Thread.
    }
}
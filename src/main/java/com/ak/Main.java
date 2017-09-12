package com.ak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//główna klasa okna i uruchomieniaowa
public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        //związanie okna plikiem xmlowym fdzie jest zefiniowany jayout//
        Parent root = FXMLLoader.load( getClass().getClassLoader().getResource( "mainwindow.fxml" ) );
        primaryStage.setTitle( "Główne okno" );
        Scene scene = new Scene( root, 300, 270 );
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch( args );
    }
}

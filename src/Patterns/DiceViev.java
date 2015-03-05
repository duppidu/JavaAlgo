/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author thomas.duppenthaler
 */
public class DiceViev extends Application implements  InvalidationListener
{
    DiceRunnable d1 = new DiceRunnable();
    VBox root1 = new VBox();
    
    private TextField txtField;

    public DiceViev()
    {
        Thread t1 = new Thread(d1);
        t1.start();
    }

    @Override
    public void start(Stage stage)
    {
       d1.addListener(this);
       
        txtField = new TextField();
        
        
        root1.getChildren().add(txtField);
        Scene scene = new Scene(root1, 600, 600);
        stage.setTitle("Dice");
        stage.setScene(scene);
        stage.show();

    }
 @Override
    public void invalidated(Observable o)
    {
        int value = ((DiceRunnable)o).getValue();
        txtField.appendText(value+"|");
        
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        launch(args);
    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author thomas.duppenthaler
 */
public class DiceViev extends Application implements EventHandler<ActionEvent>
{
    DiceRunnable d1 = new DiceRunnable();
    VBox root1 = new VBox();
    private Button btn;
    private TextField txtField;

    public DiceViev()
    {
        Thread t1 = new Thread(d1);
        t1.start();
    }

    @Override
    public void start(Stage stage)
    {
        btn = new Button("Button");
        btn.setStyle("-fx-font: 22 arial; -fx-base: #2FDCF0;");
        txtField = new TextField();
        btn.setOnAction(this);
        root1.getChildren().add(btn);
        root1.getChildren().add(txtField);
        Scene scene = new Scene(root1, 600, 600);
        stage.setTitle("Dice");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void handle(ActionEvent event)
    {

       
        Button tmp = (Button) event.getSource();
        switch (tmp.getText())
        {
            case "Button":
                txtField.appendText(d1.valueToString());
                break;

        }

    }

    public static void main(String[] args) throws InterruptedException
    {
        launch(args);
    }
}

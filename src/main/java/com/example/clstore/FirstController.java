package com.example.clstore;

import com.clocks.ClocksStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class FirstController  {

    @FXML
    private Label time_clocks;
    @FXML
    private Button set_time;
    @FXML
    private Label expensive;
    @FXML
    private Label popular;
    @FXML
    private Button buy;
    @FXML
    private Button clear;
    @FXML
    private Label am_label;
    @FXML
    private VBox basket;
    @FXML
    private VBox productTape;
    static ClocksStore an;
    Integer am_counter;
    Stage stage;
    Parent root;
    Scene scene1;


    public FirstController() {
        am_counter=0;
    }
    public void SetTime(ActionEvent event) throws IOException{
        SecondController.NewScene();
    }
    public static void Time(int h, int m, int s) throws Exception {
        an.SetTheTime(h,m,s);

       /* String t;
        if(h<10)
            t="0"+Integer.toString(h);
        else
            t=Integer.toString(h);
        if(m<10)
            t+=":0"+Integer.toString(m);
        else
            t+=":"+Integer.toString(m);
        if(s<10)
            t+=":0"+Integer.toString(s);
        else
            t+=":"+Integer.toString(s);*/



    }

    public void setButtonBrand(ClocksStore a){
        an=a;
        expensive.setText("Most expensive model: "+an.MostExpensive()+"p");
        clear.setOnAction(actionEvent ->  {
            basket.getChildren().clear();
            am_label.setText("");
            am_counter=0;
        });
        buy.setOnAction(actionEvent -> {
            for (int i=0;i<basket.getChildren().size();i++){
                BorderPane c = (BorderPane) basket.getChildren().get(i);
                Label c1= (Label) c.getLeft();
                an.ChangeStat(c1.getText());
            }
            popular.setText("Most popular model: "+an.MaxStat());
            basket.getChildren().clear();
            am_counter=0;
            am_label.setText("Куплено");

        });



        for (String st: an.SortTree()){
            BorderPane h=new BorderPane();
            h.setStyle("-fx-background-color: #1F1F1F");
            genProduct(h, st);
            productTape.getChildren().addAll(h);
        }
    }

    private void genProduct(BorderPane h, String st){
        Integer end =an.getBrandValue(st);
        Label label=new Label(st+"  "+Integer.toString(end)+"р");
        label.setTextFill(Color.WHITE);
        label.setPadding(new Insets(3));
        h.setLeft(label);
        Button button=new Button("add");
        button.setOnAction(actionEvent ->  {
            genShopping(st, end);
            setAm_label(end);
        });

        h.setRight(button);

    }
    private void genShopping(String st, Integer a){
        BorderPane f=new BorderPane();
        f.setStyle("-fx-background-color: #828990");
        Label label=new Label(st);
        label.setTextFill(Color.WHITE);
        label.setPadding(new Insets(3));
        f.setLeft(label);
        Button button=new Button("put away");
        button.setOnAction(actionEvent ->  {
            delShopping(f,a);
        });
        f.setRight(button);
        basket.getChildren().addAll(f);

    }
    private void delShopping(BorderPane f, Integer a){
        basket.getChildren().remove(f);
        setAm_label(-a);
    }
    private void setAm_label(Integer a){
        am_counter+=a;
        am_label.setText(Integer.toString(am_counter)+"р");
    }



}

package com.example.clstore;

import com.clocks.Clocks;
import com.clocks.ClocksStore;
import com.clocks.SecClocks;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //a variable is created into which the XML-file is read
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //a scene is created (add in stage)
        Scene scene = new Scene(fxmlLoader.load(), 700, 460);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        //controller is read, enter data into it
        FirstController controller = fxmlLoader.getController();

        ClocksStore AllTimes=new ClocksStore();
        introListModels(AllTimes);

        controller.setButtonBrand(AllTimes);
        stage.show();

    }

    private void introListModels(ClocksStore a){
        Clocks a1=new Clocks("Seiko SNK", 15000);
        Clocks a2=new Clocks("Citizen CA", 35000);
        SecClocks a3=new SecClocks("Louis XVI", 30000);
        SecClocks a4=new SecClocks("Louis XVII", 40000);

        a.setCl(a1);
        a.setCl(a2);
        a.setCl(a3);
        a.setCl(a4);
        a.SummStat();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
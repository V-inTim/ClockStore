package com.example.clstore;

import com.clocks.ClocksStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {
    @FXML
    private Spinner<Integer> minutes;
    @FXML
    private Spinner<Integer> hours;
    @FXML
    private Spinner<Integer> seconds;
    @FXML
    private Button confirm;
    private Integer h, m, s;
    static Stage window;



    public void Confirm(ActionEvent event) throws Exception {

        h = hours.getValue();
        m = minutes.getValue();
        s = seconds.getValue();


        FirstController.Time(h,m,s);
        window.close();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59);
        SpinnerValueFactory<Integer> valueFactory1=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,11);
        SpinnerValueFactory<Integer> valueFactory2=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59);
        valueFactory.setValue(0);
        valueFactory1.setValue(0);
        valueFactory2.setValue(0);
        minutes.setValueFactory(valueFactory);
        seconds.setValueFactory(valueFactory2);
        hours.setValueFactory(valueFactory1);
    }
    public static void NewScene() throws IOException {

        FXMLLoader fxmlLoader=new FXMLLoader(SecondController.class.getResource("SetTime.fxml"));
        Parent root =fxmlLoader.load();

        window =new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(root, 300,300);
        window.setScene(scene);
        window.showAndWait();
    }
}

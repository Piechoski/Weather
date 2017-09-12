package com.ak;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowControler implements Initializable {

    private static final String surl = "http://api.apixu.com/v1/current.json?key=d578c483ed8b494bad8170534161511&q=Warsaw";
    private final static String coldImage = "http://images.clipartpanda.com/cold-clip-art-snow.png";
    private final static String sunImage = "http://az616578.vo.msecnd.net/files/2016/07/23/636049076842624124-2115961982_sun.jpg";
    private final static String coolImage = "http://a106.phobos.apple.com/us/r30/Purple/v4/f2/d6/8b/f2d68bd9-1fc9-5fdb-b00b-71ff423d22dc/mzl.ywvjufbd.png";

    @FXML
    private ImageView image;

    @FXML
    private Label temperatureC;

    @FXML
    private Label temperatureF;


    public void initialize(URL location, ResourceBundle resources) {
        temperatureC.setText("Pobieranie danych pogody");
        try {
            URL url = new URL(surl);
            JSONObject json = new JSONObject(IOUtils.toString(url));

            //chcemy pobrac zawartosc taga o nazwie current
            JSONObject json2 = (JSONObject) json.get("current");

            //pobieramy tempereture w postaci tekstowej w stopniach C

            String sstemp = json2.get("temp_c").toString();
            Double temp = Double.parseDouble(sstemp);

            String sstempF = json2.get("temp_f").toString();
            Double tempF = Double.parseDouble(sstempF);

            Image im = null;
            if(temp < 15){
                im = new Image(coldImage);
            }
            else if(temp>15 && temp<25){
                im = new Image(coolImage);
            }
            else{
                im = new Image(sunImage);
            }

            if(im!=null){
                image.setImage(im);
            }

            temperatureC.setText("Srednia temperatura w Celsjuszach: " + temp);
            temperatureF.setText("Srednia temperatura w F: " + tempF);


            System.out.println(json);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
package Visual;import Visual.Characters.LukeSkywalker;import Visual.Characters.MasterYoda;import com.jfoenix.controls.JFXButton;import javafx.animation.FadeTransition;import javafx.animation.TranslateTransition;import javafx.event.ActionEvent;import javafx.fxml.FXML;import javafx.fxml.FXMLLoader;import javafx.scene.Node;import javafx.scene.Parent;import javafx.scene.Scene;import javafx.scene.image.ImageView;import javafx.scene.input.MouseEvent;import javafx.scene.layout.Pane;import javafx.stage.Stage;import javafx.util.Duration;import java.io.IOException;public class MenuController {    public static boolean isYoda;    @FXML    private Pane LukeAttributePane;    @FXML    private Pane YodaAttributePane;    @FXML    private JFXButton PlayButton;    @FXML    private JFXButton LukeButton;    @FXML    private JFXButton YodaButton;    @FXML    private ImageView LukeImage;    @FXML    private ImageView YodaImage;    @FXML    void CloseLukeAttributes(MouseEvent event) {        LukeAttributePane.setVisible(false);    }    @FXML    void CloseYodaAttributes(MouseEvent event) {        YodaAttributePane.setVisible(false);    }    @FXML    void OpenLukeAttributes(MouseEvent event) {        LukeAttributePane.setVisible(true);    }    @FXML    void OpenYodaAttributes(MouseEvent event) {        YodaAttributePane.setVisible(true);    }    @FXML    void MenuAnim(ActionEvent event) {        YodaImage.setVisible(true);        YodaButton.setVisible(true);        LukeImage.setVisible(true);        LukeButton.setVisible(true);        FadeTransition fadeTransition = new FadeTransition();        fadeTransition.setDuration(Duration.seconds(1));        fadeTransition.setNode(LukeImage);        fadeTransition.setFromValue(0.01);        fadeTransition.setToValue(10);        fadeTransition.play();        FadeTransition fadeTransition1 = new FadeTransition();        fadeTransition1.setDuration(Duration.seconds(1));        fadeTransition1.setNode(YodaImage);        fadeTransition1.setFromValue(0.01);        fadeTransition1.setToValue(10);        fadeTransition1.play();        FadeTransition fadeTransition2 = new FadeTransition();        fadeTransition2.setDuration(Duration.seconds(1));        fadeTransition2.setNode(YodaButton);        fadeTransition2.setFromValue(0.01);        fadeTransition2.setToValue(10);        fadeTransition2.play();        FadeTransition fadeTransition3 = new FadeTransition();        fadeTransition3.setDuration(Duration.seconds(1));        fadeTransition3.setNode(LukeButton);        fadeTransition3.setFromValue(0.01);        fadeTransition3.setToValue(10);        fadeTransition3.play();        TranslateTransition translateTransition = new TranslateTransition();        translateTransition.setNode(PlayButton);        translateTransition.setToY(100);        translateTransition.play();    }    @FXML    void LukeAnimIn(MouseEvent event) {        LukeImage.setStyle("-fx-scale-x: 1.1");        LukeImage.setStyle("-fx-scale-y: 1.1");    }    @FXML    void LukeAnimOut(MouseEvent event) {        LukeImage.setStyle("-fx-scale-x: 1");        LukeImage.setStyle("-fx-scale-y: 1");    }    @FXML    void SelectLuke(ActionEvent event) throws IOException {        openMenu(event);        isYoda = false;    }    @FXML    void SelectYoda(ActionEvent event) throws IOException{        openMenu(event);        isYoda = true;    }    @FXML    void YodaAnimIn(MouseEvent event) {        YodaImage.setStyle("-fx-scale-x: 1.1");        YodaImage.setStyle("-fx-scale-y: 1.1");    }    @FXML    void YodaAnimOut(MouseEvent event) {        YodaImage.setStyle("-fx-scale-x: 1");        YodaImage.setStyle("-fx-scale-y: 1");    }    @FXML    void openMenu(ActionEvent event) throws IOException {        Parent root = FXMLLoader.load(getClass().getResource("LoadingScene.fxml"));        Scene scene = new Scene(root,441,470);        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();        window.setScene(scene);    }}
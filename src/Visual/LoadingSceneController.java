package Visual;

import Visual.Characters.DarthVader;
import Visual.Characters.KyloRen;
import Visual.Characters.Stormtrooper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class LoadingSceneController implements Initializable {

    @FXML
    private Circle CircleOne;

    @FXML
    private Circle CircleTwo;

    @FXML
    private Circle CircleThree;

    @FXML
    private Label LoadingText;

    @FXML
    private JFXButton StartButton;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXToggleButton KyloRenButton;

    @FXML
    private JFXToggleButton DarthVaderButton;

    @FXML
    private JFXToggleButton StormtrooperButton;

    @FXML
    private JFXComboBox<String> KyloRenComboBox;

    @FXML
    private JFXComboBox<String> DarthVaderComboBox;

    @FXML
    private JFXComboBox<String> StormtrooperComboBox;

    @FXML
    private ImageView KyloImage;

    @FXML
    private ImageView DarthVaderImage;

    @FXML
    private ImageView StormtrooperImage;

    @FXML
    private JFXButton ContinueButton;

    @FXML
    private Label Title;

    @FXML
    private Pane KyloPane;

    @FXML
    private Pane DarthPane;

    @FXML
    private Pane StormtrooperPane;

    @FXML
    private Pane ControllerPane;

    @FXML
    private JFXButton ReadFileButton;

    @FXML
    private JFXComboBox<Integer> EnemyCountBox;

    @FXML
    private Label EnemyCountLabel;

    ObservableList<String> list = FXCollections.observableArrayList("A","B","C","D","E");
    ObservableList<Integer> count = FXCollections.observableArrayList(1,2,3,4,5);

    public static boolean hasStormtrooper;
    public static boolean hasDarthVader;
    public static boolean hasKyloRen;

    public static Parent root;
    public static Scene scene;
    public static File file;
    public static Vector<String> Enemies = new Vector<>();
    public static Vector<String> Temporaries = new Vector<>();
    public static Vector<String> TemporaryGates = new Vector<>();
    public static Vector<String> Gates = new Vector<>();

    public void SetFade(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(LoadingText);
        fadeTransition.setFromValue(0.1);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.seconds(1));
        fadeTransition.setCycleCount(10);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
        fadeTransition.setOnFinished((e)->{
            StartButton.setVisible(true);
            ControllerPane.setVisible(true);
            LoadingText.setVisible(false);
            CircleOne.setVisible(false);
            CircleTwo.setVisible(false);
            CircleThree.setVisible(false);
            FadeTransition fadeTransition1 = new FadeTransition();
            fadeTransition1.setNode(StartButton);
            fadeTransition1.setFromValue(0.1);
            fadeTransition1.setToValue(1);
            fadeTransition1.play();
        });
    }

    public void SetRotate(Circle c ,boolean reverse ,int angle ,int duration){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration),c);
        rotateTransition.setByAngle(angle);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(5);
        rotateTransition.setCycleCount(16);
        rotateTransition.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        KyloRenComboBox.setItems(list);
        DarthVaderComboBox.setItems(list);
        StormtrooperComboBox.setItems(list);
        EnemyCountBox.setItems(count);

    }

    @FXML
    public void AddStormtrooper(){
        Controller.Enemies.add(new Stormtrooper());
        hasStormtrooper = true;
        StormtrooperComboBox.setDisable(false);
        if(!StormtrooperButton.isSelected())
            StormtrooperComboBox.setDisable(true);
    }

    @FXML
    public void AddDarthVader(){
        Controller.Enemies.add(new DarthVader());
        hasDarthVader = true;
        DarthVaderComboBox.setDisable(false);
        if(!DarthVaderButton.isSelected())
            DarthVaderComboBox.setDisable(true);
    }

    @FXML
    public void AddKyloRen(){
        Controller.Enemies.add(new KyloRen());
        hasKyloRen = true;
        KyloRenComboBox.setDisable(false);
        if(!KyloRenButton.isSelected())
            KyloRenComboBox.setDisable(true);
    }

    @FXML
    public void StartAnimation(){

        Title.setVisible(false);
        ContinueButton.setVisible(false);
        KyloImage.setVisible(false);
        DarthVaderImage.setVisible(false);
        StormtrooperImage.setVisible(false);
        KyloRenButton.setVisible(false);
        DarthVaderButton.setVisible(false);
        StormtrooperButton.setVisible(false);
        StormtrooperComboBox.setVisible(false);
        DarthVaderComboBox.setVisible(false);
        KyloRenComboBox.setVisible(false);

        if(!KyloRenComboBox.isDisable()){
            Controller.Gates.add(KyloRenComboBox.getValue());
            Controller.kyloRen.setSpawnPoint(KyloRenComboBox.getValue());
        }

        if(!DarthVaderComboBox.isDisable()){
            Controller.Gates.add(DarthVaderComboBox.getValue());
            Controller.darthVader.setSpawnPoint(DarthVaderComboBox.getValue());
        }

        if (!StormtrooperComboBox.isDisable()) {
            Controller.Gates.add(StormtrooperComboBox.getValue());
            Controller.stormtrooper.setSpawnPoint(StormtrooperComboBox.getValue());
        }
        LoadingText.setVisible(true);
        CircleOne.setVisible(true);
        CircleTwo.setVisible(true);
        CircleThree.setVisible(true);
        SetRotate(CircleOne,true,360,10);
        SetRotate(CircleTwo,true,180,15);
        SetRotate(CircleThree,true,180,20);
        SetFade();
    }

    @FXML
    public void OpenScene(ActionEvent event) throws  IOException{
        root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        scene = new Scene(root,561,493);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @FXML
    void Quit() {
        Stage stage = (Stage)QuitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void CloseDarthAttribute(MouseEvent event) {
            DarthPane.setVisible(false);
    }

    @FXML
    void CloseKyloAttribute(MouseEvent event) {
            KyloPane.setVisible(false);
    }

    @FXML
    void CloseStormtrooperAttribute(MouseEvent event) {
            StormtrooperPane.setVisible(false);
    }

    @FXML
    void OpenDarthAttribute(MouseEvent event) {
        DarthPane.setVisible(true);
    }

    @FXML
    void OpenKyloAttribute(MouseEvent event) {
        KyloPane.setVisible(true);
    }

    @FXML
    void OpenStormtrooperAttribute(MouseEvent event) {
        StormtrooperPane.setVisible(true);
    }

    @FXML
    void ReadFile() throws  IOException {
        file = new File("Harita.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int enemyCount;
        enemyCount = EnemyCountBox.getValue();
        String lineOne,lineTwo;

        for (int i = 0; i < enemyCount; i++) {
            lineOne = bufferedReader.readLine().replace("Karakter:","");
            Temporaries.add(lineOne);
        }

        for (int i = 0; i < enemyCount; i++) {
          lineTwo =  Temporaries.get(i).replace(",Kapi:"," ");
          TemporaryGates.add(lineTwo);
        }

        System.out.println(TemporaryGates);
        //System.out.println(Enemies);
        //System.out.println(Gates);
    }
}



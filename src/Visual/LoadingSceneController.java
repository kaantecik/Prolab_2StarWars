package Visual;

import Visual.Characters.DarthVader;
import Visual.Characters.KyloRen;
import Visual.Characters.Stormtrooper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.GridPane;
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

    @FXML private Circle CircleOne;

    @FXML private Circle CircleTwo;

    @FXML private Circle CircleThree;

    @FXML private Label LoadingText;

    @FXML private JFXButton StartButton;

    @FXML private JFXButton QuitButton;

    @FXML private ImageView KyloImage;

    @FXML private ImageView DarthVaderImage;

    @FXML private ImageView StormtrooperImage;

    @FXML private JFXButton ContinueButton;

    @FXML private Label Title;

    @FXML private Pane KyloPane;

    @FXML private Pane DarthPane;

    @FXML private Pane StormtrooperPane;

    @FXML private Pane ControllerPane;

    @FXML private JFXButton ReadFileButton;

    @FXML private JFXComboBox<String> EnemyCountBox;

    @FXML private Label EnemyCountLabel;

    @FXML private ImageView tickImage;

    @FXML private ImageView KyloRenA;

    @FXML private ImageView DarthVaderA;

    @FXML private ImageView StormtrooperA;

    @FXML private ImageView KyloRenB;

    @FXML private ImageView DarthVaderB;

    @FXML private ImageView StormtrooperB;

    @FXML private ImageView KyloRenC;

    @FXML private ImageView DarthVaderC;

    @FXML private ImageView StormtrooperC;

    @FXML private ImageView KyloRenD;

    @FXML private ImageView DarthVaderD;

    @FXML private ImageView StormtrooperD;

    @FXML private ImageView KyloRenE;

    @FXML private ImageView DarthVaderE;

    @FXML private ImageView StormtrooperE;

    @FXML private Label EnemyNameA;

    @FXML private Label EnemyNameB;

    @FXML private Label EnemyNameC;

    @FXML private Label EnemyNameD;

    @FXML private Label EnemyNameE;

    @FXML private Label LabelA;

    @FXML private Label LabelB;

    @FXML private Label LabelC;

    @FXML private Label LabelD;

    @FXML private Label LabelE;

    @FXML private GridPane EnemyPane;


    ObservableList<Integer> count = FXCollections.observableArrayList(1,2,3,4,5);
    ObservableList<String> difficulty = FXCollections.observableArrayList("Beginner","Medium","Hard","Expert","Insane");


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
        EnemyCountBox.setItems(difficulty);

    }

    @FXML
    public void AddStormtrooper(){
        Controller.Enemies.add(new Stormtrooper());
        hasStormtrooper = true;
    }

    @FXML
    public void AddDarthVader(){
        Controller.Enemies.add(new DarthVader());
        hasDarthVader = true;
    }

    @FXML
    public void AddKyloRen(){
        Controller.Enemies.add(new KyloRen());
        hasKyloRen = true;
    }

    @FXML
    public void StartAnimation(){

        Title.setVisible(false);
        ContinueButton.setVisible(false);
        KyloImage.setVisible(false);
        DarthVaderImage.setVisible(false);
        StormtrooperImage.setVisible(false);
        EnemyCountLabel.setVisible(false);
        EnemyCountBox.setVisible(false);
        ReadFileButton.setVisible(false);
        tickImage.setVisible(false);
        EnemyPane.setVisible(false);

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
    void CloseDarthAttribute() {
            DarthPane.setVisible(false);
    }

    @FXML
    void CloseKyloAttribute() {
            KyloPane.setVisible(false);
    }

    @FXML
    void CloseStormtrooperAttribute() {
            StormtrooperPane.setVisible(false);
    }

    @FXML
    void OpenDarthAttribute() {
        DarthPane.setVisible(true);
    }

    @FXML
    void OpenKyloAttribute() {
        KyloPane.setVisible(true);
    }

    @FXML
    void OpenStormtrooperAttribute() {
        StormtrooperPane.setVisible(true);
    }

    void FadeAnimation(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(ReadFileButton);
        fadeTransition.setDuration(Duration.millis(60));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setOnFinished( (e) ->{
                    ReadFileButton.setVisible(false); tickImage.setVisible(true);
                    Title.setVisible(true); LabelA.setVisible(true);
                    LabelB.setVisible(true); LabelC.setVisible(true);
                    LabelD.setVisible(true); LabelE.setVisible(true);
                    EnemyNameA.setVisible(true);EnemyNameB.setVisible(true);
                    EnemyNameC.setVisible(true);EnemyNameD.setVisible(true);
                    EnemyNameE.setVisible(true);
                    EnemyPane.setVisible(true);
                }
        );

    }

    void AnimationTwo(){
        TranslateTransition translateTransition = new TranslateTransition(); TranslateTransition translateTransition1 = new TranslateTransition();TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition.setNode(tickImage); translateTransition1.setNode(EnemyCountBox); translateTransition2.setNode(EnemyCountLabel);
        translateTransition.setToY(-80); translateTransition1.setToY(-80); translateTransition2.setToY(-80);
        translateTransition.play(); translateTransition1.play(); translateTransition2.play();
    }
    @FXML
    void ReadFile() throws  IOException {
        FadeAnimation();
        AnimationTwo();
        //Reading file section
        file = new File("Harita.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int enemyCount = 1;
        switch (EnemyCountBox.getValue()){
            case "Easy":
                enemyCount = 1;
                break;
            case "Medium":
                enemyCount = 2;
                break;
            case "Hard":
                enemyCount = 3;
                break;
            case "Expert" :
                enemyCount = 4;
                break;
            case "Insane" :
                enemyCount = 5;
                break;
        }
        String lineOne,lineTwo;

        for (int i = 0; i < enemyCount; i++) {
            lineOne = bufferedReader.readLine().replace("Karakter:","");
            Temporaries.add(lineOne);
        }
        for (int i = 0; i < enemyCount; i++) {
          lineTwo =  Temporaries.get(i).replace(",Kapi:",",");
          TemporaryGates.add(lineTwo);
          StringTokenizer stringTokenizer = new StringTokenizer(TemporaryGates.get(i),",");
          Enemies.add(stringTokenizer.nextToken());
          Gates.add(stringTokenizer.nextToken());
        }
        for (int i = 0; i < Enemies.size(); i++) {
            if(Enemies.get(i).equals("DarthVader")){
                AddDarthVader();
                Controller.darthVader.setSpawnPoint(Gates.get(i));
                switch (Controller.darthVader.getSpawnPoint()){
                    case "A" :
                        DarthVaderA.setVisible(true);
                        EnemyNameA.setText("darth vader");
                        break;
                    case "B":
                        DarthVaderB.setVisible(true);
                        EnemyNameB.setText("darth vader");
                        break;
                    case  "C":
                        DarthVaderC.setVisible(true);
                        EnemyNameC.setText("darth vader");
                        break;
                    case "D":
                        DarthVaderD.setVisible(true);
                        EnemyNameD.setText("darth vader");
                        break;
                    case "E":
                        DarthVaderE.setVisible(true);
                        EnemyNameE.setText("darth vader");
                        break;
                }

            }
            if (Enemies.get(i).equals("KyloRen")){
                AddKyloRen();
                Controller.kyloRen.setSpawnPoint(Gates.get(i));
                switch (Controller.kyloRen.getSpawnPoint()){
                    case "A" :
                        KyloRenA.setVisible(true);
                        EnemyNameA.setText("kylo ren");
                        break;
                    case "B":
                        KyloRenB.setVisible(true);
                        EnemyNameB.setText("kylo ren");
                        break;
                    case  "C":
                        KyloRenC.setVisible(true);
                        EnemyNameC.setText("kylo ren");
                        break;
                    case "D":
                        KyloRenD.setVisible(true);
                        EnemyNameD.setText("kylo ren");
                        break;
                    case "E":
                        KyloRenE.setVisible(true);
                        EnemyNameE.setText("kylo ren");
                        break;
                }
            }
            if (Enemies.get(i).equals("Stormtrooper")){
                AddStormtrooper();
                Controller.stormtrooper.setSpawnPoint(Gates.get(i));
                switch (Controller.stormtrooper.getSpawnPoint()){
                    case "A" :
                        StormtrooperA.setVisible(true);
                        EnemyNameA.setText("stormtrooper");
                        break;
                    case "B":
                        StormtrooperB.setVisible(true);
                        EnemyNameB.setText("stormtrooper");
                        break;
                    case  "C":
                        StormtrooperC.setVisible(true);
                        EnemyNameC.setText("stormtrooper");
                        break;
                    case "D":
                        StormtrooperD.setVisible(true);
                        EnemyNameD.setText("stormtrooper");
                        break;
                    case "E":
                        StormtrooperE.setVisible(true);
                        EnemyNameE.setText("stormtrooper");
                        break;
                }
            }

        }

        bufferedReader.close();
    }

}



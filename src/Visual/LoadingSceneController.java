package Visual;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import java.util.StringTokenizer;
import java.util.Vector;

public class LoadingSceneController implements Initializable {

    public enum Difficulty{
        Easy,
        Medium,
        Hard,
        Expert,
        Insane
    }

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

    @FXML private Pane ControllerPane;

    @FXML private JFXButton ReadFileButton;

    @FXML private JFXComboBox<Difficulty> EnemyCountBox;

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

    ObservableList<Difficulty> difficulty = FXCollections.observableArrayList
            (Difficulty.Easy,Difficulty.Medium,Difficulty.Hard,Difficulty.Expert,Difficulty.Insane);

    public static boolean hasStormtrooperA;
    public static boolean hasStormtrooperB;
    public static boolean hasStormtrooperC;
    public static boolean hasStormtrooperD;
    public static boolean hasStormtrooperE;
    public static boolean hasDarthVaderA;
    public static boolean hasDarthVaderB;
    public static boolean hasDarthVaderC;
    public static boolean hasDarthVaderD;
    public static boolean hasDarthVaderE;
    public static boolean hasKyloRenA;
    public static boolean hasKyloRenB;
    public static boolean hasKyloRenC;
    public static boolean hasKyloRenD;
    public static boolean hasKyloRenE;

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
        ContinueButton.setDisable(false);
        //Reading file section
        file = new File("Harita.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int enemyCount = 1;
        switch (EnemyCountBox.getValue()){
            case Easy:
                enemyCount = 1;
                break;
            case Medium:
                enemyCount = 2;
                break;
            case Hard:
                enemyCount = 3;
                break;
            case Expert:
                enemyCount = 4;
                break;
            case Insane :
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
                switch (Gates.get(i)){
                    case "A" :
                        DarthVaderA.setVisible(true);
                        hasDarthVaderA = true;
                        EnemyNameA.setText("darth vader");
                        break;
                    case "B":
                        DarthVaderB.setVisible(true);
                        hasDarthVaderB = true;
                        EnemyNameB.setText("darth vader");
                        break;
                    case  "C":
                        DarthVaderC.setVisible(true);
                        hasDarthVaderC= true;
                        EnemyNameC.setText("darth vader");
                        break;
                    case "D":
                        DarthVaderD.setVisible(true);
                        hasDarthVaderD = true;
                        EnemyNameD.setText("darth vader");
                        break;
                    case "E":
                        DarthVaderE.setVisible(true);
                        hasDarthVaderE = true;
                        EnemyNameE.setText("darth vader");
                        break;
                }

            }
            if (Enemies.get(i).equals("KyloRen")){
                switch (Gates.get(i)){
                    case "A" :
                        KyloRenA.setVisible(true);
                        hasKyloRenA = true;
                        EnemyNameA.setText("kylo ren");
                        break;
                    case "B":
                        KyloRenB.setVisible(true);
                        hasKyloRenB = true;
                        EnemyNameB.setText("kylo ren");
                        break;
                    case  "C":
                        KyloRenC.setVisible(true);
                        hasKyloRenC = true;
                        EnemyNameC.setText("kylo ren");
                        break;
                    case "D":
                        KyloRenD.setVisible(true);
                        hasKyloRenD = true;
                        EnemyNameD.setText("kylo ren");
                        break;
                    case "E":
                        KyloRenE.setVisible(true);
                        hasKyloRenE = true;
                        EnemyNameE.setText("kylo ren");
                        break;
                }
            }
            if (Enemies.get(i).equals("Stormtrooper")){
                switch (Gates.get(i)){
                    case "A" :
                        StormtrooperA.setVisible(true);
                        hasStormtrooperA = true;
                        EnemyNameA.setText("stormtrooper");
                        break;
                    case "B":
                        StormtrooperB.setVisible(true);
                        hasStormtrooperB = true;
                        EnemyNameB.setText("stormtrooper");
                        break;
                    case  "C":
                        StormtrooperC.setVisible(true);
                        hasStormtrooperC = true;
                        EnemyNameC.setText("stormtrooper");
                        break;
                    case "D":
                        StormtrooperD.setVisible(true);
                        hasStormtrooperD= true;
                        EnemyNameD.setText("stormtrooper");
                        break;
                    case "E":
                        StormtrooperE.setVisible(true);
                        hasStormtrooperE = true;
                        EnemyNameE.setText("stormtrooper");
                        break;
                }
            }

        }

        bufferedReader.close();
    }

}



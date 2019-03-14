package Visual;

/**
 * LIBRARIES
 */

import Visual.Characters.*;
import Visual.Characters.Character;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.*;
/***********************************************************************************************************/

/**
 * TO DO LIST
 * -Dosyadan okuma FAILED
 * -UI düzenlemeleri/Karakterlerin görselleri DONE
 * -Duvar kontrolü DONE
 * -Düşman kontrolü DONE
 * -classların implement edilmesi DONE
 * -en kısa yol algoritması
 */

public class Controller  implements Initializable {


    /**
     * VARIABLES
     */

    @FXML
    public Pane CharacterYoda;

    @FXML
    public Pane CharacterLuke;

    @FXML
    private Pane KyloRen;

    @FXML
    private Pane Stormtrooper;

    @FXML
    private Pane DarthVader;

    @FXML
    private Pane Healthbar;

    @FXML
    private JFXButton RestartButton;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private Pane MenuPane;

    @FXML
    private Pane CreditsPane;

    @FXML
    public GridPane GameMap;

    @FXML
    private Pane GameOverPane;

    public static ArrayList<Character> Enemies = new ArrayList<Character>();
    public static ArrayList<String> Gates = new ArrayList<String>();
    public static LukeSkywalker lukeSkywalker = new LukeSkywalker();
    public static MasterYoda masterYoda = new MasterYoda();
    public static KyloRen kyloRen = new KyloRen();
    public static DarthVader darthVader = new DarthVader();
    public static Stormtrooper stormtrooper = new Stormtrooper();
    public static int HealthCount = 0;

    /***********************************************************************************************************/


    /**
     *
     * MOVEMENT
     */

    @FXML
    void CharacterController(KeyEvent key) {
            if(key.getCode()== KeyCode.DOWN || key.getCode() == KeyCode.S) {
                MoveCharacterDown();
            }else if(key.getCode()== KeyCode.UP || key.getCode() == KeyCode.W) {
                MoveCharacterUp();
            }else if(key.getCode()== KeyCode.LEFT || key.getCode() == KeyCode.A) {
                MoveCharacterLeft();
            }else if(key.getCode()== KeyCode.RIGHT || key.getCode() == KeyCode.D) {
                MoveCharacterRight();
            }
    }

    @FXML
    void MoveCharacterUp() {

        if(MenuController.isYoda){
            if(!GameMap.getChildren().get(((GridPane.getRowIndex(CharacterYoda)-1) * 14 + GridPane.getColumnIndex(CharacterYoda))).
                    getStyle().equals("-fx-fill: #738598;") && GridPane.getRowIndex(CharacterYoda) != 0){
                GridPane.setRowIndex(CharacterYoda,GridPane.getRowIndex(CharacterYoda)-1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));
            }
        }else{
            if(!GameMap.getChildren().get(((GridPane.getRowIndex(CharacterLuke)-1) * 14 + GridPane.getColumnIndex(CharacterLuke))).
                    getStyle().equals("-fx-fill: #738598;") &&  GridPane.getRowIndex(CharacterLuke) != 0){
                GridPane.setRowIndex(CharacterLuke,GridPane.getRowIndex(CharacterLuke)-1);
                lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));
                CharacterLuke.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                    if(key.getCode()==KeyCode.UP) {
                        System.out.println("You pressed enter");
                    }
                });
            }
        }


    }

    @FXML
    void MoveCharacterDown() {
        if(MenuController.isYoda){
            if(!GameMap.getChildren().get((GridPane.getRowIndex(CharacterYoda)+1) * 14 + GridPane.getColumnIndex(CharacterYoda)).
                    getStyle().equals("-fx-fill: #738598;")&& GridPane.getRowIndex(CharacterYoda) != 11){
                GridPane.setRowIndex(CharacterYoda,GridPane.getRowIndex(CharacterYoda)+1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));

            }
        }else {
            if(!GameMap.getChildren().get((GridPane.getRowIndex(CharacterLuke)+1) * 14 + GridPane.getColumnIndex(CharacterLuke)).
                    getStyle().equals("-fx-fill: #738598;") && GridPane.getRowIndex(CharacterLuke) != 11){
                GridPane.setRowIndex(CharacterLuke,GridPane.getRowIndex(CharacterLuke)+1);
                lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));
            }
        }

    }

    @FXML
    void MoveCharacterLeft() {

        if(!MenuController.isYoda){
            if(!GameMap.getChildren().get(GridPane.getRowIndex(CharacterLuke) *14 + GridPane.getColumnIndex(CharacterLuke)-1).
                    getStyle().equals("-fx-fill: #738598;")){
                GridPane.setColumnIndex(CharacterLuke,GridPane.getColumnIndex(CharacterLuke)-1);
                lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));

            }
        }else{

            if(!GameMap.getChildren().get(GridPane.getRowIndex(CharacterYoda) *14 + GridPane.getColumnIndex(CharacterYoda)-1).
                    getStyle().equals("-fx-fill: #738598;")){
                GridPane.setColumnIndex(CharacterYoda,GridPane.getColumnIndex(CharacterYoda)-1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));
            }
        }

    }

    @FXML
    void MoveCharacterRight() {
        if(!MenuController.isYoda){
            if(!GameMap.getChildren().get(GridPane.getRowIndex(CharacterLuke)*14 + GridPane.getColumnIndex(CharacterLuke) +1).
                    getStyle().equals("-fx-fill: #738598;")){
                GridPane.setColumnIndex(CharacterLuke,GridPane.getColumnIndex(CharacterLuke)+1);
                lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));
            }
        }else{

            if(!GameMap.getChildren().get(GridPane.getRowIndex(CharacterYoda)*14 + GridPane.getColumnIndex(CharacterYoda) +1).
                    getStyle().equals("-fx-fill: #738598;")){
                GridPane.setColumnIndex(CharacterYoda,GridPane.getColumnIndex(CharacterYoda)+1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));
            }
        }


    }

    /***********************************************************************************************************/

    /**
     * FINISHED
     * Damage fonksiyonu henüz kullanılmadı çünkü enemy classı oluşturulmadı
     */

    public void Damage(){

        if(MenuController.isYoda){
            Healthbar.getChildren().get(HealthCount+1).setVisible(true);
            HealthCount++;
            Healthbar.getChildren().get(HealthCount-1).setVisible(false);
            masterYoda.setHealth(masterYoda.getHealth()-0.5);
        }
        else{
            Healthbar.getChildren().get(HealthCount+2).setVisible(true);
            HealthCount+=2;
            Healthbar.getChildren().get(HealthCount-2).setVisible(false);
            lukeSkywalker.setHealth(lukeSkywalker.getHealth()-1);
        }

        if(HealthCount == 6){
            GameOverPane.setVisible(true);
            Healthbar.getChildren().get(0).setVisible(true);
            Healthbar.getChildren().get(5).setVisible(false);
            HealthCount = 0;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        if(!MenuController.isYoda){
            CharacterLuke.setVisible(true);
            CharacterYoda.setVisible(false);
        }
        else{
            CharacterYoda.setVisible(true);
            CharacterLuke.setVisible(false);
        }


        if(LoadingSceneController.hasStormtrooper){
            Stormtrooper.setVisible(true);
            if (stormtrooper.getSpawnPoint().equals("A")){
                GridPane.setRowIndex(Stormtrooper,5);
                GridPane.setColumnIndex(Stormtrooper,0);
            }if (stormtrooper.getSpawnPoint().equals("B")){
                GridPane.setRowIndex(Stormtrooper,0);
                GridPane.setColumnIndex(Stormtrooper,4);
            }if (stormtrooper.getSpawnPoint().equals("C")){
                GridPane.setRowIndex(Stormtrooper,0);
                GridPane.setColumnIndex(Stormtrooper,12);
            }if (stormtrooper.getSpawnPoint().equals("D")){
                GridPane.setRowIndex(Stormtrooper,5);
                GridPane.setColumnIndex(Stormtrooper,13);
            }if (stormtrooper.getSpawnPoint().equals("E")){
                GridPane.setRowIndex(Stormtrooper,10);
                GridPane.setColumnIndex(Stormtrooper,4);
            }
        }
        if(LoadingSceneController.hasKyloRen){
            KyloRen.setVisible(true);
            if (kyloRen.getSpawnPoint().equals("A")){
                GridPane.setRowIndex(KyloRen,5);
                GridPane.setColumnIndex(KyloRen,0);
            }if (kyloRen.getSpawnPoint().equals("B")){
                GridPane.setRowIndex(KyloRen,0);
                GridPane.setColumnIndex(KyloRen,4);
            }if (kyloRen.getSpawnPoint().equals("C")){
                GridPane.setRowIndex(KyloRen,0);
                GridPane.setColumnIndex(KyloRen,12);
            }if (kyloRen.getSpawnPoint().equals("D")){
                GridPane.setRowIndex(KyloRen,5);
                GridPane.setColumnIndex(KyloRen,13);
            }if (kyloRen.getSpawnPoint().equals("E")){
                GridPane.setRowIndex(KyloRen,10);
                GridPane.setColumnIndex(KyloRen,4);
            }
        }
        if(LoadingSceneController.hasDarthVader){
            DarthVader.setVisible(true);
            if (darthVader.getSpawnPoint().equals("A")){
                GridPane.setRowIndex(DarthVader,5);
                GridPane.setColumnIndex(DarthVader,0);
            }if (darthVader.getSpawnPoint().equals("B")){
                GridPane.setRowIndex(DarthVader,0);
                GridPane.setColumnIndex(DarthVader,4);
            }if (darthVader.getSpawnPoint().equals("C")){
                GridPane.setRowIndex(DarthVader,0);
                GridPane.setColumnIndex(DarthVader,12);
            }if (darthVader.getSpawnPoint().equals("D")){
                GridPane.setRowIndex(DarthVader,5);
                GridPane.setColumnIndex(DarthVader,13);
            }if (darthVader.getSpawnPoint().equals("E")){
                GridPane.setRowIndex(DarthVader,10);
                GridPane.setColumnIndex(DarthVader,4);
            }
        }


    }

    @FXML
    void Credits() {
        CreditsPane.setVisible(true);
    }

    @FXML
    void CloseCredits() {
        CreditsPane.setVisible(false);
    }

    @FXML
    void Quit() {
        Stage stage = (Stage)QuitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Restart() {
        GameOverPane.setVisible(false);
        Stage stage = (Stage)RestartButton.getScene().getWindow();
        stage.close();
        if(MenuController.isYoda){
            GridPane.setColumnIndex(CharacterYoda,6);
            GridPane.setRowIndex(CharacterYoda,6);
        }
        else
        {
            GridPane.setColumnIndex(CharacterLuke,6);
            GridPane.setRowIndex(CharacterLuke,6);
        }

        stage.show();
    }

    @FXML
    void CloseMenu() {
        MenuPane.setVisible(false);

    }

    @FXML
    void OpenMenu() {

        MenuPane.setVisible(true);
    }

    @FXML
    void LoadMenu(ActionEvent event) throws IOException {
        KyloRen.setVisible(false);
        DarthVader.setVisible(false);
        Stormtrooper.setVisible(false);
        LoadingSceneController.hasDarthVader = false;
        LoadingSceneController.hasKyloRen = false;
        LoadingSceneController.hasStormtrooper = false;
        Parent root = FXMLLoader.load(getClass().getResource("MenuScreen.fxml"));
        Scene scene = new Scene(root,320,500);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    /***********************************************************************************************************/

}


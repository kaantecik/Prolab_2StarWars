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
import javafx.scene.paint.Color;
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


public class Controller  implements Initializable {


    /**
     * VARIABLES
     */

    @FXML
    public  Pane CharacterYoda;
    @FXML
    public  Pane CharacterLuke;
    @FXML
    private Pane DarthVaderC;
    @FXML
    private Pane DarthVaderA;
    @FXML
    private Pane DarthVaderB;
    @FXML
    private Pane DarthVaderD;
    @FXML
    private Pane DarthVaderE;
    @FXML
    private Pane KyloRenA;
    @FXML
    private Pane KyloRenB;
    @FXML
    private Pane KyloRenC;
    @FXML
    private Pane KyloRenD;
    @FXML
    private Pane KyloRenE;
    @FXML
    private Pane StormtrooperB;
    @FXML
    private Pane StormtrooperA;
    @FXML
    private Pane StormtrooperC;
    @FXML
    private Pane StormtrooperD;
    @FXML
    private Pane StormtrooperE;
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
    public  GridPane GameMap;
    @FXML
    private Pane GameOverPane;
    @FXML
    private Pane WinPane;


    public static LukeSkywalker lukeSkywalker = new LukeSkywalker();
    public static MasterYoda masterYoda = new MasterYoda();
    public static ArrayList<Integer> pathX = new ArrayList<>();
    public static ArrayList<Integer> pathY = new ArrayList<>();

    public static int HealthCount = 0;

    public static Stormtrooper stormtrooperA = new Stormtrooper();
    public static Stormtrooper stormtrooperB = new Stormtrooper();
    public static Stormtrooper stormtrooperC = new Stormtrooper();
    public static Stormtrooper stormtrooperD = new Stormtrooper();
    public static Stormtrooper stormtrooperE = new Stormtrooper();


    public static KyloRen kyloRenA = new KyloRen();
    public static KyloRen kyloRenB = new KyloRen();
    public static KyloRen kyloRenC = new KyloRen();
    public static KyloRen kyloRenD = new KyloRen();
    public static KyloRen kyloRenE = new KyloRen();

    public static DarthVader darthVaderA = new DarthVader();
    public static DarthVader darthVaderB = new DarthVader();
    public static DarthVader darthVaderC = new DarthVader();
    public static DarthVader darthVaderD = new DarthVader();
    public static DarthVader darthVaderE = new DarthVader();
    /***********************************************************************************************************/


    /**
     * MOVEMENT
     * <p>
     * for (int p = 0; p < path.size(); p += 2) {
     * int pathX = path.get(p);
     * int pathY = path.get(p + 1);
     * route.add(new Rectangle(39,39));
     * route.get(p).setStyle("-fx-background-color: white");
     * GridPane.setRowIndex(route.get(p),pathY);
     * GridPane.setColumnIndex(route.get(p),pathX);
     * <p>
     * }
     */

    public static ArrayList<Rectangle> route = new ArrayList<>();

    @FXML
    void CharacterController(KeyEvent key) {
        if (key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.S) {
            MoveCharacterDown();

            deneme(stormtrooperA.getPosX(),stormtrooperA.getPosY(),pathX,pathY,masterYoda.getPosX(),masterYoda.getPosY());
            //deneme(ShortestPath.graph,masterYoda.getPosX(),masterYoda.getPosY(),pathX,pathY,9);
            for (int i = 0; i < pathY.size(); i++) {
                System.out.print("(" + pathX.get(i) + "," + pathY.get(i) + ")");
            }


            //Win ekranı
            if (MenuController.isYoda && GridPane.getRowIndex(CharacterYoda) == 9 && GridPane.getColumnIndex(CharacterYoda) == 13) {
                WinPane.setVisible(true);
            } else if (!MenuController.isYoda && GridPane.getRowIndex(CharacterLuke) == 9 && GridPane.getColumnIndex(CharacterLuke) == 13) {
                WinPane.setVisible(true);
            }
        } else if (key.getCode() == KeyCode.UP || key.getCode() == KeyCode.W) {
            MoveCharacterUp();

            //Win ekranı
            if (MenuController.isYoda && GridPane.getRowIndex(CharacterYoda) == 9 && GridPane.getColumnIndex(CharacterYoda) == 13) {
                WinPane.setVisible(true);
            } else if (!MenuController.isYoda && GridPane.getRowIndex(CharacterLuke) == 9 && GridPane.getColumnIndex(CharacterLuke) == 13) {
                WinPane.setVisible(true);
            }
        }
        else if (key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.A) {
            MoveCharacterLeft();

            //Win ekranı
            if (MenuController.isYoda && GridPane.getRowIndex(CharacterYoda) == 9 &&
                    GridPane.getColumnIndex(CharacterYoda) == 13) {
                WinPane.setVisible(true);
            } else if (!MenuController.isYoda && GridPane.getRowIndex(CharacterLuke) == 9 &&
                    GridPane.getColumnIndex(CharacterLuke) == 13) {
                WinPane.setVisible(true);
            }
        }
        else if (key.getCode() == KeyCode.RIGHT || key.getCode() == KeyCode.D) {
            MoveCharacterRight();

            //Win ekranı
            if (MenuController.isYoda && GridPane.getRowIndex(CharacterYoda) == 9 &&
                    GridPane.getColumnIndex(CharacterYoda) == 13) {
                WinPane.setVisible(true);
            } else if (!MenuController.isYoda && GridPane.getRowIndex(CharacterLuke) == 9 &&
                    GridPane.getColumnIndex(CharacterLuke) == 13) {
                WinPane.setVisible(true);
            }
        }
    }

    @FXML
    void MoveCharacterUp() {

        if (MenuController.isYoda) {

            if (!GameMap.getChildren().get(((GridPane.getRowIndex(CharacterYoda) - 1) * 14 + GridPane.getColumnIndex(CharacterYoda))).
                    getStyle().equals("-fx-fill: #738598;") && GridPane.getRowIndex(CharacterYoda) != 0) {
                GridPane.setRowIndex(CharacterYoda, GridPane.getRowIndex(CharacterYoda) - 1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));
            }

        } else {
            if (!GameMap.getChildren().get(((GridPane.getRowIndex(CharacterLuke) - 1) * 14 + GridPane.getColumnIndex(CharacterLuke))).
                    getStyle().equals("-fx-fill: #738598;") && GridPane.getRowIndex(CharacterLuke) != 0) {
                GridPane.setRowIndex(CharacterLuke, GridPane.getRowIndex(CharacterLuke) - 1);
                lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));
            }
        }


    }

    @FXML
    void MoveCharacterDown() {
        if (MenuController.isYoda) {
            if (!GameMap.getChildren().get((GridPane.getRowIndex(CharacterYoda) + 1) * 14 + GridPane.getColumnIndex(CharacterYoda)).
                    getStyle().equals("-fx-fill: #738598;") && GridPane.getRowIndex(CharacterYoda) != 11) {
                GridPane.setRowIndex(CharacterYoda, GridPane.getRowIndex(CharacterYoda) + 1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));
                System.out.println(masterYoda.getPosX());
                System.out.println(masterYoda.getPosY());


            } else {
                if (!GameMap.getChildren().get((GridPane.getRowIndex(CharacterLuke) + 1) * 14 + GridPane.getColumnIndex(CharacterLuke)).
                        getStyle().equals("-fx-fill: #738598;") && GridPane.getRowIndex(CharacterLuke) != 11) {
                    GridPane.setRowIndex(CharacterLuke, GridPane.getRowIndex(CharacterLuke) + 1);
                    lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                    lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));

                }
            }
        }
    }

    @FXML
    void MoveCharacterLeft() {

        if (!MenuController.isYoda) {

            if (!GameMap.getChildren().get(GridPane.getRowIndex(CharacterLuke) * 14 + GridPane.getColumnIndex(CharacterLuke) - 1).
                    getStyle().equals("-fx-fill: #738598;")) {
                GridPane.setColumnIndex(CharacterLuke, GridPane.getColumnIndex(CharacterLuke) - 1);
                lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));

            }
        } else {

            if (!GameMap.getChildren().get(GridPane.getRowIndex(CharacterYoda) * 14 + GridPane.getColumnIndex(CharacterYoda) - 1).
                    getStyle().equals("-fx-fill: #738598;")) {
                GridPane.setColumnIndex(CharacterYoda, GridPane.getColumnIndex(CharacterYoda) - 1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));

            }

        }

    }

    @FXML
    void MoveCharacterRight() {
        if (!MenuController.isYoda) {
            if (!GameMap.getChildren().get(GridPane.getRowIndex(CharacterLuke) * 14 + GridPane.getColumnIndex(CharacterLuke) + 1).
                    getStyle().equals("-fx-fill: #738598;")) {
                GridPane.setColumnIndex(CharacterLuke, GridPane.getColumnIndex(CharacterLuke) + 1);
                lukeSkywalker.setPosX(GridPane.getColumnIndex(CharacterLuke));
                lukeSkywalker.setPosY(GridPane.getRowIndex(CharacterLuke));
            }
        } else {

            if (!GameMap.getChildren().get(GridPane.getRowIndex(CharacterYoda) * 14 + GridPane.getColumnIndex(CharacterYoda) + 1).
                    getStyle().equals("-fx-fill: #738598;")) {
                GridPane.setColumnIndex(CharacterYoda, GridPane.getColumnIndex(CharacterYoda) + 1);
                masterYoda.setPosX(GridPane.getColumnIndex(CharacterYoda));
                masterYoda.setPosY(GridPane.getRowIndex(CharacterYoda));

            }

        }


    }

    /***********************************************************************************************************/


    public void Damage() {

        if (MenuController.isYoda) {
            Healthbar.getChildren().get(HealthCount + 1).setVisible(true);
            HealthCount++;
            Healthbar.getChildren().get(HealthCount - 1).setVisible(false);
            masterYoda.setHealth(masterYoda.getHealth() - 0.5);
        } else {
            Healthbar.getChildren().get(HealthCount + 2).setVisible(true);
            HealthCount += 2;
            Healthbar.getChildren().get(HealthCount - 2).setVisible(false);
            lukeSkywalker.setHealth(lukeSkywalker.getHealth() - 1);
        }

        if (HealthCount == 6) {
            GameOverPane.setVisible(true);
            Healthbar.getChildren().get(0).setVisible(true);
            Healthbar.getChildren().get(5).setVisible(false);
            HealthCount = 0;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (!MenuController.isYoda) {
            CharacterLuke.setVisible(true);
            CharacterYoda.setVisible(false);
        } else {
            CharacterYoda.setVisible(true);
            CharacterLuke.setVisible(false);
        }


        if (LoadingSceneController.hasStormtrooperA) {
            StormtrooperA.setVisible(true);
            stormtrooperA.setPosX(0);
            stormtrooperA.setPosY(5);
            GridPane.setColumnIndex(StormtrooperA, stormtrooperA.getPosX());

        }
        if (LoadingSceneController.hasStormtrooperB) {
            StormtrooperB.setVisible(true);
            stormtrooperB.setPosX(4);
            stormtrooperB.setPosY(0);
            GridPane.setRowIndex(StormtrooperB, stormtrooperB.getPosY());
        }
        if (LoadingSceneController.hasStormtrooperC) {
            StormtrooperC.setVisible(true);
            stormtrooperC.setPosX(4);
            stormtrooperC.setPosY(0);
            GridPane.setRowIndex(StormtrooperC, stormtrooperC.getPosY());
        }
        if (LoadingSceneController.hasStormtrooperD) {
            StormtrooperD.setVisible(true);
            stormtrooperD.setPosX(13);
            stormtrooperD.setPosY(5);
        }
        if (LoadingSceneController.hasStormtrooperE) {
            StormtrooperE.setVisible(true);
            stormtrooperE.setPosX(4);
            stormtrooperE.setPosY(10);
        }

        if (LoadingSceneController.hasKyloRenA) {
            KyloRenA.setVisible(true);
            kyloRenA.setPosX(0);
            kyloRenA.setPosY(5);
            GridPane.setColumnIndex(KyloRenA, kyloRenA.getPosX());

        }
        if (LoadingSceneController.hasKyloRenB) {
            KyloRenB.setVisible(true);
            kyloRenB.setPosX(4);
            kyloRenB.setPosY(0);
            GridPane.setRowIndex(KyloRenB, kyloRenB.getPosY());
        }
        if (LoadingSceneController.hasKyloRenC) {
            KyloRenC.setVisible(true);
            kyloRenC.setPosX(4);
            kyloRenC.setPosY(0);
            GridPane.setRowIndex(KyloRenC, kyloRenC.getPosY());
        }
        if (LoadingSceneController.hasKyloRenD) {
            KyloRenD.setVisible(true);
            kyloRenD.setPosX(13);
            kyloRenD.setPosY(5);
        }
        if (LoadingSceneController.hasKyloRenE) {
            KyloRenE.setVisible(true);
            kyloRenE.setPosX(4);
            kyloRenE.setPosY(10);
        }

        if (LoadingSceneController.hasDarthVaderA) {
            DarthVaderA.setVisible(true);
            darthVaderA.setPosX(0);
            darthVaderA.setPosY(5);
            GridPane.setColumnIndex(DarthVaderA, darthVaderA.getPosX());
        }
        if (LoadingSceneController.hasDarthVaderB) {
            DarthVaderB.setVisible(true);
            darthVaderB.setPosX(4);
            darthVaderB.setPosY(0);
            GridPane.setRowIndex(DarthVaderB, darthVaderB.getPosY());
        }
        if (LoadingSceneController.hasDarthVaderC) {
            DarthVaderC.setVisible(true);
            darthVaderC.setPosX(4);
            darthVaderC.setPosY(0);
            GridPane.setRowIndex(DarthVaderC, darthVaderC.getPosY());
        }
        if (LoadingSceneController.hasDarthVaderD) {
            DarthVaderD.setVisible(true);
            darthVaderD.setPosX(13);
            darthVaderD.setPosY(5);
        }
        if (LoadingSceneController.hasDarthVaderE) {
            DarthVaderE.setVisible(true);
            darthVaderE.setPosX(4);
            darthVaderE.setPosY(10);
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
        Stage stage = (Stage) QuitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Restart() {
        WinPane.setVisible(false);
        GameOverPane.setVisible(false);
        Stage stage = (Stage) RestartButton.getScene().getWindow();
        stage.close();
        if (MenuController.isYoda) {
            GridPane.setColumnIndex(CharacterYoda, 6);
            GridPane.setRowIndex(CharacterYoda, 6);
        } else {
            GridPane.setColumnIndex(CharacterLuke, 6);
            GridPane.setRowIndex(CharacterLuke, 6);
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


    //x düşmanın x konumu targetX karakterin konumu
    public void deneme(int x, int y, List<Integer> pathX, List<Integer> pathY, int targetX, int targetY) {
        if (x == targetX && y == targetY) {
            pathX.add(x);
            pathY.add(y);
        }

        int difX, difY;
        difX = x - targetX;
        difY = y - targetY;
        //sağa duvar görene kadar gitti ve mesafeyi kontrol etti
        if (difX <= 0 && !GameMap.getChildren().get(GridPane.getRowIndex(CharacterYoda) * 14 +
                GridPane.getColumnIndex(CharacterYoda) + 1).getStyle().equals("-fx-fill: #738598;")) {
            deneme(x + 1, y, pathX, pathY, targetX, targetY);
            pathX.add(x);
            pathY.add(y);

        }
        //sola duvar görene kadar gitti ve mesafeyi kontrol etti
        if (difX >= 0 && !GameMap.getChildren().get(GridPane.getRowIndex(CharacterYoda) * 14 +
                GridPane.getColumnIndex(CharacterYoda) - 1).getStyle().equals("-fx-fill: #738598;")) {
            deneme(x - 1, y, pathX, pathY, targetX, targetY);
            pathX.add(x);
            pathY.add(y);

        }

        if (difY <= 0 && !GameMap.getChildren().get(((GridPane.getRowIndex(CharacterYoda) - 1) * 14 +
                GridPane.getColumnIndex(CharacterYoda))).getStyle().equals("-fx-fill: #738598;")) {
            deneme(x, y - 1, pathX, pathY, targetX, targetY);
            pathX.add(x);
            pathY.add(y);

        }
        if (difY >= 0 && !GameMap.getChildren().get(((GridPane.getRowIndex(CharacterYoda) +1) * 14 +
                GridPane.getColumnIndex(CharacterYoda))).getStyle().equals("-fx-fill: #738598;")) {
            deneme(x, y  + 1, pathX, pathY, targetX, targetY);
            pathX.add(x);
            pathY.add(y);

        }


    }



      /*  public static boolean CalculatePathA(int[][] maze, int x, int y, List<Integer> pathX, List<Integer> pathY,int target) {

            if (maze[y][x] == target) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (maze[y][x] == 1) {
                maze[y][x] = 2;

                if (CalculatePathA(maze, x + 1, y , pathX,pathY,target)) {
                    pathX.add(x);
                    pathY.add(y);
                    return true;
                }

                if (CalculatePathA(maze, x , y - 1 , pathX,pathY,target)) {
                    pathX.add(x);
                    pathY.add(y);
                    return true;
                }

                if (CalculatePathA(maze, x , y  + 1, pathX,pathY,target)) {
                    pathX.add(x);
                    pathY.add(y);
                    return true;
                }

                if (CalculatePathA(maze, x - 1 , y , pathX,pathY,target)) {
                    pathX.add(x);
                    pathY.add(y);
                    return true;
                }
            }
            return false;


        }
*/

    public static boolean CalculatePathB(int[][] maze, int x, int y, List<Integer> pathX, List<Integer> pathY,int target) {

        if (maze[y][x] == target) {
            pathX.add(x);
            pathY.add(y);
            return true;
        }

        if (maze[y][x] == 1) {
            maze[y][x] = 2;

            if (CalculatePathB(maze, x, y + 1 , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathB(maze, x - 1, y , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathB(maze, x + 1, y , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathB(maze, x , y - 1 , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }
        }
        return false;


    }
    public static boolean CalculatePathC(int[][] maze, int x, int y, List<Integer> pathX, List<Integer> pathY,int target) {

        if (maze[y][x] == target) {
            pathX.add(x);
            pathY.add(y);
            return true;
        }

        if (maze[y][x] == 1) {
            maze[y][x] = 2;

            if (CalculatePathC(maze, x , y + 1 , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathC(maze, x - 1, y , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathC(maze, x , y - 1, pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathC(maze, x + 1  , y  , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }
        }
        return false;


    }
    public static boolean CalculatePathD(int[][] maze, int x, int y, List<Integer> pathX, List<Integer> pathY,int target) {

        if (maze[y][x] == target) {
            pathX.add(x);
            pathY.add(y);
            return true;
        }

        if (maze[y][x] == 1) {
            maze[y][x] = 2;

            if (CalculatePathD(maze, x - 1, y , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathD(maze, x , y + 1 , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathD(maze, x , y - 1, pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathD(maze, x + 1 , y  , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }
        }
        return false;


    }
    public static boolean CalculatePathE(int[][] maze, int x, int y, List<Integer> pathX, List<Integer> pathY,int target) {

        if (maze[y][x] == target) {
            pathX.add(x);
            pathY.add(y);
            return true;
        }

        if (maze[y][x] == 1) {
            maze[y][x] = 2;

            if (CalculatePathE(maze, x , y - 1 , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathE(maze, x - 1, y , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathE(maze, x + 1 , y , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }

            if (CalculatePathE(maze, x , y + 1 , pathX,pathY,target)) {
                pathX.add(x);
                pathY.add(y);
                return true;
            }
        }
        return false;


    }


    /***********************************************************************************************************/

}


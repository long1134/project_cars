package controller;

import javafx.stage.Stage;

public class stageService {
    public static Stage mainStage = new Stage();

    public Stage installStage(Stage stage)
    {
        this.mainStage = stage;
        return stage;
    }
}
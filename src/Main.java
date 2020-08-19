import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Ler arquivo");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //AQUI ACONTECE A COISA QUANDO CLICAR NO BOTÃO
                FileChooser kanjiDBchooser = new FileChooser(); //Cria novo FileChooser
                kanjiDBchooser.setInitialDirectory(new File("C:\\Users\\Mateus\\Documents\\GitHub\\Kanji-Memorizer"));
                              Alert kanjiprompt = new Alert(Alert.AlertType.INFORMATION); //Cria mensagem de aviso
                              kanjiprompt.setTitle("Select file path");
                              kanjiprompt.setHeaderText("Please, select the Kanji Database file.");
                              kanjiprompt.showAndWait();
                File kanjiDBfile = kanjiDBchooser.showOpenDialog(primaryStage); //Pede arquivo
                 //Inicia a lista de kanjis
                ArrayList<KanjiData> KanjiDatabase =  KanjiDBSplitter.KanjiDBSplit(kanjiDBfile);
                KanjiData.PrintKanjiList(KanjiDatabase);








            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Kanji Memorizer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

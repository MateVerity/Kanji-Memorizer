import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;



public class Main extends Application {

    public ArrayList<KanjiData> KanjiDatabase;
    public int ind = 0;
    private final Pane layer0 = new Pane();
    private final Pane root = new Pane();
    Scene scene = new Scene(root, 1000, 550);
    Scene scene1 = new Scene(layer0, 1000, 550);
    private final HBox layer1 = new HBox();
    Scene scene2 = new Scene(layer1, 1000,550);


    @Override
    public void start(Stage primaryStage) {
        Button returnfromgamebtn = new Button();
        Button submit = new Button();
        returnfromgamebtn.setText("Voltar");
        submit.setText("Submeter Resposta");
        Label labelKUN = new Label("Leitura Kun'Yomi:");
        TextField textfKun = new TextField();
        Label labenON = new Label("Leitura On'Yomi:");
        TextField textfOn = new TextField();
        Label labelMeaning = new Label ("Significado:");
        TextField textfMeaning = new TextField();
        

        Button gamebtn = new Button();
        gamebtn.setText("Testar Memorização");
        Text secondMenutitlte = new Text();
        secondMenutitlte.setText("Visualizador de Kanjis");
        TextArea kanjiTextPrint = new TextArea();
        Button Filebtn = new Button();
        Button Readbtn = new Button();
        Button Backbtn = new Button();
        Backbtn.setText("Anterior");
        Readbtn.setText("Próximo");
        Filebtn.setText("Ler arquivo");
        Filebtn.setOnAction(actionEvent -> {
            //AQUI ACONTECE A COISA QUANDO CLICAR NO BOTÃO
            FileChooser kanjiDBchooser = new FileChooser(); //Cria novo FileChooser
            kanjiDBchooser.setInitialDirectory(new File("C:\\Users\\Mateus\\Documents\\GitHub\\Kanji-Memorizer"));
            Alert kanjiprompt = new Alert(Alert.AlertType.INFORMATION); //Cria mensagem de aviso
            kanjiprompt.setTitle("Select file path");
            kanjiprompt.setHeaderText("Please, select the Kanji Database file.");
            kanjiprompt.showAndWait();
            File kanjiDBfile = kanjiDBchooser.showOpenDialog(primaryStage); //Pede arquivo
            //Inicia a lista de kanjis
            KanjiDatabase = KanjiDBSplitter.KanjiDBSplit(kanjiDBfile);
            KanjiData.TextKanjiList(KanjiDatabase, kanjiTextPrint, ind);
            System.out.println(KanjiDatabase.size());
            primaryStage.setScene(scene1);
        });
        Readbtn.setOnAction(actionEvent -> {
            //AQUI ACONTECE QUANDO CLICAR NO OUTRO BOTÃO

            if(ind < KanjiDatabase.size()-1) {
                kanjiTextPrint.setText("");
                ind++;
                KanjiData.TextKanjiList(KanjiDatabase, kanjiTextPrint, ind);
            }
            System.out.println(ind);

        });
        Backbtn.setOnAction(actionEvent -> {
            //AQUI VOLTA O BOTAO
            if(ind > 0)
            {
                ind--;
                kanjiTextPrint.setText("");
                KanjiData.TextKanjiList(KanjiDatabase, kanjiTextPrint, ind);
            }

        });

        gamebtn.setOnAction(actionEvent -> {
            primaryStage.setScene(scene2);

        });






        VBox vbox = new VBox(kanjiTextPrint);


        secondMenutitlte.setLayoutY(25);
        secondMenutitlte.setLayoutX(50);
        vbox.setLayoutY(50);
        Readbtn.setLayoutY(250);
        Readbtn.setLayoutX(250);
        Backbtn.setLayoutX(150);
        Backbtn.setLayoutY(250);
        Filebtn.setLayoutX(450);
        Filebtn.setLayoutY(250);
        Filebtn.setMinSize(250,150);
        gamebtn.setLayoutY(350);
        gamebtn.setLayoutX(350);
        gamebtn.setMinSize(120,120);
        layer0.getChildren().add(vbox);
        root.getChildren().add(Filebtn);
        layer0.getChildren().add(Readbtn);
        layer0.getChildren().add(Backbtn);
        layer0.getChildren().add(secondMenutitlte);
        layer0.getChildren().add(gamebtn);


        primaryStage.setTitle("Kanji Memorizer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

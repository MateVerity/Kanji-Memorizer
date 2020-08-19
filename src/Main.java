import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Main extends Application {

    public ArrayList<KanjiData> KanjiDatabase;
    public int ind = 0;
    public int currentKanji = 0;
    private final Pane layer0 = new Pane();
    private final Pane root = new Pane();
    Scene scene = new Scene(root, 1000, 550);
    Scene scene1 = new Scene(layer0, 1000, 550);
    private final Pane layer1 = new Pane();
    Scene scene2 = new Scene(layer1, 1000,550);


    @Override
    public void start(Stage primaryStage) {
        Button returnfromgamebtn = new Button();
        Button submit = new Button();
        returnfromgamebtn.setText("Voltar");
        submit.setText("Próximo");
        Label labelKUN = new Label("Leitura Kun'Yomi:");
        TextField textfKun = new TextField();
        Label labenON = new Label("Leitura On'Yomi:");
        TextField textfOn = new TextField();
        Label labelMeaning = new Label ("Significado:");
        TextField textfMeaning = new TextField();
        Text hugeKanji = new Text();
        hugeKanji.setFont(Font.font("Verdana", 300));
        Button checkAnswer = new Button();
        checkAnswer.setText("Checar respostas");
        Button showAnswer = new Button();
        showAnswer.setText("Mostrar resposta");



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
            String[] onlyCharacter = new String(KanjiDatabase.get(currentKanji).KanjiCharacter).split(";");
            hugeKanji.setText(onlyCharacter[0]);

        });

        submit.setOnAction(actionEvent -> {
           currentKanji = ThreadLocalRandom.current().nextInt(0, KanjiDatabase.size());
            String[] onlyCharacter = new String(KanjiDatabase.get(currentKanji).KanjiCharacter).split(";");
            hugeKanji.setText(onlyCharacter[0]);
            textfKun.setText("");
            textfMeaning.setText("");
            textfOn.setText("");
        });

        checkAnswer.setOnAction(actionEvent -> {
            String meaningAnswer = null, kunAnswer = null, onAnswer = null;
            meaningAnswer = textfMeaning.getText();
            kunAnswer = textfKun.getText();
            onAnswer = textfOn.getText();

            if(meaningAnswer.equals(KanjiDatabase.get(currentKanji).KanjiMeaning) && kunAnswer.equals(KanjiDatabase.get(currentKanji).KunReading) &&
            onAnswer.equals(KanjiDatabase.get(currentKanji).OnReading)){

                Alert victory = new Alert(Alert.AlertType.INFORMATION);
                victory.setTitle("Parabéns");
                victory.setContentText("Você acertou todo o kanji!");
                victory.showAndWait();

            }
            else {
                Alert defeat = new Alert(Alert.AlertType.ERROR);
                defeat.setTitle("Que pena");
                defeat.setContentText("Você errou!");
                defeat.showAndWait();
            }


        });

        showAnswer.setOnAction(actionEvent -> {
            Alert answers = new Alert(Alert.AlertType.INFORMATION);
            answers.setTitle("Respostas");
            answers.setContentText(KanjiDatabase.get(currentKanji).KanjiMeaning + "\n" + KanjiDatabase.get(currentKanji).KunReading + "\n" +
                    KanjiDatabase.get(currentKanji).OnReading);
            answers.showAndWait();




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
        labelMeaning.setLayoutX(10);
        labenON.setLayoutX(10);
        labelKUN.setLayoutX(10);
        labelMeaning.setLayoutY(50);
        labelKUN.setLayoutY(250);
        labenON.setLayoutY(150);
        textfMeaning.setLayoutX(150);
        textfMeaning.setLayoutY(50);
        textfOn.setLayoutX(150);
        textfOn.setLayoutY(150);
        textfKun.setLayoutX(150);
        textfKun.setLayoutY(250);
        hugeKanji.setLayoutY(300);
        hugeKanji.setLayoutX(350);
        submit.setLayoutY(400);
        submit.setLayoutX(125);
        checkAnswer.setLayoutY(400);
        checkAnswer.setLayoutX(230);
        showAnswer.setLayoutY(400);
        showAnswer.setLayoutX(370);
        layer0.getChildren().add(vbox);
        root.getChildren().add(Filebtn);
        layer0.getChildren().add(Readbtn);
        layer0.getChildren().add(Backbtn);
        layer0.getChildren().add(secondMenutitlte);
        layer0.getChildren().add(gamebtn);
        layer1.getChildren().addAll(labelMeaning,textfMeaning,labenON, textfOn, labelKUN, textfKun);
        layer1.getChildren().add(hugeKanji);
        layer1.getChildren().add(submit);
        layer1.getChildren().add(checkAnswer);
        layer1.getChildren().add(showAnswer);


        primaryStage.setTitle("Kanji Memorizer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

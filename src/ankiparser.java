import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ankiparser {

    public static ArrayList<KanjiData> AnkiParser(Stage ImportStage){
        int ID = 0;
        ArrayList<KanjiData> AnkiImport = null;
        AnkiImport = new ArrayList<>();
         FileChooser AnkiFileChooser = new FileChooser();
        AnkiFileChooser.setInitialDirectory(new File("C:\\Users\\Mateus\\Documents\\GitHub\\Kanji-Memorizer"));
        Alert AnkiPrompt = new Alert(Alert.AlertType.INFORMATION); //Cria mensagem de aviso
        AnkiPrompt.setTitle("Select file path");
        AnkiPrompt.setHeaderText("Please, select the Kanji Database file.");
        AnkiPrompt.showAndWait();
        File ankiFile = AnkiFileChooser.showOpenDialog(ImportStage);
        try {
            BufferedReader ankiReader = new BufferedReader(new InputStreamReader(new FileInputStream(ankiFile), "UTF-8"));
            String line;
            String tempCharacter = null, tempMeaning = null, tempOn = null, tempKun = null;
            while ((line = ankiReader.readLine()) != null) {
                String[] NewKanjiToken = line.split("(\\tSignificado: )");
                tempCharacter = NewKanjiToken[0];
                String secondPart = NewKanjiToken[1];
                NewKanjiToken = secondPart.split("On'Yomi: ");
                tempMeaning = NewKanjiToken[0];
                String thirdPart = NewKanjiToken[1];
                NewKanjiToken = thirdPart.split("Kun'Yomi: ");
                tempOn = NewKanjiToken[0];
                String finalPart = NewKanjiToken[1];
                NewKanjiToken = finalPart.split(("Exemplos:"));
                tempKun = NewKanjiToken[0];
                KanjiData newKanji = new KanjiData(ID, tempCharacter, tempMeaning, tempOn, tempKun);
                AnkiImport.add(newKanji);
                ID++;
                //AnkiPrompt.showAndWait();


            }




        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    return AnkiImport;}

}

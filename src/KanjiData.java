import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import java.util.ArrayList;

public class KanjiData {

        int KanjiID;
        String KanjiCharacter;
        String KanjiMeaning;
        String OnReading;
        String KunReading;

        public KanjiData(int tempID, String tempCharacter, String tempMeaning, String tempOn, String s) {


                tempMeaning = tempMeaning.trim();
                tempOn = tempOn.trim();
                s = s.trim();


                KanjiID = tempID;
                KanjiCharacter = tempCharacter;
                KanjiMeaning = tempMeaning;
                OnReading = tempOn;
                KunReading = s;
        }

        public static void PrintKanjiList(ArrayList<KanjiData> KanjiDB) //Printa a lista inteira de kanjis
        {
                for (KanjiData kanjiData : KanjiDB) {
                        System.out.println("\nID : " + kanjiData.KanjiID);
                        System.out.println("\nKanji : " + kanjiData.KanjiCharacter);
                        System.out.println("\nSignificado : " + kanjiData.KanjiMeaning);
                        System.out.println("\nOn'Yomi : " + kanjiData.OnReading);
                        System.out.println("\nKun'Yomi : " + kanjiData.KunReading);
                }
        }

        public static void TextKanjiList(ArrayList<KanjiData> KanjiDB, TextArea myTextArea, int i) //Printa a lista inteira de kanjis na textArea
        {
                try {
                        myTextArea.appendText("Kanji : " + KanjiDB.get(i).KanjiCharacter);
                        myTextArea.appendText("\nSignificado : " + KanjiDB.get(i).KanjiMeaning);
                        myTextArea.appendText("\nOn'Yomi : " + KanjiDB.get(i).OnReading);
                        myTextArea.appendText("\nKun'Yomi : " + KanjiDB.get(i).KunReading);
                        myTextArea.appendText("\nID : " + KanjiDB.get(i).KanjiID);
                }
                catch(IndexOutOfBoundsException e){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Erro no arquivo");
                        alert.setTitle("Erro");
                        alert.setContentText("Arquivo inválido ou corrompido. Favor selecionar outro.");
                        alert.showAndWait();
                        System.exit(0);
                }


        }

        //public KanjiData(int KanjiID, String KanjiCharacter, String KanjiMeaning, String OnReading, String KunReading, File KanjiDBFile){
          //      System.out.println("Kanji adicionado com sucesso.\n" + "Caracter: " + KanjiCharacter+"\n" + "Significado : " + KanjiMeaning + "\n" +
            //            "Leitura ON : " + OnReading + "\n" + "Leitura KUN : " + KunReading + "\n");
        //}

        

}

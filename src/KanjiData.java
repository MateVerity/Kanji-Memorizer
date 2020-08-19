import java.io.File;
import java.util.ArrayList;

public class KanjiData {

        int KanjiID;
        String KanjiCharacter;
        String KanjiMeaning;
        String OnReading;
        String KunReading;

        public KanjiData(int tempID, String tempCharacter, String tempMeaning, String tempOn, String s) {
                KanjiID = tempID;
                KanjiCharacter = tempCharacter;
                KanjiMeaning = tempMeaning;
                OnReading = tempOn;
                KunReading = s;
        }

        public static void PrintKanjiList(ArrayList<KanjiData> KanjiDB) //Printa a lista inteira de kanjis
        {
                int n = KanjiDB.size();
                for(int i=0; i<n; i++) {
                        System.out.println("\nID : " + KanjiDB.get(i).KanjiID);
                        System.out.println("\nKanji : " + KanjiDB.get(i).KanjiCharacter);
                        System.out.println("\nSignificado : " + KanjiDB.get(i).KanjiMeaning);
                        System.out.println("\nOn'Yomi : " + KanjiDB.get(i).OnReading);
                        System.out.println("\nKun'Yomi : " + KanjiDB.get(i).KunReading);
                }
        }


        //public KanjiData(int KanjiID, String KanjiCharacter, String KanjiMeaning, String OnReading, String KunReading, File KanjiDBFile){
          //      System.out.println("Kanji adicionado com sucesso.\n" + "Caracter: " + KanjiCharacter+"\n" + "Significado : " + KanjiMeaning + "\n" +
            //            "Leitura ON : " + OnReading + "\n" + "Leitura KUN : " + KunReading + "\n");
        //}

        

}

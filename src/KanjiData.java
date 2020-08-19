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
                for (KanjiData kanjiData : KanjiDB) {
                        System.out.println("\nID : " + kanjiData.KanjiID);
                        System.out.println("\nKanji : " + kanjiData.KanjiCharacter);
                        System.out.println("\nSignificado : " + kanjiData.KanjiMeaning);
                        System.out.println("\nOn'Yomi : " + kanjiData.OnReading);
                        System.out.println("\nKun'Yomi : " + kanjiData.KunReading);
                }
        }


        //public KanjiData(int KanjiID, String KanjiCharacter, String KanjiMeaning, String OnReading, String KunReading, File KanjiDBFile){
          //      System.out.println("Kanji adicionado com sucesso.\n" + "Caracter: " + KanjiCharacter+"\n" + "Significado : " + KanjiMeaning + "\n" +
            //            "Leitura ON : " + OnReading + "\n" + "Leitura KUN : " + KunReading + "\n");
        //}

        

}

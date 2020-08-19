import java.io.*;
import java.util.ArrayList;

//Recebe o arquivo contendo a database de kanjis e os carrega na memória do programa


public class KanjiDBSplitter {

    public static ArrayList<KanjiData> KanjiDBSplit(File KanjiDBFile) {
        ArrayList<KanjiData> KanjiDB = null;
        try {

            KanjiDB = new ArrayList<>();
            BufferedReader kanjiDBreader = new BufferedReader(new FileReader(KanjiDBFile));
            String line;
            String tempCharacter = null, tempMeaning = null, tempOn = null;
            int tempID = 0;
            int counter = 1;
            while ((line = kanjiDBreader.readLine()) != null) {
                String[] IDtoken = line.split("( : )");

                switch (counter) {
                    case (1) -> {
                        tempID = Integer.parseInt(IDtoken[0]);
                        counter++;
                    }
                    case (2) -> {
                        tempCharacter = IDtoken[1];
                        counter++;
                    }
                    case (3) -> {
                        tempMeaning = IDtoken[1];
                        counter++;
                    }
                    case (4) -> {
                        tempOn = IDtoken[1];
                        counter++;
                    }
                    case (5) -> {
                        KanjiData newkanji = new KanjiData(tempID, tempCharacter, tempMeaning, tempOn, IDtoken[1]);
                        KanjiDB.add(newkanji);
                        counter++;
                    }
                    case (6) -> counter = 1;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return KanjiDB;
    }
}

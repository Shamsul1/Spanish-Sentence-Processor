package Utils;

import Model.Directories;
import Model.Quiz;
import Model.WordData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SentenceUtils {



    public static List<WordData> getSentencesMatchingInputWords(List<WordData> sentenceDataList, List<WordData> wordData, int maxAmount){

        List<WordData> specifiedWordDataList = new ArrayList<>();
        Collections.shuffle(sentenceDataList);

        for (int i = 0; i < wordData.size(); i++) {

            int sentenceAmount = 0;

            for (WordData sentenceData: sentenceDataList) {

                if(sentenceData.getConjugation().equalsIgnoreCase(wordData.get(i).getConjugation())){

                    //System.out.println(sentenceData.getInfinitive()+" "+sentenceData.getEnglishSentence()+" "+sentenceData.getSpanishSentence());
                    WordData selectedWordData = new WordData();
                    selectedWordData.setInfinitive(sentenceData.getInfinitive());
                    selectedWordData.setConjugation(sentenceData.getConjugation());
                    selectedWordData.setPerson(sentenceData.getPerson());
                    selectedWordData.setEnglishSentence(sentenceData.getEnglishSentence());
                    selectedWordData.setSpanishSentence(sentenceData.getSpanishSentence());
                    specifiedWordDataList.add(selectedWordData);

                    sentenceAmount++;
                    if(sentenceAmount >= maxAmount){
                        break;
                    }
                }

            }
        }

        return specifiedWordDataList;
    }
}

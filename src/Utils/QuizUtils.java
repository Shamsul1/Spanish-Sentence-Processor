package Utils;

import Model.Quiz;
import Model.WordData;

import java.util.ArrayList;
import java.util.List;

public class QuizUtils {



    public static List<Quiz> buildQuiz(List<WordData> sentenceDataList){

        List<Quiz> quizList = new ArrayList<>();

        for (int i = 0; i < sentenceDataList.size(); i++) {

            quizList.add(processSentence(sentenceDataList.get(i)));


        }

        return quizList;

    }

    public static Quiz processSentence(WordData wordData){

        Quiz quiz = new Quiz();

        String sentence = wordData.getSpanishSentence();
        sentence = wordData.getEnglishSentence()+" \n"+sentence.replace(wordData.getConjugation()," ________ ("+wordData.getInfinitive()+")");

        quiz.setSentence(sentence);
        quiz.setAnswer(wordData.getConjugation());
        System.out.println(quiz.getSentence()+" \n"+quiz.getAnswer());


        return quiz;
    }


}

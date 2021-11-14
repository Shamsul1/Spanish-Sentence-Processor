import Model.Directories;
import Model.Quiz;
import Model.WordData;
import Utils.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final String EXCEL_PATH= Directories.EXCEL_PATH;

    public static void main(String[] args) throws IOException {

        List<WordData> sentenceDataList = ExcelUtils.getSentencesFromExcel(EXCEL_PATH);
        List<WordData> wordDataList = ExcelUtils.getInputWordsFromExcel(EXCEL_PATH);
        List<WordData> specifiedSentenceDataList = SentenceUtils.getSentencesMatchingInputWords(sentenceDataList,wordDataList,1);
        List<Quiz> quizList = QuizUtils.buildQuiz(specifiedSentenceDataList);

        OutputUtilz.output(quizList);
        FinalizeUtilz.openTextFile(new File(Directories.OUTPUT_FOLDER+"\\output.txt"));

    }
}

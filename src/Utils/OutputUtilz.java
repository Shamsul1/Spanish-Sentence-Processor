package Utils;

import Model.Directories;
import Model.Quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputUtilz {



    public static void output(List<Quiz> quizList){

        StringBuilder stringBuilder = new StringBuilder();

        for (Quiz quiz: quizList) {

            stringBuilder.append(quiz.getSentence()).append("\t").append(quiz.getAnswer()).append("++==\n");

        }

        writeText(stringBuilder.toString());
    }

    public static void writeText(String strings) {
        try {
            FileWriter myWriter = new FileWriter(Directories.OUTPUT_FOLDER+"\\output.txt");
            myWriter.write(strings);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

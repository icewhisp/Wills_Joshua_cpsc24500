/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.quiz.tool;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Joshua Wills
 */
public class QuestionReader {
    private ArrayList<Question> quiz = new ArrayList<Question>();
    
    public QuestionReader(){
        JSONParser parser = new JSONParser();
        
        try
        {
            Object obj = parser.parse(new FileReader("questions_without_answers.json"));
            JSONObject parsedFile = (JSONObject) obj;
            JSONArray rawQuestions = (JSONArray) parsedFile.get("questions");
            Iterator<JSONObject> filterQuestion = rawQuestions.iterator();
            while (filterQuestion.hasNext()) {
                fillQuestion(filterQuestion.next());
            }

            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    private void fillQuestion(JSONObject question){
        String q = (String) question.get("question");
        String a = (String) question.get("a");
        String b = (String) question.get("b");
        String c = (String) question.get("c");
        String d = (String) question.get("d");
        String correctAnswer = (String) question.get("answer");
        Question temp = new Question(q,a,b,c,d,correctAnswer);
        quiz.add(temp);
        
    }
    public  ArrayList<Question> getQuestions()
    {
        return quiz;
    }
    
}

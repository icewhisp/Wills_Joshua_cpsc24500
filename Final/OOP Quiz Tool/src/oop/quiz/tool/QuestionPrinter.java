/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.quiz.tool;
import java.util.ArrayList;
/**
 *
 * @author Joshua Wills
 */
public class QuestionPrinter {
    private ArrayList<Question> quiz = new ArrayList<Question>();
    public QuestionPrinter()
    {
        QuestionReader read;
        read = new QuestionReader();
        quiz = read.getQuestions();
    }
    public void printQuestions()
    {
        for (Question quest: quiz)
        {
            System.out.println(quest.getQ() + " "+ quest.getCA());
        }
    }
}

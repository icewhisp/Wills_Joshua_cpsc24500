/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.quiz.tool;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Joshua Wills
 */
public class Quizzer {
    ArrayList<Question> quiz = new ArrayList<Question>();
            
    public Quizzer(){
        QuestionReader read;
        read = new QuestionReader();
        quiz = read.getQuestions();

    }

    /**
     * Starts the quiz up
     */
    public void startQuiz(){
        int numberCorrect = 0;
        Scanner sc = new Scanner(System.in); 
        System.out.print("How Many Quesitons do you want: ");
        int questNum = sc.nextInt();
        
        for(int i = 0; i<questNum; i++)
        {
            int randQ = (int) Math.floor(Math.random()*quiz.size());
            Question question = quiz.get(randQ);
            quiz.remove(randQ);
            System.out.print((i+1)+".");
            System.out.println(question.toString());
            System.out.print("Answer: ");
            String answer = sc.next().toLowerCase();
            if (question.checkCorrect(answer))
            {
                numberCorrect += 1;
            }
        }
        System.out.println("You ended with a score of " +numberCorrect+"/"+questNum);
        reFillQuestions();
    }

    /**
     * reloads the questions
     */
    public void reFillQuestions()
    {
        QuestionReader read = new QuestionReader();
        quiz = read.getQuestions();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.quiz.tool;

import java.util.Scanner;

/**
 *
 * @author Joshua Wills
 */
public class QuizApp {
    public static void main(String[] args){
        System.out.println("**********************************");
        System.out.println("***OOP Theory and Concepts Quiz***");
        System.out.println("**********************************");
        Quizzer quiz = new Quizzer();
        QuestionPrinter key = new QuestionPrinter();
        Scanner sc = new Scanner(System.in);
        int answer = 5;
        while (answer != 3)
        {
            System.out.println("Here are your choices");
            System.out.println("1.  Take A Quiz");
            System.out.println("2.  See the questions and the answers");
            System.out.println("3.  Exit");
            System.out.print("Please enter the number of your choice: ");
            answer = sc.nextInt();
            if(answer == 1)
            {
               quiz.startQuiz(); 
            }
            else if (answer == 2)
            {
                key.printQuestions();
            }
        }
    }
    
}

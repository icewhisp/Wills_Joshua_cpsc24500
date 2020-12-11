/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.quiz.tool;

/**
 *
 * @author Joshua Wills
 */
public class Question {
    String question= "";
    String AnswerA = "";
    String AnswerB= "";
    String AnswerC= "";
    String AnswerD= "";
    String correctAnswer = "";
    
    
    public Question(String question,String AnswerA,String AnswerB,String AnswerC,String AnswerD, String correct_answer){
        this.question =question;
        this.AnswerA = AnswerA;
        this.AnswerB = AnswerB;
        this.AnswerC = AnswerC;
        this.AnswerD = AnswerD;
        correctAnswer =correct_answer;
    }
    @Override
    public String toString()
    {
        return question + "\n\tA: " +AnswerA+ "\n\tB: " +AnswerB+ "\n\tC: " +AnswerC+ "\n\tD: " +AnswerD;
    }
    public boolean checkCorrect(String choice){
        return choice.equals(correctAnswer);
    }
    public String getRightAnswer()
    {
        if (correctAnswer.equals("a")){
            return AnswerA;
        }
        else if (correctAnswer.equals("b")){
            return AnswerB;
        }
        else if (correctAnswer.equals("c")){
            return AnswerC;
        }
        else{
            return AnswerD;
        }
    }
    public String getA()
    {
        return AnswerA;
    }
    public String getB()
    {
        return AnswerB;
    }
    public String getC()
    {
        return AnswerC;
    }
    public String getD()
    {
        return AnswerD;
    }
    public String getQ()
    {
        return question;
    }
    public String getCA()
    {
        return correctAnswer;
    }
    public void setA(String setter)
    {
        AnswerA = setter;
    }
    public void setB(String setter)
    {
        AnswerB = setter;
    }
    public void setC(String setter)
    {
        AnswerC = setter;
    }
    public void setD(String setter)
    {
        AnswerD = setter;
    }
    public void setQ(String setter)
    {
        question = setter;
    }
    public void setQA(String setter)
    {
        correctAnswer = setter;
    }
}

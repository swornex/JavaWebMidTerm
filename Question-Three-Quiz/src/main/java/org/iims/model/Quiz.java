package org.iims.model;

public class Quiz {
    private int id;
    private String question, answer_one, answer_two, answer_three, answer_four, correct_answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_one() {
        return answer_one;
    }

    public void setAnswer_one(String answer_one) {
        this.answer_one = answer_one;
    }

    public String getAnswer_two() {
        return answer_two;
    }

    public void setAnswer_two(String answer_two) {
        this.answer_two = answer_two;
    }

    public String getAnswer_three() {
        return answer_three;
    }

    public void setAnswer_three(String answer_three) {
        this.answer_three = answer_three;
    }

    public String getAnswer_four() {
        return answer_four;
    }

    public void setAnswer_four(String answer_four) {
        this.answer_four = answer_four;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public Quiz() {
    }

    public Quiz(int id, String question, String answer_one, String answer_two, String answer_three, String answer_four, String correct_answer) {
        this.id = id;
        this.question = question;
        this.answer_one = answer_one;
        this.answer_two = answer_two;
        this.answer_three = answer_three;
        this.answer_four = answer_four;
        this.correct_answer = correct_answer;
    }
}

package org.iims.dao;

import org.iims.connection.ConnectionFactory;
import org.iims.model.Quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuizDaoImpl implements QuizDao{

    @Override
    public List<Quiz> getQuestions() throws SQLException, ClassNotFoundException {
        final String SELECT_QUERY= "SELECT * FROM quiz";
        Connection connection= ConnectionFactory.getConnection();
        List<Quiz> quizzes = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

        while(resultSet.next()){
            Quiz quiz = new Quiz();
            quiz.setId(resultSet.getInt("id"));
            quiz.setQuestion(resultSet.getString("question"));
            quiz.setAnswer_one(resultSet.getString("answer_one"));
            quiz.setAnswer_two(resultSet.getString("answer_two"));
            quiz.setAnswer_three(resultSet.getString("answer_three"));
            quiz.setAnswer_four(resultSet.getString("answer_four"));
            quiz.setCorrect_answer(resultSet.getString("correct_answer"));

            quizzes.add(quiz);
        }

        return quizzes;
    }
}

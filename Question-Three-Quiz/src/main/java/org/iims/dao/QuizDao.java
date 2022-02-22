package org.iims.dao;

import org.iims.model.Quiz;

import java.sql.SQLException;
import java.util.List;

public interface QuizDao {
    List <Quiz> getQuestions() throws SQLException, ClassNotFoundException;
}

package org.iims.dao;

import org.iims.connection.ConnectionFactory;
import org.iims.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Login findOne(String username, String password) throws SQLException, ClassNotFoundException{
        final String SEARCHQUERY = "SELECT * FROM login WHERE username =? AND password=?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCHQUERY);
         preparedStatement.setString(1, username);
         preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        Login login = null;

        while(resultSet.next()){
            login = new Login();
            login.setUsername(resultSet.getString("username"));
            login.setPassword(resultSet.getString("password"));
            login.setFirst_name(resultSet.getString("first_name"));
            login.setLast_name(resultSet.getString("last_name"));
        }
        return login;
    }
}

package org.iims.dao;

import org.iims.model.Login;

import java.sql.SQLException;

public interface LoginDao {
    Login findOne(String username, String password) throws SQLException, ClassNotFoundException;
}

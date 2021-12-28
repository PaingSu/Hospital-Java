package Database;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Con {

	Connection con;

	public Connection getConnection() throws SQLException {

		String user = "root";
		String pass = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hospitalmanage",
					user, pass);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return con;
	}

}

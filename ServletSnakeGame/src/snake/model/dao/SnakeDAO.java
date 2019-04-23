package snake.model.dao;
	
	import java.util.ArrayList;
	import snakeuser.model.*;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class SnakeDAO extends DataAccessObject{
		
		
		public void addScore(UserScore userscore) {
			Connection conn = null;
			PreparedStatement insertStmt = null;
			
			try {
				conn = getConnection();
				
				String sqlInsert = "INSERT INTO snakepoints(username, points) VALUES(?,?)";
				insertStmt = conn.prepareStatement(sqlInsert);
				insertStmt.setString(1, userscore.getuserName());
				insertStmt.setInt(2, userscore.getScore());
				insertStmt.executeUpdate();
			
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}finally {
				close(insertStmt, conn);
			}
		}
		

		public ArrayList <UserScore> findAll(){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList <UserScore> scorelist = new ArrayList<UserScore>();
			UserScore userscore = null;
			
			try {
				conn = getConnection();
				
				String sqlSelect = "SELECT username, points FROM snakepoints ORDER BY points desc";
				stmt = conn.prepareStatement(sqlSelect);
				rs = stmt.executeQuery();
				while (rs.next()) {
					userscore = readUser(rs);
					scorelist.add(userscore);
				}
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}finally {
				close(rs, stmt, conn);
			}
			return scorelist;
			
		}
		


		private UserScore readUser(ResultSet rs) {
			try {
				
				String name = rs.getString("username");
				int score = rs.getInt("points");

				
				return new UserScore(name, score);
				
				
			}catch (SQLException e) {
					throw new RuntimeException(e);
			}
			
			
		}

}

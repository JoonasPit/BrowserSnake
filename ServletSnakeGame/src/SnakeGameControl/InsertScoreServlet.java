package SnakeGameControl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snake.model.dao.SnakeDAO;
import snakeuser.model.UserScore;


@WebServlet("/insert")
public class InsertScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public InsertScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String jsp = "/scoreboard";
		
		
		

		
		String userName = request.getParameter("lol");
		String userScore = request.getParameter("userscore");
		int intScore = Integer.parseInt(userScore);
		
		UserScore userscore = new UserScore(userName, intScore);
		
		SnakeDAO snakedao = new SnakeDAO();
		
		snakedao.addScore(userscore);
		userscore = new UserScore();
		System.out.print(userName);
		System.out.print(userScore);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
		// make this not repost all the time..

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

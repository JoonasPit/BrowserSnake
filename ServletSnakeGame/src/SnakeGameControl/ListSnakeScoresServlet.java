package SnakeGameControl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import snake.model.dao.SnakeDAO;
import snakeuser.model.UserScore;


@WebServlet("/scoreboard")
public class ListSnakeScoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListSnakeScoresServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SnakeDAO snakedao = new SnakeDAO();
		ArrayList <UserScore> scorelist = snakedao.findAll();
		
		String jsp = "/view/scoreboard.jsp";
		
		request.setAttribute("scorelist", scorelist);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

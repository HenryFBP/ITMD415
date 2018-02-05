package testWebProject.Comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testWebProject.lib;

/**
 * Servlet implementation class CommentControllerServlet
 */
@WebServlet("/CommentControllerServlet")
public class CommentControllerServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//response.getWriter().append(lib.wrap(String.format("'%s' aka Comment Controller Servlet FTW!",this.getClass().getName()),"p"));
		//response.getWriter().append(lib.wrap(String.format("Served at: %s",request.getContextPath()),"p"));
		
		log("Someone is GETing our CommentControllerServlet");
		
		request.getRequestDispatcher("/tests/comment/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		log("DID SUM1 TRY TO (HTTP POST) A COMMENT????!?!?!");
	}

}

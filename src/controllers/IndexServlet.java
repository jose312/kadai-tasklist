package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



	    EntityManager em = DBUtil.createEntityManager();
	    int page = 1;
	    try {
	        page = Integer.parseInt(request.getParameter("page"));
	    } catch(NumberFormatException e) {}
	  List<Tasks> nowtasks = em.createNamedQuery("getNowTasks", Tasks.class)
			  .setFirstResult(15 * (page - 1))
              .setMaxResults(15)
  .getResultList();

	  long tasks_count = (long)em.createNamedQuery("getNowTasksCount", Long.class)
              .getSingleResult();



	  int pagef = 1;
	  try {
	      pagef = Integer.parseInt(request.getParameter("pagef"));
	  } catch(NumberFormatException e) {}
	    List<Tasks> finishtasks = em.createNamedQuery("getFinishTasks", Tasks.class)
	    		.setFirstResult(15 * (page - 1))
                .setMaxResults(15)
	    		.getResultList();

	    long tasks_countf = (long)em.createNamedQuery("getFinishTasksCount", Long.class)
	              .getSingleResult();


	    em.close();


	    request.setAttribute("nowtasks", nowtasks);

	    request.setAttribute("tasks_count", tasks_count);
	    request.setAttribute("page", page);

	    request.setAttribute("finishtasks", finishtasks);
	    request.setAttribute("tasks_countf", tasks_countf);
	    request.setAttribute("pagef", pagef);

	    if(request.getSession().getAttribute("flush") != null) {
	        request.setAttribute("flush", request.getSession().getAttribute("flush"));
	        request.getSession().removeAttribute("flush");
	    }

	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
	    rd.forward(request, response);
		}
	}



package controllers.business;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Business;
import models.Employee;
import utils.DBUtil;

/**
 * Servlet implementation class BusinessEdit
 */
@WebServlet("/business/edit")
public class BusinessEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Business b = em.find(Business.class , Integer.parseInt(request.getParameter("id")));

        em.close();

        Employee login_employee = (Employee)request.getSession().getAttribute("login_employee");
        if(b != null && login_employee.getId() == b.getEmployee().getId()){        //DBにidを元に検索した時にbが存在し、
            request.setAttribute("business", b);                                   //loginしている従業員idとDB問合せして取得した従業員idが一致したら
            request.setAttribute("_token", request.getSession().getId());          //動かす
            request.getSession().setAttribute("business_id" , b.getId());          //取得したbのid情報をセッションスコープに登録
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/business/edit.jsp");
        rd.forward(request, response);
    }

}

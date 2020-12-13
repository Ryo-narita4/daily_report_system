package controllers.company;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Company;
import models.validators.CompanyValidater;
import utils.DBUtil;

/**
 * Servlet implementation class CompanyCreate
 */
@WebServlet("/company/create")
public class CompanyCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Company c = new Company();

            c.setName(request.getParameter("name"));
            c.setAddress(request.getParameter("address"));
            c.setTell(request.getParameter("tell"));
            c.setMail(request.getParameter("mail"));
            c.setCharge(request.getParameter("charge"));

            List<String> errors = CompanyValidater.validate(c);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("company", c);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/company/new.jsp");
                rd.forward(request, response);

            }else{
                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "企業情報が追加されました。");

                response.sendRedirect(request.getContextPath() + "/business/new_select");
            }
        }
    }

}

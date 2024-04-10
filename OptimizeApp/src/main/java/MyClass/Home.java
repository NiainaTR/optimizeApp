package MyClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import MyClass.Product;
/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArrayList<Product> listAll = new ArrayList<>();
	
    /**
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public Home() throws ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
    	MySql mysql = new MySql();
		mysql.connectToDB();
		
		ResultSet rs = mysql.selectAll("products");
		
		try {
		    // Parcourir le ResultSet pour lire les données
		    while (rs.next()) {
		        // Accéder aux colonnes en utilisant les méthodes get appropriées
		    	Product p = new Product();
		    	
		        p.id = rs.getInt("id");
		        p.nom = rs.getString("name");
		        p.taille = rs.getInt("taille");
		        p.chambres = rs.getInt("chambres");
		        p.price = rs.getInt("price");
		        p.phone = rs.getString("phone");
		        
		        listAll.add(p);
		     }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // Assurez-vous de fermer le ResultSet après utilisation
		    try {
		        if (rs != null) {
		            rs.close();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("products" ,  listAll);
		
		request.getRequestDispatcher("/index.jsp").forward(request , response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/

}

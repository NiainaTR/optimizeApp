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

/**
 * Servlet implementation class ServletInsert
 */
public class ServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MySql mysql = new MySql();
    /**
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsert() throws ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
        mysql.connectToDB();
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("name");
		int  taille = Integer.valueOf(request.getParameter("taille")).intValue();
		int  chambre  = Integer.valueOf(request.getParameter("chambre")).intValue();
		int price =  Integer.valueOf(request.getParameter("price")).intValue();
		String phone = request.getParameter("phone");
		
		
		request.setAttribute("name" , name);
		request.setAttribute("taille" , taille);
		request.setAttribute("chambre" , chambre);
		request.setAttribute("price" , price);
		request.setAttribute("phone" , phone);
		
		
		
		
		/*
		// Appeler la méthode selectAll pour récupérer tous les enregistrements d'une table
		ResultSet rs = mysql.selectAll("nom_de_la_table");
		
		ArrayList<ArrayList<Integer>> tableauDonnees = new ArrayList<>();
		ArrayList<Integer> prices = new ArrayList<>();
		
		try {
		    // Parcourir le ResultSet pour lire les données
		    while (rs.next()) {
		        // Accéder aux colonnes en utilisant les méthodes get appropriées
		        int id = rs.getInt("id");
		        int t = rs.getInt("taille");
		        int c = rs.getInt("chambre");
		        int p = rs.getInt("price");
		        ArrayList<Integer> ligne = new ArrayList<>();
		        ligne.add(id);
		        ligne.add(t);
		        ligne.add(c);
		        
		        prices.add(p);
		        
		        // Ajouter cette liste à notre tableau de données à 2 dimensions
		        tableauDonnees.add(ligne);
		        
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // Assurez-vous de fermer le ResultSet après utilisation
		    try {
		    	// Obtenez la taille des lignes et des colonnes
				int lignes = tableauDonnees.size();
				int colonnes = tableauDonnees.isEmpty() ? 0 : tableauDonnees.get(0).size();

				// Créer un tableau double avec la même taille
				double[][] tableauDouble = new double[lignes][colonnes];

				// Remplir le tableau double à partir de l'ArrayList
				for (int i = 0; i < lignes; i++) {
				    for (int j = 0; j < colonnes; j++) {
				        tableauDouble[i][j] = tableauDonnees.get(i).get(j);
				    }
				}
				
				
				// Créer un tableau double[] avec la même taille que l'ArrayList
				double[] tableauDoublePrice = new double[prices.size()];

				// Copier les éléments de l'ArrayList dans le tableau double[]
				
				int i = 0;
				for(int p : prices) {
					tableauDoublePrice[i] = (double)p;
					i++;
				}
				
				PricePredictor pre = new PricePredictor(tableauDouble);
				
				pre.gradientDescent(tableauDouble, tableauDoublePrice);
				
				double newHouse[] = new double[3];
				newHouse[0] = 1.0;
				newHouse[1] = (double)taille;
				newHouse[3] = (double)chambre;
				
				
				
				
				double pricePredict = pre.predictPrice(newHouse);
				
				
				System.out.println("io e "+pricePredict);
		    	
		    	
		    	
		        rs.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		*/
		
		
		request.getRequestDispatcher("/pageEstim.jsp").forward(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int  taille = Integer.valueOf(request.getParameter("taille")).intValue();
		int  chambre  = Integer.valueOf(request.getParameter("chambre")).intValue();
		int price =  Integer.valueOf(request.getParameter("price")).intValue();
		String phone = request.getParameter("phone");
		
		String[] values =  {name , String.valueOf(taille) , String.valueOf(chambre) , String.valueOf(price) , phone};
		String[] columns = {"name" , "taille" , "chambres" , "price" , "phone"};
		
		mysql.insert("products" , columns  , values);
		
		response.sendRedirect("./Home");
	}

}

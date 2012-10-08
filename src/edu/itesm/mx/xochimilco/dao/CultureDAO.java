package edu.itesm.mx.xochimilco.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.google.appengine.api.rdbms.AppEngineDriver;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class CultureDAO implements CultureDAOInterface{
private Connection connection;
private static CultureDAO dao;
private CultureDAO(){
}
public static CultureDAO getInstance(){
if(dao == null){
dao = new CultureDAO();
}
return dao;
}


@Override
public JSONArray getSites() {
// TODO Auto-generated method stub
JSONArray sites = new JSONArray();
        try {
                if(connection.isClosed()) openConnection();
        } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
         Statement statement;
        try {
                statement = connection.createStatement();
              ResultSet rs = statement.executeQuery("select title, description, latitude, longitude, image from sites");
              while(rs.next()){
                        JSONObject s = new JSONObject();
                        s.put("title", rs.getString(1));
                        s.put("img",rs.getString(5));
                        s.put("lat", rs.getDouble(3));
                        s.put("lon", rs.getDouble(4));
                        sites.add(s);
                  }
               
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
      // Result set get the result of the SQL query
       
       
        return sites;
}


@Override
public void openConnection() {
// TODO Auto-generated method stub
try {
             DriverManager.registerDriver(new AppEngineDriver());
} catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}
try {
             connection = DriverManager.getConnection(
                              "jdbc:google:rdbms://xochimilcoccm:xochimilco/xochimilco");
} catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}
}


@Override
public void closeConnection() {
// TODO Auto-generated method stub
try {
connection.close();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
@Override
public void agrega(String n, String d){
	// TODO Auto-generated method stub
	Statement statement;
	try {
		statement = connection.createStatement();
		statement.executeUpdate("insert into sites(title,description)" + "VALUES('" + n + "','" + d +"')");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


}

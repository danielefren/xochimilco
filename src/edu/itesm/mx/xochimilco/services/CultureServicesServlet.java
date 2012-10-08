package edu.itesm.mx.xochimilco.services;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class CultureServicesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("application/json");
		
		JSONObject json, ob;
		JSONArray array;
		
		int  opcion = Integer.parseInt( req.getParameter("opcion") );
		switch( opcion  ){
		case 1:
				System.out.println("Salida" +  opcion);
				 json = new JSONObject();
				json.put("lat", 19.274085 );
				json.put("lon",  -99.138347);				
				
				 array = new JSONArray();
				array.add(json);
				
				 ob = new JSONObject();
				ob.put("places", array);
				resp.getWriter().println( ob.toString() );
				break;
		case 2:
			json = new JSONObject();
			json.put("lat", 19.29846649 );
			json.put("lon",  -99.099212179);		
			json.put("title",  "Chinampas A");
			json.put("img",  "imgs/mercado.jpg");
			array = new JSONArray();
			array.add(json);
		    
			json = new JSONObject();
			json.put("lat", 19.285828 );//19.29846649,-99.099212179
			json.put("lon",  -99.075866);		
			json.put("title",  "Chinampas B");
			json.put("img",  "imgs/viveroNeza.jpg");
			
			array.add(json);

			json = new JSONObject();
			json.put("lat", 19.2555627 );//19.29846649,-99.099212179
			json.put("lon",  -99.09983538);		
			json.put("title",  "Chinampas C");
			json.put("img",  "imgs/LagunaToro.jpg");
			
			array.add(json);
			json = new JSONObject();
			json.put("lat", 19.26048966 );//19.29846649,-99.099212179
			json.put("lon",  -99.096723);		
			json.put("title",  "Chinampas D");
			json.put("img",  "imgs/xaltocan.jpg");
			
			array.add(json)	;	
			
			json = new JSONObject();
			json.put("lat", 19.265270 );//19.29846649,-99.099212179
			json.put("lon",  -99.108567);		
			json.put("title",  "Chinampas E");
			json.put("img",  "imgs/caltongo.jpg");
			
			array.add(json)	;
			
			ob = new JSONObject();
			ob.put("places", array);
			
			resp.getWriter().println( ob.toString() );
			break;
			
		case 3:
			json = new JSONObject();
			array = new JSONArray();
			
			json.put("lat", 19.261178);
			json.put("lon", -99.101315);
			json.put("title", "Santa Crucita de Analco");
			json.put("img",  "imgs/SantaCrucitaAnalco.jpg");
			array.add(json);
			
			json.put("lat", 19.254108);
			json.put("lon", -99.012871);
			json.put("title", "San Juan Bautista Tlateuhchi");
			json.put("img",  "imgs/SanJuanBautistaTlateuhchi.jpg");
			array.add(json);
			
			json.put("lat", 19.267133);
			json.put("lon", -99.10408);
			json.put("title", "La Concepción de María Tlacoapa");
			json.put("img",  "imgs/ConcepcionMariaTlacoapa.jpg");
			array.add(json);
			
			json.put("lat", 19.257688);
			json.put("lon", -99.10666);
			json.put("title", "San Pedro Tlalnahuac");
			json.put("img",  "imgs/SanPedroTlalnahuac.jpg");
			array.add(json);
			
			json.put("lat", 19.268343);
			json.put("lon", -99.102376);
			json.put("title", "La Asunción Colhuacatzinco");
			json.put("img",  "imgs/LaAsuncion.jpg");
			array.add(json);
			
			ob = new JSONObject();
			ob.put("places", array);
			
			resp.getWriter().println(ob.toString());
			break;
		}
	}

}

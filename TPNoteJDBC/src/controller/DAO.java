package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

import utile.Bdd;

public class DAO {
	
	private String table;
	private Connection connexion;
	private PreparedStatement preparedStatement;
	private Statement statement;
	
	public DAO(String tableBdd) {
		table = tableBdd;
		connexion = Bdd.connexionBdd;
	}
	
	public ResultSet find(HashMap<String, String> data) {
		ResultSet resulat = null;
		
		String conditions = "1";
		String fields="*";
		String order= table+".id DESC";
		String othertable="";
		
		 if(data != null){
	        if(data.get("conditions") != null){
	        	conditions = data.get("conditions");
	        }
	        if(data.get("fields") != null){
	        	fields = data.get("fields");
	        }
	        if(data.get("order") != null){
	        	order = data.get("order");
	        }
	        if(data.get("othertable") != null){
	        	othertable = data.get("othertable");
	        }
		 }
        
        String sql= "SELECT "+fields+" FROM "+table+" "+othertable+" WHERE "+conditions+" ORDER BY "+order;
        
        try {
        	Statement statement = connexion.createStatement();
    		resulat = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resulat;
	}
	
	public ResultSet read(int id) {
		ResultSet resulat = null;
		
		String sql= "SELECT * FROM "+table+" WHERE id = ?";
		
		try {
        	preparedStatement = connexion.prepareStatement(sql);
        	preparedStatement.setInt(1, id);
			resulat = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resulat;
	}
	
	public int save(HashMap<String, String> data) {
		int resulat = 0;
		
		 String sql="INSERT INTO "+table+"(";
         for(Object key : data.keySet().toArray()) {
             sql+="`"+key+"`,";
         }
         
         //suppression de la virgule
         sql = sql.substring(0, sql.length()-1);
         sql+=" ) VALUES (";
         for(String value : data.values()) {
        	 try {
	    		 int numberValue = Integer.parseInt(value);
	    		 sql+=numberValue+",";
     		} catch (NumberFormatException e){
     			 sql+="'"+value+"',";
     		}
         }
         sql = sql.substring(0, sql.length()-1);
         sql+=" )";
         
     
         try {
        	statement = connexion.createStatement();
			resulat = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
         
        // resulat 1 ok si 0 ko
		return resulat;
		
	}
	
	public int update(HashMap<String, String> data) {
		int resulat = 0;
		
		String conditions = "1";
		String modification="";
		
		 if(data != null){
		        if(data.get("conditions") != null){
		        	conditions = data.get("conditions");
		        }
		        if(data.get("modification") != null){
		        	modification = data.get("modification");
		        }
		 }
		 
		 String sql="UPDATE "+ table+" SET "+modification+" WHERE "+ conditions;
		 try {
			 	statement = connexion.createStatement();
				resulat = statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return resulat;
		
	}
	
	public int delete(HashMap<String, String> data) {
		int resulat = 0;
		
        String sql="DELETE FROM "+table+" WHERE ";
        for(Entry<String, String> entryData : data.entrySet()) {
           sql+= "`"+entryData.getKey()+"` = "+entryData.getValue()+" AND";
        }
        //suppression du AND en trop
        sql = sql.substring(0, sql.length()-3);
        
        try {
        	statement = connexion.createStatement();
			resulat = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resulat;
	}
	
	public void closeStatement() {
		try {
			if(statement != null) {
				statement.close();
			}
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

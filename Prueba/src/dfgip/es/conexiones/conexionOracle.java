package dfgip.es.conexiones;

import java.sql.*;


public class conexionOracle {

	Connection conn;
	ResultSet rs=null;
	PreparedStatement ps;
	/*Libra*/
	String usuLibra="LIBRA";
	String pwdLibra="LIBRA";
	String urlLibra = "jdbc:oracle:thin:@//racufg-scan:1521/LBR";
	/*Urumea*/
	String usuUrumea="LIBRA_URUMEA";
	String pwdUrumea="LIBRA_URUMEA";
	String urlUrumea = "jdbc:oracle:thin:@//racufg-scan:1521/RRHH";
	/*Pruebas*/
	String usuPruebas="LIBRAU";
	String pwdPruebas="LIBRAU";
	String urlPruebas = "jdbc:oracle:thin:@192.168.1.37:1521:LIBRAUFG";
	
	public conexionOracle(){
		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//conn = DriverManager.getConnection(urlPruebas,usuPruebas,pwdPruebas);
			//conn = DriverManager.getConnection(urlUrumea,usuUrumea,pwdUrumea);
			conn = DriverManager.getConnection(urlLibra,usuLibra,pwdLibra);
			//System.out.println("Conexion a Base de Datos "+urlLibra+".........OK");

		}catch(Exception e){
			System.out.println(e.getMessage());}
	}
	
	public Connection getConexion(){
		return conn;
	}
	
	public void insertar_dfg_ventas_farmadata(String vfecha, String vcoop, String varticulo, String vcantidad, String vbrick, String vsanibrick){
		try{
			String sql="INSERT INTO DFG_FARMADATA_VENTAS (FECHA,COOP,ARTICULO,CANTIDAD,COD_BRICK,COD_SANIBRICK) "
					+ "VALUES (?,?,?,?,?,?)";
			//System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vfecha);
			ps.setString(2, vcoop);
			ps.setString(3, varticulo);
			ps.setString(4, vcantidad);
			ps.setString(5, vbrick);
			ps.setString(6, vsanibrick);
			ps.executeUpdate();
		}catch(Exception e){
			borrar_dfg_ventas_farmadata();
			System.out.println(e);}
	}
	
	public void insertarbatch_dfg_ventas_farmadata(){
		try{
			String sql="INSERT INTO DFG_FARMADATA_VENTAS (FECHA,COOP,ARTICULO,CANTIDAD,COD_BRICK,COD_SANIBRICK) "
					+ "VALUES (?,?,?,?,?,?)";
			//System.out.println(sql);
			ps = conn.prepareStatement(sql);
		}catch(Exception e){
			borrar_dfg_ventas_farmadata();
			System.out.println(e);}
	}
	
	public void UPDATE_dfg_ventas_farmadata(){
		try{
			String sql="UPDATE DFG_FARMADATA_VENTAS SET CANTIDAD = substr(CANTIDAD,1,1) || translate (substr(CANTIDAD,2),'-','0')";
			//System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.execute();
		}catch(Exception e){
			borrar_dfg_ventas_farmadata();
			System.out.println(e);}
	}
	
	public void addbatch_dfg_ventas_farmadata(String vfecha, String vcoop, String varticulo, String vcantidad, String vbrick, String vsanibrick){
		try{
			ps.setString(1, vfecha);
			ps.setString(2, vcoop);
			ps.setString(3, varticulo);
			ps.setString(4, vcantidad);
			ps.setString(5, vbrick);
			ps.setString(6, vsanibrick);
			ps.addBatch();		
			
		}catch(Exception e){
			borrar_dfg_ventas_farmadata();
			System.out.println(e);}
	}
	
	public void ejecutarbacth() throws SQLException{
		int[] updateCounts = ps.executeBatch();
	}

	public void borrar_dfg_ventas_farmadata(){
		try{
			String sql="DELETE FROM DFG_FARMADATA_VENTAS";
					
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeQuery();
		}catch(Exception e){
			System.out.println(e);}
	}
	
	public void borrar_dfg_ventas_cofano(){
		try{
			String sql="DELETE FROM DFG_FARMADATA_VENTAS"
					+"WHERE COOP IN ('"+0322+"','"+0364+"')";
					
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeQuery();
		}catch(Exception e){
			System.out.println(e);}
	}
	
	public ResultSet sanibricks(){
		try{
			rs = null;
			String sql="SELECT DFV.FECHA, DFV.COOP, DFV.ARTICULO, lpad(sum (to_number (DFV.CANTIDAD)),6,0), DFV.COD_SANIBRICK "
					+ "from DFG_FARMADATA_VENTAS DFV "
					+ "WHERE to_number(DFV.CANTIDAD)<>0 "
					+ "and to_number(DFV.ARTICULO)<>0 "
					+ "group by DFV.FECHA, DFV.COOP, DFV.ARTICULO, DFV.COD_SANIBRICK";
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();	
		}catch(Exception e){
			borrar_dfg_ventas_farmadata();
			System.out.println(e);}
		return rs;
	}
	
	public ResultSet bricks(){
		try{
			rs = null;
			String sql="SELECT DFV.FECHA, DFV.COOP, DFV.ARTICULO, lpad(sum (to_number (DFV.CANTIDAD)),6,0), DFV.COD_BRICK "
					+ "from DFG_FARMADATA_VENTAS DFV "
					+ "WHERE to_number(DFV.CANTIDAD)<>0 "
					+ "and to_number(DFV.ARTICULO)<>0 "
					+ "group by DFV.FECHA, DFV.COOP, DFV.ARTICULO, DFV.COD_BRICK";
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		}catch(Exception e){
			System.out.println(e);}
		return rs;
	}
	
	public Connection cerrarConexion(){
		try{
			conn.close();
			//System.out.println("Cerrando conexion a "+urlLibra+".........OK");
		}catch(SQLException ex){
			System.out.println(ex);
		}//endTry
		conn =null;
		return conn;
	}//endFunction
	
	public ResultSet buscar(String vTabla){
		
		try{
			rs = null;
			String sql="SELECT * FROM "+vTabla;
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
		
		}catch(Exception e){
			System.out.println(e);}
		return rs;
	}
	
	public void printar(){
		try{
		 while(rs.next()){
			 System.out.println("'"+rs.getString(2)+"',,1','"+rs.getString("COD_BRICK")+"',,,'"+rs.getString("ARTICULO")+",'1','1',,"+rs.getString(4)+",,,'"+rs.getString(1)+"'");
		 }
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
}

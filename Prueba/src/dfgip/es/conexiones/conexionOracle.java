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
	/***
	 * Clase constructor
	 */
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
	/***
	 * 
	 * @param vfecha fecha a insertar en la BD.
	 * @param vcoop Cooperativa a insertar en la BD.
	 * @param varticulo Articulo a insertar en la BD.
	 * @param vcantidad Cantidad a insertar en la BD.
	 * @param vbrick Brick a insertar en la BD.
	 * @param vsanibrick SaniBrick a insertar en la BD.
	 * Esta función no se utiliza para la inserccion de Lineas y que su ejecucion relentiza mucho el proceso.
	 */
	public void insertarDfgVentasFarmadata(String vfecha, String vcoop, String varticulo, String vcantidad, String vbrick, String vsanibrick){
		try{
			String sql="INSERT INTO DFG_FARMADATA_VENTAS (FECHA,COOP,ARTICULO,CANTIDAD,COD_BRICK,COD_SANIBRICK) "
					+ "VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vfecha);ps.setString(2, vcoop);ps.setString(3, varticulo);
			ps.setString(4, vcantidad);ps.setString(5, vbrick);ps.setString(6, vsanibrick);
			ps.executeUpdate();
		}catch(Exception e){
			borrarDfgVentasFarmadata();
			System.out.println(e);}
	}
	/***
	 * Funcion que prepara la sentencia de INSERT antes de generar todos los BATCH, pa su posterior ejecucion.
	 */
	public void insertarBatchdDfgVentasFarmadata(){
		try{
			String sql="INSERT INTO DFG_FARMADATA_VENTAS (FECHA,COOP,ARTICULO,CANTIDAD,COD_BRICK,COD_SANIBRICK) "
					+ "VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
		}catch(Exception e){
			borrarDfgVentasFarmadata();
			System.out.println(e);}
	}
	
	public void correcionCantidad(){
		try{
			String sql="UPDATE DFG_FARMADATA_VENTAS SET CANTIDAD = substr(CANTIDAD,1,1) || translate (substr(CANTIDAD,2),'-','0')";
			ps = conn.prepareStatement(sql);
			ps.execute();
		}catch(Exception e){
			borrarDfgVentasFarmadata();
			System.out.println(e);}
	}
	/***
	 * Correcion cuando los Sanibricks son 99999 pone los bricks a 99999.
	*/
	public void correcionCodBrick(){
		try{
			String sql="UPDATE DFG_FARMADATA_VENTAS SET COD_BRICK='99999' WHERE COD_SANIBRICK='999999'";
			ps = conn.prepareStatement(sql);
			ps.execute();
		}catch(Exception e){
			borrarDfgVentasFarmadata();
			System.out.println(e);}
	}
	/***
	 * Correcion de la numeracion de la coop. de 0232 a 0234.
	 */
	public void correcionCoopJaen(){
		try{
			String sql="UPDATE DFG_FARMADATA_VENTAS SET COOP='0234' WHERE COOP='0232'";
			ps = conn.prepareStatement(sql);
			ps.execute();
		}catch(Exception e){
			borrarDfgVentasFarmadata();
			System.out.println(e);}
	}
	/***
	 * Correcion de la numeracion de la coop. de 0352 a 0354.
	 */
	public void correcionCoopCofarca(){
		try{
			String sql="UPDATE DFG_FARMADATA_VENTAS SET COOP='0354' WHERE COOP='0352'";
			ps = conn.prepareStatement(sql);
			ps.execute();
		}catch(Exception e){
			borrarDfgVentasFarmadata();
			System.out.println(e);}
	}
	/***
	 * 
	 * @param vfecha fecha a insertar en la BD.
	 * @param vcoop Cooperativa a insertar en la BD.
	 * @param varticulo Articulo a insertar en la BD.
	 * @param vcantidad Cantidad a insertar en la BD.
	 * @param vbrick Brick a insertar en la BD.
	 * @param vsanibrick SaniBrick a insertar en la BD.
	 * Esta función se utiliza para la generar el BATCH.
	 */
	public void addBatchDfgVentasFarmadata(String vfecha, String vcoop, String varticulo, String vcantidad, String vbrick, String vsanibrick){
		try{
			ps.setString(1, vfecha);
			ps.setString(2, vcoop);
			ps.setString(3, varticulo);
			ps.setString(4, vcantidad);
			ps.setString(5, vbrick);
			ps.setString(6, vsanibrick);
			ps.addBatch();		
			
		}catch(Exception e){
			borrarDfgVentasFarmadata();
			System.out.println(e);}
	}
	
	public void ejecutarBacth() throws SQLException{
		int[] updateCounts = ps.executeBatch();
	}
	/***
	 * Borrar el contenido de la tabla DFG_FARMADATA_VENTAS.
	 */
	public void borrarDfgVentasFarmadata(){
		try{
			String sql="DELETE FROM DFG_FARMADATA_VENTAS";
					
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeQuery();
		}catch(Exception e){
			System.out.println(e);}
	}
	
	public void correcoinDfgVentasCofano(){
		try{
			String sql="DELETE FROM DFG_FARMADATA_VENTAS WHERE COOP IN ('0322','0364')";		
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeQuery();
		}catch(Exception e){
			System.out.println(e);}
	}
	/***
	 * 
	 * @return el ResultSet de SaniBricks
	 */
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
			borrarDfgVentasFarmadata();
			System.out.println(e);}
		return rs;
	}
	/***
	 * 
	 * @return el ResultSet de Bricks
	 */
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
	/***
	 * 
	 * @return conxion = null
	 */
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
}

package dbcpTest.jdbcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author zq
 *
 */
public class JdbcUtil3 {
	
	//Connection pool
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	static{
		try {
			Properties prop = loadJdbcConfig("jdbc.properties");
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pwd = prop.getProperty("pwd");
			int poolSize = new Integer(prop.getProperty("initialSize"));
			
			Class.forName(driver);
			for(int i = 0; i < poolSize; i++){
				Connection conn = DriverManager.getConnection(url, user, pwd);
				pool.addLast((Connection) conn);										
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private static Properties loadJdbcConfig(String filename) throws IOException{
		InputStream in = null;
		try {
			in = JdbcUtil3.class
								.getClassLoader()
								.getResourceAsStream(filename);
			Properties prop = new Properties();
			prop.load(in);
			return prop;
		}finally{
			if(in != null){
				in.close();
			}
		}
	}
	
	public static Connection getConnection(){
		synchronized (pool) {
			if(pool.size() == 0){
				try {
					pool.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
			Connection conn = pool.removeFirst();;
			
			return new ConnectionWrapper(conn);
		}
	}
	
	public static void release(ResultSet rs, Statement st, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				st = null;
			}
		}
		
	}
	
  static class ConnectionWrapper implements Connection {

		private Connection conn;
		
		public void close() throws SQLException {
			synchronized (pool) {
				pool.addLast(conn);
				pool.notify();
			}
		}
		
		public ConnectionWrapper(Connection conn) {
			this.conn = conn;
		}
		public <T> T unwrap(Class<T> iface) throws SQLException {
			return conn.unwrap(iface);
		}

		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return conn.isWrapperFor(iface);
		}

		public Statement createStatement() throws SQLException {
			return conn.createStatement();
		}

		public PreparedStatement prepareStatement(String sql)
				throws SQLException {
			return conn.prepareStatement(sql);
		}

		public CallableStatement prepareCall(String sql) throws SQLException {
			return conn.prepareCall(sql);
		}

		public String nativeSQL(String sql) throws SQLException {
			return conn.nativeSQL(sql);
		}

		public void setAutoCommit(boolean autoCommit) throws SQLException {
			conn.setAutoCommit(autoCommit);
		}

		public boolean getAutoCommit() throws SQLException {
			return conn.getAutoCommit();
		}

		public void commit() throws SQLException {
			conn.commit();
		}

		public void rollback() throws SQLException {
			conn.rollback();
		}

		public boolean isClosed() throws SQLException {
			return conn.isClosed();
		}

		public DatabaseMetaData getMetaData() throws SQLException {
			return conn.getMetaData();
		}

		public void setReadOnly(boolean readOnly) throws SQLException {
			conn.setReadOnly(readOnly);
		}

		public boolean isReadOnly() throws SQLException {
			return conn.isReadOnly();
		}

		public void setCatalog(String catalog) throws SQLException {
			conn.setCatalog(catalog);
		}

		public String getCatalog() throws SQLException {
			return conn.getCatalog();
		}

		public void setTransactionIsolation(int level) throws SQLException {
			conn.setTransactionIsolation(level);
		}

		public int getTransactionIsolation() throws SQLException {
			return conn.getTransactionIsolation();
		}

		public SQLWarning getWarnings() throws SQLException {
			return conn.getWarnings();
		}

		public void clearWarnings() throws SQLException {
			conn.clearWarnings();

		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return conn.createStatement(resultSetType, resultSetConcurrency);
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return conn.prepareStatement(sql, resultSetConcurrency);
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return conn.prepareCall(sql, resultSetType, resultSetConcurrency);
		}

		public Map<String, Class<?>> getTypeMap() throws SQLException {
			return conn.getTypeMap();
		}

		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			conn.setTypeMap(map);
		}

		public void setHoldability(int holdability) throws SQLException {
			conn.setHoldability(holdability);
		}

		public int getHoldability() throws SQLException {
			return conn.getHoldability();
		}

		public Savepoint setSavepoint() throws SQLException {
			return conn.setSavepoint();
		}

		public Savepoint setSavepoint(String name) throws SQLException {
			return conn.setSavepoint(name);
		}

		public void rollback(Savepoint savepoint) throws SQLException {
			conn.rollback(savepoint);
		}

		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			conn.releaseSavepoint(savepoint);
		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return conn.createStatement(resultSetType, resultSetConcurrency,
					resultSetHoldability);
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			return conn.prepareStatement(sql, resultSetType,
					resultSetConcurrency, resultSetHoldability);
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return conn.prepareCall(sql, resultSetType, resultSetConcurrency,
					resultSetHoldability);
		}

		public PreparedStatement prepareStatement(String sql,
				int autoGeneratedKeys) throws SQLException {
			return conn.prepareStatement(sql, autoGeneratedKeys);
		}

		public PreparedStatement prepareStatement(String sql,
				int[] columnIndexes) throws SQLException {

			return conn.prepareStatement(sql, columnIndexes);
		}

		public PreparedStatement prepareStatement(String sql,
				String[] columnNames) throws SQLException {
			return conn.prepareStatement(sql, columnNames);
		}

		public Clob createClob() throws SQLException {
			return conn.createClob();
		}

		public Blob createBlob() throws SQLException {
			return conn.createBlob();
		}

		public NClob createNClob() throws SQLException {
			return conn.createNClob();
		}

		public SQLXML createSQLXML() throws SQLException {
			return conn.createSQLXML();
		}

		public boolean isValid(int timeout) throws SQLException {
			return conn.isValid(timeout);
		}

		public void setClientInfo(String name, String value)
				throws SQLClientInfoException {
			conn.setClientInfo(name, value);
		}

		public void setClientInfo(Properties properties)
				throws SQLClientInfoException {
			conn.setClientInfo(properties);
		}

		public String getClientInfo(String name) throws SQLException {
			return conn.getClientInfo(name);
		}

		public Properties getClientInfo() throws SQLException {
			return conn.getClientInfo();
		}

		public Array createArrayOf(String typeName, Object[] elements)
				throws SQLException {
			return conn.createArrayOf(typeName, elements);
		}

		public Struct createStruct(String typeName, Object[] attributes)
				throws SQLException {
			return conn.createStruct(typeName, attributes);
		}

		@Override
		public void setSchema(String schema) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getSchema() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void abort(Executor executor) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getNetworkTimeout() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
}


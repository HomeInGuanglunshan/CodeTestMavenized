package dbcpTest.jdbcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

/**
 * @author zq
 *
 */
public class JdbcUtil {
	
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
			in = JdbcUtil.class
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
			final Connection conn = pool.removeFirst();;
			//proxy
			Object connProxy = Proxy.newProxyInstance(JdbcUtil.class.getClassLoader(),
								new Class[]{Connection.class}, 
								new InvocationHandler() {
									
									public Object invoke(Object proxy, Method method, Object[] args)
											throws Throwable {
										if(method.getName().equals("close")){
											synchronized (pool) {
												pool.addLast(conn);
												pool.notify();
												return null;
											}
										}
										return method.invoke(conn, args);
									}
								});
			return (Connection) connProxy;
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
}

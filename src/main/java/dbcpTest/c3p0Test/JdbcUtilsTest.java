package dbcpTest.c3p0Test;
import java.sql.Connection;  
import java.sql.SQLException;  
  
import org.junit.Test;  
  
/** 
 * JdbcUtils用来获取Connection * 底层使用了c3p0连接池！ * 还需要mysql驱动 
 *  
 * @author pplsunny 
 * 
 */  
public class JdbcUtilsTest {  
    /** 
     * 底层使用了c3p0连接池，说明我们还要提供c3p0配置文件 
     *  
     * @throws SQLException 
     */  
    @Test  
    public void testGetConnection() throws SQLException {  
  
        // System.setProperty("com.mchange.v2.c3p0.cfg.xml","classloader:/resources/c3p0-config.xml");  
  
        // System.setProperty("com.mchange.v2.c3p0.cfg.xml",System.getProperty("user.dir")+"/WebContent/WEB-INF/c3p0-config.xml");  
        System.setProperty("com.mchange.v2.c3p0.cfg.xml", System.getProperty("user.dir") + "/src/dbcpTest/c3p0Test/c3p0-config.xml");  
  
        String aa = System.getProperty("user.dir");  
        System.out.println("=======" + aa);  
        Connection con = JdbcUtils.getConnection();  
        System.out.println(con);  
        JdbcUtils.releaseConnection(con);  
        System.out.println(con.isClosed());  
    }  
}  
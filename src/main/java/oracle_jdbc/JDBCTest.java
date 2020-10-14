package oracle_jdbc;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.util.ArrayList;  
import java.util.List;  
  
import javax.sql.PooledConnection;  
  
import oracle.jdbc.pool.OracleConnectionPoolDataSource;  
  
public class JDBCTest {  
    private String url = null;  
  
    /* 
     *  
     */  
    public JDBCTest(String sHostName, String sPortNumber, String sSid) {  
//        url = "jdbc:oracle:thin:@" + sHostName + ":" + sPortNumber + ":" + sSid;  
        url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP) (HOST="+sHostName+") (PORT="+sPortNumber+"))) (CONNECT_DATA=(SID="+sSid+")))";
        // if JDK1.6 you also can use as  
        // url = "jdbc:oracle:thin:@" + sHostName + ":" + sPortNumber + "/" + sSid;  
    }  
  
    public List<String> getList(String sUsrName, String sPassword, String sql) {  
        List<String> resultList = new ArrayList<String>();  
        try {  
            OracleConnectionPoolDataSource ocpds = new OracleConnectionPoolDataSource();  
            String url1 = System.getProperty("JDBC_URL");  
            if (url1 != null)  
                url = url1;  
            ocpds.setURL(url);  
            ocpds.setUser(sUsrName);  
            ocpds.setPassword(sPassword);  
            PooledConnection pc = ocpds.getPooledConnection();  
            Connection conn = pc.getConnection();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            ResultSet rset = pstmt.executeQuery();  
            while (rset.next()) {  
                resultList.add(rset.getString(1));  
            }  
            rset.close();  
            pstmt.close();  
            conn.close();  
            pc.close();  
        } catch (Exception e) {  
        	e.printStackTrace();
        }  
        return resultList;  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
                // use you real info  
        String sUsrName = "ampmonitor";  
        String sPassword = "shsnc2015";  
        String sql = "select * from top_sql_test";  
  
        JDBCTest jdbctest = new JDBCTest("192.168.11.68", "1521", "itctest");  
        List<String> list = jdbctest.getList(sUsrName, sPassword, sql);  
        System.out.println(list.size());  
    }  
  
}  

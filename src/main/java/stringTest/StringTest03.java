package stringTest;

public class StringTest03 {

	public static void main(String[] args) {
		String sql = "";
		String [] os_type={"WINDOWS", "LINUX", "AIX", "SOLARIS", "HP-UX", "Oracle", "DB2", "SQLServer", "Mysql", "Weblogic", "Websphere", "Apeche", "Tomcat", "IIS"};
		for(int i=0;i<os_type.length;i++){
	    	sql+=" and name like '%"+os_type[i]+"%'";
	    	System.out.println(sql);
	    }
		//System.out.println(sql);
	}

}

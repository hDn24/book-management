package dont.ok.connect;

import java.sql.Connection;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MySqlService {
	protected Connection conn;
	public MySqlService() {
		try {
			String strlConn = "jdbc:mysql://localhost/csdlquanlysach?useUnicode=true&characterEncoding=utf-8";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			conn = driver.connect(strlConn, pro);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

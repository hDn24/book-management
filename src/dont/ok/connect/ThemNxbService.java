package dont.ok.connect;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class ThemNxbService extends MySqlService {
	public void themNhaXuatBan(String maNhaxb, String tenNhaxb, String diaChiNhaxb, String sdtNhaxb) {
		try {
			String sql = "insert into nhaxuatban values(?,?,?,?)";
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, maNhaxb);
			preStatement.setString(2, tenNhaxb);
			preStatement.setString(3, diaChiNhaxb);
			preStatement.setString(4, sdtNhaxb);
			int x = preStatement.executeUpdate();
			if(x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm sách thành công");
			}
			else JOptionPane.showMessageDialog(null, "Thêm sách thất bại");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}

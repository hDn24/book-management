package dont.ok.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import dont.ok.model.Sach;

public class ThemSachService extends MySqlService {
	public void themSach(String maSach, String tenSach, String maNhaXuatBan, int soTrang) {
		try {
			String sql = "insert into sach values(?,?,?,?)";
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, maSach);
			preStatement.setString(2, tenSach);
			preStatement.setString(3, maNhaXuatBan);
			preStatement.setInt(4, soTrang);
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

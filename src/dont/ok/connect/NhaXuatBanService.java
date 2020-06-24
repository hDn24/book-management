package dont.ok.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dont.ok.model.NhaXuatBan;

public class NhaXuatBanService extends MySqlService {
	public ArrayList<NhaXuatBan> layToanBoNhaXuatBan() {
		ArrayList<NhaXuatBan> dsNxb = new ArrayList<NhaXuatBan>();
		try {
			String sql="select * from nhaxuatban";
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet result = preStatement.executeQuery();
			while(result.next()) {
				NhaXuatBan nxb = new NhaXuatBan();
				nxb.setMaNhaXuatBan(result.getString(1));
				nxb.setTenNhaXuatBan(result.getString(2));
				nxb.setDiaChi(result.getString(3));
				nxb.setDienThoai(result.getString(4));
				dsNxb.add(nxb);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return dsNxb;
	}
}

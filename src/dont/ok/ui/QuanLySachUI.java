package dont.ok.ui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dont.ok.connect.NhaXuatBanService;
import dont.ok.connect.ThemNxbService;
import dont.ok.model.NhaXuatBan;

public class QuanLySachUI extends JFrame {
	JTextField txtManxb, txtTenNxb, txtDiachi, txtDienthoai;
	JButton btnVeTruoc, btnVeSau;
	JLabel lblStep;
	
	JButton btnThem, btnLuu, btnSua, btnXoa;
	
	DefaultTableModel dtmNxb;
	JTable tblNXB;
	
	JButton btnTimKiem;
	
	ArrayList<NhaXuatBan>dsNXB = null;
	
	public QuanLySachUI(String title) {
		super(title);
		addControls();
		addEvents();
		
		hienThiToanBoNhaXuatBan();
	}

	private void hienThiToanBoNhaXuatBan() {
		NhaXuatBanService nxbService = new NhaXuatBanService();
		dsNXB = nxbService.layToanBoNhaXuatBan();
		
		dtmNxb.setRowCount(0);
		for(NhaXuatBan nxb : dsNXB) { 
			Vector<Object>vec = new  Vector<Object>();
			vec.add(nxb.getMaNhaXuatBan());
			vec.add(nxb.getTenNhaXuatBan());
			vec.add(nxb.getDiaChi());
			vec.add(nxb.getDienThoai());
			dtmNxb.addRow(vec);
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnTimKiem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimKiemUI ui = new TimKiemUI("Tìm kiếm sách");
				ui.showWindow();
			}
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ThemNxbService themNxbService =  new ThemNxbService();
				themNxbService.themNhaXuatBan(txtManxb.getText(), txtTenNxb.getText(), txtDiachi.getText(), txtDienthoai.getText());
				txtManxb.setText("");
				txtTenNxb.setText("");
				txtDiachi.setText("");
				txtDienthoai.setText("");
				hienThiToanBoNhaXuatBan();
			}
		});
	}

	private void addControls() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JPanel pnCenter = new JPanel();
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.add(pnNorth,BorderLayout.NORTH);
		con.add(pnCenter,BorderLayout.CENTER);
		con.add(pnSouth,BorderLayout.SOUTH);
		
		pnNorth.setLayout(new BorderLayout());
		JPanel pnChiTiet = new JPanel();
		pnNorth.add(pnChiTiet,BorderLayout.CENTER);
		JPanel pnThucHien = new JPanel();
		pnNorth.add(pnThucHien,BorderLayout.EAST);
		
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet,BoxLayout.Y_AXIS));
		JPanel pnNxb = new JPanel();
		JLabel lblNxb = new JLabel("Thông tin nhà xuất bản");
		lblNxb.setForeground(Color.BLUE);
		Font ft = new Font("arial",Font.BOLD,20);
		lblNxb.setFont(ft);
		pnNxb.add(lblNxb);
		pnChiTiet.add(pnNxb);
		
		JPanel pnManxb = new JPanel();
		JLabel lblManxb = new JLabel("Mã Nxb:");
		txtManxb = new JTextField(25);
		pnManxb.add(lblManxb);
		pnManxb.add(txtManxb);
		pnChiTiet.add(pnManxb);
		
		JPanel pnTennxb = new JPanel();
		JLabel lblTennxb = new JLabel("Tên Nxb:");
		txtTenNxb = new JTextField(25);
		pnTennxb.add(lblTennxb);
		pnTennxb.add(txtTenNxb);
		pnChiTiet.add(pnTennxb);
		
		JPanel pnDiachi = new JPanel();
		JLabel lblDiachi = new JLabel("Địa chỉ:");
		txtDiachi = new JTextField(25);
		pnDiachi.add(lblDiachi);
		pnDiachi.add(txtDiachi);
		pnChiTiet.add(pnDiachi);
		
		JPanel pnDienThoai = new JPanel();
		JLabel lblDienThoai = new JLabel("Điện thoại:");
		txtDienthoai = new JTextField(25);
		pnDienThoai.add(lblDienThoai);
		pnDienThoai.add(txtDienthoai);
		pnChiTiet.add(pnDienThoai);
		
		JPanel pnButtonChiTiet = new JPanel();
		btnVeTruoc = new JButton("Về trước");
		lblStep = new JLabel("1/10");
		btnVeSau = new JButton("Về sau");
		pnButtonChiTiet.add(btnVeTruoc);
		pnButtonChiTiet.add(lblStep);
		pnButtonChiTiet.add(btnVeSau);
		pnChiTiet.add(pnButtonChiTiet);
		
		pnThucHien.setLayout(new BoxLayout(pnThucHien, BoxLayout.Y_AXIS));
		JPanel pnButtonThem = new JPanel();
		btnThem = new JButton("Thêm");
		pnButtonThem.add(btnThem);
		pnThucHien.add(pnButtonThem);
		
		JPanel pnButtonLuu = new JPanel();
		btnLuu = new JButton("Lưu");
		pnButtonLuu.add(btnLuu);
		pnThucHien.add(pnButtonLuu);
		
		
		JPanel pnButtonSua = new JPanel();
		btnSua = new JButton("Sửa");
		pnButtonSua.add(btnSua);
		pnThucHien.add(pnButtonSua);
		
		JPanel pnButtonXoa = new JPanel();
		btnXoa = new JButton("Xóa");
		pnButtonXoa.add(btnXoa);
		pnThucHien.add(pnButtonXoa);
		
		pnCenter.setLayout(new BorderLayout());
		dtmNxb = new DefaultTableModel();
		dtmNxb.addColumn("Mã nhà XB");
		dtmNxb.addColumn("Tên nhà XB");
		dtmNxb.addColumn("Địa chỉ ");
		dtmNxb.addColumn("Điện thoại");
		tblNXB = new JTable(dtmNxb);
		JScrollPane scTable = new JScrollPane(tblNXB,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable,BorderLayout.CENTER);
		
		JPanel pnButtonOfSouth = new JPanel();
		pnButtonOfSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnTimKiem = new JButton("Tìm kiếm");
		pnButtonOfSouth.add(btnTimKiem);
		pnSouth.add(pnButtonOfSouth);
		
		TitledBorder borderThongTinChiTiet=
				new TitledBorder(
						BorderFactory.createLineBorder(Color.RED),
						"Thông tin chi tiết");
		pnChiTiet.setBorder(borderThongTinChiTiet);
		
		TitledBorder borderThucHien=
				new TitledBorder(
						BorderFactory.createLineBorder(Color.BLUE),
						"Thực hiện");
		pnThucHien.setBorder(borderThucHien);
		
		lblManxb.setPreferredSize(lblDienThoai.getPreferredSize());
		lblTennxb.setPreferredSize(lblDienThoai.getPreferredSize());
		lblDiachi.setPreferredSize(lblDienThoai.getPreferredSize());
		
		btnThem.setIcon(new ImageIcon("images/them.png"));
		btnLuu.setIcon(new ImageIcon("images/save.png"));
		btnSua.setIcon(new ImageIcon("images/edit.png"));
		btnXoa.setIcon(new ImageIcon("images/remove.png"));
		
		btnVeSau.setIcon(new ImageIcon("images/next.png"));
		btnVeTruoc.setIcon(new ImageIcon("images/previous.png"));
		
		
		TitledBorder borderDanhSachNXb =
				new TitledBorder(
						BorderFactory.createLineBorder(Color.BLUE),
						"Danh sách nhà xuất bản");
		pnCenter.setBorder(borderDanhSachNXb);
		
		btnTimKiem.setIcon(new ImageIcon("images/search.png"));
	}
	public void showWindow() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}


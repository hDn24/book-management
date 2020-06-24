package dont.ok.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dont.ok.connect.SachService;
import dont.ok.model.Sach;

public class TimKiemUI extends JFrame {
	JTextField txtTim;
	JButton btnBatDauTim;
	DefaultTableModel dtmSach;
	JTable tblSach;
	public TimKiemUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnBatDauTim.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyTimKiem();
			}
		});
	}

	protected void xuLyTimKiem() {
		// TODO Auto-generated method stub
		SachService sservice = new SachService();
		ArrayList<Sach>dsSach = sservice.timSachTheoNhaXuatBan(txtTim.getText());
		dtmSach.setRowCount(0);
		for(Sach s: dsSach) {
			Vector<Object> vec=new Vector<Object>();
			vec.add(s.getMaSach());
			vec.add(s.getTenSach());
			vec.add(s.getMaNhaXuatBan());
			vec.add(s.getSoTrang());
			dtmSach.addRow(vec);
		}
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNhap = new JLabel("Muốn gì?:");
		txtTim = new JTextField(20);
		btnBatDauTim = new JButton("Tìm kiếm");
		pnNorth.add(lblNhap);
		pnNorth.add(txtTim);
		pnNorth.add(btnBatDauTim);
		con.add(pnNorth,BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		dtmSach = new DefaultTableModel();
		dtmSach.addColumn("Mã sách");
		dtmSach.addColumn("Tên sách");
		dtmSach.addColumn("Nhà xuất bản");
		dtmSach.addColumn("Số trang");
		tblSach = new JTable(dtmSach);
		JScrollPane scTable = new JScrollPane(tblSach,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable,BorderLayout.CENTER);
		con.add(pnCenter,BorderLayout.CENTER);
	}
	public void showWindow()
	{
		this.setSize(500, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

package baitap;

import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends NhanSu implements TinhLuong {
	private List<NhanVien> danhSachNhanVienDuoiQuyen;
	private int soNhanVienDangQuanLy;
    private static final int LUONG1NGAY = 200;

    public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        danhSachNhanVienDuoiQuyen = new ArrayList<>();
        soNhanVienDangQuanLy = 0;
    }
    
    public int getSoNhanVienDangQuanLy() {
		return soNhanVienDangQuanLy;
	}

	public void setSoNhanVienDangQuanLy(int soNhanVienDangQuanLy) {
		this.soNhanVienDangQuanLy = soNhanVienDangQuanLy;
	}

	public void themNhanVien(NhanVien nv) {
        danhSachNhanVienDuoiQuyen.add(nv);
        soNhanVienDangQuanLy++; // Tăng 1 moi lan them nhan vien
    }
    
    public void xoaNhanVien(NhanVien nv) {
        danhSachNhanVienDuoiQuyen.remove(nv);
        soNhanVienDangQuanLy--; // giam 1 moi lan xoa nhan vien
    }
    
	@Override
	public double tinhLuong() {
		return LUONG1NGAY * soNgayLamViec + 100*soNhanVienDangQuanLy;
	}

	@Override
	public void xuatThongTin(int stt) {
		System.out.printf("| %-5d | %5s | %20s | %10s | %5s | %10.2f | %5s |%n",
				stt, maSo, hoTen, soDienThoai, soNgayLamViec, tinhLuong(), soNhanVienDangQuanLy);
	}
}

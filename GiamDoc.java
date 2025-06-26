package baitap;

public class GiamDoc extends NhanSu implements TinhLuong{
	private double coPhan; //%
	private static final int LUONG1NGAY = 300;
	
	public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, double coPhan) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        this.coPhan = coPhan;
    }
	
	public double getCoPhan() {
		return coPhan;
	}

	public void setCoPhan(double coPhan) {
		this.coPhan = coPhan;
	}

	@Override
	public double tinhLuong() {
		return LUONG1NGAY*soNgayLamViec;
	}
	
	public double tinhThuNhap(double loiNhuanCongTy) {
        return tinhLuong() + (coPhan / 100.0) * loiNhuanCongTy;
    }
	
	@Override
	public void xuatThongTin(int stt) {
		System.out.printf("| %-5d | %5s | %20s | %10s | %5s | %10.2f | %5s |%n",
				stt, maSo, hoTen, soDienThoai, soNgayLamViec, tinhLuong(), coPhan);
	}
}

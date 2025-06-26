package baitap;

public class NhanVien extends NhanSu implements TinhLuong{
	private TruongPhong truongPhongQuanLy; // co kieu du lieu la TruongPhong để có thể linh hoạt sử dụng
    private static final int Luong1Ngay = 100; // gán cứng lương 
    
    public NhanVien(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        this.truongPhongQuanLy = null;
    }
    
    public TruongPhong getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}


	public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}
	
	@Override
	public double tinhLuong() {
    	return Luong1Ngay * soNgayLamViec;
    }
	
	@Override
	public void xuatThongTin(int stt) {
		System.out.printf("| %-5d | %5s | %20s | %10s | %5s | %10.2f | %20s |%n",
				stt, maSo, hoTen, soDienThoai, soNgayLamViec, tinhLuong(), truongPhongQuanLy.getHoTen());
	}
}

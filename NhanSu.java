package baitap;

import java.util.Scanner;

public abstract class NhanSu {
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgayLamViec;
	
	public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soNgayLamViec = soNgayLamViec;
    }

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}
	
	void nhap() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mã: ");
        maSo = scanner.nextLine();
        System.out.println("Tên: ");
        hoTen = scanner.nextLine();
        System.out.println("SĐT: ");
        soDienThoai = scanner.nextLine();
        System.out.print("Số ngày làm: ");
        soNgayLamViec = Integer.parseInt(scanner.nextLine());
	}
	
}

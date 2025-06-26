package baitap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CongTy {
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang;
	private List<NhanSu> danhSachNhanSu;
	private Scanner scanner = new Scanner(System.in);
	public CongTy() {
		tenCongTy = "";
		maSoThue = "";
		doanhThuThang = 0.0;
	}
	
	public CongTy(String tenCongTy, String maSoThue, double doanhThuThang) {
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.doanhThuThang = doanhThuThang;
        danhSachNhanSu = new ArrayList<>();
    }
	
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}
	
	void nhap() {
		System.out.println("Nhap ten cong ty: ");
		tenCongTy = scanner.nextLine();
		System.out.println("Ma so thue: ");
		maSoThue = scanner.nextLine();
		System.out.println("Doanh thu thang: ");
		doanhThuThang = Double.parseDouble(scanner.nextLine());
	}
	
	//Tim nhan su theo mã số trả về kiểu NhanSu
	public NhanSu timNhanSuTheoMaSo(String maSo) {
		for (NhanSu ns : danhSachNhanSu) {
            if (ns.getMaSo().equalsIgnoreCase(maSo)) return ns;
        }
		return null;// khong tim thay nhan su 
	}
	
	// sau khi tim duoc nhan vien va truong phong theo ma thi bat dau set nv theo tp
	public void phanBoNhanVienVaoTruongPhong(String maSoNV, String maSoTP) {
		//Lay ra nv va tp nhan theo kieu NhanSu
		NhanSu nv = timNhanSuTheoMaSo(maSoNV);
		NhanSu tp = timNhanSuTheoMaSo(maSoTP);
		
		//kiem tra xem nv co nam trong class nv khong, tuong tu voi tp
		if(nv instanceof NhanVien && tp instanceof TruongPhong) {
			//do ca 2 deu dang co kieu NhanSu nen phai tien hanh` ep kieu
			((NhanVien) nv).setTruongPhongQuanLy((TruongPhong) tp);
			((TruongPhong) tp).themNhanVien((NhanVien) nv); // them nhan vien vao danh sach nhan su duoi quyen
		}
	}
	
	void themNhanSu(NhanSu ns) {
		danhSachNhanSu.add(ns);
	}
	
	void xoaNhanSu(String maSo) {
		NhanSu ns1 = timNhanSuTheoMaSo(maSo); // tim nhan su theo ma so
		if(ns1 != null) {
			if(ns1 instanceof TruongPhong) { // kiem tra xem co thuoc class trưởng phòng không
				for(NhanSu ns2 : danhSachNhanSu) {  // duyệt tìm tất cả Nhân viên trong danh sách
					if(ns2 instanceof NhanVien) {
						if(((NhanVien) ns2).getTruongPhongQuanLy() == ns1) { //kiểm tra xem nhân viên có trưởng phòng trùng với Trưởng phòng đang xét??
							((NhanVien) ns2).setTruongPhongQuanLy(null); // thì ngắt liên kết
						}
					}
				}
			}
			danhSachNhanSu.remove(ns1);
		}else {
			System.out.println("Khong tim thay nhan su!");
		}
	}

	void xuatThongTinToanBoNhanSu() {
		int stt = 0;
		for (NhanSu ns : danhSachNhanSu) {
			stt++;
			if(ns instanceof NhanVien) {
				((NhanVien) ns).xuatThongTin(stt);
			}else if (ns instanceof TruongPhong) {
				((TruongPhong) ns).xuatThongTin(stt);
			}else if (ns instanceof GiamDoc) {
				((GiamDoc) ns).xuatThongTin(stt);
			}
		}
	}
	
	double tinhTongLuongCongTy() {
		double tong = 0;
		for (NhanSu ns : danhSachNhanSu) {
			if(ns instanceof NhanVien) {
				tong += ((NhanVien) ns).tinhLuong();
			}else if (ns instanceof TruongPhong) {
				tong += ((TruongPhong) ns).tinhLuong();
			}else if (ns instanceof GiamDoc) {
				tong += ((GiamDoc) ns).tinhLuong();
			}
		}
		return tong;
	}
	
	void timNhanVienLuongCaoNhat() {
		double max = Double.MIN_VALUE;// dat bien max co gia tri nho nhat trong vung gia tri cua double
		List<NhanVien> danhSachNhanVienLuongCaoNhat = new ArrayList<>(); // dsach dung de luu NhanVien co cung muc luong cao nhat
		for (NhanSu ns : danhSachNhanSu) {
			if(ns instanceof NhanVien) {
				if (((NhanVien) ns).tinhLuong() > max) {
					max = ((NhanVien) ns).tinhLuong();
					danhSachNhanVienLuongCaoNhat.clear(); // neu xuat hien nv co luong cao hon thi xoa het tat ca nhan vien da luu truoc do
					danhSachNhanVienLuongCaoNhat.add(((NhanVien) ns));
				}else if(((NhanVien) ns).tinhLuong() == max) {
					danhSachNhanVienLuongCaoNhat.add(((NhanVien) ns)); // them nv co cung` muc luong cao nhat
				}
			}
		}
		
		if (!danhSachNhanVienLuongCaoNhat.isEmpty()) {
	        System.out.println("Các nhân viên thường có lương cao nhất:");
	        int stt = 0;
	        for (NhanVien nv : danhSachNhanVienLuongCaoNhat) {
	            stt++;
	            nv.xuatThongTin(stt);
	        }
	    }else {
	    	System.out.println("Không tìm thấy");
	    }
	}
	
	//Tim truong phong co nhieu nhan vien duoi quyen nhat
	void timTruongPhongCoNhieuNhanVienNhat() {
		int max = -1;
		List<TruongPhong> danhSachTruongPhongCoNhieuNhanVienNhat = new ArrayList<>();
		for(NhanSu ns : danhSachNhanSu) {
			if(ns instanceof TruongPhong) {
				if(((TruongPhong) ns).getSoNhanVienDangQuanLy() > max) {
					max = ((TruongPhong) ns).getSoNhanVienDangQuanLy();
					danhSachTruongPhongCoNhieuNhanVienNhat.clear();
					danhSachTruongPhongCoNhieuNhanVienNhat.add((TruongPhong) ns);
				}else if(((TruongPhong) ns).getSoNhanVienDangQuanLy() == max) {
					danhSachTruongPhongCoNhieuNhanVienNhat.add(((TruongPhong) ns)); // them tp co cung` so luong nhan vien duoi quyen
				}
			}
		}
		
		if (!danhSachTruongPhongCoNhieuNhanVienNhat.isEmpty()) {
	        System.out.println("Các trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất:");
	        int stt = 0;
	        for (TruongPhong nv : danhSachTruongPhongCoNhieuNhanVienNhat) {
	            stt++;
	            nv.xuatThongTin(stt);
	        }
	    }else {
	    	System.out.println("Không tìm thấy");
	    }
	}
	
	//Collections.sort(), được sử dụng để sắp xếp các phần tử trong một List
	void sapXepNhanSuTheoThuTuABC() {
		Collections.sort(danhSachNhanSu, Comparator.comparing(NhanSu::getHoTen)); //Comparator.comparing dung de so sanh theo 1 thuoc tinh duoc chon
	}
	
	// tinh luong cho nhan su theo tung class khac nhau
	double tinhLuongCuaMoiNhanSu(NhanSu ns) {
		double luong =0;
		if(ns instanceof NhanVien) {
			luong = ((NhanVien) ns).tinhLuong();
		}else if (ns instanceof TruongPhong) {
			luong = ((TruongPhong) ns).tinhLuong();
		}else if (ns instanceof GiamDoc) {
			luong = ((GiamDoc) ns).tinhLuong();
		}
		return luong;
	}
	
	//sap xep nhan su giam dan theo luong 
	void sapXepNhanSuTheoLuongGiamDan() {       //selection sort
		for(int i =0; i < danhSachNhanSu.size() - 1; i++) { 
			for(int j = 1; j < danhSachNhanSu.size(); j++) {
				if(tinhLuongCuaMoiNhanSu(danhSachNhanSu.get(i)) < tinhLuongCuaMoiNhanSu(danhSachNhanSu.get(j))) {
					NhanSu temp = danhSachNhanSu.get(i);
	                danhSachNhanSu.set(i, danhSachNhanSu.get(j));
	                danhSachNhanSu.set(j, temp);
				}
			}
		}
	}
	
	//tim giam doc co so co phan nhieu nhat
	void timGiamDocCoSoCoPhanNhieuNhat() {
		double max = -1;
		List<GiamDoc> danhSachGiamDocCoCoPhanNhieuNhat = new ArrayList<>();
		for (NhanSu ns : danhSachNhanSu) {
			if(ns instanceof GiamDoc) {
				if(((GiamDoc) ns).getCoPhan() > max) {
					max = ((GiamDoc) ns).getCoPhan();
					danhSachGiamDocCoCoPhanNhieuNhat.clear(); // xoa toan bo danh sach da luu tru truoc do
					danhSachGiamDocCoCoPhanNhieuNhat.add((GiamDoc) ns);
				}else if(((GiamDoc) ns).getCoPhan() == max) {
					danhSachGiamDocCoCoPhanNhieuNhat.add(((GiamDoc) ns)); // them gd co cung` so luong co phan nhieu nhat
				}
			}
		}
		
		if (!danhSachGiamDocCoCoPhanNhieuNhat.isEmpty()) {
	        System.out.println("Các giám đốc có số lượng cổ phần nhiều nhất:");
	        int stt = 0;
	        for (GiamDoc nv : danhSachGiamDocCoCoPhanNhieuNhat) {
	            stt++;
	            nv.xuatThongTin(stt);
	        }
	    }else {
	    	System.out.println("Không tìm thấy");
	    }
	}
	
	// tinh loi nhuan cong ty dung trong viec tinh thu nhap giam doc
	double loiNhuanCongTy(){
		return doanhThuThang - tinhTongLuongCongTy();
	}
	
	void tinhVaXuatTongThuNhapTungGiamDoc() {
		double thuNhap = 0;
		for (NhanSu ns : danhSachNhanSu) {
			if(ns instanceof GiamDoc) {
				thuNhap = ((GiamDoc) ns).tinhThuNhap(loiNhuanCongTy());
				System.out.printf("GD %s - ThuNhap: %.2f\n", ((GiamDoc) ns).getHoTen(),thuNhap);
			}
		}
	}
	
	void xuat() {
		System.out.println("Thong tin Cong Ty");
		System.out.printf("| %15s | %10s | %15.2f | %n",
				tenCongTy,maSoThue,doanhThuThang);
	}
}

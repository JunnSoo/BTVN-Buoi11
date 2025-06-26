package baitap;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CongTy congTy = new CongTy();
		int luaChon;
		System.out.println("1. Nhap thong tin cong ty ");
		System.out.println("2. Phan bo nhan vien vao truong phong");
		System.out.println("3. Them nhan su");
		System.out.println("4. Xoa nhan su");
		System.out.println("5. Xuat ra thong tin toan bo nguoi trong công ty");
		System.out.println("6. Tính và xuất tổng lương công ty");
		System.out.println("7. Tìm nhân viên thường có lương cao nhất");
		System.out.println("8. Tìm Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("9. Sắp xếp toàn bộ nhân sự theo ABC");
		System.out.println("10. Sắp xếp toàn bộ nhân sự theo lương giảm dần");
		System.out.println("11. Tìm giám đốc có số lượng cổ phần nhiều nhất");
		System.out.println("12. Tính và xuất tổng thu nhập của từng giám đốc");
		System.out.println("0. Dừng lại");
		
		do {		
			System.out.println("Hãy nhập lựa chọn từ 0-12");
		
			luaChon = scanner.nextInt();
			switch(luaChon) {
			case 1:
				congTy.nhap();
				System.out.println("");
				congTy.xuat();
				break;
				
			case 2:
				System.out.println("Nhap ma so Nhan Vien:");
				String maSoNV = scanner.nextLine();
				System.out.println("Nhap ma so Truong Phong:");
				String maSoTP = scanner.nextLine();
				congTy.phanBoNhanVienVaoTruongPhong(maSoNV, maSoTP);
				break;
			
			case 3:
				System.out.println("Loại (1: Nhan Vien, 2: Truong Phong, 3: Giam Đoc): ");
                int loai = Integer.parseInt(scanner.nextLine());
                System.out.println("Mã: ");
                String maSo = scanner.nextLine();
                System.out.println("Tên: ");
                String ten = scanner.nextLine();
                System.out.println("SĐT: ");
                String sdt = scanner.nextLine();
                System.out.println("Số ngày làm: ");
                int ngay = Integer.parseInt(scanner.nextLine());

                if (loai == 1)
                    congTy.themNhanSu(new NhanVien(maSo, ten, sdt, ngay));
                else if (loai == 2)
                    congTy.themNhanSu(new TruongPhong(maSo, ten, sdt, ngay));
                else {
                    System.out.println("Cổ phần: ");
                    double cp = Double.parseDouble(scanner.nextLine());
                    congTy.themNhanSu(new GiamDoc(maSo, ten, sdt, ngay, cp));
                }
				break;
				
			case 4:
				System.out.println("Nhap ma so Nhan Su:");
				String maSoNS = scanner.nextLine();
				congTy.xoaNhanSu(maSoNS);
				break;
				
			case 5:
				congTy.xuatThongTinToanBoNhanSu();
				break;
			
			case 6:
				System.out.println("Tong luong cong ty: " + congTy.tinhTongLuongCongTy());
				break;
				
			case 7:
				congTy.timNhanVienLuongCaoNhat();
				break;
			
			case 8:
				congTy.timTruongPhongCoNhieuNhanVienNhat();
				break;
			
			case 9:
				congTy.sapXepNhanSuTheoThuTuABC();
				break;
				
			case 10:
				congTy.sapXepNhanSuTheoLuongGiamDan();
				break;
				
			case 11:
				congTy.timGiamDocCoSoCoPhanNhieuNhat();
				break;
			case 12:
				congTy.tinhVaXuatTongThuNhapTungGiamDoc();
				break;
			case 0:
			        System.out.println("Đã thoát chương trình.");
			        break;
	
	        	default:
	            		System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập từ 0 đến 6.");
			}
		} while(luaChon != 0);
	}
}

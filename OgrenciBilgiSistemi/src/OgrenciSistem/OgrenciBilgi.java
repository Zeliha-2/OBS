package OgrenciSistem;

import java.util.Scanner;

public class OgrenciBilgi {

	
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        StudentManagementSystem a = new StudentManagementSystem(10); // Kapasite 10

	        int secim;
	        do {
	  
	            System.out.println("1️.  Öğrenci Ekle");
	            System.out.println("2️. Öğrenci Listele");
	            System.out.println("3️. Öğrenci Güncelle");
	            System.out.println("4️. Öğrenci Sil");
	            System.out.println("5️. Çıkış");
	            System.out.print("👉 Seçiminizi yapın: ");
	            secim = scanner.nextInt();
	            scanner.nextLine(); // 

	            switch (secim) {
	                case 1: 
	                    System.out.print("ID: ");
	                    int id = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.print("Ad: ");
	                    String ad = scanner.nextLine();
	                    System.out.print("Soyad: ");
	                    String soyad = scanner.nextLine();
	                    System.out.print("Email: ");
	                    String email = scanner.nextLine();
	                    a.addStudent(id, ad, soyad, email);
	                    break;

	                case 2: 
	                    a.listStudent();
	                    break;

	                case 3: // ✏️ Öğrenci Güncelle
	                    System.out.print("Güncellenecek öğrencinin ID'si: ");
	                    int guncelleId = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.print("Yeni Ad: ");
	                    String yeniAd = scanner.nextLine();
	                    System.out.print("Yeni Soyad: ");
	                    String yeniSoyad = scanner.nextLine();
	                    System.out.print("Yeni Email: ");
	                    String yeniEmail = scanner.nextLine();
	                    a.updateStudent(guncelleId, yeniAd, yeniSoyad, yeniEmail);
	                    break;

	                case 4: // 🗑️ Öğrenci Sil
	                    System.out.print("Silinecek öğrencinin ID'si: ");
	                    int silId = scanner.nextInt();
	                    a.deleteStudent(silId);
	                    break;

	                case 5: // 🚪 Çıkış
	                    System.out.println("👋 Programdan çıkılıyor...");
	                    break;

	                default:
	                    System.out.println("⚠️ Geçersiz seçim! Lütfen 1-5 arasında bir değer girin.");
	            }
	        } while (secim != 5);

	        scanner.close();
	    
		
		
		
	}

}



class Student{
	private int id;
	private String ad;
	private String soyad;
	private String email;
	Student(){
		
	}
	 
	Student(int id,String ad,String soyad ,String email){
		
		this.id=id;
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad=ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad=soyad;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	
	
	
	
	
}


class StudentManagementSystem{
StudentManagementSystem(){
	
}
	
	private Student[] ogrenciDizisi;
	private int mevcutOgrenciSayisi;
	private String ad;
	
	public StudentManagementSystem(int kapasite) {
		ogrenciDizisi= new Student[kapasite];
		ogrenciDizisi[0]=new Student(1,"zeliha","kilic","zelis20021@gmail.com");
		ogrenciDizisi[1]=new Student(2,"isa","acer","isaAcer@gamil.com");
		ogrenciDizisi[2]=new Student(3,"esila","yasar","esilayasar@gmail.com");
		ogrenciDizisi[3]=new Student(4,"fadime","ergin","fadimeergingmail.com");
		ogrenciDizisi[4]=new Student(5,"elif","yaman","elifyaman@gmail.com");
		mevcutOgrenciSayisi=5;
	}
	
	
	public void addStudent(int id, String ad, String soyad, String email) {
		if(mevcutOgrenciSayisi<ogrenciDizisi.length) {
			ogrenciDizisi[mevcutOgrenciSayisi]=new Student(id,ad,soyad,email);
			System.out.println("Ogrenci basariyla eklendi : " + id);
			mevcutOgrenciSayisi++;
			listStudent();
			
		}
   }
	
	
	public void listStudent() {
		
		for(int i=0; i<mevcutOgrenciSayisi; i++) {
			System.out.println("ID : "+ ogrenciDizisi[i].getId()+
					", Ad: "+ ogrenciDizisi[i].getAd() +
					" , Soyad: " + ogrenciDizisi[i].getSoyad()+
					", Email: "+ ogrenciDizisi[i].getEmail()
					
					
					
					);
		}
	}
	
	
	public void updateStudent(int id , String yeniAd , String yeniSoyad, String yeniEmail) {
	    boolean bulundu = false;
	    for (int i = 0; i < mevcutOgrenciSayisi; i++) {
	        if (ogrenciDizisi[i].getId() == id) {
	            ogrenciDizisi[i].setAd(yeniAd);
	            ogrenciDizisi[i].setSoyad(yeniSoyad);
	            ogrenciDizisi[i].setEmail(yeniEmail);
	            System.out.println("Öğrenci bilgileri başarıyla güncellendi: " + ogrenciDizisi[i].getId() +
	                               ", Ad: " + ogrenciDizisi[i].getAd() + 
	                               ", Soyad: " + ogrenciDizisi[i].getSoyad() + 
	                               ", Email: " + ogrenciDizisi[i].getEmail());
	            bulundu = true;
	            break; // Öğrenciyi bulup güncelledikten sonra döngüden çık
	        }
	    }
	    
	    if (!bulundu) {
	        System.out.println(id + " ID'li öğrenci bulunamadı!");
	    }
	    listStudent();
	}

	
	
	public void deleteStudent(int id) {
	    boolean bulundu = false;
	    for (int i = 0; i < mevcutOgrenciSayisi; i++) {
	        if (ogrenciDizisi[i].getId() == id) {  // ✅ ID kontrolü ekledik
	            for (int j = i; j < mevcutOgrenciSayisi - 1; j++) {
	                ogrenciDizisi[j] = ogrenciDizisi[j + 1];  // Öğrencileri kaydır
	            }
	            ogrenciDizisi[mevcutOgrenciSayisi - 1] = null;  // Son elemanı null yap
	            mevcutOgrenciSayisi--;  // Öğrenci sayısını azalt
	            bulundu = true;
	            System.out.println("🗑️ Öğrenci başarıyla silindi: " + id);
	            break;  // Öğrenci bulunduğunda döngüden çık
	        }
	    }
	    if (!bulundu) {
	        System.out.println("⚠️ " + id + " ID'li öğrenci bulunamadı!");
	    }
	    listStudent();  // 📜 Güncel listeyi göster
	}

	
   }
	
	
	


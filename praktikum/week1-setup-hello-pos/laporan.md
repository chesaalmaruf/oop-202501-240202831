# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: MEMAHAMI PRADIGMA PEMROGRAMAN 

## Identitas
- Nama  : CHESA SALSABIL AL'MA'RUF
- NIM   : 240202831
- Kelas : 3IKRA

---

## Tujuan
Memahami serta mampu menjelaskan paradigma pemrograman(prosedural, OOP, functional) serta mendemonstrasikan perbedaan implementasinya dalam program sederhan

---

## Dasar Teori
1.Class (Kelas), Cetak biru (blueprint) untuk membuat objek. Berisi atribut (data/variabel) dan method (perilaku)
2. Method, Fungsi yang berada di dalam kelas. Menjelaskan perilaku objek. Ada instance method (butuh objek) & static method (bisa dipanggil langsung).
---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1. Langkah-langkah yang dilakukan (setup, coding, run).  
2. File/kode yang dibuat.  
3. Commit message yang digunakan.)

---

## Kode Program


```java
// HelloOOP.java
class helloworldd {
   String me;
   int nim;
   helloworldd(String me, int nim) {
      this.me = me;
      this.nim = nim;
   }
   void printhello(){
   System.out.println("helloworld i'm" + me +"NIM :" + nim );
   }
}
public class helloworlOOP {
   public static void main(String[] args) {
      helloworldd mahasiswa1 = new helloworldd ("chesa salsabil al'ma'ruf ",240202831);
      mahasiswa1.printhello();
   }
}
```
procedural
```java
public class helloprosedural {
    public static void main(String[] args) {
        String nim = "240202831";
        String nama = " chesa salsabil al'ma'ruf" ;

        System.out.println("hello POS world, i'm  " + nama + "nim " + nim);
}
}
```
functional
```java
// HelloFunctional.java
import java.util.*;
import java.util.stream.*;
public class HelloFunctional {
   public static void main(String[] args) {
      String nim = "2310112345";
      String nama = "Budi";
      List<String> produk = Arrays.asList("Beras", "Pupuk", "Benih");
      List<Integer> harga = Arrays.asList(10000, 15000, 12000);
      System.out.println("Hello POS World");
      System.out.println("NIM: " + nim + ", Nama: " + nama);
      System.out.println("Daftar Produk:");
      IntStream.range(0, produk.size())
         .forEach(i -> System.out.println("- " + produk.get(i) + ": " + harga.get(i)));
      int total = harga.stream().mapToInt(Integer::intValue).sum();
      System.out.println("Total harga semua produk: " + total);
   }
}
```

---

## Hasil Eksekusi
[(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)](https://github.com/chesaalmaruf/oop-202501-240202831/tree/main/praktikum/week1-setup-hello-pos/screenshoot)
---

## Analisis

- Dalam pemrograman prosedural, kode dijalankan secara berurutan dari atas ke bawah melalui fungsi-fungsi yang dipanggil secara eksplisit; sedangkan dalam OOP (Object-Oriented Programming), kode berjalan dengan cara membuat objek dari kelas lalu mengeksekusi method pada objek tersebut untuk merepresentasikan perilaku; sementara dalam pemrograman fungsional, data diproses melalui aliran fungsi murni (seperti map, filter, reduce) secara deklaratif, sehingga fokusnya bukan pada langkah demi langkah, melainkan pada apa yang ingin dicapai dari transformasi data. 


- Kendala yang dihadapi dan cara mengatasinya. kendala dalam indtalasi JDK dikarnakan dikarnakan visual studio code tidak menemukan lokasi file JDK, dan perlu instalasi ulang jdk

---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural? 
   **Jawaban:**
    Tidak selalu.

3. Kapan functional programming lebih cocok digunakandibanding OOP atau prosedural? 
   **Jawaban:**
      1. Saat aplikasi butuh pemrosesan data yang kompleks (misalnya data stream, big data, machine learning).
      2. Saat dibutuhkan kode deklaratif (fokus pada apa yang dilakukan, bukan bagaimana).
      3. Saat menghindari efek samping (mutasi data), misalnya dalam sistem paralel/konkuren.
 

4. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi? 
   **Jawaban:**
     1.  Prosedural → mudah dipahami di awal, tapi sulit di-maintain bila program membesar (karena kode bercampur).
     2.  OOP → lebih mudah di-maintain dan di-scale karena ada struktur class/objek yang modular.
     3.  Fungsional → maintainability tinggi untuk logika data karena kode singkat, minim side-effect, cocok untuk scalable data processing

5. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
**Jawaban**
      1. POS (Point of Sale) punya banyak entitas: produk, pelanggan, transaksi, kasir.
      2. OOP memudahkan dengan membuat class untuk tiap entitas → kode lebih terorganisir.
      3. Mendukung reusability (class bisa digunakan ulang), dan extensibility (fitur baru bisa ditambah tanpa merombak besar-besaran).
         
6. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?
**Jawaban**
      1. Dengan higher-order function (fungsi bisa dipakai ulang & dipassing ke fungsi lain).
      2. Dengan lambda expression → kode lebih ringkas.
      3. Dengan Stream API → operasi data (map, filter, reduce) bisa ditulis singkat tanpa loop berulang.
      4. Hasilnya: kode lebih pendek, lebih bersih, dan minim duplikasi.
   



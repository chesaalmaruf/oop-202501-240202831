# Laporan Praktikum Minggu 1 
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

hello oop java

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
import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        // BiConsumer menerima 2 parameter (nama, nim) dan melakukan aksi (print)
        BiConsumer<String, Integer> printHello = (nama, nim) -> 
            System.out.println("Hello World, saya " + nama + " dengan NIM: " + nim);

        // Panggil fungsi
        printHello.accept("Chesa Salsabil Al Ma'ruf", 240202831);
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
1. Setiap paradigma pemrograman memiliki kelebihan dan kekurangan masing- masing:

      - Prosedural mudah dipahami untuk program kecil, tetapi sulit di maintain jika program semakin besar.

      - OOP lebih terstruktur karena menggunakan konsep class dan object, sehingga program lebih modular, mudah dikembangkan, serta cocok untuk aplikasi berskala besar.

      - Fungsional meminimalkan side-effect, mendukung penulisan kode ringkas, dan sangat berguna dalam pemrosesan data paralel maupun berskala besar.

2. Dengan mempraktikkan ketiga paradigma, mahasiswa dapat memahami perbedaan cara berpikir dalam menyusun program serta memilih pendekatan yang tepat sesuai kebutuhan.

3. Kendala teknis yang muncul (seperti instalasi JDK dan konfigurasi di VS Code) dapat diatasi dengan instalasi ulang dan pengaturan ulang environment, sehingga proses praktikum dapat berjalan dengan lancar.

4. Secara keseluruhan, praktikum ini membantu mahasiswa untuk memahami dasar dari paradigma pemrograman serta penerapannya melalui contoh sederhana, sehingga menjadi pondasi untuk mengembangkan program yang lebih kompleks di pertemuan berikutnya.

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
   



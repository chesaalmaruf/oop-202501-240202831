# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik:  "Class dan Object"

## Identitas
- Nama  : chesa salsabil al'ma'ruf
- NIM   : 240202831
- Kelas : 3IKRA

---

## Tujuan
1. Mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.
2. Mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.
3. Mampu mengimplementasikan class Produk pertanian dengan atribut dan method yang sesuai.
4. Mampu mendemonstrasikan instansiasi object serta menampilkan data produk pertanian di console.
5. Mampu menyusun laporan praktikum dengan bukti kode, hasil eksekusi, dan analisis sederhana.

---

## Dasar Teori
1. Class adalah blueprint atau cetak biru dari objek yang berisi atribut dan metode.
2. Object adalah instance atau perwujudan nyata dari sebuah class
3. Enkapsulasi merupakan konsep penyembunyian data agar hanya dapat diakses melalui metode tertentu.
4. Getter dan Setter digunakan untuk mengatur dan membaca data atribut yang bersifat private.
5. Penerapan OOP membantu membuat kode yang lebih modular, mudah dikembangkan, dan terstruktur.

---

## Langkah Praktikum
1. Set up degan cara sync repository
2. Membuat tiga file utama:
   `Produk.java`
   `CreditBy.java`
   `MainProduk.java`

3. Menulis kode untuk menerapkan konsep class, object, dan enkapsulasi.
4. Melakukan compile dan run program.

---

## Kode Program 
main product
```java
package com.upb.agripos;
import com.upb.agripos.model.Produk;
import com.upb.agripos.util.CreditBy;



public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
        Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
        Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        // Tampilkan identitas mahasiswa
        CreditBy.print("240202831", " chesa salsabil al'ma'ruf ");
    }
}
```
produk
```java
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}
```
credit by
```java
package com.upb.agripos.util;


public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}
```

---

## Hasil Eksekusi
praktikum/week2-class-object/screenshots/image.png
---

## Analisis
Analisis

- Kode program menggunakan konsep enkapsulasi dengan menjadikan atribut private dan menyediakan akses lewat getter dan setter.
- Objek Produk dibuat di MainProduk untuk menampilkan informasi barang.
- Dibanding pendekatan prosedural, penggunaan class dan object membuat program lebih terorganisir dan mudah dikembangkan.
- Kendala yang dihadapi: kesalahan struktur folder dan package saat menjalankan program.
- Solusi: menyesuaikan nama package (package main;) dengan struktur folder proyek (src/main/).
---

## Kesimpulan
Dengan menggunakan class dan object, program menjadi lebih terstruktur, mudah dikelola, dan mendukung pengembangan fitur yang lebih kompleks di masa depan seperti transaksi, pelanggan, atau laporan penjualan.
---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?
   Jawaban:
   Atribut sebaiknya dideklarasikan sebagai private agar data dalam class terlindungi dari akses langsung oleh class lain. Ini merupakan prinsip enkapsulasi (encapsulation) dalam OOP, yang bertujuan membatasi manipulasi data secara langsung dan hanya mengizinkan perubahan melalui metode yang sudah dikontrol (seperti getter dan setter). Dengan begitu, keamanan dan konsistensi data lebih terjamin.

2. Apa fungsi getter dan setter dalam enkapsulasi?
   Jawaban:
      -Getter dan setter berfungsi sebagai penghubung (interface) untuk mengakses dan mengubah nilai atribut private dari luar class.
      -Getter digunakan untuk mengambil (membaca) nilai atribut.
      -Setter digunakan untuk mengubah (menetapkan) nilai atribut dengan kontrol atau validasi tertentu.
   Dengan getter dan setter, developer bisa menjaga agar nilai atribut selalu valid dan sesuai aturan logika program.

3. Bagaimana cara class Produk mendukung pengembangan aplikasi POS yang lebih kompleks?
   Jawaban:
   Class Produk berperan sebagai representasi data dari setiap barang di sistem POS (Point of Sale). Dengan adanya class ini, setiap produk memiliki atribut seperti nama, harga, dan stok, serta metode untuk mengelola data tersebut.
   Dalam pengembangan aplikasi POS yang lebih kompleks, class Produk bisa diperluas untuk:
      -Menambahkan fitur seperti kategori, diskon, dan supplier.
      -Berinteraksi dengan class lain seperti Transaksi, Pelanggan, atau Kasir.
      -Mempermudah penyimpanan data produk ke database dan pengelolaan inventori.
      -Dengan demikian, class Produk menjadi pondasi utama dalam modularitas dan skalabilitas aplikasi POS.

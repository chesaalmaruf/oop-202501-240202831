# Laporan Praktikum Minggu 4
Topik: Polymorphism (Info Produk)

## Identitas
- Nama  : [Nama Mahasiswa]
- NIM   : [NIM Mahasiswa]
- Kelas : [Kelas]

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.  
- Mahasiswa mampu membedakan method overloading dan overriding.  
- Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.  
- Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).  

---

## Dasar Teori
1. **Polymorphism** berarti “banyak bentuk”, memungkinkan objek berbeda merespons method yang sama dengan cara berbeda.  
2. **Overloading** adalah pendefinisian beberapa method dengan nama yang sama tetapi parameter berbeda.  
3. **Overriding** adalah ketika subclass mengganti implementasi method milik superclass.  
4. **Dynamic Binding** menentukan method mana yang dipanggil saat runtime, bukan saat compile time.  
5. Dalam konteks Agri-POS, polymorphism mempermudah pengelolaan berbagai jenis produk seperti Benih, Pupuk, dan Alat Pertanian dengan satu referensi umum.

---

## Langkah Praktikum
1. Tambahkan method **overloading** `tambahStok(int jumlah)` dan `tambahStok(double jumlah)` pada class `Produk`.  
2. Tambahkan method `getInfo()` pada superclass `Produk`, lalu **override** pada subclass `Benih`, `Pupuk`, dan `AlatPertanian`.  
3. Buat array `Produk[] daftarProduk` berisi objek dari subclass untuk mendemonstrasikan **dynamic binding**.  
4. Jalankan program di `MainPolymorphism.java` untuk menampilkan hasil.  
5. Tambahkan pemanggilan `CreditBy.print("<NIM>", "<Nama>")`.  
6. Commit dengan pesan: `week4-polymorphism`.  

---

## Kode Program

### Produk.java
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

    // Overloading
    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void tambahStok(double jumlah) {
        this.stok += (int) jumlah;
    }

    public String getInfo() {
        return "Produk: " + nama + " (Kode: " + kode + ")";
    }
}
```
Benih.java
```java
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    @Override
    public String getInfo() {
        return "Benih: " + super.getInfo() + ", Varietas: " + varietas;
    }
}
Pupuk.java
```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public String getInfo() {
        return "Pupuk: " + super.getInfo() + ", Jenis: " + jenis;
    }
}
```
AlatPertanian.java
```java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String bahan;

    public AlatPertanian(String kode, String nama, double harga, int stok, String bahan) {
        super(kode, nama, harga, stok);
        this.bahan = bahan;
    }

    @Override
    public String getInfo() {
        return "Alat Pertanian: " + super.getInfo() + ", Bahan: " + bahan;
    }
}
```
MainPolymorphism.java
```java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja")
        };

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo()); // Dynamic Binding
        }

        CreditBy.print("<NIM>", "<Nama Mahasiswa>");
    }
}
```
---
hasil eksekusi

ss

```
Benih: Produk: Benih Padi IR64 (Kode: BNH-001), Varietas: IR64
Produk: Pupuk Urea (Kode: PPK-101)
Produk: Cangkul Baja (Kode: ALT-501)

credit by: 240202831 - CHESA SALSABIL AL'MA'RUF
PS C:\Users\LENOVO\Downloads\oop>
```
---
Analisis

- Kode menunjukkan bahwa method getInfo() pada masing-masing subclass menggantikan implementasi superclass (Produk).

- tambahStok() menunjukkan overloading, karena dua method memiliki nama sama tetapi parameter berbeda.

- Saat looping daftarProduk, Java secara otomatis memilih method getInfo() sesuai tipe objek sebenarnya (dynamic binding).

- Pendekatan polymorphism membuat program lebih fleksibel dan mudah diperluas.
---

Kendala:
Awalnya terjadi error pada struktur package dan penempatan file, namun diperbaiki dengan memastikan root folder src/main/java/com/upb/agripos sudah benar.
---
Kesimpulan

Dengan menggunakan konsep polymorphism, program menjadi lebih dinamis, efisien, dan mudah dikembangkan.
Overriding, overloading, dan dynamic binding mempermudah pengelolaan berbagai tipe objek dengan cara yang seragam.
---
Quiz

1. Apa perbedaan overloading dan overriding?
Jawaban: Overloading menggunakan nama method yang sama tetapi parameter berbeda; overriding mengganti implementasi method superclass di subclass.

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?
Jawaban: Java menentukan method yang dipanggil berdasarkan tipe objek aktual saat runtime, bukan tipe referensinya.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.
Jawaban: Pada sistem POS restoran, class Menu dapat memiliki subclass Makanan, Minuman, dan Dessert yang masing-masing meng-override method getInfo()
# Laporan Praktikum Minggu 3
Topik: Inheritance (Kategori Produk)"

## Identitas
- Nama : Chesa Salsabil Al Ma’ruf
- NIM : 240202831
- Kelas : 3IKRA

---

## Tujuan
1. Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
2. Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.
3. Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
4. Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
5. Mahasiswa mampu menjelaskan perbedaan penggunaan inheritance dibandingkan class tunggal.

---

## Dasar Teori
1. Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.
2. Superclass adalah class induk yang berisi atribut umum dan dapat diturunkan ke subclass.
3. Subclass adalah class turunan yang mewarisi atribut/method superclass, serta dapat menambahkan atribut atau method baru.
4. Keyword super digunakan untuk memanggil konstruktor atau method dari superclass.
5. Inheritance membuat program lebih modular, efisien, dan mudah dikelola dibanding membuat class terpisah tanpa hubungan.
---

## Langkah Praktikum
1. Membuat superclass Produk yang berisi atribut umum: kode, nama, harga, dan stok.
2. Membuat tiga subclass:
   -Benih.java → atribut tambahan: varietas.
   -Pupuk.java → atribut tambahan: jenis.
   -AlatPertanian.java → atribut tambahan: material.

3. Membuat MainInheritance.java untuk menampilkan hasil instansiasi dari tiap subclass.

4. Menambahkan CreditBy.java untuk menampilkan identitas mahasiswa.

5. Menjalankan program dan mengambil screenshot hasil eksekusi.

6. Melakukan commit dengan pesan: week3-inheritance.

---

## Kode Program 
`Produk.java`
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
`AlatPertanian.java`
```java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}
```
`Benih.java`
```java
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }
}
```
`Pupuk.java`
```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
}

`CreditBy.java`
```java

package com.upb.agripos.util;


public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}
```MainInheritance.java`
```java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("Benih: " + b.getNama() + " Varietas: " + b.getVarietas());
        System.out.println("Pupuk: " + p.getNama() + " Jenis: " + p.getJenis());
        System.out.println("Alat Pertanian: " + a.getNama() + " Material: " + a.getMaterial());

        CreditBy.print(" 240202831 ", " Chesa Salsabil AL'MA'RUF ");
    }
}

```


---

## Hasil Eksekusi
![alt text](https://github.com/chesaalmaruf/oop-202501-240202831/blob/main/praktikum/week3-inheritance/screenshots/Screenshot%202025-10-22%20142256.png)

output
:
```
Benih: Benih Padi IR64 Varietas: IR64
Pupuk: Pupuk Urea Jenis: Urea
Alat Pertanian: Cangkul Baja Material: Baja

credit by:  240202831  -  Chesa Salsabil AL'MA'RUF

```
---

## Analisis
1. Program menggunakan inheritance untuk menghindari penulisan ulang atribut dan method pada setiap class produk.
2. Benih, Pupuk, dan AlatPertanian mewarisi atribut umum dari Produk.

3. Penggunaan super() di konstruktor subclass memastikan data diwariskan dengan benar.
4. Dibanding minggu sebelumnya (class tunggal), inheritance membuat kode lebih modular dan mudah dikembangkan.
5. Kendala yang dihadapi: error “Incorrect Package” karena struktur folder belum sesuai; diselesaikan dengan menyesuaikan path `src/main/java/com/upb/agripos/....`
---

## Kesimpulan
- Konsep inheritance memudahkan pengelompokan class dengan atribut umum.
- Subclass dapat memperluas fungsionalitas tanpa menulis ulang kode dasar.
- Program menjadi lebih terstruktur dan mudah dikembangkan.
- Penggunaan super() penting untuk memanggil konstruktor superclass.
---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
   Jawaban: Inheritance menghindari duplikasi kode, membuat program lebih efisien, mudah dikelola, dan memperjelas hubungan antar class.
2. Bagaimana cara subclass memanggil konstruktor superclass?
   Jawaban: Dengan menggunakan keyword super(parameter) di dalam konstruktor subclass.  
3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.
   Jawaban: Contohnya `Pestisida` (atribut tambahan: jenis bahan aktif) atau ObatTanaman (atribut tambahan: dosis dan kemasan).

# Laporan Praktikum Minggu 5
Topik: Abstraction (Abstract Class & Interface)

## Identitas
- Nama  : Chesa Salsabil Al'ma'ruf
- NIM   : 240202831
- Kelas : 3IKRA

---

## Tujuan
Mahasiswa mampu:
- Menjelaskan perbedaan abstract class dan interface.
- Mendesain abstract class dengan method abstrak sesuai kebutuhan kasus.
- Membuat interface dan mengimplementasikannya pada class.
- Menerapkan multiple inheritance melalui interface pada rancangan kelas.

---

## Dasar Teori
1. Abstraksi adalah proses menyederhanakan kompleksitas dengan hanya menampilkan elemen penting dan menyembunyikan detail implementasi.
2. Abstract class tidak dapat diinstansiasi langsung, namun dapat berisi method abstrak dan non-abstrak serta menyimpan state (field).
3. Interface adalah kumpulan kontrak yang hanya berisi deklarasi method tanpa implementasi konkret, dan mendukung multiple inheritance.
4. Gunakan abstract class bila terdapat perilaku dasar bersama, sedangkan interface digunakan untuk mendefinisikan kemampuan lintas hierarki.
5. Dalam studi kasus Agri-POS, abstraksi digunakan untuk memodelkan sistem pembayaran dengan `Pembayaran` sebagai abstract class, serta `Validatable` dan `Receiptable` sebagai interface tambahan.

---

## Langkah Praktikum
1. Membuat abstract class `Pembayaran` dengan field `invoiceNo`, `total`, dan method abstrak `biaya()` serta `prosesPembayaran()`.
2. Membuat subclass konkret:
   - `Cash` → tanpa biaya tambahan, proses berhasil jika tunai mencukupi.
   - `EWallet` → biaya 1.5% dan memerlukan validasi OTP.
3. Membuat dua interface:
   - `Validatable` → memiliki method `boolean validasi()`.
   - `Receiptable` → memiliki method `String cetakStruk()`.
4. Mengimplementasikan multiple inheritance via interface:
   - `EWallet` mengimplementasikan `Validatable` dan `Receiptable`.
   - `Cash` mengimplementasikan `Receiptable`.
5. Menulis program utama `MainAbstraction.java` untuk mendemonstrasikan polymorphism antar metode pembayaran.
6. Melakukan commit dengan pesan `week5-abstraction-interface`.

---

## Kode Program
`Pembayaran.java`
```java
package main.java.com.upb.agripos.model.pembayaran;

public abstract class Pembayaran {
    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public abstract double biaya();
    public abstract boolean prosesPembayaran();

    public double totalBayar() {
        return total + biaya();
    }
}
```
`Cash.java`
```java
package main.java.com.upb.agripos.model.pembayaran;

import main.java.com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() { return 0; }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar();
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL: %.2f | CASH: %.2f | KEMBALI: %.2f",
            invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}
```
`EWallet.java`
```java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.*;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private String akun;
    private String otp;

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() { return total * 0.015; }

    @Override
    public boolean validasi() { return otp != null && otp.length() == 6; }

    @Override
    public boolean prosesPembayaran() { return validasi(); }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL+FEE: %.2f | E-WALLET: %s | STATUS: %s",
            invoiceNo, totalBayar(), akun, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}
```
`MainAbstraction.java`
```java

package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.pembayaran.*;
import main.java.com.upb.agripos.model.kontrak.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("INV-001", 100000, 120000);
        Pembayaran ew = new EWallet("INV-002", 150000, "user@ewallet", "123456");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());

        CreditBy.print("[NIM]", "[Nama Mahasiswa]");
    }
}
```

---

## Hasil Eksekusi

```
INVOICE INV-001 | TOTAL: 100000.00 | BAYAR CASH: 120000.00 | KEMBALI: 20000.00
INVOICE INV-002 | TOTAL+FEE: 152250.00 | E-WALLET: user@ewallet | STATUS: BERHASIL

credit by: 240202831 - CHESA SALSABIL AL'MA'RUF
PS C:\Users\LENOVO\Downloads\oop>

```

![Screenshot hasil](https://github.com/chesaalmaruf/oop-202501-240202831/blob/main/praktikum/week5-abstraction-interface/screenshots/image.png)

---

## Analisis
- Program menunjukkan bagaimana konsep abstraction dan interface diterapkan secara bersamaan.
- Abstract class digunakan untuk perilaku dasar semua jenis pembayaran, sedangkan interface memberikan fleksibilitas untuk menambah kemampuan seperti validasi dan pencetakan struk.
- Pendekatan minggu ini menekankan pemisahan kontrak dan implementasi, berbeda dengan minggu sebelumnya yang fokus pada inheritance dan polymorphism.
- Kendala umum adalah kesalahan struktur paket dan import, yang dapat diatasi dengan memastikan struktur direktori sesuai dengan deklarasi package.

---

## Kesimpulan
Dengan menggunakan abstract class dan interface, program menjadi lebih modular dan fleksibel. Mahasiswa memahami bagaimana konsep abstraksi dapat menyederhanakan desain program serta memungkinkan implementasi multiple inheritance secara aman di Java.

---

## Quiz
1. **Jelaskan perbedaan konsep dan penggunaan abstract class dan interface.**  
   **Jawaban:** Abstract class dapat berisi implementasi dan state, sedangkan interface hanya berisi kontrak perilaku.  

2. **Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?**  
   **Jawaban:** Karena interface tidak membawa state, sehingga tidak menimbulkan konflik pewarisan seperti pada class.  

3. **Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya.**  
   **Jawaban:** `Pembayaran` menjadi abstract class karena memiliki data dan perilaku dasar, sedangkan `Validatable` dan `Receiptable` menjadi interface karena mendefinisikan kemampuan tambahan yang dapat diimplementasikan lintas kelas.

# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : chesa salsabil al'ma'ruf
- NIM   : 240202831
- Kelas : 3IKRA

---

## Tujuan

1. Menjelaskan konsep collection dalam Java (List, Map, Set).
2. Menggunakan ArrayList untuk menyimpan dan mengelola objek.
3. Mengimplementasikan Map atau Set sesuai kebutuhan pengelolaan data.
4. Melakukan operasi dasar pada collection: tambah, hapus, dan hitung total.
5. Menganalisis efisiensi penggunaan collection dalam konteks sistem Agri-POS.

---

## Dasar Teori
Collections Framework
Java Collections Framework menyediakan struktur data untuk mengelola objek secara dinamis dan efisien.
Struktur utama:

- List (implementasi: ArrayList) — Terurut, dapat menyimpan elemen duplikat.
- Map (implementasi: HashMap) — Menyimpan pasangan key–value, akses cepat berdasarkan key.
- Set (implementasi: HashSet) — Tidak menerima duplikat dan tidak mempertahankan urutan.

---
---

## Langkah Praktikum
1. Menyiapkan directory
   dan konfigurasi clashpath untuk week 7
2. mnyiapkan kode program
3. menyiapkan (mendeklarasikan pacage) pada setiap pacage
4. gitt push

---

## Kode Program
`MainCart.java`
```java

package main.java.com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am CHESSA SALSBIL AL'MA'RUF-240202831 (Week7)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}
```
`Product.java`
```java
package main.java.com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
```
`ShoppingCart.java`
```java
package main.java.com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}
```
`ShoppingCartMap.java`
```java
package main.java.com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}
```
---

## Hasil Eksekusi
  
![Screenshot hasil](screenshots/week%207.png)

---

## Analisis

- Jelaskan bagaimana kode berjalan.  
Program terdiri dari tiga class utama: Product, ShoppingCart, dan MainCart.

1. Product

    Class sederhana yang menyimpan data produk:

    - code
    - name
    - price

    Objek produk dibuat dan datanya hanya bisa dibaca melalui getter.

2. ShoppingCart (ArrayList)

    Menggunakan ArrayList untuk menyimpan daftar produk.

    Fungsinya:
    - addProduct() → menambah produk ke keranjang.

    - removeProduct() → menghapus produk dari list.

    - getTotal() → menjumlahkan harga seluruh produk.

    - printCart() → menampilkan isi keranjang dan total harganya.

    ArrayList cocok untuk keranjang belanja sederhana karena mendukung duplikasi dan mudah ditambah/hapus.

3. ShoppingCartMap (HashMap)

    - Versi keranjang menggunakan Map<Product, Integer> untuk menyimpan produk beserta jumlahnya.
    - addProduct() → jika produk sudah ada, jumlahnya ditambah.
    - removeProduct() → jumlah dikurangi, dan dihapus jika 0.
    - getTotal() → total harga dihitung dari harga × jumlah.
    - printCart() → menampilkan produk + quantity.

4. MainCart
    Menjalankan program:

    - Membuat dua produk.
    - Membuat keranjang.
    - Menambah produk ke keranjang.
    - Menampilkan isi keranjang.
    - Menghapus satu produk dan mencetak ulang.
    - Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
    - Kendala yang dihadapi dan cara mengatasinya.  

---

## Kesimpulan
Praktikum mempelajari penggunaan Java Collections seperti List dan Map untuk mengelola data produk pada sistem Agri-POS. Dengan ArrayList, proses menambah dan menghapus produk menjadi lebih sederhana, sementara HashMap memudahkan pencatatan jumlah produk secara efisien. Dibandingkan minggu sebelumnya yang berfokus pada konsep abstraksi, minggu ini lebih praktis karena langsung mengatur data dalam jumlah banyak. Dari praktikum ini dapat disimpulkan bahwa Collections mempermudah pengelolaan data, membuat program lebih terstruktur, efisien, dan mudah dikembangkan untuk kebutuhan sistem yang lebih besar.

---

## Quiz
1. Jelaskan perbedaan mendasar antara List, Map, dan Set.
  
   `jawab`
   List adalah struktur data yang menyimpan elemen secara berurutan dan mengizinkan adanya data yang duplikat. Elemen di dalam List dapat diakses menggunakan indeks, sehingga cocok untuk data yang membutuhkan urutan tertentu.

   Map adalah struktur data yang menyimpan pasangan key–value. Setiap key harus unik dan digunakan untuk mengakses value dengan cepat. Map tidak menyimpan elemen secara tunggal, tetapi selalu dalam bentuk hubungan antara key dan value.

   Set adalah struktur data yang menyimpan elemen tanpa duplikasi. Set tidak mempertahankan urutan tertentu dan setiap elemen dianggap unik. Jika elemen yang sama dimasukkan dua kali, Set hanya akan menyimpannya satu kali.

   Jadi, perbedaan utamanya adalah: List fokus pada urutan dan duplikasi diperbolehkan, Map fokus pada hubungan key–value, dan Set fokus pada keunikan data tanpa duplikasi.

2. Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?
`jawab`
   Karena:
   - Struktur list mudah ditambah dan dihapus elemennya.
   - Bisa menyimpan duplikat (misal user membeli beras 2 kali).
   - Akses berdasarkan indeks cepat.
   - Implementasinya sederhana, cocok untuk data yang jumlahnya tidak terlalu besar.


3. Bagaimana struktur Set mencegah duplikasi data?

   `jawab`

   Set menggunakan struktur hash (misalnya HashSet), sehingga:
   - Setiap elemen dihitung hash-nya.
   - Saat elemen baru ingin dimasukkan, Set mengecek apakah hash tersebut sudah ada.
   - Jika ada → elemen tidak dimasukkan.
   - Jika belum ada → elemen baru ditambahkan.

   Inilah sebabnya Set hanya menyimpan data yang unik.

4. Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.

   Gunakan Map jika ingin menghubungkan dua data secara langsung, biasanya key → value, dan membutuhkan akses cepat berdasarkan key.

   Contoh:
   Dalam sistem kasir, kita ingin menyimpan produk → jumlahnya:

   ```java
   Map<Product, Integer> cart = new HashMap<>();
   ```
   Keuntungan:
   - Jika user menambah produk yang sama, kita tinggal menambah jumlahnya.
   - Tidak perlu menambah item baru seperti pada List.
   - Akses berdasarkan key cepat (O(1)).
   Situasi lain:
   - Menyimpan data customer berdasarkan ID
   - Menyimpan harga berdasarkan kode produk
   - Menyimpan data konfigurasi berdasarkan nama parameter
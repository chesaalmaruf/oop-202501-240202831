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

import java.util.ArrayList;
import java.util.Scanner;

class Chocolate {
    String varian;
    String ukuran;
    String bentuk;
    double harga;

    public Chocolate(String varian, String ukuran, String bentuk, double harga) {
        this.varian = varian;
        this.ukuran = ukuran;
        this.bentuk = bentuk;
        this.harga = harga;
    }
}

public class App {
    static ArrayList<Chocolate> chocolates = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime();
            }
        } catch (Exception e) {
            System.out.println("Error saat membersihkan layar: " + e.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=======================================");
            System.out.println("|               Welcome               |");
            System.out.println("|         Alfa Chocolate Store        |");
            System.out.println("=======================================");
            System.out.println("|  Menu:                              |");
            System.out.println("|  1. Lihat Menu                      |");
            System.out.println("|  2. Masuk ke Menu CRUD              |");
            System.out.println("|  3. Keluar                          |");
            System.out.println("=======================================");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Tampilan_Menu();
                    break;
                case 2:
                    Tampilan_CRUD();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
        System.out.println("Terima Kasih Sudah Berbelanja ");
    }


    // FUNGSI TAMPILAN MENU
    static void Tampilan_Menu() {
        clearScreen();
        System.out.println("============================================");
        System.out.println("|               Menu Cokelat               |");
        System.out.println("|------------------------------------------|");
        System.out.println("| Varian :   Dark, Matcha, Berry, Hazelnut |");
        System.out.println("| Ukuran :   Small, Medium, Large          |");
        System.out.println("| Bentuk :   Bar, Truffle, Love            |");
        System.out.println("| Harga  :   Sesuai dengan jenis cokelat   |");
        System.out.println("============================================");
    }
    

    // FUNGSI TAMPILAN CRUD
    static void Tampilan_CRUD() {
        clearScreen();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=======================================");
            System.out.println("|         Menu CRUD Cokelat           |");
            System.out.println("|-------------------------------------|");
            System.out.println("| 1. Tambah Data Cokelat              |");
            System.out.println("| 2. Tampilkan Data Cokelat           |");
            System.out.println("| 3. Edit Data Cokelat                |");
            System.out.println("| 4. Hapus Data Cokelat               |");
            System.out.println("| 5. Kembali ke Menu Utama            |");
            System.out.println("=======================================");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (choice) {
                case 1:
                    tambah_Chocolate();
                    break;
                case 2:
                    tampilan_Chocolates();
                    break;
                case 3:
                    edit_Chocolate();
                    break;
                case 4:
                    hapus_Chocolate();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }


    // FUNGSI TAMBAH DATA COKLAT
    static void tambah_Chocolate() {
        Tampilan_Menu();
        System.out.print("Masukkan varian cokelat : ");
        String varian = scanner.nextLine();
        System.out.print("Masukkan ukuran cokelat : ");
        String ukuran = scanner.nextLine();
        System.out.print("Masukkan bentuk cokelat : ");
        String bentuk = scanner.nextLine();
        System.out.print("Masukkan harga cokelat  : ");
        double harga = scanner.nextDouble();

        Chocolate chocolate = new Chocolate(varian, ukuran, bentuk, harga);
        chocolates.add(chocolate);

        System.out.println("Cokelat berhasil ditambahkan ");
    }


    // FUNGSI TAMPILAN DATA COKLAT
    static void tampilan_Chocolates() {
        if (chocolates.isEmpty()) {
            System.out.println("Tidak ada cokelat yang tersedia.");
            return;
        }

        System.out.println("\n===== Daftar Cokelat =====");
        for (int i = 0; i < chocolates.size(); i++) {
            System.out.println("Cokelat " + (i + 1) + ":");
            System.out.println("Varian : " + chocolates.get(i).varian);
            System.out.println("Ukuran : " + chocolates.get(i).ukuran);
            System.out.println("Bentuk : " + chocolates.get(i).bentuk);
            System.out.println("Harga  : " + chocolates.get(i).harga);
            System.out.println("---------------------------");
        }
    }


    // FUNGSI EDIT DATA COKLAT
    static void edit_Chocolate() {
        if (chocolates.isEmpty()) {
            System.out.println("Tidak ada cokelat yang tersedia untuk diperbarui.");
            return;
        }

        System.out.println("\n===== Perbarui Cokelat =====");
        tampilan_Chocolates();
        System.out.print("Masukkan nomor cokelat yang ingin diperbarui: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > chocolates.size()) {
            System.out.println("Nomor cokelat tidak valid.");
            return;
        }

        Tampilan_Menu();
        System.out.print("Masukkan varian baru cokelat : ");
        String varian = scanner.nextLine();
        System.out.print("Masukkan ukuran baru cokelat : ");
        String ukuran = scanner.nextLine();
        System.out.print("Masukkan bentuk baru cokelat : ");
        String bentuk = scanner.nextLine();
        System.out.print("Masukkan harga baru cokelat  : ");
        double harga = scanner.nextDouble();

        Chocolate updatedChocolate = new Chocolate(varian, ukuran, bentuk, harga);
        chocolates.set(index - 1, updatedChocolate);
        System.out.println("Cokelat berhasil diperbarui.");
    }


    // FUNGSI HAPUS DATA COKLAT
    static void hapus_Chocolate() {
        if (chocolates.isEmpty()) {
            System.out.println("\nTidak ada cokelat yang tersedia untuk dihapus.");
            return;
        }

        System.out.println("\n===== Hapus Cokelat =====");
        tampilan_Chocolates();
        System.out.print("Masukkan nomor cokelat yang ingin dihapus : ");
        int index = scanner.nextInt();
        if (index < 1 || index > chocolates.size()) {
            System.out.println("Nomor cokelat tidak valid.");
            return;
        }

        chocolates.remove(index - 1);
        System.out.println("Cokelat berhasil dihapus.");
    }
}

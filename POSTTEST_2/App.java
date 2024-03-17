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

    public String getVarian() {
        return varian;
    }

    public void setVarian(String varian) {
        this.varian = varian;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getBentuk() {
        return bentuk;
    }

    public void setBentuk(String bentuk) {
        this.bentuk = bentuk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
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

    private static class MenuData {
        static final String[] VARIAN = {"Dark", "Matcha", "Berry", "Hazelnut"};
        static final String[] UKURAN = {"Small", "Medium", "Large"};
        static final String[] BENTUK = {"Bar", "Truffle", "Love"};
    }

    public static void main(String[] args) {
        clearScreen();
        boolean Keluar = true;
        while (Keluar) {
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
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: Input tidak valid.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    Tampilan_Menu();
                    break;
                case 2:
                    Tampilan_CRUD();
                    break;
                case 3:
                    Keluar = false;
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
        boolean Keluar = true;
        while (Keluar) {
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
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: Input tidak valid.");
                scanner.nextLine();
                continue;
            }

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
                    Keluar = false;
                    clearScreen();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    // FUNGSI TAMBAH DATA COKLAT
    static void tambah_Chocolate() {
        clearScreen();
        Tampilan_Menu();
        System.out.println("======================================");
        System.out.println("|          Tambah Cokelat            |");
        System.out.println("|------------------------------------|");
        System.out.println("| Pilih Varian :                     |");
        for (int i = 0; i < MenuData.VARIAN.length; i++) {
            System.out.println("| " + (i + 1) + ". " + MenuData.VARIAN[i]);
        }
        System.out.print("| Pilihan Anda : ");
        int varianChoice;
        try {
            varianChoice = scanner.nextInt();
            scanner.nextLine();
            if (varianChoice < 1 || varianChoice > MenuData.VARIAN.length) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error: Pilihan tidak valid.");
            scanner.nextLine();
            return;
        }
    
        System.out.println("| Pilih Ukuran :                     |");
        for (int i = 0; i < MenuData.UKURAN.length; i++) {
            System.out.println("| " + (i + 1) + ". " + MenuData.UKURAN[i]);
        }
        System.out.print("| Pilihan Anda : ");
        int ukuranChoice;
        try {
            ukuranChoice = scanner.nextInt();
            scanner.nextLine();
            if (ukuranChoice < 1 || ukuranChoice > MenuData.UKURAN.length) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error: Pilihan tidak valid.");
            scanner.nextLine();
            return;
        }
    
        System.out.println("| Pilih Bentuk :                     |");
        for (int i = 0; i < MenuData.BENTUK.length; i++) {
            System.out.println("| " + (i + 1) + ". " + MenuData.BENTUK[i]);
        }
        System.out.print("| Pilihan Anda : ");
        int bentukChoice;
        try {
            bentukChoice = scanner.nextInt();
            scanner.nextLine();
            if (bentukChoice < 1 || bentukChoice > MenuData.BENTUK.length) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error: Pilihan tidak valid.");
            scanner.nextLine();
            return;
        }
    
        System.out.print("| Masukkan harga cokelat : ");
        double harga;
        try {
            harga = scanner.nextDouble();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: Input harga tidak valid.");
            scanner.nextLine();
            return;
        }
    
        String varian = MenuData.VARIAN[varianChoice - 1];
        String ukuran = MenuData.UKURAN[ukuranChoice - 1];
        String bentuk = MenuData.BENTUK[bentukChoice - 1];
    
        Chocolate chocolate = new Chocolate(varian, ukuran, bentuk, harga);
        chocolates.add(chocolate);
    
        System.out.println("| Cokelat berhasil ditambahkan       |");
        System.out.println("======================================");
    }
    

    // FUNGSI TAMPILAN DATA COKLAT
    static void tampilan_Chocolates() {
        clearScreen();
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
            System.out.println("===========================");
        }
    }

    // FUNGSI EDIT DATA COKLAT
    static void edit_Chocolate() {
        clearScreen();
        if (chocolates.isEmpty()) {
            System.out.println("Tidak ada cokelat yang tersedia untuk diperbarui.");
            return;
        }

        System.out.println("\n===== Perbarui Cokelat =====");
        tampilan_Chocolates();
        System.out.print("Masukkan nomor cokelat yang ingin diperbarui: ");
        int index;
        try {
            index = scanner.nextInt();
            scanner.nextLine();
            if (index < 1 || index > chocolates.size()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error: Nomor cokelat tidak valid.");
            scanner.nextLine();
            return;
        }

        String varian = "";
        String ukuran = "";
        String bentuk = "";
        double harga = 0.0;

        boolean inputValid = false;
        while (!inputValid) {
            System.out.println("\n===== Data Cokelat =====");
            System.out.print("Masukkan varian baru cokelat (Dark, Matcha, Berry, Hazelnut): ");
            varian = scanner.nextLine();
            if (!isValidVarian(varian)) {
                System.out.println("Error: Varian tidak valid.");
                continue;
            }

            System.out.print("Masukkan ukuran baru cokelat (Small, Medium, Large): ");
            ukuran = scanner.nextLine();
            if (!isValidUkuran(ukuran)) {
                System.out.println("Error: Ukuran tidak valid.");
                continue;
            }

            System.out.print("Masukkan bentuk baru cokelat (Bar, Truffle, Love): ");
            bentuk = scanner.nextLine();
            if (!isValidBentuk(bentuk)) {
                System.out.println("Error: Bentuk tidak valid.");
                continue;
            }

            System.out.print("Masukkan harga baru cokelat: ");
            try {
                harga = scanner.nextDouble();
                scanner.nextLine();
                inputValid = true;
            } catch (Exception e) {
                System.out.println("Error: Input harga tidak valid.");
                scanner.nextLine();
            }
        }

        Chocolate updatedChocolate = new Chocolate(varian, ukuran, bentuk, harga);
        chocolates.set(index - 1, updatedChocolate);
        System.out.println("Cokelat berhasil diperbarui.");
    }

    // Method to validate varian input
    static boolean isValidVarian(String varian) {
        for (String v : MenuData.VARIAN) {
            if (v.equalsIgnoreCase(varian)) {
                return true;
            }
        }
        return false;
    }

    // Method to validate ukuran input
    static boolean isValidUkuran(String ukuran) {
        for (String u : MenuData.UKURAN) {
            if (u.equalsIgnoreCase(ukuran)) {
                return true;
            }
        }
        return false;
    }

    // Method to validate bentuk input
    static boolean isValidBentuk(String bentuk) {
        for (String b : MenuData.BENTUK) {
            if (b.equalsIgnoreCase(bentuk)) {
                return true;
            }
        }
        return false;
    }

    // FUNGSI HAPUS DATA COKLAT
    static void hapus_Chocolate() {
        clearScreen();
        if (chocolates.isEmpty()) {
            System.out.println("Tidak ada cokelat yang tersedia untuk dihapus.");
            return;
        }

        tampilan_Chocolates();
        System.out.print("Pilih nomor cokelat yang ingin dihapus: ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 || choice > chocolates.size()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error: Nomor cokelat tidak valid.");
            scanner.nextLine();
            return;
        }

        chocolates.remove(choice - 1);
        System.out.println("Data cokelat berhasil dihapus.");

    }

}

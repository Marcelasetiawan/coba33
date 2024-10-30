import java.util.Scanner;

/** //Program PenghitungNilaiAkhir ini digunakan untuk menghitung nilai akhir mata kuliah
 *  //berdasarkan bobot nilai tugas, UTS, dan UAS.
 */ //Menentukan juga grade akhir berdasarkan nilai akhir.
public class PenghitungNilaiAkhir {
    private static final double BOBOT_UAS = 0.4;
    private static final double BOBOT_UTS = 0.3;
    private static final double BOBOT_TUGAS = 0.3;
    private static final Scanner scanner = new Scanner(System.in);

    /** //Metode utama yang memulai program untuk meminta input nilai dan menampilkan
     * //hasil nilai akhir serta grade-nya.
     * @param args //argumen dari command line (tidak digunakan)
     */
    public static void main(String[] args) {
        double nilaiTugas = inputNilai(scanner, "tugas");
        double nilaiUTS = inputNilai(scanner, "UTS");
        double nilaiUAS = inputNilai(scanner, "UAS");
        displayNilaiAkhir(hitungNilaiAkhir(nilaiTugas, nilaiUTS, nilaiUAS));
        scanner.close();
    }

    /** //Menampilkan nilai akhir dan grade berdasarkan nilai akhir.
     *
     * @param nilaiAkhir //nilai akhir hasil perhitungan bobot nilai tugas, UTS, dan UAS
     */
    private static void displayNilaiAkhir(double nilaiAkhir) {
        System.out.println("Nilai akhir mata kuliah Anda adalah: " + nilaiAkhir);
        if (nilaiAkhir >= 85) {
            System.out.println("Grade: A");
        } else if (nilaiAkhir >= 70) {
            System.out.println("Grade: B");
        } else if (nilaiAkhir >= 60) {
            System.out.println("Grade: C");
        } else if (nilaiAkhir >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: E");
        }
    }

    /**
     * //Menghitung nilai akhir berdasarkan bobot nilai tugas, UTS, dan UAS.
     * @param nilaiTugas // nilai dari tugas yang telah diberikan
     * @param nilaiUTS //nilai dari Ujian Tengah Semester
     * @param nilaiUAS //nilai dari Ujian Akhir Semester
     * @return //nilai akhir yang dihitung berdasarkan bobot tugas, UTS, dan UAS
     */
    private static double hitungNilaiAkhir(double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        return (nilaiTugas * BOBOT_TUGAS) + (nilaiUTS * BOBOT_UTS) + (nilaiUAS * BOBOT_UAS);
    }

    /**
     * //Meminta input nilai dari pengguna dan memastikan input berada dalam rentang yang benar (0-100).
     * @param scanner //scanner objek Scanner untuk membaca input pengguna
     * @param jenisNilai //jenisNilai jenis nilai yang akan diminta dari pengguna, misalnya "tugas", "UTS", atau "UAS"
     * @return //nilai yang valid (berada antara 0 hingga 100) yang dimasukkan oleh pengguna
     */
    private static double inputNilai(Scanner scanner, String jenisNilai) {
        while (true) {
            try {
                System.out.print("Masukkan nilai " + jenisNilai + " (0-100): ");
                double nilai = Double.parseDouble(scanner.nextLine());

                if (nilai < 0 || nilai > 100) {
                    System.out.println("Error: Nilai harus antara 0 dan 100. Coba lagi.");
                }else {
                    return nilai;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka. Coba lagi.");
            }
        }
    }
}

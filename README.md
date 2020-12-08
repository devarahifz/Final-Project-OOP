# Tic Tac Toe

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

**Implementasi Java untuk membuat game TicTacToe. Game ini dimainkan oleh 2 orang yang masing-masing memilih simbol antara 'X' atau 'O', Pemain ditugaskan untuk menyejajarkan simbol mereka masing-masing secara horizontal, vertikal maupun diagonal. Pemain bergerak secara bergiliran dan yang lebih dahulu menyejajarkan simbol adalah pemenangnya.**

## Tim 3T
| NPM           | Name        |
| ------------- |-------------|
| 140810190019  | Devara Hifzhurrahman |
| 140810190055  | Anki Prawira Hidayat |
| 140810190067  | David Aditya Susanto |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (18/11/2020)** 
   -  Diskusi awal, membuat backlog
   -  Mencari tahu/eksplore TicTacToe di Java

- **[Sprint 1](changelog/sprint-1.md) - (18/11/2020 - 24/11/2020)** 
   - Membuat JFrame
   - Membuat Panel
   - Menyelesaikan mekanisme dasar dari game

- **[Sprint 2](changelog/sprint-2.md) - (25/11/2020 - 01/12/2020)** 
   - Merapikan UI
   - Menambahkan beberapa tombol
   
- **[Sprint 3](changelog/sprint-3.md) - (02/11/2020 - 08/11/2020)** 
   - Membetulkan error yang terdapat di leaderboard
   - Membetulkan tombol reset agar bisa mereset leaderboard
   - Mengubah beberapa access modifier
   - Merapikan dan menghapus kode yang tidak dipakai

## Running The App

1. Buka Folder src lalu buka command
     
2. Compile file TicTacToe.java
```
javac TicTacToe.java
```

3. Running file TicTacToe yang telah dicompile
```
java TicTacToe
```

## Classes Used

1. **Logic** - `Logic.java`
   - Objek yang menyimpan logika memulai dan mengakhiri game TicTacToe.
   - Dalam Logic juga terdapat objek yang mengekstensi ``JPanel``.
   - Dalam Logic juga terdapat objek yang mengekstensi ``ActionListener``.
2. **TicTacToe (Main Program)** - `TicTacToe.java`
   - Main Program yang dimana TicTacToe berjalan berdasarkan UI.
   - Dalam main program juga terdapat objek yang menjadi frame TicTacToe. 

![UML](/images/UML.png)

## Notable Assumption and Design App Details

- Buat frame dan panel 3x3.
- Buat giliran X atau O.
- Mengubah konten panel menjadi huruf dengan mencoba membentuk garis horizontal atau vertikal atau diagonal.
- Jika kotak terisi penuh dan tidak ada pemain yang bisa membentuk garis, permainan akan berakhir dan akan menampilkan seri.
- Setelah kondisi membentuk garis, tampilan akan berubah dan menampilkan pemain yang membentuk garis tersebut.
- Setelah permainan berakhir, tombol "Main lagi" akan muncul untuk memulai permainan lagi.
- Indikator Leaderboard akan bertambah pada pemain yang telah memenangkan permainan sebelumnya.

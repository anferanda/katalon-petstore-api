# API Testing Automation Project

Repository ini berisi script pengujian otomatis (*automated testing*) untuk API testing menggunakan API dari Petstore. 
Pengujian ini menggunakan Katalon Studio. 
Project ini memiliki 4 Test Case Positive yang ada di folder Pet-Store Positive Case dan 4 Test Case Negative yang ada di folder Pet-Store Negative Case.

## Struktur Project
* **Test Cases** : Berisi script pengujian skenario utama (Positive & Negative Cases).
* **Test Suites** : Kumpulan skenario untuk dieksekusi secara otomatis.
* **Object Repository** : Kumpulan request & endpoint API yang diuji.
* **Reports** : Berisi laporan hasil eksekusi pengujian dari test suite.

## Cara Menjalankan
1. Clone repository ini: `git clone https://github.com/anferanda/katalon-petstore-api.git`
2. Buka Katalon Studio, pilih **Open Project**, lalu arahkan ke folder API Testing.
3. Jalankan Test Suite 'Positive Test - Pets'.
4. Buka folder **Reports** untuk melihat hasil pengujian.
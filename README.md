# Tutorial APAP
## Authors

* **Fayza Azzahra Robby** - 1906305934 - C

---
## Tutorial 1
### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

Issue tracker atau GitHub Issues adalah suatu fitur di GitHub yang sangat membantu sebagai suatu 'tracker' yang dapat digunakan oleh development team (apabila collaborated project) maupun secara pribadi, untuk keep track berbagai *tasks*, *enhancements*, dan bugs pada project yang kita miliki. Adapun beberapa fitur yang disediakan oleh GitHub Issues adalah:
* Deal with issues
* Buat dan apply labels ke issues untuk assign ke users/tim
* Drag and drop issues
* Search, sort, dan filter
* Close issues

Dengan menggunakan Issue Tracker, kita dapat dengan mudah keep track of permintaan terhadap perubahan maupun tambahan fitur-fitur baru yang diinginkan pada project. Selain itu, dapat membantu untuk mengetahui sekarang sedang di tahapan mana pengerjaan. Issues juga dapat di-link ke suatu pull request. Apabila pull request tersebut di-merge, maka issue yang terhubung tersebut akan tertutup secara otomatis.
Untuk soal bug tracker, GitHub Issues sangat membantu untuk melakukan bug tracking bersama tim, apabila memang suatu collaborated project.
**Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**
Pada Issues, terdapat labels yang dapat diberikan kepada issues untuk menandakan hal tersebut dikategorikan ke permasalahan apa. Berikut adalah pembagiaannya:

* Bugs
* Documentation (add improvements or additions to documentation)
* Duplicate (apabila terdapat issue atau pull request yang sudah ada, lalu ingin di-duplicate)
* Enhancement (fitur baru atau request baru)
* Good first issue
* Help wanted
* Invalid
* Question
* Wontfix
* Selain itu, kita juga dapat menambahkan label baru yang di-custom sesuka kita.

Referensi:
* https://github.blog/2009-04-15-github-issue-tracker/


2. Apa perbedaan dari git merge dan git merge --squash?

Walaupun keduanya memiliki tujuan utama yang sama, yaitu menggabungkan branch dengan branch master, namun terdapat beberapa perbedaan. Sesuai dengan referensi yang saya baca, git merge akan melakukan merge semua commit yang ada dari branch terkait ke main branch. Sedangkan untuk git merge --squash akan menggabungkan semua commit yang ada di branch terkait menjadi satu commit, lalu baru akan di-merge ke main branch. Sesuai dengan namanya, 'squash' akan melakukan penggabungan dulu semua commit yang ada pada branch tersebut, baru di-merge dalam bentuk 1 commit tergabung.

Referensi:
* https://rietta.com/blog/github-merge-types/

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?

Version Control sangat membantu dalam pengembangan suatu aplikasi, karena dapat melakukan pengaturan pada suatu file, dataset, maupun document yang digunakan pada proyek tersebut. Selain itu, jika terdapat perubahan apapun pasti akan tersimpan sebagai suatu *version*, dan dapat kita lihat lagi historynya setelahnya. Kelebihan seperti branching juga membantu apabila terdapat banyak fitur yang perlu dikerjakan, dan apabila dilakukan pada suatu branch saja pasti nanti akan sangat chaos, atau dalam kata lain dapat mengembangkan secara paralel, lalu di-merge ke main apabila sudah siap. Untuk masalah collaboration juga sangat memadai jika menggunakan Version Control System. 
Berikut adalah beberapa benefits yang saya dapatkan dari sumber terkait:
* Traceability
* Document History
* Branching and Merging
* Identity
* Reduction Of Duplication And Errors
* Management Overview
* Open Channels of Communication
* Adherence to Compliance
* Efficiency

Referensi:
* https://reqtest.com/requirements-blog/what-are-benefits-of-version-control/

### Spring
4. Apa itu library & dependency?

Pada Spring maupun pada programming in general, library adalah koleksi dari berbagai fungsi yang prewritten dan dapat digunakan pada pengembangan aplikasi atau program yang sedang kita buat. Sesuai dengan definisi kata tersebut, dependency berarti keterkaitan, yang berarti keterkaitan antar class maupun fungsi pada aplikasi. Sebagai contoh, apabila terdapat interface yang bernama SortAlgorithm, lalu ada class bernama BubbleSortAlgorithm yang implements class tersebut, maka dapat dibilang bahwa SortAlgorithm adalah dependency dari BubbleSortAlgorithm.

Referensi:
* https://www.idtech.com/blog/what-are-libraries-in-coding
* https://www.springboottutorial.com/spring-framework-what-is-a-dependency

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?

Maven adalah suatu tool project management yang berbasis pada konsep Project Object Model (POM). Maven dapat manage build dari suatu project, dengan cara reporting dan melakukan dokumentasi dari suatu central piece of information. Maven dapat digunakan untuk mengembangkan project yang Java-based. 
Adapun beberapa alasan dari penggunaan Maven adalah (berdasarkan sumber dari official Maven Docs):
* Change log created directly from source control
* Cross referenced sources
* Mailing lists managed by the project
* Dependencies used by the project
* Unit test reports including coverage
Alternatif dari Maven adalah Azure DevOps, CMake, GNU Make, dan Gradle.

Referensi:
* https://maven.apache.org/
* https://alternativeto.net/software/maven/

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?

Selain untuk pengembangan web, spring framework dapat digunakan untuk Microservices, Reactive, Cloud, Event Driven, Serverless, dan Batch (automated tasks).

Referensi:
* https://spring.io/

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?

Pada Spring MVC, @RequestParam dan @PathVariable sama-sama digunakan untuk fetch value dari request parameters. Walaupun tujuannya sama, namun terdapat perbedaan pada penggunaannya. @RequestParam digunakan untuk mengakses value dari query parameter, sedangkan @PathVariable digunakan untuk mengakses value dari URI template. Untuk @RequestParam di-encode dan cocok untuk web yang datanya disimpan melalui query dan parameter di=passing dalam bentuk request parameter, sedangkan @PathVariables tidak di-encode dan cocok untuk web yang menyimpan data dari URL dengan value pada placeholder.

Referensi:
* https://www.dineshonjava.com/requestparam-vs-pathvariable-annotations-in-spring-mvc/

### What I did not understand
- [ ] Saya masih belum terlalu memahami mengenai Maven, apabila tidak menggunakan Maven apakah bisa?
- [ ] Kenapa harus mengetahui mengenai Dependency Injection?


---
## Tutorial 2
### What I have learned today
Pada tutorial kali ini, saya lebih memahami mengenai konsep MVC dan implementasinya secara nyata pada Model, Controller, dan Service. Awalnya ketika belajar teorinya saja saya sempat kebingungan. Selain itu, saya juga menjadi lebih paham mengenai Request Mapping, karena saya seringkali mengalami error terkait hal tersebut.

1. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

* Saat membuka link tersebut, akan terjadi Whitelabel Error Page dengan status error 500, dan disebutkan bahwa template might not exist. Alasannya adalah karena pada tahap ini (saat membuka link tersebut) kita belum membuat template, dan baru hanya membuat Controller saja. Sesuai dengan konsep MVC, belum ada view untuk controller tersebut. Untuk resolve error tersebut, solusinya adalah dengan membuat template HTML pada resources/templates. 
* Berikut adalah screenshot dari tampilan web ketika link tersebut dibuka: https://ibb.co/PYgV49K

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

Anotasi @Autowired pada class Controller adalah implementasi dari konsep Dependency Injection (DI). Dengan menggunakan anotasi Autowired, Spring dapat *resolve dan inject collaborating beans into our bean*. Selain itu, suatu dependency akan ter-inject interfacenya secara otomatis ke Service yang mengimplementasikan autowiring ini, maka kita letakkan anotasi Autowired di atas declaration BioskopService. Jika dilihat pada BioskopInMemoryService, terdapat anotasi @Service yang menandakan bahwa itu adalah suatu Service.

cara kerjanya adalah dependency interfacenya diinject otomatis via autowiring ke service yang mengimplementasi autowiring ini.

Referensi:
* https://blog.scottlogic.com/2020/02/25/spring-autowiring-its-a-kind-of-magic.html
* https://www.baeldung.com/spring-autowire
* https://javapointers.com/spring/spring-mvc/use-autowired-annotation-spring/
* https://springframework.guru/best-practices-for-dependency-injection-with-spring/

3. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

**Berikut adalah error yang terjadi:**
There was an unexpected error (type=Bad Request, status=400).
Required request parameter 'jumlahStudio' for method parameter type int is not present
* Screenshot: https://ibb.co/5LhFWGq
* Error yang terjadi adalah kurangnya parameter jumlahStudio yang seharusnya berada setelah parameter noTelpon. So to put it simply, error terjadi karena hanya kurang satu parameter yang required true.

4. Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?

* Seperti pada latihan 1, kita bisa menggunakan Path Variable namun dengan value namaBioskop. Jika pada latihan 1 saya menggunakan idBioskop sebagai value, maka untuk kasus pada pertanyaan ini bisa diganti menjadi namaBioskop, dan contoh path link untuk mengaksesnya bisa menjadi bioskop/view/nama-bioskop/{namaBioskop}
* Namun jika diasumsikan bioskop dengan nama Bioskop Maung tersebut memiliki id 2, maka kita bisa mengakses melalui link http://localhost:8080/bioskop/view/id-bioskop/2


5. Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

Saya menambahkan bioskop baru dengan cara berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20fayza&alamat=Maung&noTelepon=081xxx&jumlahStudio=10

* Saat menambahkan Bioskop baru: https://ibb.co/mBFcLpz
* Saat mengakses viewall: https://ibb.co/qnZy4VW
* Saya menambahkan suatu Bioskop baru dengan ID yang sama (karena penasaran ingin mencoba apakah dengan ID yang sama tetap akan terbuat, dan ternyata bisa karena kita tidak ngeset unique dimanapun). Lalu, ketika saya mengakses laman viewall, akan ditampilkan bioskop baru tersebut.

### What I did not understand
- [ ] Implementasi Autowiring secara mendalam
- [ ] Perbedaan Path Variable dan Request Param
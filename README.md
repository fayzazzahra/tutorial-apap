# Tutorial APAP
## Authors

* **Fayza Azzahra Robby** - 1906305934 - C

## Tutorial 7
### What I have learned today

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan
props?

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam
React? sebutkan alasannya.

4. Apa perbedaan class component dan functional component?

5. Dalam react, apakah perbedaan component dan element?

- ---

## Tutorial 6
### What I have learned today


1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
   * Otentikasi: Proses verifikasi pengguna oleh sistem, agar dapat membuktikan identitas pengguna. Proses otentikasi terjadi saat user sedang login ke sistem. 
     * Implementasi otentikasi dalam kode tutorial terdapat pada WebSecurityConfig.java:
     
     `@Autowired
     public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
     }`
   * Otorisasi: Setelah pengguna sudah lolos otentikasi, dan ketika pengguna ingin mengakses suatu resource. Proses otorisasi ini akan cek apakah user tersebut memiliki hak akses terhadap resource yang ingin diakses. 
     * Implementasinya otorisasi dalam kode tutorial terdapat pada class WebSecurityConfig.java, dimana path /penjaga/ hanya dapat diakses oleh role MANAGER:
     `.antMatchers("/penjaga/**").hasAuthority("MANAGER")`
       * Juga terdapat pada home.html, saat menunjukkan button yang akan tertampil ke user:
   `<div sec:authorize="hasAuthority('ADMIN')`

* https://www.sailpoint.com/identity-library/difference-between-authentication-and-authorization/

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
   * BCrypthPasswordEncoder merupakan sebuah class dari package org.springframework.security.crypto.bcrypt yang melakukan hashing/encrypt password menggunakan algoritma BCrypt. Jadi, saat user register dan menginput password mereka utk pertama kalinya, akan langsung dienkripsi karena adanya BCryptPasswordEncoder, dan yang tersimpan pada database adalah hasil enkripsi password tersebut. Cara kerjanya adalah akan secara otomatis men-generate dan menggunakan suatu random salt untuk menentukan hashingnya, sehingga tiap kita memanggilnya pasti akan mendapatkan output/hasil hasihng yang berbeda.
* https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html
* https://stackoverflow.com/questions/48131535/how-does-bcryptpasswordencoder-work-with-spring-security

3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
   * Hashing melakukan permanent data conversion, dan melindungi integritas informasi.
   * Encryption memiliki dua mekanisme, yaitu encoding dan decoding data terkait, dan digunakan untuk melindungi data dari pihak ketiga.
   * Hashing dan Encryption sama-sama menyediakan cara untuk menjaga keamanan data yang bersifat sensitif. Namun, dalam penggunaan secara umum, password harus di-hash, bukan dienkripsi.
   * Hashing merupakan fungsi one-way yang cocok untuk validasi password. Oleh karena itu, walaupun penyerang mempunyai hashed password pengguna, mereka tidak akan bisa memasukkannya ke field password dan login seperti orang biasa.
   * Sedangkan Encryption merupakan fungsi two-way, dimana plaintext original datanya bisa dengan mudah diambil. Encryption cocok digunakan untuk penyimpanan data yang sifatnya tidak terlalu sensitif (seperti password), misalnya alamat atau nomor telepon.
     * https://www.clickssl.net/blog/difference-between-hashing-vs-encryption

4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
    * Universally Unique Identifier (UUID) adalah 128-bit value yang digunakan untuk mengidentifikasi sebuah object atau entity secara unik.
    * UUID dapat terjamin berbeda, atau at least sangat kecil probabilitasnya untuk terulang dua kali (tergantung pada mekanisme yang digunakan).
    * UUID biasanya digunakan untuk meningkatkan keamanan data pengguna, karena unik.
    * Sebagai contoh, ID pengguna dibuat hashing 32 karakter secara unik dan acak, sehingga ID tersebut akan sulit diretas. Hal ini diimplementasikan pada saat kita membuat user baru pada sistem 21cineplux.
      * https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
   Class UserDetailsServiceImpl.java mengimplementasikan interface UserDetailsService yang diimport dari org.springframework.security.core (bawaan, bukan kita implement sendiri). Interface UserDetailsService ini akan dipakai untuk user DAO saat mengambil informasi otentikasi serta otorisasi pengguna.

### What I did not understand

 ---
## Tutorial 5
Pada tutorial kali ini, saya membelajari mengenai Postman dan WebClient

1. Apa itu Postman? Apa kegunaannya?
* Postman adalah aplikasi yang digunakan untuk API testing, dan merupakan sebuah HTTP client yang melakukan test HTTP request. GUI dari Postman sangat membantu agar testing API menjadi jauh lebih mudah.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
* @JsonIgnoreProperties : menandai property atau sekumpulan property yang perlu di-ignore saat serialization, serta dapat ignore processing JSON read saat deserealization. Anotasi ini digunakan pada level Class
  * https://fasterxml.github.io/jackson-annotations/javadoc/2.6/com/fasterxml/jackson/annotation/JsonIgnoreProperties.html
* @JsonProperty : digunakan untuk mendefinisikan property name di JSON. Anotasi ini digunakan untuk serialize atau deserialize nama property saat sedang berurusan dengan non-standard setter dan getter. Anotasi ini digunakan pada level Field.
  * https://fasterxml.github.io/jackson-annotations/javadoc/2.8/com/fasterxml/jackson/annotation/JsonProperty.html
  * https://www.baeldung.com/jackson-annotations

3.Apa kegunaan atribut WebClient?
* Atribut WebClient adalah interface yang berfungsi untuk mengirim dan menerima data dari resource URI. Berdasarkan sumber dari Baeldung, WebClient adalah main entry point untuk melakukan web requests.
  * https://www.baeldung.com/spring-5-webclient

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
* ResponseEntity: mewakilkan keseluruhan respons HTTP, yaitu status code, headers, dan body. Dengan ResponseEntity, kita dapat melakukan konfigurasi status code yang dengan @ResponseStatus, lalu untukheader, dan body yang dengan @ResponseBody. Harus dilakukan dari endpoint.
  * https://www.baeldung.com/spring-response-entity
* BindingResult: interface yang dapat menentukan bagaimana suatu object menyimpan serta mengambil hasil validasi, dan objeknya dapat dijadikan argumen method Validator di Controller.
  * https://www.baeldung.com/spring-mvc-custom-validator


## Tutorial 4
### What I have learned today
Pada tutorial kali ini, saya semakin memahami mengenai konsep MVC dan implementasinya secara nyata pada Model, Controller, Service, dan View. Selain itu, saya memahami mengenai praktisnya menggunakan JPA, walaupun masih harus banyak latihan lagi.

1. Jelaskan perbedaan th:include dan th:replace!
* th:include
Digunakan untuk memasukkan konten dari fragments ke dalam tag <div> (tag host). Syntaxnya adalah sebagai berikut: <div th:include=”..”> content </div>

* th:replace
Digunakan untuk mengganti tag host dengan tag pada fragment. Intinya, akan menghapus tag host dan menambahkan tag fragmen. Syntaxnya adalah: <div th:replace=”..”> content </div>

Referensi: 
* https://stackoverflow.com/questions/37103958/difference-between-thymeleaf-include-and-replace

2. Jelaskan apa fungsi dari th:object!

th:object digunakan untuk spesifikasi suatu objek yang akan disubmit pada form. Wajib digunakan pada atribut pada tag form di thymeleaf, dan fungsinya untuk menandakan model attribute manakah yang akan disubmit. Contohnya adalah pada tag form di halaman add bioskop:
<form th:action="@{/bioskop/add}" th:object="${bioskop}" method="POST">
Syntaxnya adalah th:field=”*{name}”, dimana nama adalah object yang akan disubmit.

https://www.baeldung.com/thymeleaf-in-spring-mvc

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?

Kedua * dan $ digunakan pada th:object
* *{...} atau asterisk biasanya digunakan pada th:object untuk mengevaluasi suatu object yang sudah dideklarasi
* ${...} digunakan untuk mengevaluasi variabel atau secara keseluruhan. 

https://stackoverflow.com/questions/58976993/what-is-the-difference-between-thfield-something-and-thfield-something

### What I did not understand

---
## Tutorial 3
### What I have learned today
Pada tutorial kali ini, saya semakin memahami mengenai konsep MVC dan implementasinya secara nyata pada Model, Controller, Service, dan View. Selain itu, saya memahami mengenai praktisnya menggunakan JPA, walaupun masih harus banyak latihan lagi.


1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
   (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)

Anotasi-anotasi yang terdapat pada model adalah Constructor Injection in Spring dengan menggunakan Lombok. Hal ini sangat membantu ketika ingin melakukan passing dependency dari sebuah component ke sebuah constructor secara explicitly. Dengan menggunakan anotasi-anotasi tersebut, kita tidak perlu worry apabila ada dependency yang tidak terinject ke constructor, serta mengurangi kode yang repetitif. 
* @AllArgsConstructor : generate constructor untuk semua field pada suatu class
* @NoArgsContructor : generate empty constructor
* @Setter & @Getter : generate setter ataupun getter untuk semua field pada suatu class. Tidak perlu buat satu persatu secara manual
* @Entity : digunakan pada entity class, di mana field pada class tersebut mampu merepresentasikan sebuah object pada database
* @Table : digunakan untuk mengganti nama table pada database, agar tidak sama dengan nama class pada Model. Dalam kasus BioskopModel, table yang akan terbuat pada database untuk model Bioskop adalah "bioskop", yang didefinisikan dengan @Table(name = "bioskop"). Tanpa anotasi @Table, nama tabel yang akan terbuat akan disesuaikan dengan nama Model.

Referensi: 
* https://www.baeldung.com/spring-injection-lombok
* https://www.baeldung.com/intro-to-project-lombok
* https://www.objectdb.com/java/jpa/start/entity
* https://huongdanjava.com/learn-about-entity-and-table-annotation-in-jpa.html

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut?

* Spring Data JPA memiliki berbagai derived query method yang dapat melakukan operasi find, read, count, dan get standar. Untuk memanfaatkannya, kita perlu mendeklarasikan pada Repository BioskopDB yang extends interface JpaRepository. Method findByNoBioskop memanfaatkan keyword findBy yang ada di JPARepository, yang merupakan implementasi SQL secara instan. Terdapat syntax untuk menggunakan derived query ini, yaitu dengan cara queryByName. 
* Method findByNoBioskop digunakan untuk melakukan filter objek bioskop berdasarkan noBioskop. Pada dasarnya, method tersebut sama saja seperti melakukan query SELECT ke tabel bioskop pada SQL.

Referensi: 
* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn

* @JoinTable : menyimpan id dari kedua entity yang dilakukan operasi JOIN dalam ke table yang terpisah. Dapat digunakan digunakan ketika membutuhkan database yang dinormalisasi, atau ketika terdapat hubungan antar entity pada tabel yang berbeda.
* @JoinColumn : menyimpan id dari salah satu entity, dan disimpan di column baru pada tabel yang sama. Dapat digunakan ketika entity-entity tersebut memiliki hubungan langsung (contohnya foreign key antara kedua entity), dan tidak ada keperluan membuat tabel gabungan baru.

Referensi: 
* https://javakeypoint.wordpress.com/2020/04/21/difference-between-joincolumn-and-jointable-in-hibernate/

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull

Anotasi @JoinColumn memiliki beberapa properti yang dapat dilihat pada atribut bioskop di class PenjagaModel, yaitu name, referencedColumnName, dan nullable.
* name : menunjukkan nama kolom yang akan menjadi foreignkey (dikaitkan/dirujuk ke kolom lain)
* referencedColumnName: menunjukkan nama kolom yang dirujuk oleh foreign key
* nullable : apabila false, maka tidak boleh ada nilai null. intinya, nullable memberikan constraint not null ke kolom tersebut. 
* @NotNull adalah bean validation, yang berarti @NotNull bisa menerapkan fungsi yang serupa dengan nullable, tapi tidak terbatas pada entity tersebut saja, dan bisa diterapkan untuk bean lainnya.

Referensi:
* https://www.baeldung.com/hibernate-notnull-vs-nullable
* https://www.baeldung.com/jpa-join-column

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

Pada Hibernate, data fetching/loading dapat diklasifikasikan menjadi dua tipe yaitu LAZY dan EAGER. Secara garis besar, EAGER melakukan data inizialization on the spot, dan LAZY dapat menunda pemanggilan data hingga terdapat pemanggilan method secara eksplisit. 
* FetchType.LAZY : tidak melakukan load semua object child, saat object parent dilakukan fetching. Baru akan di-load ketika dipanggil secara eksplisit menggunakan Getter.
* CascadeType.ALL : memungkinkan operasi secara otomatis kepada sutu entity, apabila entity yang berelasi dengannya dilakukan suatu operasi tertentu. ALL menandakan bahwa semua jenis operasi dapat di-cascade.
* FetchType.EAGER : load semua object child saat object parent dilakukan fetching.

Referensi:
* https://www.baeldung.com/hibernate-lazy-eager-loading

### What I did not understand
- [ ] Implementasi hibernate
- [ ] Logic dari method JPA
- [ ] Perbedaan Optional dan List biasa
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


>>>>>>> main

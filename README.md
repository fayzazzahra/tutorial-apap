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

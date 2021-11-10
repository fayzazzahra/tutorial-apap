package apap.tutorial.cineplux.model;

<<<<<<< HEAD
=======

>>>>>>> main
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "bioskop")
public class BioskopModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noBioskop;

    @NotNull
    @Size(max = 80)
    @Column(nullable = false)
    private String namaBioskop;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String alamatBioskop;

    @NotNull
    @Column(nullable = false)
    private int jumlahStudio;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuTutup;

    //Relasi dengan PenjagaModel
    @OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PenjagaModel> listPenjaga;

    //Relasi dengan FilmModel
    @ManyToMany
    @JoinTable(
            name = "film_bioskop",
            joinColumns = @JoinColumn(name = "no_bioskop"),
            inverseJoinColumns = @JoinColumn(name = "no_film"))
    List<FilmModel> listFilm;

}




//    public BioskopModel(String idBioskop, String namaBioskop, String alamat, String noTelepon, int jumlahStudio) {
//        this.idBioskop = idBioskop;
//        this.namaBioskop = namaBioskop;
//        this.alamat = alamat;
//        this.noTelepon = noTelepon;
//        this.jumlahStudio = jumlahStudio;
//    }
//
//    public String getIdBioskop() {
//        return idBioskop;
//    }
//
//    public void setIdBioskop(String idBioskop) {
//        this.idBioskop = idBioskop;
//    }
//
//    public String getNamaBioskop() {
//        return namaBioskop;
//    }
//
//    public void setNamaBioskop(String namaBioskop) {
//        this.namaBioskop = namaBioskop;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public String getNoTelepon() {
//        return noTelepon;
//    }
//
//    public void setNoTelepon(String noTelepon) {
//        this.noTelepon = noTelepon;
//    }
//
//    public int getJumlahStudio() {
//        return jumlahStudio;
//    }
//
//    public void setJumlahStudio(int jumlahStudio) {
//        this.jumlahStudio = jumlahStudio;
//    }
//}
<<<<<<< HEAD
=======

public class BioskopModel {
    private String idBioskop;
    private String namaBioskop;
    private String alamat;
    private String noTelepon;
    private int jumlahStudio;

    public BioskopModel(String idBioskop, String namaBioskop, String alamat, String noTelepon, int jumlahStudio) {
        this.idBioskop = idBioskop;
        this.namaBioskop = namaBioskop;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.jumlahStudio = jumlahStudio;
    }

    public String getIdBioskop() {
        return idBioskop;
    }

    public void setIdBioskop(String idBioskop) {
        this.idBioskop = idBioskop;
    }

    public String getNamaBioskop() {
        return namaBioskop;
    }

    public void setNamaBioskop(String namaBioskop) {
        this.namaBioskop = namaBioskop;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public int getJumlahStudio() {
        return jumlahStudio;
    }

    public void setJumlahStudio(int jumlahStudio) {
        this.jumlahStudio = jumlahStudio;
    }
}

>>>>>>> main

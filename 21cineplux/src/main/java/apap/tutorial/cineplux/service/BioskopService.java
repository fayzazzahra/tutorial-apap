package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService {
    //method untuk menambah bioskop
    void addBioskop(BioskopModel bioskop);

    //update bioskop
    void updateBioskop(BioskopModel bioskop);


    //method untuk mendapatkan daftar bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    //method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop

    BioskopModel getBioskopByNoBioskop(Long noBioskop);

    //untuk latihan no 1, memanfaatkan query pada JPA
    List<BioskopModel> findByOrderByNamaBioskopAsc();

    //deletebioskop
    void deleteBioskop (BioskopModel bioskop);

    BioskopModel getBioskopByIdBioskop(String idBioskop);

    //method untuk remove bioskop
    void removeBioskop(BioskopModel bioskop);


}

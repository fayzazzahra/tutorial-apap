package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> main
public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    int updatePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
<<<<<<< HEAD
    int deletePenjaga (PenjagaModel penjaga);
    List<PenjagaModel> findByOrderByNamaPenjagaAsc();

=======
    void deletePenjaga (PenjagaModel penjaga);
>>>>>>> main

}
package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface PenjagaService {
    int addPenjaga(PenjagaModel penjaga);
    int updatePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
    void deletePenjaga (PenjagaModel penjaga);
    List<PenjagaModel> findByOrderByNamaPenjagaAsc();

}
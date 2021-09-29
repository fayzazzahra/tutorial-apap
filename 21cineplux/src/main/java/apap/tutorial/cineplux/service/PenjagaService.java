package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    int updatePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
    void deletePenjaga (PenjagaModel penjaga);

}
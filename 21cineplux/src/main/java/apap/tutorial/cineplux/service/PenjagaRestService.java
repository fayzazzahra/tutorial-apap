package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.rest.BioskopDetail;
import apap.tutorial.cineplux.rest.UmurPenjaga;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PenjagaRestService {
    PenjagaModel createPenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
    PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate);
    List<PenjagaModel> retrieveListPenjaga();
    void deletePenjaga(Long noPenjaga);


//    Mono<String> getStatus(Long noBioskop);
//    Mono<BioskopDetail> postStatus();

    Mono<UmurPenjaga> umurPenjaga(Long noPenjaga);
}
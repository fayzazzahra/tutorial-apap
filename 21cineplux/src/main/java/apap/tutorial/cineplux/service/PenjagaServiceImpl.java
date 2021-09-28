package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService{

    @Autowired
    PenjagaDB penjagaDB;

    @Autowired
    BioskopDB bioskopDB;

    @Override
    public int addPenjaga(PenjagaModel penjaga) {
//        PenjagaModel uPenjaga = penjagaDB.findByNoPenjaga(penjaga.getNoPenjaga());
//        BioskopModel bioskop = bioskopDB.;
//        List<BioskopModel> listBioskop = bioskopDB.findByOrderByNamaBioskopAsc();
        //findallbynamapenjaga -> paramnya nama penjaga, jadi kalau ada -> berarti udah ada nama penjaganya trus bs return t/f
        List<PenjagaModel> listPenjaga = (List<PenjagaModel>) penjagaDB.findByOrderByNamaPenjagaAsc();
        for (PenjagaModel x: listPenjaga) {
            if (penjaga.getNamaPenjaga().equals(x.getNamaPenjaga())) {
                return 0;
            }
        }
        penjagaDB.save(penjaga);
        return 1;
    }

    @Override
    public int updatePenjaga(PenjagaModel penjaga) {
        PenjagaModel uPenjaga = penjagaDB.findByNoPenjaga(penjaga.getNoPenjaga());

        BioskopModel bioskop = bioskopDB.findByNoBioskop(uPenjaga.getBioskop().getNoBioskop()).get();
        LocalTime now = LocalTime.now();
        LocalTime tutup = bioskop.getWaktuTutup();
        LocalTime buka = bioskop.getWaktuBuka();

        if ((now.isAfter(tutup) || now.isBefore(buka))) {
            uPenjaga.setNamaPenjaga(penjaga.getNamaPenjaga());
            uPenjaga.setJenisKelamin(penjaga.getJenisKelamin());
            penjagaDB.save(uPenjaga);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        PenjagaModel penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        return penjaga;
    }

    @Override
    public void deletePenjaga(PenjagaModel penjaga) {
        penjagaDB.delete(penjaga);
    }

    @Override
    public List<PenjagaModel> findByOrderByNamaPenjagaAsc() {
        return (List<PenjagaModel>) penjagaDB.findByOrderByNamaPenjagaAsc();
    }
}

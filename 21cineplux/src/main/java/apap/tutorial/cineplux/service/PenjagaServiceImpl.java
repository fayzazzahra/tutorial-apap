package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.repository.BioskopDB;
<<<<<<< HEAD
import org.apache.tomcat.jni.Local;
=======
>>>>>>> main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> main
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService{

    @Autowired
    PenjagaDB penjagaDB;

    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
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
<<<<<<< HEAD
    public int deletePenjaga(PenjagaModel penjaga) {
        LocalTime now = LocalTime.now();
        BioskopModel bioskop = bioskopDB.findByNoBioskop(penjaga.getBioskop().getNoBioskop()).get();
        if (now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup())) {
            penjagaDB.delete(penjaga);
            return 1;
        }
        return 0;
    }

    @Override
    public List<PenjagaModel> findByOrderByNamaPenjagaAsc() {
        return (List<PenjagaModel>) penjagaDB.findByOrderByNamaPenjagaAsc();
    }
=======
    public void deletePenjaga(PenjagaModel penjaga) {
        penjagaDB.delete(penjaga);
    }

>>>>>>> main
}

package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
public class PenjagaController {

    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("/penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("penjaga/add")
    public String addPenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        penjagaService.addPenjaga(penjaga);
        String msg = "";
        msg += penjaga.getNamaPenjaga();
        msg += " successfully added to ";
        msg += penjaga.getBioskop().getNamaBioskop();

        model.addAttribute("msg", msg);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());

        return "add-penjaga";
    }

    @RequestMapping(value = "penjaga/update/{noPenjaga}", method = RequestMethod.GET)
    public String updatePenjagaForm(@PathVariable Long noPenjaga,
                                    Model model) {
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        if (penjaga == null) {
            return "notfound-penjaga";
        }
        model.addAttribute("penjaga", penjaga);
        return "form-update-penjaga";
    }

    @PostMapping("penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        int update = penjagaService.updatePenjaga(penjaga);
        String msg = "";
        if (update == 1) {
            msg += "Penjaga berhasil diupdate";
        } else if (update == 0) {
            msg += "Tidak dapat update penjaga saat bioskop masih buka";
        }
        model.addAttribute("msg", msg);
//        model.addAttribute("bioskop",penjaga.getBioskop().getNoBioskop());
        return "update-penjaga";
    }

    @PostMapping("/penjaga/delete")
    public String deletePenjagaSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {

        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        int res = 1;
        for (PenjagaModel penjaga: bioskop.getListPenjaga()) {
            res = penjagaService.deletePenjaga(penjaga);
        }

        if (res == 1) {
            model.addAttribute("msg", "Penjaga berhasil dihapus.");
            return "remove-penjaga";
        }
        return "error";
    }

    @RequestMapping(value = "penjaga/delete/{noPenjaga}",
            method = RequestMethod.GET)
    public String removePenjagaByNoPenjaga(
            @PathVariable Long noPenjaga,
            @ModelAttribute PenjagaModel penjagaModel,
            Model model
    ) {
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);

        if (penjaga == null) {
            return "notfound-penjaga";
        }

        LocalTime now = LocalTime.now();
        LocalTime buka = penjaga.getBioskop().getWaktuBuka();
        LocalTime tutup = penjaga.getBioskop().getWaktuTutup();
        System.out.println(now.isAfter(tutup) || now.isBefore(buka));

        String msg = "";
        List<PenjagaModel> listPenjaga = penjaga.getBioskop().getListPenjaga();
        if (now.isAfter(tutup) || now.isBefore(buka)) {
            penjagaService.deletePenjaga(penjaga);
            msg += "Penjaga berhasil dihapus";
        } else {
            msg += "Tidak dapat delete penjaga saat bioskop masih buka";
        }
        model.addAttribute("msg", msg);
        System.out.println(msg);
        return "remove-penjaga";
    }

}
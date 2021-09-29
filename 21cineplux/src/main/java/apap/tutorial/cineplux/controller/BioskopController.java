package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

@Controller
public class BioskopController {
    @Qualifier("bioskopServiceImpl")

import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BioskopController {

    @Autowired
    private BioskopService bioskopService;

    //routing URL yang diinginkan

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop", new BioskopModel());
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.findByOrderByNamaBioskopAsc();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);

        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        model.addAttribute("bioskop", bioskop);

        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.updateBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @RequestMapping(value = "bioskop/delete/{noBioskop}",
            method = RequestMethod.GET)
    public String removeBioskopByNoBioskop(
            @PathVariable Long noBioskop,
            @ModelAttribute BioskopModel bioskopModel,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        if (bioskop == null) {
            return "notfound-bioskop";
        }
        LocalTime now = LocalTime.now();
        LocalTime buka = bioskop.getWaktuBuka();
        LocalTime tutup = bioskop.getWaktuTutup();

        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        String msg = "";
        Boolean checkPenjaga = listPenjaga.size() == 0;
        Boolean checkTime = now.isAfter(tutup) || now.isBefore(buka);
        if (checkPenjaga && checkTime) {
            bioskopService.deleteBioskop(bioskop);
            msg += "Bioskop berhasil dihapus";
        } else if (!checkTime) {
            msg += "Tidak dapat delete bioskop saat masih buka. Coba beberapa saat lagi";
        } else if (!checkPenjaga) {
            msg += "Tidak dapat delete bioskop yang memiliki penjaga. Lakukanlah delete penjaga terlebih dahulu.";
        }
        model.addAttribute("msg", msg);
        return "remove-bioskop";
    }
}


//
//    public String addBioskop(
//            //request parameter yang ingin digunakan
//            @RequestParam(value = "idBioskop",required = true) String idBioskop,
//            @RequestParam(value = "namaBioskop",required = true) String namaBioskop,
//            @RequestParam(value = "alamat",required = true) String alamat,
//            @RequestParam(value = "noTelepon",required = true) String noTelepon,
//            @RequestParam(value = "jumlahStudio",required = true) int jumlahStudio,
//            Model model
//    ) {
//        //membuat objek BioskopModel
//        BioskopModel bioskopModel = new BioskopModel(idBioskop,namaBioskop,alamat,noTelepon,jumlahStudio);
//
//        //menambahkan objek BioskopModel ke dalam service
//        bioskopService.addBioskop(bioskopModel);
//
//        //add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
//        model.addAttribute("idBioskop",idBioskop);
//
//        //return view template yang digunakan
//        return "add-bioskop";
//    }
//
//    @RequestMapping("/bioskop/viewall")
//    public String listBioskop(Model model) {
//        //mendapatkan semua bioskop
//        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
//
//        //add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
//        model.addAttribute("listBioskop", listBioskop);
//
//        //return view template yang diinginkan
//        return "viewall-bioskop";
//    }
//
//    @RequestMapping("/bioskop/view")
//    public String detailBioskop(
//            @RequestParam(value = "idBioskop", required = true) String idBioskop,
//            Model model
//    ) {
//        //mendapatkan bioskop sesuai dengan idBioskop
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//
//        //cek keberadaan bioskop
//        if(bioskop == null){
//            return "notfound-bioskop";
//        }
//
//        //add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
//        model.addAttribute("bioskop", bioskop);
//        return "view-bioskop";
//    }
//
//    @RequestMapping("bioskop/view/id-bioskop/{idBioskop}")
//    public String viewBioskopPathVariable(
//            @PathVariable(value = "idBioskop") String idBioskop,
//            Model model
//    ){
//        //mendapatkan bioskop sesuai dengan id
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//
//        //cek keberadaan bioskop
//        if(bioskop == null){
//            return "notfound-bioskop";
//        }
//
//        model.addAttribute("bioskop",bioskop);
//        return "view-bioskop";
//    }
//
//    @RequestMapping("bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
//    public String updateJumlahStudio(
//            @PathVariable(value = "idBioskop") String idBioskop,
//            @PathVariable(value = "jumlahStudio") int jumlahStudio,
//            Model model
//    ){
//
//        //mendapatkan bioskop sesuai dengan id
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//
//        //cek keberadaan bioskop
//        if(bioskop == null){
//            return "notfound-bioskop";
//        }
//
//        //set jumlah studio yang mau diupdate
//        bioskop.setJumlahStudio(jumlahStudio);
//
//        //add variabel bioskop untuk dirender pada thymeleaf
//        model.addAttribute("bioskop",bioskop);
//        return "update-bioskop";
//    }
//
//    @RequestMapping("bioskop/delete/id-bioskop/{idBioskop}")
//    public String deleteBioskop(
//            @PathVariable(value = "idBioskop") String idBioskop,
//            Model model
//    ){
//
//        //mendapatkan bioskop sesuai dengan id
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//
//        //cek keberadaan bioskop
//        if(bioskop == null){
//            return "notfound-bioskop";
//        }
//
//        //remove bioskop menggunakan method remove yang ada di Service
//        bioskopService.removeBioskop(bioskop);
//
//        //add variabel bioskop untuk dirender pada thymeleaf
//        model.addAttribute("bioskop",bioskop);
//        return "delete-bioskop";
//    }
//
//    @RequestMapping("bioskop/delete/no-telepon/{noTelepon}")
//    public String deleteBioskopByPhoneNumb(
//            @PathVariable(value = "noTelepon") String noTelepon,
//            Model model
//    ){
//
//        //mendapatkan bioskop sesuai dengan notelepon
//        BioskopModel bioskop = bioskopService.getBioskopByNoTelepon(noTelepon);
//
//        //cek keberadaan bioskop
//        if(bioskop == null){
//            return "notfound-bioskop";
//        }
//
//        //bisa pake index
//        //list of bioskop -> isinya sama kyk getBioskopList
//        //ntar pas mau ngapus -> yg diapus temporary list
//        //yg diiterasiin sama yg diaapus tuh beda
//        //remove bioskop menggunakan method remove yang ada di Service
//        for (BioskopModel x: bioskopService.getBioskopList()){
//            if (x.getNoTelepon().equals(noTelepon)){
//                bioskopService.removeBioskop(bioskop);
//                continue;
//            }
//        }
//
//        //add variabel bioskop untuk dirender pada thymeleaf
//        model.addAttribute("bioskop",bioskop);
//        return "delete-bioskop";
//    }
//
//}
=======
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop",required = true) String idBioskop,
            @RequestParam(value = "namaBioskop",required = true) String namaBioskop,
            @RequestParam(value = "alamat",required = true) String alamat,
            @RequestParam(value = "noTelepon",required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio",required = true) int jumlahStudio,
            Model model
    ) {
        //membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop,namaBioskop,alamat,noTelepon,jumlahStudio);

        //menambahkan objek BioskopModel ke dalam service
        bioskopService.addBioskop(bioskopModel);

        //add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop",idBioskop);

        //return view template yang digunakan
        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        //return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        //mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);

        //cek keberadaan bioskop
        if(bioskop == null){
            return "notfound-bioskop";
        }

        //add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskop);
        return "view-bioskop";
    }

    @RequestMapping("bioskop/view/id-bioskop/{idBioskop}")
    public String viewBioskopPathVariable(
            @PathVariable(value = "idBioskop") String idBioskop,
            Model model
    ){
        //mendapatkan bioskop sesuai dengan id
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);

        //cek keberadaan bioskop
        if(bioskop == null){
            return "notfound-bioskop";
        }

        model.addAttribute("bioskop",bioskop);
        return "view-bioskop";
    }

    @RequestMapping("bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateJumlahStudio(
            @PathVariable(value = "idBioskop") String idBioskop,
            @PathVariable(value = "jumlahStudio") int jumlahStudio,
            Model model
    ){

        //mendapatkan bioskop sesuai dengan id
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);

        //cek keberadaan bioskop
        if(bioskop == null){
            return "notfound-bioskop";
        }

        //set jumlah studio yang mau diupdate
        bioskop.setJumlahStudio(jumlahStudio);

        //add variabel bioskop untuk dirender pada thymeleaf
        model.addAttribute("bioskop",bioskop);
        return "update-bioskop";
    }

    @RequestMapping("bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable(value = "idBioskop") String idBioskop,
            Model model
    ){

        //mendapatkan bioskop sesuai dengan id
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);

        //cek keberadaan bioskop
        if(bioskop == null){
            return "notfound-bioskop";
        }

        //remove bioskop menggunakan method remove yang ada di Service
        bioskopService.removeBioskop(bioskop);

        //add variabel bioskop untuk dirender pada thymeleaf
        model.addAttribute("bioskop",bioskop);
        return "delete-bioskop";
    }
}


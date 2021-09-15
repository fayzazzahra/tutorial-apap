package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
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

        //add variabel hotel model ke hotel untuk dirender pada thymeleaf
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
    public String deleteHotel(
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

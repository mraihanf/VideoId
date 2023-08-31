package ID.VideoId;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VideoId_Controller {

    @Autowired
    private VideoId_Repository videoId_Repository;

    // Integer norut = videoId_Repository.count();
    // model.addAttribute("brd",countBrand);

    @PostMapping(value = "/In")
    public ResponseEntity<Map> In (@RequestParam String hasil1, @RequestParam String hasil2, @RequestParam String tahun){

        Map data = new HashMap<>();

        Integer max = videoId_Repository.findByMaxnourut(tahun);
        String hasil;

        if(videoId_Repository.findbytahun(tahun)){
            if(videoId_Repository.findBynourut(tahun, max)){
                Integer no_urut = max + 1;
                int lenght = String.valueOf(no_urut).length();
                    if (lenght == 1) {
                        hasil = hasil1 + "0000" + no_urut + "_" + hasil2;
                    } else if (lenght == 2) {
                        hasil = hasil1 + "000" + no_urut + "_" + hasil2;
                    } else if (lenght == 3) {
                        hasil = hasil1 + "00" + no_urut + "_" + hasil2;
                    } else if (lenght == 4) {
                        hasil = hasil1 + "0" + no_urut + "_" + hasil2;
                    } else if (lenght == 5) {
                        hasil = hasil1 + no_urut + "_" + hasil2;
                    } else {
                        data.put("icon", "error");
                        data.put("message", "Number Of Asset Is Full");
                        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
                    }

                VideoId id = new VideoId();
                id.setHasil(hasil);
                id.setTahun(tahun);
                id.setNorut(no_urut);
                videoId_Repository.save(id);
            } else {
                System.out.println("Nomor Urut Error");
                data.put("icon", "error");
                data.put("message", "ERROR");
                return new ResponseEntity<>(data, HttpStatus.OK);
            }
        } else {
            Integer no_urut = 1;
            int lenght = String.valueOf(no_urut).length();
                    if (lenght == 1) {
                        hasil = hasil1 + "0000" + no_urut + "_" + hasil2;
                    } else if (lenght == 2) {
                        hasil = hasil1 + "000" + no_urut + "_" + hasil2;
                    } else if (lenght == 3) {
                        hasil = hasil1 + "00" + no_urut + "_" + hasil2;
                    } else if (lenght == 4) {
                        hasil = hasil1 + "0" + no_urut + "_" + hasil2;
                    } else if (lenght == 5) {
                        hasil = hasil1 + no_urut + "_" + hasil2;
                    } else {
                        data.put("icon", "error");
                        data.put("message", "Number Of Asset Is Full");
                        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
                    }
                VideoId id = new VideoId();
                id.setHasil(hasil);
                id.setTahun(tahun);
                id.setNorut(no_urut);
                videoId_Repository.save(id);
        }
        data.put("icon", "success");
        data.put("message", "success");
        data.put("hasil", hasil);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(value = "/findvideo") 
    public ResponseEntity<Map> find(@RequestParam(defaultValue = "0") Integer start,
                                   @RequestParam(defaultValue = "5") Integer length) {
        Map data = new HashMap<>();
        Pageable pageable = PageRequest.of(start, length, Sort.by("createdAt").descending());
        Page<VideoId> dataPaging = videoId_Repository.findAll(pageable);
        data.put("data", dataPaging);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    
}

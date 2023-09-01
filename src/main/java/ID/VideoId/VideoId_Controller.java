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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VideoId_Controller {

    @Autowired
    private VideoId_Repository videoId_Repository;

    // Integer norut = videoId_Repository.count();
    // model.addAttribute("brd",countBrand);

    @PostMapping(value = "/In")
    public ResponseEntity<Map> In(@RequestParam String hasil1, @RequestParam String hasil2,
            @RequestParam String tahun) {

        Map data = new HashMap<>();

        Integer max = videoId_Repository.findByMaxnourut(tahun);
        String hasil;

        if (videoId_Repository.findbytahun(tahun)) {
            if (videoId_Repository.findBynourut(tahun, max)) {
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
    public ResponseEntity<Map> find(@RequestParam(defaultValue = "1") Integer sort, @RequestParam(defaultValue = "0") Integer start, @RequestParam(required = false) String search,
                                   @RequestParam(defaultValue = "5") Integer length) {
        Map data = new HashMap<>();
        switch (sort) {
            case 1:
            // untuk filter by format desc
                Pageable pageable = PageRequest.of(start, length, Sort.by("createdAt").descending());
                Page<VideoId> dataPaging = videoId_Repository.search(search, pageable);
                data.put("data", dataPaging);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 2:
            // untuk filter by asc
                Pageable pageable2 = PageRequest.of(start, length, Sort.by("hasil").ascending());
                Page<VideoId> dataPaging2 = videoId_Repository.search(search, pageable2);
                data.put("data", dataPaging2);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 3:
            // untuk filter by format
                Pageable pageable3 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging3 = videoId_Repository.search1("search", pageable3);
                data.put("data", dataPaging3);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 4:
            // untuk filter by format
                Pageable pageable4 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging4 = videoId_Repository.search2("search", pageable4);
                data.put("data", dataPaging4);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 5:
            // untuk filter by format
                Pageable pageable5 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging5 = videoId_Repository.search3("search", pageable5);
                data.put("data", dataPaging5);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 6:
            // untuk filter by format
                Pageable pageable6 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging6 = videoId_Repository.search4("search", pageable6);
                data.put("data", dataPaging6);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 7:
            // untuk filter by format
                Pageable pageable7 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging7 = videoId_Repository.search5("search", pageable7);
                data.put("data", dataPaging7);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 8:
            // untuk filter by format
                Pageable pageable8 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging8 = videoId_Repository.search6("search", pageable8);
                data.put("data", dataPaging8);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 9:
            // untuk filter by format
                Pageable pageable9 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging9 = videoId_Repository.search7("search", pageable9);
                data.put("data", dataPaging9);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 10:
            // untuk filter by format
                Pageable pageable10 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging10 = videoId_Repository.search8("search", pageable10);
                data.put("data", dataPaging10);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 11:
            // untuk filter by format
                Pageable pageable11 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging11 = videoId_Repository.search9("search", pageable11);
                data.put("data", dataPaging11);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 12:
            // untuk filter by format
                Pageable pageable12 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging12 = videoId_Repository.search10("search", pageable12);
                data.put("data", dataPaging12);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 13:
            // untuk filter by format
                Pageable pageable13 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging13 = videoId_Repository.search11("search", pageable13);
                data.put("data", dataPaging13);
                return new ResponseEntity<>(data, HttpStatus.OK);
            case 14:
            // untuk filter by format
                Pageable pageable14 = PageRequest.of(start, length, Sort.by("createdAt").ascending());
                Page<VideoId> dataPaging14 = videoId_Repository.search12("search", pageable14);
                data.put("data", dataPaging14);
                return new ResponseEntity<>(data, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    
}

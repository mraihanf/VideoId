package ID.VideoId;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VideoId_Controller {

    @Autowired
    private VideoId_Repository videoId_Repository;

    @PostMapping(value = "/In")
    public ResponseEntity<Map> In (@RequestParam String hasil, @RequestParam String tahun){

        Map data = new HashMap<>();

        Integer max = videoId_Repository.findByMaxnourut(tahun);

        if(videoId_Repository.findbytahun(tahun)){
            if(videoId_Repository.findBynourut(tahun, max)){
                Integer no_urut = max + 1;
                int lenght = String.valueOf(no_urut).length();
                    // if (lenght == 1) {
                    //     hasil = nobar + "0000" + no_urut;
                    // } else if (lenght == 2) {
                    //     hasil = nobar + "000" + no_urut;
                    // } else if (lenght == 3) {
                    //     hasil = nobar + "00" + no_urut;
                    // } else if (lenght == 4) {
                    //     hasil = nobar + "0" + no_urut;
                    // } else if (lenght == 5) {
                    //     hasil = nobar + no_urut;
                    // } else {
                    //     data.put("icon", "error");
                    //     data.put("message", "Number Of Asset Is Full");
                    //     return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
                    // }

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
                    // if (lenght == 1) {
                    //     hasil = nobar + "0000" + no_urut;
                    // } else if (lenght == 2) {
                    //     hasil = nobar + "000" + no_urut;
                    // } else if (lenght == 3) {
                    //     hasil = nobar + "00" + no_urut;
                    // } else if (lenght == 4) {
                    //     hasil = nobar + "0" + no_urut;
                    // } else if (lenght == 5) {
                    //     hasil = nobar + no_urut;
                    // } else {
                    //     data.put("icon", "error");
                    //     data.put("message", "Number Of Asset Is Full");
                    //     return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
                    // }

                VideoId id = new VideoId();
                id.setHasil(hasil);
                id.setTahun(tahun);
                id.setNorut(no_urut);
                videoId_Repository.save(id);
        }

        data.put("icon", "success");
        data.put("message", "success");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }
    
}

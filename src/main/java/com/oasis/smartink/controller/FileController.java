package com.oasis.smartink.controller;

import com.oasis.smartink.model.Files;
import com.oasis.smartink.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class FileController {

    @Autowired
    FilesService filesService;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file/*,
                                             @PathVariable(name = "idUser", required = true) String idUser*/) {

        Files files = filesService.save(file/*, idUser*/);

        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
                                                            .path("/downloadFile/")
                                                            .path(files.getId()
                                                                       .toString())
                                                            .toString());
    }

}

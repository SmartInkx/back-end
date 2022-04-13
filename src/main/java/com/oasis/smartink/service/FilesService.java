package com.oasis.smartink.service;

import com.oasis.smartink.model.Files;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FilesService {

    Files save(MultipartFile files/*, String idUser*/);
}

package com.oasis.smartink.service;

import com.oasis.smartink.model.Files;
import org.springframework.web.multipart.MultipartFile;

public interface FilesService {

    Files save(MultipartFile files, String idUser);
}

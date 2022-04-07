package com.oasis.smartink.service;

import com.oasis.smartink.model.Files;
import com.oasis.smartink.model.Usuario;
import com.oasis.smartink.repository.FilesRepository;
import com.oasis.smartink.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class FilesServiceImpl implements FilesService {

    FilesRepository filesRepository;
    UsuarioRepository usuarioRepository;

    @Override
    public Files save(MultipartFile files, String idUser){
        try {
            return uploadFile(files, idUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Files uploadFile(MultipartFile files, String idUser) throws IOException {
        byte[] data = files.getBytes();
        String type = files.getContentType();
        String filename = files.getOriginalFilename();
        validacaoFileName(filename);

        Usuario usuario = usuarioRepository.findById(Long.parseLong(idUser))
                                           .orElseThrow(() -> new RuntimeException("Usuario não encontrado pelo id informado [" + idUser + "]"));

        Files buildFiles = filesRepository.saveAndFlush(Files.builder().data(data).filename(filename).type(type).usuario(usuario).build());

        usuario.setFiles(buildFiles);

        usuarioRepository.save(usuario);

        return buildFiles;
    }

    private void validacaoFileName(String filename) {
        if(filename.contains("..")){
            throw new RuntimeException("Desculpe! o nome do arquivo contem caracteres invalidos [" + filename + "]");
        }
    }

}

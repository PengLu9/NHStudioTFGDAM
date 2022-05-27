package com.curso.web.interfacesService;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IImageFileService {

	public String saveImage(MultipartFile file) throws IOException;
	public void deleteImage(String nombre);
}

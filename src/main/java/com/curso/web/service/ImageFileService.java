package com.curso.web.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.curso.web.interfacesService.IImageFileService;

@Service
public class ImageFileService implements IImageFileService {

	private String folder ="Image//";

	@Override
	public String saveImage(MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			byte[] bytes=file.getBytes();
			Path path =Paths.get(folder+file.getOriginalFilename());
			Files.write(path, bytes);
			return file.getOriginalFilename();
		}
		return "default.jpg";
	}

	@Override
	public void deleteImage(String nombre) {
		String ruta="Image//";
		File file = new File(ruta+nombre);
		file.delete();
		
	}
	
}

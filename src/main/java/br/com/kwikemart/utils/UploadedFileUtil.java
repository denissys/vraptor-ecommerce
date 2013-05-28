package br.com.kwikemart.utils;

import static org.apache.commons.io.IOUtils.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class UploadedFileUtil {

	// TODO: Move this path to system.properties
	private static final String UPLOAD_IMAGE_DIR_PATH = "C:\\dev\\workspace\\kwik-e-mart\\WebContent\\assets\\images\\";

	public String storeFile(UploadedFile uploadedFile, String newFilename)
			throws IOException {

		String storedFilename = null;

		try {
			storedFilename = newFilename + getExtensao(uploadedFile);
			FileOutputStream newFile = new FileOutputStream(new File(UPLOAD_IMAGE_DIR_PATH, storedFilename));
			copy(uploadedFile.getFile(), newFile);
			newFile.close();

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Arquivo não encontrado!");

		} catch (IOException e) {
			throw new IOException("Não foi possível gravar o arquivo!");

		} finally {
			uploadedFile.getFile().close();
		}

		return storedFilename;
	}

	private String getExtensao(UploadedFile uploadedFile) {
		int start = uploadedFile.getFileName().lastIndexOf(".");
		String extensao = (start > 0) ? uploadedFile.getFileName().substring(start) : ".jpg";
		return extensao;
	}

}

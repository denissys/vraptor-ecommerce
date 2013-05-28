package br.com.kwikemart.session;

import java.io.Serializable;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class ImageUpload implements Serializable {

    private static final long serialVersionUID = 1L;
	private UploadedFile image;


	public void save(UploadedFile image) {
		if (image != null) {
			this.image = image;
		}
    }

	public UploadedFile getImage() {
		return image;
    }
    
	public boolean hasUploaded() {
		return image != null;
    }

}
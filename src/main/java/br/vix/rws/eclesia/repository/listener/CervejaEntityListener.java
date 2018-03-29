package br.vix.rws.eclesia.repository.listener;

import javax.persistence.PostLoad;

import br.vix.rws.eclesia.EclesiaApplication;

import br.vix.rws.eclesia.model.Cerveja;
import br.vix.rws.eclesia.storage.FotoStorage;

public class CervejaEntityListener {

	@PostLoad
	public void postLoad(final Cerveja cerveja) {
		FotoStorage fotoStorage = EclesiaApplication.getBean(FotoStorage.class);
		cerveja.setUrlFoto(fotoStorage.getUrl(cerveja.getFotoOuMock()));
		cerveja.setUrlThumbnailFoto(fotoStorage.getUrl(FotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOuMock()));
	}
}

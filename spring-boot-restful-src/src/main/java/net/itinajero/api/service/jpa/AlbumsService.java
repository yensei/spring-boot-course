package net.itinajero.api.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.itinajero.api.entity.Album;
import net.itinajero.api.repository.AlbumsRepository;
import net.itinajero.api.service.IAlbumsService;

@Service
public class AlbumsService implements IAlbumsService {

	@Autowired
	private AlbumsRepository repoAlbums;
	
	public List<Album> buscarTodos() {
		return repoAlbums.findAll();
	}

	public void guardar(Album album) {
		repoAlbums.save(album);
	}

	public void eliminar(int idAlbum) {
		repoAlbums.deleteById(idAlbum);
	}

}

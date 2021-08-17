package net.itinajero.api.service;

import java.util.List;
import net.itinajero.api.entity.Album;

public interface IAlbumsService {

	List<Album> buscarTodos();
	void guardar(Album album);
	void eliminar(int idAlbum);
}

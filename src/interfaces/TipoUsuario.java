package interfaces;
import model.musica.Cancion;
import model.musica.Playlist;

public interface TipoUsuario {

    public void reproducirRandom();
    public void agregarCancion(Playlist playlist, Cancion cancion);
    public void escucharCancion(Cancion cancion);
    public Playlist crearPlaylist(String titulo);
    }

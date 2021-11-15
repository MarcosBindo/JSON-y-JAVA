package model.usuarios;
import interfaces.TipoUsuario;
import model.musica.Cancion;
import model.musica.Playlist;

public class UsuarioPremiun implements TipoUsuario{

    @Override
    public void agregarCancion(Playlist playlist ,Cancion cancion) {
       playlist.addSong(cancion);
       System.out.println("Se agrego "+ cancion.getNombre() + " a la playlist " + playlist.getTitulo());
    }

    @Override
    public void reproducirRandom() {
        //Las acciones las realiza la clase USUARIO
    }

    @Override
    public Playlist crearPlaylist(String titulo){
        return new Playlist(titulo); 
    }

    @Override
    public void escucharCancion(Cancion cancion) {
        System.out.println("Reproduciendo "+ cancion.getNombre() + "de " + cancion.getArtista());
    }

    

    
}

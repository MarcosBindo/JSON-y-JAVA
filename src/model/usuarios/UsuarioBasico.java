package model.usuarios;
import interfaces.TipoUsuario;
import model.musica.Cancion;
import model.musica.Playlist;

public class UsuarioBasico implements TipoUsuario{

    @Override
    public void agregarCancion(Playlist playlist ,Cancion cancion) {
        if(playlist.getCanciones().size() <= 30){
            playlist.addSong(cancion);
            System.out.println("Se agrego "+ cancion.getNombre() + " a la playlist " + playlist.getTitulo());
        }else{
            System.out.println("Pasate a premiun si queres agregar mas de 30 canciones");
        }
        
    }
    
    @Override
    public void reproducirRandom() {
        //Las acciones las realiza la clase USUARIO
    }

    @Override
    public void escucharCancion(Cancion cancion) {
        System.out.println("Pasate a premiun para dejar de escuchar aleateoreamente");
    }

    @Override
    public Playlist crearPlaylist(String titulo) {
        return new Playlist(titulo); 
    }

}

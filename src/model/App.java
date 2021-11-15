package model;
import adaptadores.secundarios.manipuladorJSON;
import interfaces.TipoUsuario;
import model.musica.Cancion;
import model.musica.Playlist;
import model.usuarios.Usuario;
import model.usuarios.UsuarioBasico;
import model.usuarios.UsuarioPremiun;

public class App {
    public static void main(String[] args) throws Exception {
        Cancion c1 = new Cancion("ORO y PLATINO", "YSY-A", "---", 3.4);
        Cancion c2 = new Cancion("No friends in the Industry", "Drake", "Certified Lover Boy", 4);
        Cancion c3 = new Cancion("Fair Trade", "Drake", "Certified Lover Boy", 3.5);


        TipoUsuario basico = new UsuarioBasico();
        TipoUsuario premium = new UsuarioPremiun();
        Usuario user1 = new Usuario("MarcosBindo", "1234567", basico);
        Usuario user2 = new Usuario("TomasAusino", "laidjada", premium);
        Usuario user3 = new Usuario("NicolasEscude", "mwfsyscp", basico);
        Usuario user4 = new Usuario("NicolesLiloia", "iaymdkw", premium);
        Usuario user5 = new Usuario("PabloPerez", "10972424dadrg", premium);
        Usuario user6 = new Usuario("ChristianBravo", "FE92748sds", basico);



        user1.escucharCancion(c1);
        user1.setTipoUsuario(premium);
        user1.escucharCancion(c1);

        Playlist pl1 = user1.crearPlaylist("Playlist-1");
        Playlist pl2 = user1.crearPlaylist("Playlist-2");
        Playlist pl3 = user1.crearPlaylist("Playlist-3");
        Playlist pl4 = user1.crearPlaylist("Playlist-4");
        Playlist pl5 = user1.crearPlaylist("Playlist-5");
        

        user1.verPlaylistdisponibles();

    
        user1.agregarCancion(pl1, c1);
        user1.agregarCancion(pl1, c2);
        user1.agregarCancion(pl1, c3);
        manipuladorJSON.addPlaylist(pl1);

        user1.agregarCancion(pl2, c1);
        user1.agregarCancion(pl2, c2);
        user1.agregarCancion(pl2, c3);
        manipuladorJSON.addPlaylist(pl2);

        user1.agregarCancion(pl3, c1);
        user1.agregarCancion(pl4, c2);
        user1.agregarCancion(pl5, c3);
        manipuladorJSON.addPlaylist(pl3);
        user1.reproducirRandom();

        manipuladorJSON.addUser(user1);
        manipuladorJSON.addUser(user2);
        manipuladorJSON.addUser(user3);
        manipuladorJSON.addUser(user4);
        manipuladorJSON.addUser(user5);
        manipuladorJSON.addUser(user6);
        

        manipuladorJSON.leerJSON();


       
    }
}

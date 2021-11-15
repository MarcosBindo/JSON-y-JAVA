package model.usuarios;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import model.Cancion;
import model.Playlist;

public class Usuario{

    private String nombreUsuario, pass;
    private static ArrayList<Playlist> contenedorPlaylist;
    private TipoUsuario tipoUsuario;
    private static final AtomicInteger count = new AtomicInteger();
    private int Id;
    

    public Usuario (String nombreUsuario, String pass, TipoUsuario tipoUsuario){
        this.nombreUsuario = nombreUsuario;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
        this.contenedorPlaylist = new ArrayList<Playlist>();
        Id = count.incrementAndGet();
    }

    public void reproducirRandom(){
        /* Random rndm = new Random();
        int pl = rndm.nextInt(contenedorPlaylist.size());
        int cn = rndm.nextInt(contenedorPlaylist.get(pl).getCanciones().size());
        System.out.println("Reproduciendo "+ contenedorPlaylist.get(pl).getCanciones().get(cn).getNombre() ); 
        /* "de la playlist " + contenedorPlaylist.get(n).getTitulo()); */     
        this.tipoUsuario.reproducirRandom();
    }

    public void agregarCancion(Playlist playlist,Cancion cancion){
        this.tipoUsuario.agregarCancion(playlist, cancion);
    }

    public void escucharCancion(Cancion cancion){
        this.tipoUsuario.escucharCancion(cancion);
    }

    public Playlist crearPlaylist(String titulo){
        this.tipoUsuario.crearPlaylist(titulo);
        return new Playlist(titulo);
    }

    public void verPlaylistdisponibles(){
        System.out.println("Playlists disponibles: ");
        for (int i = 0; i < contenedorPlaylist.size() ; i++) {
            System.out.println(contenedorPlaylist.get(i).getTitulo());
        }
    }

    public ArrayList<Playlist> getContenedorPlaylist() {
        return contenedorPlaylist;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getPass() {
        return pass;
    }
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    public void setContenedorPlaylist(ArrayList<Playlist> contenedorPlaylist) {
        this.contenedorPlaylist = contenedorPlaylist;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
   
   public static Playlist addPlaylist(Playlist playlist){
        contenedorPlaylist.add(playlist);
        return playlist;
    }   
    
}
package adaptadores.secundarios;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Cancion;
import model.*;
import model.usuarios.Usuario;
import model.usuarios.UsuarioBasico;
import model.usuarios.UsuarioPremiun;

public class manipuladorJSON {



    private static JSONArray playlists = new JSONArray();
    private static JSONObject mainJSON = new JSONObject();

    private static JSONArray usuarios = new JSONArray();

    private static ArrayList<Playlist> arrayPlaylists = new ArrayList<Playlist>();
    private static ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();


    public static JSONObject agregarCancion(Cancion cancion){
        JSONObject cancionDATA = new JSONObject();
        cancionDATA.put("Nombre", cancion.getNombre());
        cancionDATA.put("Artista", cancion.getArtista());
        cancionDATA.put("Album", cancion.getAlbum());
        cancionDATA.put("Duracion", cancion.getDuracion());

        JSONObject objCancion = new JSONObject();
        objCancion.put(cancion.getNombre(), cancionDATA);
        
        return objCancion;
    }

    public static void addPlaylist(Playlist pl){
        JSONArray playlist = new JSONArray();
        JSONObject estructura = new JSONObject();
        
        for (Cancion cancion : pl.getCanciones()) {
            JSONObject objCancion = agregarCancion(cancion);
            playlist.add(objCancion);
        }

        estructura.put(pl.getId(), playlist);
        playlists.add(estructura);
        escribirJSON(mainJSON);
    }

    /* public static void addSongToPlaylist(Playlist playlist, Cancion cancion){
        
    } */

    public static JSONObject agregarUsuario(Usuario usuario){
        JSONObject userData = new JSONObject();
        userData.put("ID", usuario.getId());
        userData.put("Username", usuario.getNombreUsuario());
        userData.put("Pass", usuario.getPass());
        userData.put("Type: ", usuario.getTipoUsuario().getClass().getName());
        userData.put("Cant. Playlists", usuario.getContenedorPlaylist().size());

        return userData;
    } 

    public static void addUser(Usuario user){
        JSONObject estructura = new JSONObject();
        JSONObject objUser = agregarUsuario(user);
        
        estructura.put(user.getId(), objUser);
        usuarios.add(estructura);
        escribirJSON(mainJSON);
    }

    private static void escribirJSON(JSONObject objeto){
        objeto.clear();
        objeto.put("Playlists",playlists);
        objeto.put("Usuarios",usuarios);
        try (FileWriter file = new FileWriter("Reproductor/src/adaptadores/BD.json", false)) {
            file.write(objeto.toString()); 
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    public static void leerJSON(){
        JSONParser parser = new JSONParser();

        try(FileReader file = new FileReader("Reproductor/src/adaptadores/BD.json")){
            Object obj = parser.parse(file);
            JSONObject json = (JSONObject) obj;
            arrayPlaylists = (JSONArray) json.get("Playlists");
            arrayUsuarios = (JSONArray) json.get("Usuarios");

            for(Object object : arrayPlaylists){
                JSONObject playlist = (JSONObject) object;
                Playlist actual = new Playlist((String) playlist.get("titulo"));
                System.out.println(actual);
            }

            for(Object object: arrayUsuarios){
                JSONObject user = (JSONObject) object;
                String userType = (String) user.get("tipoUsuario");
                if(userType.contains("UsuarioBasico")){
                    Usuario temp = new Usuario((String) user.get("Username"), (String) user.get("Pass"), new UsuarioBasico());
                    System.out.println(temp);
                } else {
                    Usuario temp = new Usuario((String) user.get("Username"), (String) user.get("Pass"), new UsuarioPremiun());
                    System.out.println(temp);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Playlist> getArrayPlaylists() {
        return arrayPlaylists;
    }

    public static ArrayList<Usuario> getArrayUsuarios() {
        return arrayUsuarios;
    }


}

    

    


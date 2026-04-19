package Problems_Solving;
    //creating a Music nplaylist system using circular linked list

public class MusicPlaylistSystem {

    Song front = null;
    Song rear = null;
    int size = 0;
    Song current = null;

    public static void main(String[] args) {
        MusicPlaylistSystem mps = new MusicPlaylistSystem();

        mps.addSongAtEnd(1, "Perfect", "Tailor swift");
        mps.addSongAtEnd(15, "Perfect girl", "Tailor swift");
        mps.addSongAtBeginning(63, "Ali", "Atif");
        mps.addSongAtBeginning(78, "Afifa", "hoor");
        mps.printPlaylist();
        mps.deleteSong(63);
        mps.playNextSong();
        mps.searchSong(16);
        mps.addSongAtEnd(16, "Perfect", "Tailor swift");
        mps.addSongAtEnd(55, "Perfect girl", "Tailor swift");
        mps.addSongAtBeginning(66, "Ali", "Atif");
        mps.addSongAtBeginning(780, "Afifa", "hoor");
        mps.searchSong(66);
        System.out.println(mps.countSongs());
        mps.findWordingSong("Aliya");
        mps.findWordingSong("Ali");
        mps.playNextSong();

        mps.printPlaylist();

    }


    // creating the methods
    public void printPlaylist() {
        if(front==null){
            System.out.println("Playlist is empty");
        }
        Song current = front;
        do {
            System.out.println(current.SongID + " -> " + current.SongTitle + " -> " + current.ArtistName);
            current = current.nextSong;
        } while (current != front);
    }

    public void addSongAtBeginning(int id, String title, String artist) {
        size++;
        Song song = new Song(id, title, artist);
        if (front == null) {
            front = song;
            rear = front;
            rear.nextSong = front;
            return;
        }
        song.nextSong = front;
        front = song;
        rear.nextSong = front;
    }

    public void addSongAtEnd(int id, String title, String artist) {
        size++;
        Song song = new Song(id, title, artist);
        if (front == null) {
            front = song;
            rear = front;
            rear.nextSong = front;
            return;
        }

        rear.nextSong = song;
        rear = song;
        song.nextSong = front;

    }

    public void deleteSong(int id) {
        Song found = front;
        if (front == null){
            System.out.println("The list is empty");
            return;
        }
        if(front==rear){
            front=null;
            rear=null;
            size--;
            return;
        }
        while (found.nextSong.SongID != id) {
            found = found.nextSong;
            if(found.nextSong==front){
                System.out.println("Id not found!");
                return;
            }
        }
        found.nextSong = found.nextSong.nextSong;
        size--;

    }

    public void searchSong(int id) {
        Song found = front;
        if ((front == rear) || (front == null)) {
            Song song = new Song();
            return;
        }
        while (found.SongID != id) {
            found = found.nextSong;
            if (found.nextSong == front) {
                System.out.println("ID not found");
                return;
            }
        }
        System.out.println("The song with id " + id + " is " + found.SongTitle + " " + found.ArtistName);
    }

    public void findWordingSong(String word) {
        Song found = front;
        if (front == null) {
            System.out.println("Playlist is empty");
            return;
        }
        while (found.SongTitle.contains(word)) {
            found = found.nextSong;
            if (found == front) {
                System.out.println("MusicPlaylistSystem.Song not found with this name");
                return;
            }
        }
        System.out.println("The song with the name " + word + " has this id:" + found.SongID
                + " and this artist: " + found.ArtistName + ".");

    }

    public int countSongs() {
        return size;
    }

    public void playNextSong() {
        if(current==null){
            current=front;
            System.out.println("The first song in the playlist is played "+ current.SongID + ", " + current.SongTitle + ", by "
                    + current.ArtistName);
            return;
        }
        System.out.println("The current song is " + current.SongID + ", " + current.SongTitle + ", by "
                + current.ArtistName);
        current = current.nextSong;
        System.out.println("The next song played is " + current.SongID + ", " + current.SongTitle + ", by "
                + current.ArtistName);
    }

    public static class Song {
        int SongID;
        String SongTitle;
        String ArtistName;
        Song nextSong;
        Song(){
            this.SongID=0;
            this.SongTitle=null;
            this.ArtistName=null;
            this.nextSong=null;
        }
        Song(int id){
            this.SongID=id;
            this.nextSong=null;
        }
        Song(int id, String title, String artist){
            this.SongID=id;
            this.SongTitle=title;
            this.ArtistName=artist;
            this.nextSong=null;
        }
        Song(int id, Song addressNext){
            this.SongID=id;
            this.nextSong=addressNext;
        }
    }
}
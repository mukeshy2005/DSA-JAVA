package Programs;

class StreamingSong {
    String title;
    String artist;
    int duration;
    void play() {
        System.out.println("Playing song");
    }
    void printDetails() {
        System.out.println("This is " + title +
                " by " + artist);
    }
}

class PlatformSong{

    void play() {

        System.out.println("--- Platform Starting ---");
        StreamingSong song = new StreamingSong();
        song.artist = "The Beatles";
        song.title = "Come Together";
        song.play();
        song.printDetails();
    }
}
// let us create a manager instead of using direct main
class StreamingSongTestDrive {
    public static void main(String[] args) {
    PlatformSong myspotify= new PlatformSong();
    myspotify.play();

    }
}

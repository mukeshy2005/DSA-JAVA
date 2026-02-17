package Programs;

class Speaker{
    int trebleNum=10;
    int baseNum=20;
    void Playsound(){
        System.out.println("treble and sound is set");
    }
}
class SonySpeaker{
    public static void main(String [] args){
        Speaker mix1 = new Speaker();
        mix1.trebleNum=50;
        mix1.baseNum=100;
        mix1.Playsound();

        Speaker mix2 = new Speaker();
        mix2.trebleNum=60;
        mix2.baseNum=200;
        mix2.Playsound();
    }
}
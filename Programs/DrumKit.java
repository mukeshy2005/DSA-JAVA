package Programs;
class Drumkit {
    boolean TopHat =true;
    boolean Snare =false;
    void PlaySnare(){
        System.out.println(" bang bang ba-bang");
    }
    void TopHat(){
        System.out.println(" ding ding da-ding");
    }
}
class DrumTestDrive{
    public static void main(String [] args){
        Drumkit d = new Drumkit();
        if(d.Snare == true){
            d.PlaySnare();
        }
        d.Snare = false;
        d.PlaySnare();
        d.TopHat();


    }

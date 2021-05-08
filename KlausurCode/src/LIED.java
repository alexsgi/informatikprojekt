public class LIED extends BAUMELEMENT{
    public BAUMELEMENT rechterNachfolger = new ABSCHLUSS();
    public BAUMELEMENT linkerNachfolger = new ABSCHLUSS();

    LIEDDATEN daten;

    public LIED(LIEDDATEN daten)
    {
        this.daten = daten;
    }

    public String TitelGeben(){
        return daten.titel;
    }


}
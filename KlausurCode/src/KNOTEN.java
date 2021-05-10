public abstract class KNOTEN {
    BAUMELEMENT linkerNachfolger; // = new ABSCHLUSS();
    BAUMELEMENT rechterNachfolger; // = new ABSCHLUSS();

    public KNOTEN() {

    }

    public void infosAusgeben(String schluessel) {
        linkerNachfolger.infosAusgeben(schluessel);
        if (titelGeben() == schluessel) {
            System.out.println(schluessel);
        }
        rechterNachfolger.infosAusgeben(schluessel);

    }

    public String titelGeben() {
        return null;
    }
}

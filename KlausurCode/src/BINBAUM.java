public class BINBAUM {

    BAUMELEMENT wurzel;

    public BINBAUM() {
        // manuelle Erstellung beispielhafter BAUMELEMENTE also Einfügen von Liedern
        // wurzel: Ebene 0
        wurzel = new LIED(new LIEDDATEN("Faded"));
        // Ebene 1
        wurzel.rechterNachfolger = new LIED(new LIEDDATEN("Faded"));
        wurzel.linkerNachfolger = new LIED(new LIEDDATEN("Cheap Thrills"));
        // Ebene 2
        wurzel.rechterNachfolger.rechterNachfolger = new LIED(new LIEDDATEN("Don't Let Me Down"));
        wurzel.rechterNachfolger.linkerNachfolger = new LIED(new LIEDDATEN("One Dance"));
        wurzel.linkerNachfolger.rechterNachfolger = new LIED(new LIEDDATEN("Stressed Out"));
        wurzel.linkerNachfolger.linkerNachfolger = new LIED(new LIEDDATEN("Faded"));
        // Ebene 3
        wurzel.rechterNachfolger.rechterNachfolger.rechterNachfolger = new LIED(new LIEDDATEN("Hymn For The Weekend"));
        wurzel.rechterNachfolger.rechterNachfolger.linkerNachfolger = new LIED(new LIEDDATEN("This Girl"));

        wurzel.rechterNachfolger.linkerNachfolger.rechterNachfolger = new LIED(new LIEDDATEN("Fast Car"));
        wurzel.rechterNachfolger.linkerNachfolger.linkerNachfolger = new LIED(new LIEDDATEN("Cake by the Ocean"));

        wurzel.linkerNachfolger.rechterNachfolger.rechterNachfolger = new LIED(new LIEDDATEN("Shape of You"));
        wurzel.linkerNachfolger.rechterNachfolger.linkerNachfolger = new LIED(new LIEDDATEN("Despacito "));

        wurzel.linkerNachfolger.linkerNachfolger.rechterNachfolger = new LIED(new LIEDDATEN("Thunder"));
        wurzel.linkerNachfolger.linkerNachfolger.linkerNachfolger = new LIED(new LIEDDATEN("Ok"));

    }

    public void automatischerMethodenaufruf() {
        wurzel.infosAusgeben("Cake by the Ocean");
    }
}

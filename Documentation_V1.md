# informatikprojekt

## Dokumentation

### **22.03.2021**
Jessica, Alex, Jonas:
1. Einrichtung der Plattform GitHub
2. Besprechung der Ordnerstrukturen zur Versions- und Änderungsverwaltung
3. Besprechung der Vorgehensweise bei Änderungen und Dokumentationen 

### **07.04.2021**
Jessica, Alex, Jonas:
1. Besprechung und Erarbeitung des Pflichtenheftes
2. Entscheidung über das Spielkonzept und die Spielidee
3. Aufgabenverteilung innerhalb der Gruppe
4. Besprechung der Vorgehensweise bei Änderungen
5. Entscheidung: Text wird "outgesourced", um eine Übersetzung in weitere Sprachen zu erleichtern

### **08.04.2021**
Alex:
1. Konfiguration Datenbank

### **29.04.2021**
1. Migrierung zu IntelliJ

Alex:
1. Erstellen eines einfachen GUI
2. Implementierung Hintergrund des JFrames
3. Font-Ladetest (fehlgeschlagen) mit Jonas
4. Ordnerstrukturanpassung mit Jonas

Jonas:
1. Einfügen eines App-Icons mit der Hilfe einer von Alex bearbeiteten Methode (Auswahl der richtigen Größe eines Platzhahltericons, welches später ausgetauscht wird)
2. Auswahl der Schriftart Arial Black als vorläufige Überschrift
3. Prototyp einer Login-Seite hinzugefügt
4. Auswahl provisorischer Hintergrund
5. Auswahl Icons

### **30.04.2021**
Alex:
1. Importieren benötigter Bibliotheken
2. Datenbankanbindungsimplementierung
3. Erstellen der Klasse Player (→ Datenklasse für Daten aus DB)

### **01.05.2021**
Jessica, Alex, Jonas:
1. Besprechung (Review) des derzeitigen Codes
2. Besprechen der Klassenstruktur
3. Planung weiteres Vorgehen und Aufgabenverteilung

Alex:
1. Implementierung der Datenbankabfragen
2. Anpassung Klasse Player

Jonas:
1. Einfügen aller Klassen, die in Verbindung mit der Klasse GameElement stehen

Jessica:
1. Bearbeiten mehrerer Tutorials zur Erstellung eines GUIs

### **02.05.2021**
Alex:
1. Implementierung Loading screen

### **03.05.2021**
Alex:
1. Anpassung Loading screen mit Jonas
2. Anpassung Datenbankverbindung
3. MVC-Versuch mit Jonas

Jonas: 
1. Implementieren der Klasse Controller mit Alex mit vorläufigem Aufbau, bei welchem Controller von ActionListener erbt

### **05.05.2021**
Jessica, Alex, Jonas:
1. Konferenz mit Besprechung des MVC
2. Überarbeitung der Anwendung des MVC durch die Klasse Controller, ohne ActionListener

Jonas:
1. Umsetzen des KeyListeners über die Klassen des Frames, Panels und Controllers
2. Testen und weiterer Funktionen hinzugefügt mit Alex und Jessica

### **07.05.2021**
Alex:
1. Aufsetzen eines MySQL-/MariaDB-Servers auf einem Raspberry Pi
2. Migrieren der DB zu selbst-gehostetem MySQL-Dienst
3. Anpassung der Verbindung in DBConnection

Jonas:
1. Überarbeitung der Liste und Klärung dessen genaue Funktionialität mit Alex

### **08.05.2021**
Jessica, Alex, Jonas:
1. Fertigstellung der Klassen- und Ordnerstruktur

Alex:
1. Implementieren der Listen zur Speicherung der Spieler

### **09.05.2021**
Alex:
1. Anpassung der Listen zur Speicherung der Spieler
2. Schreiben der GameElementRender-Klasse zur Visualisierung von Spielobjekten

Jonas:
1. Umstrukturierung mancher Ordner zu einer logischeren Struktur (unter Rücksprache mit den
Gruppenmitgliedern)

### **10.05.2021**
Alex:
1. Implementierung Netzwerk- und Servertest

Jonas:
1. Erstellen des MovingBackgrounds mit Testen und Einfügen in GamePanelView
2. Hinzufügen der Buttons "Start" und "Stop" als provisorische StartGame und GameOver Situationen

### **11.05.2021**
Jessica:
1. Ausarbeitung des Klassendiagramms zu Sprint-Planning 2

Jonas:
1. Einfügen der für die Abgabe am folgenden Tag geforderten Methoden zum Auslesen der
HighScorewerte
2. Erstellung eines Labels, welches den aktuellen Score anzeigt

### **12.05.2021**
Jessica:
1. Fertigstellung des Klassendiagramms zu Sprint-Planning 2

Jonas:
1. Erstellung eines automatisch generierten svg-Dokuments, welches als Klassendiagramm fungiert
2. UI-Anpassung StartPanel mit Alex

Alex:
1. UI-Anpassung LoginPanel mit Jonas

### **13.05.2021**
Alex:
1. Erstellen einer neuen Oberfläche des LoginPanels
2. UI-Anpassung RegisterPanel mit Jonas

Jonas: 
1. UI-Anpassung LoginPanel mit Alex
2. Erstellen eine Oberfläche des RegisterPanels

### **14.05.2021**
Alex: 
1. weitere UI-Anpassungen mit Jonas 

Jonas: 
1. Umstrukturierung einiger Klassen mit Erstellen struktureller Klassen, welche den Controller "entlasten"
2. Actionlistener "aufräumen"
3. weitere UI-Anpassungen mit Alex 

### **15.05.2021**
Alex:
1. Anpassung Mouse-/Action-Listener mit Jonas
2. Erstellung der Settings-Klasse
3. Laden aller Bilder beim Loading-Screen

Jonas:
1. Anpassung der Klassen ImageManager und PanelFrame Manager
2. Controller "aufräumen"

### **16.05.2021**
Alex:
1. Anpassung RegisterPanelView

Jonas:
1. Vergebliche Anpassung des MovingBackgrounds zu einer "glitchfreien" Version
2. Erarbeitung einer Lösungsstrategie für dieses Problem


### **17.05.2021**
Alex:
1. Implementierung updateHighScore in DBConnection
2. Registrierungslogik verfasst in RegisterPanelView
3. Hinzufügen eines warningLabels in RegisterPanelView

Jonas:
1. Testphase zum Testen der Datenbankverbindung durch ein JTextField in GamePanelView
2. Anpassung der getesteten Methoden zur richtigen Funktionsweise

### **18.05.2021**
Alex:
1. Fertigstellung DB-Verbindung und -Funktionen
2. Fertigstellung AdvancedButton

Jonas: 
1. Einrichtung der Datenbank in meiner Entwicklungsumgebung
2. Testphase für Anmeldungen

### **19.05.2021**
Jonas: 
1. Einfügen einer Methode, welche einen "Click-Sound" beim drücken eines AdvancedButtons abspielt
2. Anpassen der Methode mit relativem "jar-kompatiblem" Pfad mit Alex

### ""20.05.2021**
!!! Vorhaben
Jonas:
1. "Verallgemeinerung" der playSound - Methode in UI-Tools


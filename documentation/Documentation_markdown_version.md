# StickJumper

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

Alex:
1. MovingBackground, Buttons in RegisterPanel angepasst

### **20.05.2021**
Jonas:
1. "Verallgemeinerung" der playSound - Methode in UI-Tools

Alex:
1. MV-Panel erstellt
2. Passwort-Hashing implementiert und aktiviert

### **21.05.2021**
Jessica, Alex, Jonas:
1. Besprechung über Soundausgabe und Umsetzung der Spiellogik

Jonas: 
1. Überarbeitung der playSound - Methode mit lag - Optimierung

Alex:
1. GamElementRender angepasst

### **22.05.2021**

Alex:
1. Reguläre Internetverbindungstest
2. MV-Anpassung

Jonas: 
1. Implementierung der automatisierten Bewegung der Vordergrundelemente mit anpassbarer Geschwindigkeit
2. Anpassung der Game - Elemente, sodass die Konstruktoren für die Bewegung passen
3. Anpassung der Variable SkinType in allen GameElement - Klassen, sodass man diesen im Nachhinein verändern kann

### **23.05.2021**

Jonas:
1. Random Generator hinzugefügt, sodass die Elemente in einer externen Klasse (später nach einen "random" Muster) erzeugt werden können
2. Random Generator so testweise implementiert, dass in regelmäßigen Abständen Hindernisse und Münzen erscheinen

Alex:
1. Anpassung RandomGenerator

### **24.05.2021**

Alex:
1. Jump-Funktion und Game-Over screen implementiert mit Jonas
2. Automatische Spielzugüberprüfung mit Jonas
3. Adaption der Jump-Bewegung, sodass diese "natürlich" wirkt, aber lange genug dauert, sodass Hindernisse übersprungen werden können mit Jonas

Jonas:
1. Jump-Funktion und Game-Over Screen implementiert mit Alex
2. Adaption der Jump-Bewegung, sodass diese "natürlich" wirkt, aber lange genug dauert, sodass Hindernisse übersprungen werden können mit Alex
3. Implementierung der Funktion, dass sobald die Bereiche des GameCharakters und des Hindernisses übereinstimmen das Spiel beendet wird mit Alex
4. Implementierung einiger Sound Effekte und einer Highscore Erhöhung bei Münzberührung (mit einem neuen provisorischen Label)
5. Implementierung einer Funktion, sodass die Münzen verschwinden, wenn man sie berührt

### **25.05.2021**

Alex:
1. Fix eines Fehlers bei Jonas' Implementierung der Generierung der Coins
2. Höhe der Coins wird zufällig erzeugt
3. Fix eines Fehlers beim Beenden des Spiels (MultiThreading)
4. Umbenennen einiger Attribute und Variablen
5. Code teilweise vereinfacht; Redundantes entfernt
6. CountDownTimer hinzugefügt

### **26.05.2021**

Jessica, Alex, Jonas:
1. Konferenz zur Besprechung des Spielalgortihmus (v.a. zufälliges Erzeugen aller Gegner usw.)

### **28.05.2021**
Alex:
1. Wiederherstellen der funktionierenden Jump-Animation und -Logik
2. Implementieren der Pattern 10 - 15 (SceneryRandomGenerator)

Jonas:
1. Implemetierung der Patterns 1-4
2. Anpassung des Algorithmus zur Erzeugung der Patterns

Jessica:
1. Implementieren der Pattern 5-9

### **01.06.2021**
Alex:
1. Ändern der Struktur der Variablen
2. Highscore-Funktionalität vollständig implementiert

Jonas: 
1. RandomGenerator angepasst

### **03.06.2021**
Alex: 
1. Vollständige Implementierung der Statistiken

Jonas: 
1. Anpassung der Spiellogik und der Jump-Bewegung

### **04.06.2021**
Alex:
1. Implementieren der Einstellungen
2. Outsourcen aller Strings

### **10.06.2021**
Alex:
1. Ändern der hit-Funktionalität → läuft nun über ein interface statt üver booleans + Timer

Jonas: 
1. Bugfix

### **11.06.2021**
Alex:
1. Letzte Änderungen der hit-Funktionalität; Pull-Request
2. Vollständige Text-Outsourcung mit Implementierung aller benötigten Advanced-Klassen

### **15.06.2021**
Alex:
1. Geringfügige Änderungen; Formatieren des Codes

Jonas: 
1. Bugfix bei der Sprung-Bewegung

### **23.06.2021**
Alex:
1. Überarbeitung der Menü-UIs; Verbesserung Lesbarkeit
2. Coinicons hinzugefügt für verschiedene Münzwerte

Jonas: 
1. Anpassung des "Sterberadius" 

### **26.06.2021**
Alex:
1. Überarbeiten Boden
2. Erstellen verschiedener Münzicons

Jonas: 
1. Überarbeitung des Bodens durch ein transparentes Icon
2. Beginn mit der Arbeit an der Power-Point-Präsentation

### **27.06.2021**
Jessica, Alex, Jonas:
1. Konferenz zur Besprechung der verschiedenen Münzicons und Bugfix

Alex:
1. Implementieren der verschiedenen Münzicons

Jonas: 
1. Experimentelle Implementierung der verschiedenfarbigen Münzicons
2. Arbeit an der Power-Point-Präsentation

Jessica:
1. Implementieren des Bodens

### **28.06.2021**
Alex:
1. Suchen verschiedener Playericons und Implementierung der benötigten Logik

Jonas, Jessica:
1. Wiederholte Anpassung des "Sterberadius", sodass unberechtigte Game-Over-Meldungen vermieden werden

### **30.06.2021**
Alex:
1. Letzte Codeanpassungen und Export
2. Schreiben der README

Jonas: 
1. Fertigstellen der PowerPoint-Präsentation

### **03.07.2021**
Jessica, Alex, Jonas:
1. Besprechen der PowerPoint-Präsentation

Alex, Jonas:
1. Anpassen des Settings-Menüs
2. Hinzufügen eines Vorschau-Fensters zum Settingsmenü

### **04.07.2021**
Alex:
1. Migrieren der DB zu DigitalOcean
2. Entfernen redundanter Codeteile (z.B. Verbindungsüberprüfung)
3. Export
4. Fertigstellen der Dokumentation

Jonas: 
1. Finaler Test mit Bug-Überprüfung
2. Export der Dokumentationen und Datentypanpassung

Hinweis:
Nach einer Abwägung der Vor- und Nachteile, sowie der erforderlichen Arbeit und Zeit, wurde entschieden, dass man von dem ursprünglichen Konzept - ein Spiel mit Sticks, welche platziert werden können, und Klippen, welche überquert werden müssen - abweichen wird. Der eigentlich daraus resultierende Aufwand ist massiv. Es wurde Wert gelegt auf ein Spiel, dass fehlerfrei ist und dem Spieler viele Konfigurationsmöglichkeiten bietet. Dieses Ziel wurde erreicht.
So fügt man das hier vorgestellte Projekt in Eclipse ein:

Nach dieser Reiheinfolge vorgehen:

Das Projekt runterladen:

-> Forge runterladen 
-> Im Forge Ordner 
-> Shift +  Rechtsklick 
-> PowerShell 
-> ./gradlew setup Decompworkspace eclipse 
-> in Eclipse Ordner navigieren 
-> Diesen als Workspace in Eclipse angeben 
-> MDK Example wird in Eclipse angezeigt 
-> Existing Project into workspace kopieren 
-> Projekt minecraftmdkmodding importieren
-> Fehler Libraries nicht vorhanden 
-> Eclipse schließen 
-> Im minecraftmdkmodding Ordner wieder Power Shell
-> Folgende Befehle nacheinander ausfürhen: 
-> ./gradlew clean -> ./gradlew --refresh-dependencies -> ./gradlew setup Decompworkspace eclipse 
-> Eclipse wieder öffnen 
-> Run configs öffnen 
-> Im Reiter Java applications den client auswählen 
-> Klick auf Run 
-> Minecraft sollte starten!

Bei Fehlern Problembehandlung durchlesen!

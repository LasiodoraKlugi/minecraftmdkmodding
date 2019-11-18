Erstellen neuer Forge Ordner > power shell > neuer workspace eclipse(in eclipse ordner) > Kopieren meines Projekts in MDK Example(Overwrite => Error)

Problem dann: Fehler kann nicht abspeichern
Git: Nicht möglich und terminiert sich selber, Fehler hat wohl was zu tun mit den .metadata die schon existieren
Eventuell das projekt manuell auf Git hub hochziehen?
Mdk example direkt in Eclipse reinziehen geht nicht, weil dann kein Client vorhanden ist zum starten von MC.
Und ein neues Projekt bei einem schon existierenden ForgeMDK erstellen geht nicht, weil er dann in MC keinen Mod erkennt und nur
den Standart MDKExample auslesen kann.
Vielleicht einfach neu coden somit sollte der Pfad wieder stimmen.
Problem möglichweise im zusammenhang mit dem alten Pfad in .location unter 
F:\Forge2768\eclipse\.metadata\.plugins\org.eclipse.core.resources\.projects\MDKExample\.location

Problem gibt es wohl beim Überschreiben von MDKExample mit meinem schon fertigen Mod, aufgrund von doppelten Dateien, allerdings
lässt sich nur so den Mod in Minecraft nutzen
Zusätzlich sollte man den Exmaple mod löschen, da dieser noch als 6 Mod beim starten von mc erkannt wird.
Soweit sollte das alles auch am Pc funktionieren.

********************************************************* ~fixed
Einfach das Projekt einfpgen und run neu configurieren auf das aktuvelle projekt
Problem beim push zu github -> rejected -> pull ausfürhen

Aktuelles Forge:



Aktueller Git Ordner:

F:\GitMinecraft\minecraftmod
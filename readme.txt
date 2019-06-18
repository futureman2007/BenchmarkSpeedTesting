Der Zusatz stellt ein eigenes Projekt das, das mithilfe des CommandPatterns Realisiert wurde.

K U R Z B E S C H R E I B U N G 

Dieses Projekt ist eine Software zum "Benchmarken" (also zum Testen von Preformancezeiten) beliebiger Programme bzw. Methoden.
(Java 9 Modules)
Enthalten sind einmal die Benchmark-Software und ein Demoprogramm.
Die Benchmark-Software testet die Ausf�hrungszeit einer beliebigen Methode oder Klasse und schreibt die Ergebnisse
in eine Datei.

Die Pr�zision, also in welcher Zeiteinheit gemessen werden soll, der Pfad der zu erstellenden 
Ergebniss-Dateien k�nnen frei eingestellt werden. Es kann auch eingestellt werden, wie oft ein 
Experiment wiederholt werden soll und ob dazu die durchschnittliche Bearbeitungszeit (in Abh�ngigkeit der Genauigkeit)
mit ausgegeben werden soll.
Jedes Experiment erh�lt dabei eine eigene Datei.

D E T A  I L S / V E R W E N D U N G

Der Client bekommt das Modul:

module futureman.benchmarker{
	exports speed.testing.methods;
	exports speed.testing.benchmark.configurators;
	exports speed.testing.benchmark.runner;
}

zur Verf�gung gestellt. 

speed.testing.methods: beinhaltet beispielimplementierungen von Opperationen, die es gilt zu "benchmarken" 
(Also deren Verarbeitungszeit es gilt festzuhalten).

Desweiteren wird hier das interface MethodToBenchmark bereitgestellt.
Vorgehensweise:
1. Der Nutzer W�hlt sich eine Klasse aus, die getestet werden soll.
2. Der Nutzer f�gt "implements MethodToBenchmark" zu seiner Klassendeffinition hinzu und implementiert die dort geforderte 
   Methoden void run() und String getName()
   2.1: run()
   run() soll lediglich den Aufruf einer (oder mehrere) zu testenden Methoden durchf�hren. Die Software misst dann deren Ausf�hrungszeit.
   getName() soll lediglich einen Namen f�r dieses Geschwindigkeitsexperiment zur�ckliefern.
3. Der Nutzer verwendet das Objekt bzw. Klasse Configurator (Package speed.testing.benchmark.configurators).
   Mit diesem k�nnen Einstellungen des/der Tests vorgenommen werden: 
	* Wie viel mal soll der Test wiederholt werden?
	* Wohin sollen die Ergebnisse geschrieben werden?
	* Wie hoch soll die genauigkeit sein (Sekunden, Millisekunden, Microsekunden, Nanosekunden)?
	* Soll ein durschnitt aller Ergebnisse gebildet werden?
	* ...
4. Der nutzer startet den test �ber ein erzeugtes Runner Objekt: Runner.startBenchmarking().
   Diesem Objekt wird die aus 3. Erstellte Konfiguration �bergeben (Configuration Objekt) und startet anahnd dessen 
   das Experiment.
   (Pakage speed.testing.benchmark.runner)
   Ein Beispiel kann in diesem Package gefunden werden: Run.java ist ein beispiel benchmark experiment, 
   dass die mitgelieferten Implementierungen von MethodToBenchmark verwendet.

C O M P I L I E R E N

Wer dieses Projekt gerne selbst Kompilieren m�chte, muss lediglich �ber das Build-Tool Maven die "pom.xml"
im speedTesting Wurzelverzeichniss starten.

L I N K E N  &  C O 

Es sind mehrere .bat Dateien hinterlegt. Dieser erzeugen eine eige Java JVM die nur dieses Programm eth�lt.
Nachdem das Linken erfolgreich abgeschlossen ist, kann diese mit "launch.bat" verwendet werden.

Die selbst erstellte JVM ist wie eine normale JVM! Das heist:
Die erstellte JVM kann auf einen beliebigen rechner portiert und ausgef�hrt werden ohne installation!
Einfach das Script ausf�hren und es l�uft!
BEACHTE: Diese JVM ersetzt eine normale JAVA Destirbution nicht! Sie enh�lt nur das benchmark-Programm.
# Webtech_Projkekt_WS2223

Implementierung eines Online-Portals, wo man einen Termin zum Friseur vereinbaren kann.
-Ein Konto kann entweder als Mitarbeiter des Salons oder als Kunde angelegt werden.
-Wenn die Daten angelegt sind, werden sie in einer Datenbank "SalonDB" gespeichert.
1-Funktionalitäten Kunde_in:

- Auf der Seite kann sich der/die Kunde_in registrieren, sich anmelden, wenn er bereits ein Benutzerkonto hat, oder
  einen
  Termin als Gast vereinbaren.
- Danach hat der/die Kunde_in die Möglichkeit, einen Termin zu vereinbaren. Dazu muss er/sie den gewünschten Tag
  eingeben, an dem er/sie einen Termin haben möchte. Der/die Kunde_in wählt dann die gewünschte Uhrzeit aus und
  bestätigt die
  Eingabe.
- Anschließend wird überprüft, ob die gewählte Zeit nicht bereits vergeben ist, falls ja, ist eine Bestätigung nicht
  möglich. Wenn dies nicht der Fall ist, ist der Termin gültig und wird gespeichert (im Konto des Kunden).
- Der/die Kunde_in kann sich dann ausloggen und zur Startseite zurückkehren.

2-Funktionalitäten Mitarbeiter(Friseur_in)
-Der Friseur kann sich mit seinen Daten einloggen und die ihm zugewiesenen Termine überprüfen.
-Hat Zugriff auf die Kundendaten, mit denen er/sie den Termin hat.
-Kann sich ausloggen.
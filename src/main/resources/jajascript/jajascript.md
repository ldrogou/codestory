## Location d'astronef sur Jajascript

Votre cousin par alliance, Martin O. sur la plan�te Jajascript vient de monter sa petite entreprise de vol spatial priv�e: Jajascript Flight Rental. Il loue aux grosses corporations son astronef lorsqu'elles ont de fortes charges ou un p�pin avec leurs propres appareils. Il s'occupe de la maintenance et de l'entretien de son petit astronef. Il ne pouvait s'en payer qu'un pour d�marrer.

Ces grosses corporations envoient des commandes de location qui consistent en un intervalle de temps, et le prix qu'ils sont pr�ts � payer pour louer l'astronef durant cet intervalle.

Les commandes de tous les clients sont connues plusieurs jours � l'avance. Ce qui permet de faire un planning pour une journ�e.
Les commandes viennent de plusieurs soci�t�s diff�rentes et parfois elles se chevauchent. On ne peut donc pas toutes les honorer.

Id�alement, il faut donc �tre capable de prendre les plus rentables, histoire de maximiser les gains de sa petite entreprise, et de s'acheter d'autres astronefs.
Votre cousin passe des heures � trouver le planning id�al et vous demande **pour un planning donn� de calculer une solution qui maximise son gain**.

### Exemple

Consid�rez par exemple le cas o� la JajaScript Flight Rental a 4 commandes :

	MONAD42 : heure de d�part 0, dur�e 5, prix 10
	META18 : heure de d�part 3, dur�e 7, prix 14
	LEGACY01 : heure de d�part 5, dur�e 9, prix 8
	YAGNI17 : heure de d�part 5, dur�e 9, prix 7

La solution optimale consiste � accepter MONAD42 et LEGACY01, et le revenu est de `10 + 8 = 18`. Remarquez qu'une solution � partir de MONAD42 et YAGNI17 est faisable (l'avion serait lou� sans interruption de 0 � 14) mais non optimale car le b�n�fice serait que de 17.

### Pr�cisions

L'identifiant d'un vol ne d�passe jamais 50 caract�res,
les heures de d�parts, dur�e et prix sont des entiers positifs raisonnablement grands.

### Serveur

Votre serveur doit r�pondre aux requ�tes http POST de la forme `http://serveur/jajascript/optimize` avec un payload de la forme :

	[
		{ "VOL": "NOM_VOL", "DEPART": HEURE, "DUREE": DUREE, "PRIX": PRIX },
		...
	]

En reprenant l'exemple ci dessus :

	[
		{ "VOL": "MONAD42", "DEPART": 0, "DUREE": 5, "PRIX": 10 },
		{ "VOL": "META18", "DEPART": 3, "DUREE": 7, "PRIX": 14 },
		{ "VOL": "LEGACY01", "DEPART": 5, "DUREE": 9, "PRIX": 8 },
		{ "VOL": "YAGNI17", "DEPART": 5, "DUREE": 9, "PRIX": 7 }
	]

Vous devrez r�pondre le r�sultat suivant :

	{
		"gain" : 18,
		"path" : ["MONAD42","LEGACY01"]
	}

Le gain repr�sentant la somme optimale, path repr�sentant l'ordre des vols.

Bons calculs !
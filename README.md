# En résumé
API REST de conversion de nombres entiers en mots

# Exercice 
Les chèques ou certains contrats par exemple, nécessitent d'écrire les montants en toute lettre.
Cet exercice propose d'écrire un programme permettant d'automatiser une telle conversion.
Ce programme, écrit en **Java**, doit convertir un nombre entier en mots (en anglais).


Voici quelques exemples :  
"245" est converti en "two hundred forty-five"  
"75" est converti en "seventy-five"  

# Comment exécuter le programme ?
## en ligne de commande

Aller dans le répertoire du jar et lancer la commande suivante :
```
java -jar integer-to-words-v1-1.0-SNAPSHOT.jar
```

## via Maven
Ouvrir le projet avec un IDE et exécuter la commande suivante :
```
mvn spring-boot:run
```

## résultat
Lancer un client web (Firefox / Postman / cUrl) et exécuter l'URL suivante, où 4123 est la valeur � traduire :
```
http://localhost:8080/api/v1/convert/4123
```

On obtient alors le résultat suivant :
```
{
value: "four thousand one hundred twenty-three"
}
```

# Architecture logicielle




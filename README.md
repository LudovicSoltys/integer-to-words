# En r�sum�
API REST de conversion de nombres entiers en mots

# Exercice 
Les ch�ques ou certains contrats par exemple, n�cessitent d'�crire les montants en toute lettre.
Cet exercice propose d'�crire un programme permettant d'automatiser une telle conversion.
Ce programme, �crit en **Java**, doit convertir un nombre entier en mots (en anglais).


Voici quelques exemples :  
"245" est converti en "two hundred forty-five"  
"75" est converti en "seventy-five"  

# Comment ex�cuter le programme ?
## en ligne de commande

Aller dans le r�pertoire du jar et lancer la commande suivante :
```
java -jar integer-to-words-v1-1.0-SNAPSHOT.jar
```

## via Maven
Ouvrir le projet avec un IDE et ex�cuter la commande suivante :
```
mvn spring-boot:run
```

## r�sultat
Lancer un client web (Firefox / Postman / cUrl) et ex�cuter l'URL suivante, o� 4123 est la valeur � traduire :
```
http://localhost:8080/api/v1/convert/4123
```

On obtient alors le r�sultat suivant :
```
{
value: "four thousand one hundred and twenty-three"
}
```

# Architecture logicielle




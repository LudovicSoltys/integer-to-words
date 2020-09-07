# En résumé
API REST de conversion de nombres entiers en mots

# Exercice 
Les chèques ou certains contrats par exemple, nécessitent d'écrire les montants en toute lettre.
Cet exercice propose d'écrire un programme permettant d'automatiser une telle conversion.
Ce programme, écrit en **Java**, doit convertir un nombre entier en mots (en anglais).


Voici quelques exemples :  
"245" est converti en "two hundred forty-five"  
"75" est converti en "seventy-five"  

# Solution
L'application contient 3 solutions possibles :
- V1 : version basique avec des nombres compris entre 0 et 999999999
- V2 : version gérant les nombres longs (jusqu'aux quintillions) et négatifs
- V3 : version qui gère les nombres longs et négatifs, mais propose l'utilisation des MessagesSources pour la traduction 
des nombres composés de 3 caractères ou moins (0 à 999) en des mots 

La distinction de la version se fait via l'URL :
```
http://localhost:8080/api/v1/convert/4123

http://localhost:8080/api/v2/convert/4123

http://localhost:8080/api/v3/convert/4123
```

# Pré-requis
L'application nécessite d'utiliser **Maven** pour être compilée et buildée.  

Aussi, elle utilise du code généré (voir https://immutables.github.io/). Pour le créer, exécuter :
```
mvn clean compile
```
Il apparaît alors dans target/generated-sources/.

Pour builder :
```
mvn clean install
```

Pour générer le JAR :
```
mvn clean package
```
Le fichier s'appelle **integer-to-words-v1-1.0-SNAPSHOT.jar** et peut être trouvé à la racine de 
target/.

 
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
Lancer un client web (Firefox / Postman / cUrl) et exécuter l'URL suivante, où 4123 est la valeur à 
traduire :
```
http://localhost:8080/api/v1/convert/4123
```

On obtient alors le résultat suivant :
```
{
value: "four thousand one hundred twenty-three"
}
```


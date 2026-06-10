# Procesdocument: Gore Magala Mod

## Inleiding
Voor dit project heb ik een Minecraft-mod gemaakt in Fabric rond Gore Magala uit Monster Hunter. Mijn idee was om niet alleen een monster toe te voegen, maar ook armor, drops en een status effect dat past bij het gevecht. Tijdens dit project heb ik vooral gewerkt met Java, registraties in Fabric, GeckoLib voor armor, crafting recepten, loot tables en entity AI.

## Wat ik heb gemaakt
De mod bevat op dit moment een werkende basis met meerdere onderdelen.

### Armor
Ik heb een complete Gore Magala armor set toegevoegd:
- Gore Helm
- Gore Mail
- Gore Coil
- Gore Greaves

De helm heeft een eigen model met GeckoLib. De andere armorstukken werken in-game en gebruiken op dit moment een placeholder uiterlijk op basis van Netherite armor. Functioneel zijn ze dus wel aanwezig en craftbaar.

### Gore Magala monster
Ik heb ook een eerste werkende versie van Gore Magala gemaakt als entity. Het monster:
- spawnt in het spel via een spawn egg
- loopt rond en target spelers
- gebruikt melee attacks
- kan speciale aanvallen uitvoeren
- kan bladeren breken tijdens het bewegen
- laat loot vallen na het verslaan

De special attacks die nu werken zijn:
- **Leap Attack**: Gore springt naar de speler toe en doet damage met knockback
- **Potion Throw**: Gore infecteert een speler met Frenzy
- **Frenzy Burst**: Gore maakt meerdere Frenzy-wolken om zich heen
- **Frenzy Attack**: een extra area attack die spelers in de buurt infecteert

### Frenzy-virus
Ik heb een custom Frenzy-effect toegevoegd. Dit effect kan door Gore Magala op de speler worden gezet en is ook als potion aanwezig. De potion is te brouwen met een Awkward Potion en een Gore Magala Scale.

### Loot en crafting
Ik heb custom drops toegevoegd voor Gore Magala:
- Gore Magala Scale
- Gore Magala Wing
- Gore Magala Gem
- Gore Magala Tail

Deze items worden gebruikt voor crafting en voor de Frenzy potion. Ook heb ik crafting recepten toegevoegd voor de armor set.

## Hoe ik het heb aangepakt
Ik heb het project stap voor stap opgebouwd. Eerst heb ik items en armor toegevoegd, daarna het Frenzy-effect, daarna de crafting en loot, en pas daarna de entity zelf. Dat werkte voor mij beter omdat ik zo eerst een stabiele basis had voordat ik aan de moeilijkere delen begon, zoals AI en speciale aanvallen.

Bij het monster ben ik begonnen met een simpele preview entity om schaal en model te testen. Daarna heb ik movement, targeting en aanvallen toegevoegd. Toen de basis werkte, heb ik extra gedrag toegevoegd zoals potion attacks, leap attacks en het breken van bladeren.

## Problemen die ik tegenkwam
Tijdens het maken van de mod liep ik tegen een paar belangrijke problemen aan.

### GeckoLib crash bij de helm
In het begin crashte de game als ik de Gore Helm opzette. Dat kwam doordat ik eerst een tutorial volgde die nog voor GeckoLib 4 was, terwijl mijn project GeckoLib 5 gebruikte. Uiteindelijk heb ik dat opgelost door de officiële documentatie te volgen en de code daarop aan te passen.

### Loot drops werkten niet
Op een gegeven moment liet Gore Magala geen items meer vallen. De oorzaak was dat de loot table wel in code stond, maar dat de datagen nog niet goed was uitgevoerd. Nadat ik dat had gecontroleerd en opnieuw had gegenereerd, werkte de loot weer zoals bedoeld.

### Speciale aanvallen stopten na de eerste keer
Een ander probleem was dat sommige speciale aanvallen alleen vlak na het spawnen werkten. Tijdens het gevecht kwamen ze bijna niet meer terug. Dat bleek te komen door hoe de goal cooldown werkte. Die heb ik aangepast zodat de goals actief blijven en de cooldown in `tick()` wordt afgehandeld.

## Resultaat
Het eindresultaat is een werkende mod waarin je:
- een Gore Magala armor set kunt craften en dragen
- Gore Magala kunt spawnen en bevechten
- Frenzy kunt krijgen tijdens het gevecht
- custom loot kunt krijgen na het verslaan van het monster
- een custom potion kunt brouwen met de drops

De mod is dus niet alleen een los model of een test, maar echt een speelbare basis van een Monster Hunter-achtige toevoeging in Minecraft.

## Wat nog niet volledig af is
Niet alles is visueel al helemaal af. De helm is het meest uitgewerkt. De andere armorstukken werken wel, maar gebruiken nog placeholder visuals. Ook heeft Gore Magala nog geen volledig afgewerkt model met textures en animaties zoals in het originele spel. Toch werkt de technische basis van de mod al wel goed.

## Wat ik heb geleerd
Door dit project heb ik beter geleerd hoe een mod is opgebouwd in Fabric. Vooral het werken met registraties, custom items, loot tables, status effects en entity AI was leerzaam. Ik merkte ook dat documentatie vaak betrouwbaarder is dan random tutorials, vooral als libraries zoals GeckoLib veranderen tussen versies.

Ik heb daarnaast geleerd dat het beter werkt om grote features op te splitsen in kleinere delen. Eerst iets simpel werkend krijgen, daarna pas uitbreiden, gaf veel minder fouten en maakte het makkelijker om bugs terug te vinden.

## Conclusie
Ik vind dat het project een goed eindresultaat heeft opgeleverd. De belangrijkste onderdelen van het idee zitten erin: armor, Gore Magala als monster, Frenzy-virus, drops en gevechtsgedrag. Niet alles is visueel helemaal af, maar de mod werkt technisch wel en laat duidelijk zien wat ik heb gebouwd en geleerd tijdens het project.

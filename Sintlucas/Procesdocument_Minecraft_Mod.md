# Procesdocument: Minecraft Gore Magala Mod

## 1. Technologische Stack
* **Taal:** Java 21 (Strongly Typed, automatische Garbage Collection via de JVM).
* **IDE & Build-tool:** IntelliJ IDEA + Gradle (dependency- en buildbeheer).
* **Mod Framework:** Fabric API & Loader (lichtgewicht basis).
* **Code-injectie:** SpongePowered Mixins (aanpassen van Minecraft AI/gedrag zonder broncode-wijziging).
* **Deobfuscation:** Yarn Mappings (vertalen van onleesbare gamecode naar normale Java-termen).
* **Modellering:** Blockbench (3D-modellen en animaties voor armor en boss).

---

## 2. Gerealiseerde Voortgang (Tijdlijn)

* **Februari 2026 (Opstart & Basis)**
  * Project geïnitialiseerd met een Fabric mod skeleton.
  * Eerste Blockbench-modellen (`gore_magala_helmet.bbmodel`) aangemaakt, textures toegevoegd en bestanden herstructureerd/hernoemd.

* **Maart 2026 (Items & Iconen)**
  * Basis itemregistratie toegevoegd aan de game.
  * Item-icoon voor de helm werkend gekregen; in-game renderde de helm op het hoofd op dit moment nog als een diamond helmet placeholder.
  * Build-scripts en dependencies gefikst.

* **April 2026 (Armor, GUI & Start Boss)**
  * Blockbench-model voor de helm definitief gefikst en texture-fouten opgelost.
  * Eerste opzet gemaakt voor de custom GUI.
  * Frenzy status-effect en craftable armor toegevoegd aan de code.
  * Begonnen met de logica en opzet voor de daadwerkelijke Gore Magala entity.

* **Mei 2026 (Armor Uitbreiding & Model Updates)**
  * Mail armor (bodyplate) toegevoegd aan de mod.
  * Meerdere grote model-updates doorgevoerd in `gore_magala.bbmodel` om het monster vorm te geven.

* **Juni 2026 (AI, Movement & Drops)**
  * Geavanceerd model geïmplementeerd en de movement/bewegingslogica voor de Gore Magala gecodeerd.
  * Custom boss drops functioneel gemaakt via `ModLootTableProvider.java`.

---

## 3. Scope-wijzigingen (MoSCoW vs. Realiteit)

### Oorspronkelijk Plan
* **Must Have:** Switch Axe (transformeren), Gore Magala boss (model + AI), Frenzy virus, Gore Armor Set.
* **Should Have:** Crafting recipes, Switch Axe Gauge, Frenzy Enraged mode, Custom sounds.

### Gemaakte Keuzes door Tijdnood (Blockbench werk kostte te veel tijd):
1. **Gore Magala Textures:** Het 3D-model is er grotendeels maar hij heeft geen vleugels, animatie en textures. Dit komt omdat dat erg lang zou duren en ik me verdiep in Java en niet in blockbench.
2. **Armor Modellen:** De Java-code voor de items en armor-registratie staat erin, maar de visuele 3D-modellen (behalve de helm) duurde te lang om te maken.
3. **Frenzy Virus:** Basis zit erin; de dynamische win/verlies-balk (damage tracking) wordt nu afgerond richting de deadline.
4. **Switch Axe:** De switchaxe wou ik graag toevoegen maar vooral het model en animaties zouden te lang duren. Het was geen prioritiet. 

---

## 4. Grote Bug & Oplossing
* **Probleem:** In de vroege testfase crashte de complete Minecraft-client direct zodra de speler de custom helm opzette.
* **Oorzaak:** API-conflict. De gevolgde YouTube-tutorial gebruikte code voor GeckoLib Versie 4, terwijl mijn project draaide op het nieuwere GeckoLib Versie 5. Versie 5 gebruikt een compleet andere syntax voor het registreren van de GeoArmorRenderer.
* **Oplossing:** Tutorial losgelaten en de officiële GeckoLib 5 GitHub Wiki handleiding gelezen. De renderer en registratie-code volledig herschreven naar de Versie 5 standaard. Helm werkt nu perfect zonder crashes.


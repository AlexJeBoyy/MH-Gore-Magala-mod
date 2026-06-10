# Procesdocument: Minecraft Gore Magala Mod

## 1. Wat is deze mod?

Dit is een Minecraft-mod die het monster "Gore Magala" uit Monster Hunter toevoegt aan Minecraft. De mod bevat:
- **Gore Magala harnas** (4 onderdelen die je kan dragen)
- **Gore Magala monster** dat je in de wereld kan tegenkomen
- **Frenzy-virus effect** dat je kan krijgen als het monster je raakt
- **Recepten** om het harnas te craften

---

## 2. Voortgang per maand

| Maand | Wat is er gedaan |
|-------|------------------|
| **Februari 2026** | Project opgestart, eerste modellen gemaakt |
| **Maart 2026** | Harnas-items toegevoegd, iconen werkend |
| **April 2026** | Helm afgemaakt, Gore Magala monster begonnen, Frenzy-effect toegevoegd |
| **Mei 2026** | Alle 4 harnas-onderdelen klaar in code |
| **Juni 2026** | Gore Magala kan aanvallen, bewegen en items droppen |

---

## 3. Wat is klaar?

### Harnas-onderdelen ✅

| Onderdeel | In-spel? | 3D-Model | Textuur | Zichtbaar |
|-----------|----------|----------|---------|----------|
| **Gore Helm** | ✅ Ja | ✅ Ja | ✅ Ja | ✅ Perfect |
| **Gore Mail** | ⚠️ Deels | ❌ Nee | ✅ Ja | ✅ Werkend |
| **Gore Coil** | ⚠️ Deels | ❌ Nee | ❌ Nee | ⚠️ Placeholder |
| **Gore Greaves** | ⚠️ Deels | ❌ Nee | ❌ Nee | ⚠️ Placeholder |

### Gore Magala monster ✅ (Deels)

- ✅ Monster verschijnt in het spel
- ✅ Kan spelers aanvallen
- ✅ Kan bewegen
- ✅ Droopt items als je het verslaat
- ❌ Geen vleugels of vloeiende animaties
- ❌ Geen texturen

### Frenzy-effect ✅ (Deels)

- ✅ Effect werkt
- ❌ Niet zichtbaar op scherm 

---

## 4. Wat is NIET gedaan?

1. **Switch Axe** - Dit wapen zou veel werk zijn (model + animaties), dus niet gedaan
2. **Armor 3D-modellen** - Mail, Coil en Greaves hebben geen 3D-modellen nodig (Mail werkt met textuur)
3. **Boss animaties** - Gore Magala heeft geen vloeiende aanvals- of lopen-animaties
4. **Custom geluiden** - Geen boss-geluiden of effectgeluiden
5. **HUD display** - Frenzy-effect is niet zichtbaar op het scherm

---

## 5. Grote probleem & oplossing

**Het probleem:**
De game crashte als je de Gore Helm opzette.

**Waarom?**
Ik volgde een YouTube-tutorial die code gebruikte die niet meer werkte. De code was geschreven voor een oudere versie van de bibliotheek (GeckoLib 4), maar het project gebruikte een nieuwere versie (GeckoLib 5).

**De oplossing:**
Ik las de officiële handleiding en herschreef al de code voor GeckoLib 5. Nu werkt het perfect!

---

## 6. Wat je kan doen met de huidige mod

✅ De Gore Helm craften en dragen
✅ Mail, Coil en Greaves craften (verschijnen als gewone items)
✅ Gore Magala tegenkomen in het spel
✅ Gore Magala aanvallen en verslaan
✅ Items krijgen als je Gore Magala verslaat

---

## 7. Wat nog gedaan moet worden

### Hoge prioriteit (Voor afronding)
- [ ] Armor 3D-modellen afmaken (Mail, Coil, Greaves)
- [ ] Gore Magala model afmaken met texturen
- [ ] Frenzy-effect zichtbaar maken (balken op scherm)

### Lage prioriteit (Nice-to-have)
- [ ] Switch Axe wapen toevoegen
- [ ] Boss-geluiden toevoegen
- [ ] Armor animaties

---

## 8. Samenvatting

**Status: In Development** 🔧

De mod is functioneel: je kan het harnas craften, Gore Magala tegenkomen en aanvallen. De basis zit er in, maar het ontbreekt nog aan visuele details zoals 3D-modellen en animaties.

**Volgende stap:** Afmaken van de armor-modellen en Gore Magala's uiterlijk.


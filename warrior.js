function generateWarriors() {

    amt = Math.floor(Math.random() * 7) + 1;
    let d = 0;
    if (amt === 1)
        d = 3
    else if (amt > 3)
        d = 1
    else
        d = 2

    let gender = Math.floor(Math.random() * 3);
    let race = Math.floor(Math.random() * 7);
    let clique = Math.floor(Math.random() * 7);
    switch (gender) {
        case 0:
            gender = "Male"
            break
        case 1:
            gender = "Female"
            break
        case 2:
            gender = "NonBinary"
            break
    }
    switch (race) {
        case 0:
            race = "Human"
            break
        case 1:
            race = "Elf"
            break
        case 2:
            race = "Dwarf"
            break
        case 3:
            race = "Orc"
            break
        case 4:
            race = "Goblin"
            break
        case 5:
            race = "Druid"
            break
        case 6:
            race = "Ogre"
            break
    }
    switch (clique) {
        case 0:
            clique = "Mage"
            break
        case 1:
            clique = "Warrior"
            break
        case 2:
            clique = "Paladin"
            break
        case 3:
            clique = "Brute"
            break
        case 4:
            clique = "Mad Scientist"
            break
        case 5:
            clique = "Ranger"
            break
        case 6:
            clique = "Assassin"
            break
    }
    listOfWarriors = []
    for (let i = 0; i < amt; i++) {
        listOfWarriors.push(new Warrior(gender, race, clique, d))
    }
    return listOfWarriors
}


class Warrior {
    constructor(gender, race, clique, d) {
        this.gender = gender
        this.race = race
        this.clique = clique
        this.str = 1;
        this.def = 1;
        this.spd = 1;
        this.agl = 1;
        this.int = 1;
        this.mag = 1;
        this.lck = Math.floor(Math.random() * 50) + 50;
        this.hp = 100;
        this.mp = 100;
        this.stam = 100;
        this.generateStats(d);
    }
    generateStats(d) {
        const statGen = (c) => {
            if (c === 1) {
                return Math.floor(Math.random() * 12);
            } else if (c === 3) {
                return Math.floor(Math.random() * 11 + 7 * d + 2);
            } else {
                return Math.floor(Math.random() * 11 + 4 * d);
            }
        };

        if (this.clique === "Warrior") {
            this.str += statGen(2);
            this.def += statGen(2);
            this.spd += statGen(2);
            this.agl += statGen(2);
            this.int += statGen(2);
            this.mag += statGen(2);
        } else if (this.clique === "Mage") {
            this.str += statGen(2);
            this.def += statGen(2);
            this.spd += statGen(2);
            this.agl += statGen(1);
            this.int += statGen(2);
            this.mag += statGen(3);
        } else if (this.clique === "Paladin") {
            this.str += statGen(2);
            this.def += statGen(3);
            this.spd += statGen(1);
            this.agl += statGen(2);
            this.int += statGen(2);
            this.mag += statGen(2);
        } else if (this.clique === "Brute") {
            this.str += statGen(3);
            this.def += statGen(2);
            this.spd += statGen(2);
            this.agl += statGen(2);
            this.int += statGen(1);
            this.mag += statGen(2);
        } else if (this.clique === "Mad Scientist") {
            this.str += statGen(2);
            this.def += statGen(2);
            this.spd += statGen(2);
            this.agl += statGen(2);
            this.int += statGen(3);
            this.mag += statGen(1);
        } else if (this.clique === "Ranger") {
            this.str += statGen(2);
            this.def += statGen(1);
            this.spd += statGen(2);
            this.agl += statGen(3);
            this.int += statGen(2);
            this.mag += statGen(2);
        } else if (this.clique === "Assassin") {
            this.str += statGen(1);
            this.def += statGen(2);
            this.spd += statGen(3);
            this.agl += statGen(2);
            this.int += statGen(2);
            this.mag += statGen(2);
        }

        if (this.race === "Human") {
            this.str += statGen(2);
            this.def += statGen(2);
            this.spd += statGen(2);
            this.agl += statGen(2);
            this.int += statGen(2);
            this.mag += statGen(2);
        } else if (this.race === "Elf") {
            this.str += statGen(1);
            this.def += statGen(1);
            this.spd += statGen(2);
            this.agl += statGen(3);
            this.int += statGen(2);
            this.mag += statGen(3);
        } else if (this.race === "Dwarf") {
            this.str += statGen(2);
            this.def += statGen(3);
            this.spd += statGen(2);
            this.agl += statGen(1);
            this.int += statGen(3);
            this.mag += statGen(1);
        } else if (this.race === "Goblin") {
            this.str += statGen(1);
            this.def += statGen(1);
            this.spd += statGen(3);
            this.agl += statGen(3);
            this.int += statGen(2);
            this.mag += statGen(2);
        } else if (this.race === "Ogre") {
            this.str += statGen(3);
            this.def += statGen(3);
            this.spd += statGen(1);
            this.agl += statGen(2);
            this.int += statGen(1);
            this.mag += statGen(2);
        } else if (this.race === "Druid") {
            this.str += statGen(2);
            this.def += statGen(2);
            this.spd += statGen(1);
            this.agl += statGen(1);
            this.int += statGen(3);
            this.mag += statGen(3);
        } else if (this.race === "Orc") {
            this.str += statGen(3);
            this.def += statGen(2);
            this.spd += statGen(3);
            this.agl += statGen(2);
            this.int += statGen(1);
            this.mag += statGen(1);
        }

        if (this.gender === "Male") {
            this.str += statGen(3);
            this.def += statGen(3);
            this.spd += statGen(3);
            this.agl += statGen(1);
            this.int += statGen(1);
            this.mag += statGen(1);
        } else if (this.gender === "Female") {
            this.str += statGen(1);
            this.def += statGen(1);
            this.spd += statGen(1);
            this.agl += statGen(3);
            this.int += statGen(3);
            this.mag += statGen(3);
        }
        else if (this.gender === "NonBinary") {
            this.str += statGen(2);
            this.def += statGen(2);
            this.spd += statGen(2);
            this.agl += statGen(2);
            this.int += statGen(2);
            this.mag += statGen(2);
        }
    }
}